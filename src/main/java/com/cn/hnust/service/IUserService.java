package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.User;

public interface IUserService {
	public User getUserById(int userId);

	public User findUserExist(String name, String pwd);

	public boolean deleteById(int userId);

	public List<User> selectUser();

	public int updateById(User u);

	public int addUser(User u);

	public List<User> selectUserByName(String name);
}
