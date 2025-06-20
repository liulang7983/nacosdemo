package com.example.consumer1.feign;

/**
 * @Author ming.li
 * @Date 2025/6/20 11:00
 * @Version 1.0
 */
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// value：指定要调用的生产者服务名（与 Nacos 注册的服务名一致）
// contextId：Feign 客户端的唯一标识（避免与其他同名接口冲突）
@FeignClient(value = "producer-service", contextId = "producerService1")
public interface ProducerService1 {

    // 映射生产者的 /hello 接口
    @GetMapping("/hello")
    String hello(@RequestParam(required = false, defaultValue = "User") String name);

    // 可选：映射生产者的 /info 接口
    @GetMapping("/info")
    String info();
}
