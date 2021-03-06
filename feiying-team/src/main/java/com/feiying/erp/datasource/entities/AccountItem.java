package com.feiying.erp.datasource.entities;

import java.math.BigDecimal;

public class AccountItem {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_accountitem.Id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_accountitem.HeaderId
     *
     * @mbggenerated
     */
    private Long headerid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_accountitem.AccountId
     *
     * @mbggenerated
     */
    private Long accountid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_accountitem.InOutItemId
     *
     * @mbggenerated
     */
    private Long inoutitemid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_accountitem.EachAmount
     *
     * @mbggenerated
     */
    private BigDecimal eachamount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_accountitem.Remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_accountitem.tenant_id
     *
     * @mbggenerated
     */
    private Long tenantId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_accountitem.delete_Flag
     *
     * @mbggenerated
     */
    private String deleteFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_accountitem.Id
     *
     * @return the value of feiying_accountitem.Id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_accountitem.Id
     *
     * @param id the value for feiying_accountitem.Id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_accountitem.HeaderId
     *
     * @return the value of feiying_accountitem.HeaderId
     *
     * @mbggenerated
     */
    public Long getHeaderid() {
        return headerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_accountitem.HeaderId
     *
     * @param headerid the value for feiying_accountitem.HeaderId
     *
     * @mbggenerated
     */
    public void setHeaderid(Long headerid) {
        this.headerid = headerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_accountitem.AccountId
     *
     * @return the value of feiying_accountitem.AccountId
     *
     * @mbggenerated
     */
    public Long getAccountid() {
        return accountid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_accountitem.AccountId
     *
     * @param accountid the value for feiying_accountitem.AccountId
     *
     * @mbggenerated
     */
    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_accountitem.InOutItemId
     *
     * @return the value of feiying_accountitem.InOutItemId
     *
     * @mbggenerated
     */
    public Long getInoutitemid() {
        return inoutitemid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_accountitem.InOutItemId
     *
     * @param inoutitemid the value for feiying_accountitem.InOutItemId
     *
     * @mbggenerated
     */
    public void setInoutitemid(Long inoutitemid) {
        this.inoutitemid = inoutitemid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_accountitem.EachAmount
     *
     * @return the value of feiying_accountitem.EachAmount
     *
     * @mbggenerated
     */
    public BigDecimal getEachamount() {
        return eachamount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_accountitem.EachAmount
     *
     * @param eachamount the value for feiying_accountitem.EachAmount
     *
     * @mbggenerated
     */
    public void setEachamount(BigDecimal eachamount) {
        this.eachamount = eachamount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_accountitem.Remark
     *
     * @return the value of feiying_accountitem.Remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_accountitem.Remark
     *
     * @param remark the value for feiying_accountitem.Remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_accountitem.tenant_id
     *
     * @return the value of feiying_accountitem.tenant_id
     *
     * @mbggenerated
     */
    public Long getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_accountitem.tenant_id
     *
     * @param tenantId the value for feiying_accountitem.tenant_id
     *
     * @mbggenerated
     */
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_accountitem.delete_Flag
     *
     * @return the value of feiying_accountitem.delete_Flag
     *
     * @mbggenerated
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_accountitem.delete_Flag
     *
     * @param deleteFlag the value for feiying_accountitem.delete_Flag
     *
     * @mbggenerated
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}