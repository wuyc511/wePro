package com.feiying.erp.datasource.mappers;

import com.feiying.erp.datasource.entities.SerialNumber;
import com.feiying.erp.datasource.entities.SerialNumberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SerialNumberMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_serial_number
     *
     * @mbggenerated
     */
    int countByExample(SerialNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_serial_number
     *
     * @mbggenerated
     */
    int deleteByExample(SerialNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_serial_number
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_serial_number
     *
     * @mbggenerated
     */
    int insert(SerialNumber record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_serial_number
     *
     * @mbggenerated
     */
    int insertSelective(SerialNumber record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_serial_number
     *
     * @mbggenerated
     */
    List<SerialNumber> selectByExample(SerialNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_serial_number
     *
     * @mbggenerated
     */
    SerialNumber selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_serial_number
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SerialNumber record, @Param("example") SerialNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_serial_number
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SerialNumber record, @Param("example") SerialNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_serial_number
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SerialNumber record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_serial_number
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SerialNumber record);
}