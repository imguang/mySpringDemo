package com.imguang.demo.entity;

import com.imguang.demo.model.Address;
import com.sun.swing.internal.plaf.synth.resources.synth_it;

public class AddressEntity {
	private Integer id;

	private String realName;

	private String province;

	private String city;

	private String district;

	private String code;

	private String phonenum;

	public AddressEntity() {
	}

	public AddressEntity(Address address) {
		this.id = address.getId();
		this.realName = address.getRealName();
		this.province = address.getProvince();
		this.city = address.getCity();
		this.district = address.getDistrict();
		this.code = address.getCode();
		this.phonenum = address.getPhonenum();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

}
