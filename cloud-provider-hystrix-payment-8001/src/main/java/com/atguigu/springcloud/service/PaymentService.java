package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_OK(String id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_OK , id:"+id+"O(∩_∩)O哈哈";
    }

    public String paymentInfo_TimeOut(String id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOut , 耗时时间3秒 , id:"+id+"O(∩_∩)O哈哈";
    }
}
