package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentService {
    public String paymentInfo_OK(String id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_OK , id:"+id+"O(∩_∩)O哈哈";
    }

    @HystrixCommand(fallbackMethod = "payment_timeout" )
    public String paymentInfo_TimeOut(String id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.info("线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOut , 耗时时间3秒 , id:"+id+"O(∩_∩)O哈哈");
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOut , 耗时时间3秒 , id:"+id+"O(∩_∩)O哈哈";
    }

    public String payment_timeout(String id) {
        return "8001接口处理时间过长";
    }
}
