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
public class SuperCustomerService implements CustomerService {

    @Override
    public String findCustomer() {
        return "超级客服";
    }

    @Override
    public boolean support(int recharge) {
        return recharge > 100000 && recharge <= 1000000;
    }
}
