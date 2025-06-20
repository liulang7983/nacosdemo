package com.example.consumer2;

/**
 * @Author ming.li
 * @Date 2025/6/20 10:33
 * @Version 1.0
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.example.consumer2.feign") // 指定 Feign 客户端包路径
public class Consumer2Application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer2Application.class, args);
    }
    // 声明带负载均衡的 RestTemplate
    @Bean
    @LoadBalanced
    public RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }
}