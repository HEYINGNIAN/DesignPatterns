package com.hyn.strategypattern.v1.service.imp;

import com.hyn.strategypattern.v1.service.CustomerService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
*@Author: hyn
*@CreateTime: 2025-05-14  14:30
*@Description: 
*@Version: 1.0
*/
@Component
@Order(1)
public class NormalCustomerService implements CustomerService {
    @Override
    public String findCustomer() {
        return "普通玩家客服";
    }

    @Override
    public boolean support(int recharge) {
        return recharge > 0 && recharge <= 100;
    }
}
