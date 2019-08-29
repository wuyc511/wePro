package com.feiying.erp.service.organization;

import com.feiying.erp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * Description
 *  机构
 */
@ResourceInfo(value = "organization", type = 110)
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrganizationResource {
}
