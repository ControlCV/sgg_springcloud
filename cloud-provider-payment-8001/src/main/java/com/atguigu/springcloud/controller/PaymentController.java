package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element:services) {
            log.info("***element"+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : instances) {
            log.info("host:"+serviceInstance.getHost()+"port:"+serviceInstance.getPort()+"uri:"+serviceInstance.getUri());
        }

        return discoveryClient;
    }
}