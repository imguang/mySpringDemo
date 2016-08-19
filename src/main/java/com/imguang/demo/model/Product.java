package com.imguang.demo.model;

public class Product {
	private Integer id;

	private String gName;

	private Long gPrice;

	private Integer gNum;

	private String gImgurl;

	private String gDescription;

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
		this.gName = gName == null ? null : gName.trim();
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
		this.gImgurl = gImgurl == null ? null : gImgurl.trim();
	}

	public String getgDescription() {
		return gDescription;
	}

	public void setgDescription(String gDescription) {
		this.gDescription = gDescription == null ? null : gDescription.trim();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", gName=" + gName + ", gPrice=" + gPrice
				+ ", gNum=" + gNum + ", gImgurl=" + gImgurl + ", gDescription="
				+ gDescription + "]";
	}

}