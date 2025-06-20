package com.example.consumer2.service;

/**
 * @Author ming.li
 * @Date 2025/6/20 10:34
 * @Version 1.0
 */


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProducerService {

    private final RestTemplate loadBalancedRestTemplate;

    // 构造注入带负载均衡的 RestTemplate
    public ProducerService(@LoadBalanced RestTemplate loadBalancedRestTemplate) {
        this.loadBalancedRestTemplate = loadBalancedRestTemplate;
    }

    public String callProducerHello(String serviceName, String name) {
        // 直接通过服务名调用，Spring Cloud 自动负载均衡
        return loadBalancedRestTemplate.getForObject(
                "http://" + serviceName + "/hello?name=" + name,
                String.class
        );
    }
}
