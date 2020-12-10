package com.atguigu.springcloud.servcie;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")//这里写服务名
public interface PaymentService {

     @PostMapping("/payment/get/{id}")//这里写路由
     CommonResult<Payment> getById(@PathVariable("id") String id);
}
