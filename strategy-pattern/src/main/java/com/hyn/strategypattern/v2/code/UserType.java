package com.hyn.strategypattern.v2.code;

import java.util.function.IntPredicate;

public enum UserType {
    PERSONAL(recharge -> recharge > 1000000),
    BIGR(recharge -> recharge > 1000 && recharge <= 10000),
    SMALLR(recharge -> recharge > 100 && recharge <= 1000),
    SUPER(recharge -> recharge > 10000 && recharge <= 1000000),
    NORMAL(recharge -> recharge > 0 && recharge <= 100);


    //IntPredicate是一个函数式的接口类型
    private final IntPredicate supper;

    UserType(IntPredicate supper) {
        this.supper = supper;
    }

    public static UserType typeof(int recharge) {
        for (UserType userType : UserType.values()) {
            if (userType.supper.test(recharge)) {
                return userType;
            }
        }
        return null;
    }
}
