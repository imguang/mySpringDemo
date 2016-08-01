package com.imguang.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.imguang.demo.model.Product;

public interface IProductService {
	public String transferFileAndInsert(MultipartFile file, String realPath,
			Product product);

	public List<Product> selectAllProducts();

}
