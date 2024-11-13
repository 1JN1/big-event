package com.bigeventserver.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author 王文涛
 * @date 2024/11/13
 * @description
 **/

@Configuration
public class Knife4jConfig {

    @Bean
    public GroupedOpenApi defaultApi() {
        return GroupedOpenApi.builder()
                .group("api")
                // 接口请求路径规则
                .pathsToMatch("/**")
                .packagesToScan("com.bigeventserver.controller")
                .build();
    }

    /**
     * 配置基本信息
     */
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        // 标题
                        .title("大事件接口文档")
                        // 描述Api接口文档的基本信息
                        .description("大事件接口文档")
                        // 版本
                        .version("1.0")
                        // 设置OpenAPI文档的联系信息，姓名，邮箱。
                        .contact(new Contact().name("王文涛").email("2471902111@qq.com"))
                        // 设置OpenAPI文档的许可证信息，包括许可证名称为"Apache 2.0"，许可证URL为"http://springdoc.org"。
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                );
    }

}
