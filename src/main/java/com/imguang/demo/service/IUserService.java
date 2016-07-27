package com.imguang.demo.service;

import java.util.List;

import com.imguang.demo.model.UserT;

public interface IUserService {
	public UserT getUserById(int userId);

	public boolean insert(UserT userT);

	public boolean selectUserByName(String userName);

	public boolean selectUserByNameAndPassword(String user_name, String password);

	public List<UserT> selectAllUserTs();

	public boolean deleteByPrimaryKey(int id);

	public boolean resetPasswordByPrimaryKey(int id);
}
