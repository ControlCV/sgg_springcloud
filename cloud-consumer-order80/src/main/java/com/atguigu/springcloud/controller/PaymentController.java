package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2020-12-03 15:18:30
 */
@RestController
@Slf4j
public class PaymentController {
    public static  final String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/payment/create",produces = "application/json;charset=UTF-8")
    public CommonResult create(@RequestBody Payment payment){
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<Payment> formEntity = new HttpEntity<>(payment, headers);//requestbody只能取一次
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",formEntity,CommonResult.class);
    }


    @PostMapping("/consumer/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") String id){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/get/"+id,"",CommonResult.class);
    }

    @PostMapping("/consumer/payment/create1")
    public CommonResult<Payment> getById1(@RequestBody Payment payment){
        System.out.println(payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

}