package com.face.mapper;

import com.face.model.UserCamera;
import com.face.model.UserCameraExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCameraMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_camera
     *
     * @mbg.generated
     */
    long countByExample(UserCameraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_camera
     *
     * @mbg.generated
     */
    int deleteByExample(UserCameraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_camera
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_camera
     *
     * @mbg.generated
     */
    int insert(UserCamera record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_camera
     *
     * @mbg.generated
     */
    int insertSelective(UserCamera record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_camera
     *
     * @mbg.generated
     */
    List<UserCamera> selectByExample(UserCameraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_camera
     *
     * @mbg.generated
     */
    UserCamera selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_camera
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") UserCamera record, @Param("example") UserCameraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_camera
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") UserCamera record, @Param("example") UserCameraExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_camera
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserCamera record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_camera
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserCamera record);
}