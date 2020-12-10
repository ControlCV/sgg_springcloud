package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.servcie.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OderFeignController {

    @Resource
    private PaymentService paymentService;


    @PostMapping("/consumer/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") String id){
        return paymentService.getById(id);
    }
}
