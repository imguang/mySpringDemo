package com.imguang.demo.dao;

import java.util.Map;

import com.imguang.demo.model.UserT;

public interface UserTMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserT record);

    int insertSelective(UserT record);

    UserT selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserT record);

    int updateByPrimaryKey(UserT record);
    
    UserT seletcByUserName(String userName);
    
    UserT seletcByUserNamePassword(Map<String, String> map);
}