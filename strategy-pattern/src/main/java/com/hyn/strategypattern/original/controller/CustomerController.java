package com.hyn.strategypattern.original.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hyn
 * @CreateTime: 2025-05-14  10:54
 * @Description: 原始代码
 * @Version: 1.0
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @GetMapping("/{recharge}")
    public String getCustomer(@PathVariable String recharge) {
        try {
            int rechargeNum = Integer.parseInt(recharge);
            if (rechargeNum > 0 && rechargeNum <= 100) {
                return "普通玩家客服";
            } else if (rechargeNum > 100 && rechargeNum <= 1000) {
                return "小R玩家客服";
            } else if (rechargeNum > 1000 && rechargeNum <= 100000) {
                return "大R玩家客服";
            } else if (rechargeNum > 100000) {
                return "专属客服";
            } else {
                return "找不到客服";
            }
        } catch (Exception e) {
            return "传值错误";
        }

    }
}
