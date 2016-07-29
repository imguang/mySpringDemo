package com.imguang.demo.service;

import org.springframework.web.multipart.MultipartFile;

import com.imguang.demo.model.Product;

public interface IProductService {
	public boolean transferFileAndInsert(MultipartFile file, String realPath,
			Product product);

}
