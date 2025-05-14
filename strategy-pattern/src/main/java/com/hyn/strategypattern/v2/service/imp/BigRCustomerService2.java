package com.hyn.strategypattern.v2.service.imp;

import com.hyn.strategypattern.v2.code.UserType;
import com.hyn.strategypattern.v2.service.CustomerService2;
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
public class BigRCustomerService2 implements CustomerService2 {

    @Override
    public UserType support() {
        return UserType.BIGR;
    }

    @Override
    public String findCustomer() {
        return "大R玩家客服";
    }


}
