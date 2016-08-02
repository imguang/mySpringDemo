package com.imguang.demo.dao;

import java.util.List;
import java.util.Map;

import com.imguang.demo.model.Product;

public interface ProductMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Product record);

	int insertSelective(Product record);

	Product selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Product record);

	int updateByPrimaryKeyWithBLOBs(Product record);

	int updateByPrimaryKey(Product record);

	List<Product> selectAllProducts();

	int selectProductCnt();

	List<Product> selectLimit(Map<String, Object> maps);
}