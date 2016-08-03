package com.imguang.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.imguang.demo.dao.UserTMapper;
import com.imguang.demo.model.UserT;
import com.imguang.demo.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private UserTMapper userTMapper;

	@Override
	public UserT getUserById(int userId) {
		return (UserT) userTMapper.selectByPrimaryKey(userId);
	}

	@Override
	public boolean insert(UserT userT) {
		int re = userTMapper.insert(userT);
		if (re != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean selectUserByName(String userName) {
		UserT userT = userTMapper.seletcByUserName(userName);
		if (userT != null && userT.getUserName().equals(userName)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean selectUserByNameAndPassword(String user_name, String password) {
		Map<String, String> temMap = new HashMap<String, String>();
		temMap.put("userName", user_name);
		temMap.put("password", password);
		UserT userT = userTMapper.seletcByUserNamePassword(temMap);
		if (userT != null && userT.getPassword().equals(password)
				&& userT.getUserName().equals(user_name)) {
			return true;
		}
		return false;
	}

	@Override
	public List<UserT> selectAllUserTs() {
		List<UserT> userTs = new ArrayList<UserT>();
		userTs.addAll(userTMapper.selectAllUserTs());
		return userTs;
	}

	@Override
	public boolean deleteByPrimaryKey(int id) {
		if (userTMapper.deleteByPrimaryKey(id) != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean resetPasswordByPrimaryKey(int id) {
		UserT userT = userTMapper.selectByPrimaryKey(id);
		userT.setPassword(DigestUtils.sha1Hex("88888" + userT.getUserName()));
		if (userTMapper.updateByPrimaryKey(userT) != 0) {
			return true;
		}
		return false;
	}

	@Override
	public int selectUserCnt() {
		return userTMapper.selectUserCnt();
	}

	@Override
	public List<UserT> selectLimit(int limit, int offset) {
		Map<String, Object> maps = new HashMap<String, Object>();
		List<UserT> lists = new ArrayList<UserT>();
		maps.put("limit", limit);
		maps.put("offset", offset);
		lists.addAll(userTMapper.selectLimit(maps));
		return lists;
	}

}
