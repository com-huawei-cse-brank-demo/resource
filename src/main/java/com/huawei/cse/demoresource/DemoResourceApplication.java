package com.huawei.cse.demoresource;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableServiceComb

public class DemoResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoResourceApplication.class, args);
    }

}
