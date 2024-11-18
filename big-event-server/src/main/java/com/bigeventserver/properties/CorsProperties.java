package com.bigeventserver.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 王文涛
 * @date 2024/11/18
 * @description 跨域配置参数
 **/

@Component
@ConfigurationProperties(prefix = "cors")
@Data
public class CorsProperties {

    private String[] allowedOrigins;

    private String[] allowedHeaders;

    private String[] allowedMethods;

}
