package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.service.PaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Payment)表服务实现类
 *
 * @author makejava
 * @since 2020-12-03 11:39:06
 */
@Service
public class PaymentServiceImpl  extends ServiceImpl<PaymentDao,Payment> implements PaymentService {

}