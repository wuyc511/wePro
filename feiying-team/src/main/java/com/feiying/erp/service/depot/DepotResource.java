package com.feiying.erp.service.depot;

import com.feiying.erp.service.ResourceInfo;

import java.lang.annotation.*;


@ResourceInfo(value = "depot", type = 20)
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DepotResource {
}
