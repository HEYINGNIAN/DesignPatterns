package com.hyn.strategypattern.v3.controller;


import com.hyn.strategypattern.v3.annotation.SupportUserType;
import com.hyn.strategypattern.v3.code.UserType;
import com.hyn.strategypattern.v3.service.CustomerService3;
import com.hyn.strategypattern.v3.service.imp.DefaultCustomerService3;
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
@RequestMapping("/v3/customers")
public class CustomerController3 {

    //这样就不需要@Order注解确认顺序了，都是在map中get
    private Map<UserType, CustomerService3> customerServiceMap;

    @Autowired
    private DefaultCustomerService3 defaultCustomerService;

    @Autowired
    public void setCustomerServiceMap(List<CustomerService3> customerService) {
        this.customerServiceMap = customerService.stream().filter(service -> service.getClass().isAnnotationPresent(SupportUserType.class)).collect(Collectors.toMap(this::findUserType, Function.identity())  // value: service 自身
        );
        if (this.customerServiceMap.size() != com.hyn.strategypattern.v2.code.UserType.values().length) {
            throw new RuntimeException("有用户类型没有对应的策略");
        }
    }


    @GetMapping("/{recharge}")
    public String getCustomer(@PathVariable String recharge) {
        try {
            int rechargeNum = Integer.parseInt(recharge);
            UserType userType = UserType.typeof(rechargeNum);
            CustomerService3 customerService = customerServiceMap.getOrDefault(userType, defaultCustomerService);
            return customerService.findCustomer();
        } catch (Exception e) {
            return "传值错误";
        }

    }

    private UserType findUserType(CustomerService3 customerService) {
        SupportUserType annotation = customerService.getClass().getAnnotation(SupportUserType.class);
        return annotation.value();
    }

}
