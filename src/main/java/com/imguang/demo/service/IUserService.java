package com.imguang.demo.service;

import java.util.List;

import com.imguang.demo.model.UserT;

public interface IUserService {
	public UserT getUserById(int userId);

	public boolean insert(UserT userT);

	public boolean comfirmUserByName(String userName);

	public boolean comfirmUserByNameAndPassword(String user_name, String password);

	public List<UserT> selectAllUserTs();

	public boolean deleteByPrimaryKey(int id);

	public String resetPasswordByPrimaryKey(int id);

	public int selectUserCnt();

	public List<UserT> selectLimit(int limit, int offset);

	public UserT selectUserByUserName(String userName);
}
