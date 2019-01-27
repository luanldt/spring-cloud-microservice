package com.luandeptrai.demooneservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("demo-two-service")
public interface DemoTwoClient {
    @GetMapping("/hello")
    String hello();
}
