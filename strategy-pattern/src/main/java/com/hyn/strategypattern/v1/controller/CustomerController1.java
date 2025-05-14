package com.hyn.strategypattern.v1.controller;

import com.hyn.strategypattern.v1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@RequestMapping("/v1/customers")
public class CustomerController1 {

    //这样可以讲所有实现CustomerService的策略的组件都注入到容器中
    @Autowired
    private List<CustomerService> customerService;

//    @PostConstruct 也可以排序
//    public void init() {

//    }

    @GetMapping("/{recharge}")
    public String getCustomer(@PathVariable String recharge) {
        try {
            int rechargeNum = Integer.parseInt(recharge);
            //多态性
            //这样新增的策略，只需要新增一个类实现CustomerService接口，并注入到容器中，就会自动生效  假设新增PersonalCustomerService,DefaultCustomerService
            //但是兜底策略DefaultCustomerService默认是true，所以 List<CustomerService> customerService 中的顺序是不确定的，有可能返回的都是默认的DefaultCustomerService
            //所以利用@Order注解来指定顺序，默认顺序是Integer的最大值，值越小优先级越高

            for (CustomerService customerService : customerService) {
                if (customerService.support(rechargeNum)) {
                    return customerService.findCustomer();
                }
            }
            return "找不到客服";
        } catch (Exception e) {
            return "传值错误";
        }

    }
}
