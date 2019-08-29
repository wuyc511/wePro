package com.feiying.erp.datasource.entities;

import java.math.BigDecimal;

public class Depot {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_depot.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_depot.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_depot.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_depot.warehousing
     *
     * @mbggenerated
     */
    private BigDecimal warehousing;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_depot.truckage
     *
     * @mbggenerated
     */
    private BigDecimal truckage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_depot.type
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_depot.sort
     *
     * @mbggenerated
     */
    private String sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_depot.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_depot.principal
     *
     * @mbggenerated
     */
    private Long principal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_depot.tenant_id
     *
     * @mbggenerated
     */
    private Long tenantId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_depot.delete_Flag
     *
     * @mbggenerated
     */
    private String deleteFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feiying_depot.is_default
     *
     * @mbggenerated
     */
    private Boolean isDefault;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_depot.id
     *
     * @return the value of feiying_depot.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_depot.id
     *
     * @param id the value for feiying_depot.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_depot.name
     *
     * @return the value of feiying_depot.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_depot.name
     *
     * @param name the value for feiying_depot.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_depot.address
     *
     * @return the value of feiying_depot.address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_depot.address
     *
     * @param address the value for feiying_depot.address
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_depot.warehousing
     *
     * @return the value of feiying_depot.warehousing
     *
     * @mbggenerated
     */
    public BigDecimal getWarehousing() {
        return warehousing;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_depot.warehousing
     *
     * @param warehousing the value for feiying_depot.warehousing
     *
     * @mbggenerated
     */
    public void setWarehousing(BigDecimal warehousing) {
        this.warehousing = warehousing;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_depot.truckage
     *
     * @return the value of feiying_depot.truckage
     *
     * @mbggenerated
     */
    public BigDecimal getTruckage() {
        return truckage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_depot.truckage
     *
     * @param truckage the value for feiying_depot.truckage
     *
     * @mbggenerated
     */
    public void setTruckage(BigDecimal truckage) {
        this.truckage = truckage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_depot.type
     *
     * @return the value of feiying_depot.type
     *
     * @mbggenerated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_depot.type
     *
     * @param type the value for feiying_depot.type
     *
     * @mbggenerated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_depot.sort
     *
     * @return the value of feiying_depot.sort
     *
     * @mbggenerated
     */
    public String getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_depot.sort
     *
     * @param sort the value for feiying_depot.sort
     *
     * @mbggenerated
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_depot.remark
     *
     * @return the value of feiying_depot.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_depot.remark
     *
     * @param remark the value for feiying_depot.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_depot.principal
     *
     * @return the value of feiying_depot.principal
     *
     * @mbggenerated
     */
    public Long getPrincipal() {
        return principal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_depot.principal
     *
     * @param principal the value for feiying_depot.principal
     *
     * @mbggenerated
     */
    public void setPrincipal(Long principal) {
        this.principal = principal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_depot.tenant_id
     *
     * @return the value of feiying_depot.tenant_id
     *
     * @mbggenerated
     */
    public Long getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_depot.tenant_id
     *
     * @param tenantId the value for feiying_depot.tenant_id
     *
     * @mbggenerated
     */
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_depot.delete_Flag
     *
     * @return the value of feiying_depot.delete_Flag
     *
     * @mbggenerated
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_depot.delete_Flag
     *
     * @param deleteFlag the value for feiying_depot.delete_Flag
     *
     * @mbggenerated
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feiying_depot.is_default
     *
     * @return the value of feiying_depot.is_default
     *
     * @mbggenerated
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feiying_depot.is_default
     *
     * @param isDefault the value for feiying_depot.is_default
     *
     * @mbggenerated
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
}