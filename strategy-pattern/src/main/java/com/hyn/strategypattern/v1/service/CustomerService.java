package com.hyn.strategypattern.v1.service;

/**
 * 定义策略模式
 */
public interface CustomerService {
    String findCustomer();
    boolean support(int recharge);
}
