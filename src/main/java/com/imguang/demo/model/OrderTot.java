package com.imguang.demo.model;

import java.util.List;

public class OrderTot {
    private Integer id;

    private String orderid;

    private String userName;

    private Double totMoney;

    private String oState;

    private Integer addressid;
    
	private Address address;

	private List<OrderItem> orderItems;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getTotMoney() {
        return totMoney;
    }

    public void setTotMoney(Double totMoney) {
        this.totMoney = totMoney;
    }

    public String getoState() {
        return oState;
    }

    public void setoState(String oState) {
        this.oState = oState;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "OrderTot [id=" + id + ", orderid=" + orderid + ", userName=" + userName + ", totMoney=" + totMoney
				+ ", oState=" + oState + ", addressid=" + addressid + ", address=" + address + ", orderItems="
				+ orderItems + "]";
	}
	
	
}