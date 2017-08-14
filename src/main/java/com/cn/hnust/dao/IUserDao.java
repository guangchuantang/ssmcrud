package com.cn.hnust.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.User;

public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /** 
     * 使用注解方式传入多个参数查询对用用户是否存在
     * @param 
     * @return #{name},#{pwd}
     */  
	User findUserExist(@Param(value="name")String name,@Param(value="pwd")String pwd);

	boolean deleteById(Integer id);

	List<User> selectUser();
	
	List<User> selectUserByName(@Param(value="name")String name);
	
	
}