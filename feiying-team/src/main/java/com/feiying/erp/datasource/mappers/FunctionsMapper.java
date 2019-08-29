package com.feiying.erp.datasource.mappers;

import com.feiying.erp.datasource.entities.Functions;
import com.feiying.erp.datasource.entities.FunctionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunctionsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_functions
     *
     * @mbggenerated
     */
    int countByExample(FunctionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_functions
     *
     * @mbggenerated
     */
    int deleteByExample(FunctionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_functions
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_functions
     *
     * @mbggenerated
     */
    int insert(Functions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_functions
     *
     * @mbggenerated
     */
    int insertSelective(Functions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_functions
     *
     * @mbggenerated
     */
    List<Functions> selectByExample(FunctionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_functions
     *
     * @mbggenerated
     */
    Functions selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_functions
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Functions record, @Param("example") FunctionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_functions
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Functions record, @Param("example") FunctionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_functions
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Functions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_functions
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Functions record);
}