package com.hyn.strategypattern.v2.controller;


import com.hyn.strategypattern.v2.code.UserType;
import com.hyn.strategypattern.v2.service.CustomerService2;
import com.hyn.strategypattern.v2.service.imp.DefaultCustomerService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 策略模式步骤
 * 1. 抽象逻辑
 * 2. 实现具体的逻辑策略
 * 3.选择一个不同的策略
 * 4.调用策略具体的逻辑
 *
 * @Author: hyn
 * @CreateTime: 2025-05-14  10:54
 * @Description: 原始代码
 * @Version: 1.0
 */
@RestController
@RequestMapping("/v2_1/customers")
public class CustomerController2_1 {


    //这样就不需要@Order注解确认顺序了，都是在map中get
    private Map<UserType, CustomerService2> customerServiceMap;

    @Autowired
    private DefaultCustomerService2 defaultCustomerService;

    @Autowired
    public void setCustomerServiceMap(List<CustomerService2> customerService) {
        this.customerServiceMap = customerService.stream().filter(service -> service.support() != null).collect(Collectors.toMap(CustomerService2::support,  // key: service.support()
                Function.identity()   // value: service 自身
        ));
        if (this.customerServiceMap.size() != UserType.values().length) {
            throw new RuntimeException("有用户类型没有对应的策略");
        }
    }


    @GetMapping("/{recharge}")
    public String getCustomer(@PathVariable String recharge) {
        try {
            int rechargeNum = Integer.parseInt(recharge);
            UserType userType = UserType.typeof(rechargeNum);
            //这里做了优化，这里是直接从map中获取，不在像之前那么每一个service都需要在list中遍历
            CustomerService2 customerService = customerServiceMap.getOrDefault(userType, defaultCustomerService);
            return customerService.findCustomer();
        } catch (Exception e) {
            return "传值错误";
        }

    }
}
