package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.Teacher;

public interface TeacherService {

	public boolean deleteById(int TeacherId);

	public List<Teacher> selectTeacher();

	public int updateById(Teacher t);

	public int addTeacher(Teacher t);

}
