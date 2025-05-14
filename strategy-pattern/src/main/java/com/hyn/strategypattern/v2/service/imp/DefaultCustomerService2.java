package com.hyn.strategypattern.v2.service.imp;

import com.hyn.strategypattern.v2.code.UserType;
import com.hyn.strategypattern.v2.service.CustomerService2;
import org.springframework.stereotype.Component;

/**
 * @Author: hyn
 * @CreateTime: 2025-05-14  14:00
 * @Description:
 * @Version: 1.0
 */
@Component
public class DefaultCustomerService2 implements CustomerService2 {
    @Override
    public String findCustomer() {
        return "普通玩家";
    }

    @Override
    public UserType support() {
        return null;
    }
}
