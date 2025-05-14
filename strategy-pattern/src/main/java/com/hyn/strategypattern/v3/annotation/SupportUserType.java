package com.hyn.strategypattern.v3.annotation;

import com.hyn.strategypattern.v3.code.UserType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SupportUserType {
    UserType value();
}
