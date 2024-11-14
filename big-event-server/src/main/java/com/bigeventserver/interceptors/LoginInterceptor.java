package com.bigeventserver.interceptors;

import com.bigeventserver.constant.JwtClaimsConstant;
import com.bigeventserver.exception.UserNotFoundException;
import com.bigeventserver.properties.JwtProperties;
import com.bigeventserver.utils.JwtUtil;
import com.bigeventserver.utils.ThreadLocalUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description
 **/

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 令牌验证
        String token = request.getHeader(jwtProperties.getTokenName());

        try {

            Claims claims = JwtUtil.parseJwt(jwtProperties.getSecretKey(), token);

            long userId = Long.parseLong(claims.get(JwtClaimsConstant.USER_ID).toString());

            log.info("用户id, {}", userId);

            ThreadLocalUtil.setUserId(userId);

            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }

    }
}
