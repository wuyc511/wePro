package com.feiying.erp.datasource.mappers;

import com.feiying.erp.datasource.entities.OrgaUserRel;
import com.feiying.erp.datasource.entities.OrgaUserRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgaUserRelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_orga_user_rel
     *
     * @mbggenerated
     */
    int countByExample(OrgaUserRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_orga_user_rel
     *
     * @mbggenerated
     */
    int deleteByExample(OrgaUserRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_orga_user_rel
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_orga_user_rel
     *
     * @mbggenerated
     */
    int insert(OrgaUserRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_orga_user_rel
     *
     * @mbggenerated
     */
    int insertSelective(OrgaUserRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_orga_user_rel
     *
     * @mbggenerated
     */
    List<OrgaUserRel> selectByExample(OrgaUserRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_orga_user_rel
     *
     * @mbggenerated
     */
    OrgaUserRel selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_orga_user_rel
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") OrgaUserRel record, @Param("example") OrgaUserRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_orga_user_rel
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") OrgaUserRel record, @Param("example") OrgaUserRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_orga_user_rel
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OrgaUserRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feiying_orga_user_rel
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrgaUserRel record);
}