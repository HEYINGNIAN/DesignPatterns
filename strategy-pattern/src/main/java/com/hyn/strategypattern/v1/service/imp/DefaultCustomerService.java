package com.hyn.strategypattern.v1.service.imp;

import com.hyn.strategypattern.v1.service.CustomerService;
import org.springframework.stereotype.Component;

/**
 * @Author: hyn
 * @CreateTime: 2025-05-14  14:00
 * @Description:
 * @Version: 1.0
 */
@Component
public class DefaultCustomerService implements CustomerService {
    @Override
    public String findCustomer() {
        return "普通玩家";
    }

    @Override
    public boolean support(int recharge) {
        return true;
    }
}
