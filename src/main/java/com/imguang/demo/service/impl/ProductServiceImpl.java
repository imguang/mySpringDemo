package com.imguang.demo.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

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
	public String transferFileAndInsert(MultipartFile file, String realPath,
			Product product) {
		String originString = file.getOriginalFilename();
		// 文件没上传或上传失败
		if (originString == null || originString.equals("")) {
			return "2";
		}
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
				product.setgImgurl("/resources/img/" + datePath + logImageName);
				int re = productMapper.insert(product);
				if (re != 0) {
					return "1";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "2";
	}

	@Override
	public List<Product> selectAllProducts() {
		return productMapper.selectAllProducts();
	}

}
