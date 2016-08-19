package com.imguang.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.imguang.demo.entity.PageInfo;
import com.imguang.demo.service.IMainPageService;
import com.imguang.demo.service.IProductService;

@Service
public class MainPageServiceImpl implements IMainPageService {

	@Resource
	IProductService productServiceImpl;

	/*
	 * 对分页信息进行处理
	 */
	public PageInfo dealPageInfo(PageInfo pageInfo) {
		if (pageInfo.getTotNum() <= 0) {// 总条数
			pageInfo.setTotNum(productServiceImpl.selectProductCnt());
		}
		if (pageInfo.getOnePageNum() <= 0) {// 一页的条数
			pageInfo.setOnePageNum(9);
		}
		int temPageNum = pageInfo.getTotNum() / pageInfo.getOnePageNum();
		pageInfo.setTotPage(pageInfo.getTotNum() % pageInfo.getOnePageNum() == 0 ? temPageNum : temPageNum + 1);// 总页数
		if (pageInfo.getNowPage() <= 0) {// 当前页数
			pageInfo.setNowPage(1);
		} else if (pageInfo.getNowPage() > pageInfo.getTotNum()) {
			pageInfo.setNowPage(pageInfo.getTotNum());
		}
		return pageInfo;
	}
}
