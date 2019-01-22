package com.luandeptrai.demooneservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DemoOneServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoOneServiceApplication.class, args);
    }

}

