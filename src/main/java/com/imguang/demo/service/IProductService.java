package com.imguang.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.imguang.demo.model.Product;

public interface IProductService {
	public String insertProduct(Product product);

	public List<Product> selectAllProducts();

	public String deleteOneProducts(int id,HttpServletRequest request, HttpServletResponse response);

	public String transferFile(MultipartFile file, HttpServletRequest request,
			HttpServletResponse response);

	public String updateProduct(MultipartFile file, Product product,
			HttpServletRequest request, HttpServletResponse response);

}
