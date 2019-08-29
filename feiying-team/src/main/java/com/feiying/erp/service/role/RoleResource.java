package com.feiying.erp.service.role;

import com.feiying.erp.service.ResourceInfo;

import java.lang.annotation.*;


@ResourceInfo(value = "role", type = 10)
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RoleResource {
}
