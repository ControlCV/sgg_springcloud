package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @PostMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") String  id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @HystrixCommand(fallbackMethod = "payment_timeout" )
    @PostMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") String  id){
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String payment_timeout(String id) {
        return "80接口处理时间过长";
    }

    public String payment_timeout(Payment payment) {
        return "80接口处理时间过长";
    }
}