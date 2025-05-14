package com.hyn.strategypattern.v3.service.imp;

import com.hyn.strategypattern.v3.annotation.SupportUserType;
import com.hyn.strategypattern.v3.code.UserType;
import com.hyn.strategypattern.v3.service.CustomerService3;
import org.springframework.stereotype.Component;

/**
*@Author: hyn
*@CreateTime: 2025-05-14  14:30
*@Description: 
*@Version: 1.0
*/
@Component
@SupportUserType(UserType.NORMAL)
public class NormalCustomerService3 implements CustomerService3 {
    @Override
    public String findCustomer() {
        return "普通玩家客服";
    }

}
