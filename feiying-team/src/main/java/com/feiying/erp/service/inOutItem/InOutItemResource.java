package com.feiying.erp.service.inOutItem;

import com.feiying.erp.service.ResourceInfo;

import java.lang.annotation.*;


@ResourceInfo(value = "inOutItem", type = 35)
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface InOutItemResource {
}
