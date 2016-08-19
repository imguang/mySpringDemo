package com.imguang.demo.model;

public class OrderItem {
	private Integer id;

	private String orderid;

	private Integer productid;

	private Integer pNum;

	private Double pPrice;

	private Product product;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getpNum() {
		return pNum;
	}

	public void setpNum(Integer pNum) {
		this.pNum = pNum;
	}

	public Double getpPrice() {
		return pPrice;
	}

	public void setpPrice(Double pPrice) {
		this.pPrice = pPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderid=" + orderid + ", productid=" + productid + ", pNum=" + pNum
				+ ", pPrice=" + pPrice + ", product=" + product + "]";
	}
	
	
}