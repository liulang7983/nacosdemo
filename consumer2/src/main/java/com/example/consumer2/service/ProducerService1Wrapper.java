package com.example.consumer2.service;

/**
 * @Author ming.li
 * @Date 2025/6/20 11:01
 * @Version 1.0
 */
import com.example.consumer2.feign.ProducerService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService1Wrapper {

    /*private final ProducerService1 producerService1;

    @Autowired
    public ProducerService1Wrapper(ProducerService1 producerService1) {
        this.producerService1 = producerService1;
    }*/
    @Autowired
    private  ProducerService1 producerService1;
    // 封装调用生产者1的逻辑
    public String callProducer1Hello(String name) {
        return producerService1.hello(name);
    }

    // 封装调用生产者1的 info 接口
    public String getProducer1Info() {
        return producerService1.info();
    }
}
