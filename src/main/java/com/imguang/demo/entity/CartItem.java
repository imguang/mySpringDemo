package com.imguang.demo.entity;

import com.imguang.demo.model.Product;

public class CartItem {

	private Integer id;

	private String gName;

	private Long gPrice;

	private Integer gNum;

	private String gImgurl;

	private int needNum;

	public void setProduct(Product product) {
		id = product.getId();
		gName = product.getgName();
		gPrice = product.getgPrice();
		gNum = product.getgNum();
		gImgurl = "<img src='" + product.getgImgurl() + "' alt='20x20'/>";
	}

	public int getNeedNum() {
		return needNum;
	}

	public void setNeedNum(int needNum) {
		this.needNum = needNum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public Long getgPrice() {
		return gPrice;
	}

	public void setgPrice(Long gPrice) {
		this.gPrice = gPrice;
	}

	public Integer getgNum() {
		return gNum;
	}

	public void setgNum(Integer gNum) {
		this.gNum = gNum;
	}

	public String getgImgurl() {
		return gImgurl;
	}

	public void setgImgurl(String gImgurl) {
		this.gImgurl = gImgurl;
	}

}