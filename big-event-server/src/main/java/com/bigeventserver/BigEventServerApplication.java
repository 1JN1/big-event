package com.bigeventserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author 王文涛
 */
@SpringBootApplication
@EnableCaching
public class BigEventServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigEventServerApplication.class, args);
    }

}
