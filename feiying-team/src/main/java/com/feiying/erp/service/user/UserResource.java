package com.feiying.erp.service.user;

import com.feiying.erp.service.ResourceInfo;

import java.lang.annotation.*;


@ResourceInfo(value = "user", type = 5)
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserResource {
}
