package com.feiying.erp.service.orgaUserRel;

import com.feiying.erp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * Description
 *  机构用户关系
 *
 */
@ResourceInfo(value = "orgaUserRel", type = 115)
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrgaUserRelResource {

}
