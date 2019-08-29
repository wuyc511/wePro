package com.feiying.erp.service.unit;

import com.feiying.erp.service.ResourceInfo;

import java.lang.annotation.*;


@ResourceInfo(value = "unit", type = 40)
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnitResource {
}
