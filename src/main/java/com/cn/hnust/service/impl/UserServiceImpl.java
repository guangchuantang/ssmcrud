package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}
	public User findUserExist(String name, String pwd) {
		// TODO Auto-generated method stub
		return this.userDao.findUserExist(name,pwd);
	}
	public boolean deleteById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.deleteById(userId);
	}
	public List<User> selectUser() {
		// TODO Auto-generated method stub
		return this.userDao.selectUser();
	}
	public int updateById(User u) {
		// TODO Auto-generated method stub
		return this.userDao.updateByPrimaryKeySelective(u);
	}
	public int addUser(User u) {
		// TODO Auto-generated method stub
		return this.userDao.insert(u);
	}
	public List<User> selectUserByName(String name) {
		// TODO Auto-generated method stub
		return this.userDao.selectUserByName(name);
	}

}
