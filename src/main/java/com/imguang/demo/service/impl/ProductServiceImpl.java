package com.imguang.demo.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.imguang.demo.dao.ProductMapper;
import com.imguang.demo.model.Product;
import com.imguang.demo.service.IProductService;
import com.imguang.demo.util.DateFormatUtil;

@Service
public class ProductServiceImpl implements IProductService {

	@Resource
	ProductMapper productMapper;

	@Override
	public String insertProduct(Product product) {
		int re = productMapper.insert(product);
		if (re != 0) {
			return "1";
		}
		return "2";
	}

	@Override
	public List<Product> selectAllProducts() {
		return productMapper.selectAllProducts();
	}

	@Override
	public String deleteOneProducts(int id, HttpServletRequest request,
			HttpServletResponse response) {
		Product temProduct = productMapper.selectByPrimaryKey(id);
		if (temProduct == null) {
			return "3";
		}
		String realPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ temProduct.getgImgurl();
		// 首先删除图片
		File file2 = new File(realPath);
		file2.delete();
		int re = productMapper.deleteByPrimaryKey(id);
		if (re != 0) {
			return "1";
		}
		return "2";
	}

	@Override
	public String updateProduct(MultipartFile file, Product product,
			HttpServletRequest request, HttpServletResponse response) {
		Product temProduct = productMapper.selectByPrimaryKey(product.getId());
		if (temProduct == null) {
			return "3";
		}
		String originString = file.getOriginalFilename();
		if (originString == null || originString.equals("")) {
			product.setgImgurl(temProduct.getgImgurl());
		} else {// 如果要进行图片更改
			String realPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ temProduct.getgImgurl();
			// 首先删除图片
			File file2 = new File(realPath);
			file2.delete();
			// 转存文件
			product.setgImgurl(transferFile(file, request, response));
		}
		int i = productMapper.updateByPrimaryKey(product);
		if (i > 0) {
			return "1";
		}
		return "2";
	}

	@Override
	public String transferFile(MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		String realPath = request.getSession().getServletContext()
				.getRealPath("/");
		String originString = file.getOriginalFilename();
		// 文件后缀
		String suffix = originString.substring(originString.lastIndexOf("."));
		// @TODO 后缀判断
		// 生成文件名
		String logImageName = UUID.randomUUID().toString() + suffix;
		String datePath = DateFormatUtil.getFormat(new Date());
		// 文件保存路径
		String filePath = realPath + "/resources/img/" + datePath;
		File oneFile = new File(filePath);
		try {
			if (!file.isEmpty()) {
				if (!oneFile.exists()) {
					oneFile.mkdirs();
				}
				oneFile = new File(filePath + logImageName);
				if (!oneFile.exists()) {
					oneFile.createNewFile();
				}
				// 转存文件
				file.transferTo(oneFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/resources/img/" + datePath + logImageName;
	}

}
