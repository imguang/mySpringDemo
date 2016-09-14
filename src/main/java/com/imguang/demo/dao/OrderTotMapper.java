package com.imguang.demo.dao;

import java.util.List;

import com.imguang.demo.model.OrderTot;

public interface OrderTotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderTot record);

    int insertSelective(OrderTot record);

    OrderTot selectByPrimaryKey(Integer id);
    
    List<OrderTot> selectCasByUserName(String userName);

    int updateByPrimaryKeySelective(OrderTot record);

    int updateByPrimaryKey(OrderTot record);
    
    OrderTot selectCasByPrimaryKey(Integer id);
}