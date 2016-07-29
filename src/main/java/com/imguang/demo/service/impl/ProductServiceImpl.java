package com.imguang.demo.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
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
	public boolean transferFileAndInsert(MultipartFile file, String realPath,
			Product product) {
		System.out.println(product);
		String datePath = DateFormatUtil.getFormat(new Date());
		// 文件保存路径
		String filePath = realPath + "/resources/img/" + datePath;
		String fileName = DigestUtils.sha1Hex(product.toString())
				+ file.getOriginalFilename();
		File oneFile = new File(filePath);
		try {
			if (!file.isEmpty()) {
				if (!oneFile.exists()) {
					oneFile.mkdirs();
				}
				oneFile = new File(filePath + fileName);
				if (!oneFile.exists()) {
					oneFile.createNewFile();
				}
				// 转存文件
				file.transferTo(oneFile);
				product.setgImgurl("/resources/img/" + datePath + fileName);
				int re = productMapper.insert(product);
				if (re != 0) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
