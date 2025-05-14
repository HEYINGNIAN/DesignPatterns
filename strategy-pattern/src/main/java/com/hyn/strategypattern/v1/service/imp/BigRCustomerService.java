package com.hyn.strategypattern.v1.service.imp;

import com.hyn.strategypattern.v1.service.CustomerService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: hyn
 * @CreateTime: 2025-05-14  11:55
 * @Description:
 * @Version: 1.0
 */
@Component
@Order(1)
public class BigRCustomerService implements CustomerService {

    @Override
    public String findCustomer() {
        return "大R玩家客服";
    }

    @Override
    public boolean support(int recharge) {
        return recharge > 1000 && recharge <= 10000;
    }
}
