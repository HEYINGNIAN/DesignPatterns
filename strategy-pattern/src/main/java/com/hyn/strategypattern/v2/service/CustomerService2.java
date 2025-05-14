package com.hyn.strategypattern.v2.service;

import com.hyn.strategypattern.v2.code.UserType;

/**
 * 定义策略模式
 */
public interface CustomerService2 {
    UserType support();
    String findCustomer();
}
