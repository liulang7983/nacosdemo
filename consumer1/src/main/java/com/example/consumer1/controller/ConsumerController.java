package com.example.consumer1.controller;

/**
 * @Author ming.li
 * @Date 2025/6/20 10:35
 * @Version 1.0
 */

import com.example.consumer1.service.ProducerService;
import com.example.consumer1.service.ProducerService1Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    private final ProducerService producerService;       // 原 LoadBalancer 调用
    private final ProducerService1Wrapper producerService1; // 新 Feign 调用

    @Autowired
    public ConsumerController(ProducerService producerService,
                              ProducerService1Wrapper producerService1) {
        this.producerService = producerService;
        this.producerService1 = producerService1;
    }

    // 原 LoadBalancer 调用生产者
    @GetMapping("/call-producer")
    public String callProducer(@RequestParam(required = false, defaultValue = "User") String name) {
        return producerService.callProducerHello("producer-service", name);
    }

    // 新增 Feign 调用生产者1
    @GetMapping("/call-producer1-via-feign")
    public String callProducer1ViaFeign(@RequestParam(required = false, defaultValue = "User") String name) {
        return producerService1.callProducer1Hello(name);
    }

    // 新增 Feign 调用生产者1的 info 接口
    @GetMapping("/producer1-info-via-feign")
    public String getProducer1InfoViaFeign() {
        return producerService1.getProducer1Info();
    }
}
