package com.example.producer1;

/**
 * @Author ming.li
 * @Date 2025/6/20 10:27
 * @Version 1.0
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class Producer1Application {
    public static void main(String[] args) {
        SpringApplication.run(Producer1Application.class, args);
    }
    // 声明带负载均衡的 RestTemplate
    @Bean
    @LoadBalanced
    public RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }
}
