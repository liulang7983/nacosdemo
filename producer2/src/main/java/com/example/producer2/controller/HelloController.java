package com.example.producer2.controller;

/**
 * @Author ming.li
 * @Date 2025/6/20 10:28
 * @Version 1.0
 */


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false, defaultValue = "Producer2") String name) {
        System.out.println("hello被调用");
        return "Hello, " + name + " from Producer2";
    }

    @GetMapping("/info")
    public String info() {
        System.out.println("info被调用");
        return "This is Producer2 service, instance ID: " + getInstanceId();
    }

    private String getInstanceId() {
        System.out.println("getInstanceId被调用");
        // 获取当前实例ID的方法
        try {
            java.net.InetAddress localHost = java.net.InetAddress.getLocalHost();
            return localHost.getHostAddress() + ":" + 8082;
        } catch (Exception e) {
            return "unknown";
        }
    }
}
