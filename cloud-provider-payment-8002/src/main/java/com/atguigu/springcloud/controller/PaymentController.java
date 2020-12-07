package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2020-12-03 11:39:07
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("payment/create")
    public CommonResult create(@RequestBody  Payment payment){
        paymentService.save(payment);
        log.info("插入结果集："+payment.getId());

        if(!ObjectUtils.isEmpty(payment.getId())){
            return new CommonResult(200,"插入数据库成功,端口号为："+serverPort,payment.getId());
        }else{
            return new CommonResult(500,"插入数据库失败");

        }
    }

    @PostMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getById(id);
        log.info("查询到的数据："+payment);

        if(!ObjectUtils.isEmpty(payment)){
            return new CommonResult(200,"查询到的数据,端口号为："+serverPort,payment);
        }else {
            return new CommonResult(200,"查询数据失败");
        }
    }

}