package com.openapi.springdoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringdocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdocApplication.class, args);
    }

}
