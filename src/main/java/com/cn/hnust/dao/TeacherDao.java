package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.Teacher;
import com.cn.hnust.pojo.User;

public interface TeacherDao {

	//添加教师信息
	int insert(Teacher record);
	//根据id删除
	boolean deleteById(Integer id);
    //根据id修改
	int updateById(Teacher record);
	//查询所有
	List<Teacher> selectTeacher();
	
	
}
