package com.openapi.springdoc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan("com.openapi.springdoc.mapper")
public class SpringdocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdocApplication.class, args);
    }

}
