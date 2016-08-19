package com.imguang.demo.dao;

import com.imguang.demo.model.OrderTot;

public interface OrderTotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderTot record);

    int insertSelective(OrderTot record);

    OrderTot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderTot record);

    int updateByPrimaryKey(OrderTot record);
    
    OrderTot selectCasByPrimaryKey(Integer id);
}