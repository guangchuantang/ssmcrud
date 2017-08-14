package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.TeacherDao;
import com.cn.hnust.pojo.Teacher;
import com.cn.hnust.service.TeacherService;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
	@Resource
	private TeacherDao tDao;

	public boolean deleteById(int TeacherId) {
		// TODO Auto-generated method stub
		return tDao.deleteById(TeacherId);
	}

	public List<Teacher> selectTeacher() {
		// TODO Auto-generated method stub
		return tDao.selectTeacher();
	}

	public int updateById(Teacher t) {
		// TODO Auto-generated method stub
		return tDao.updateById(t);
	}

	public int addTeacher(Teacher t) {
		// TODO Auto-generated method stub
		return tDao.insert(t);
	}
	
}
