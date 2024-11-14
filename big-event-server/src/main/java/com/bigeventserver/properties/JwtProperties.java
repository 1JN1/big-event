package com.bigeventserver.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description
 **/

@Component
@ConfigurationProperties("jwt")
@Data
public class JwtProperties {

    /**
     * 密钥
     */
    private String secretKey;

    /**
     * 过期时间
     */
    private Long ttl;

    /**
     * 请求携带token的请求头的名称
     */
    private String tokenName;

}
