package com.imguang.demo.entity;


/**
 *
 *用来存储页面传来的数据
 *@TODO
 *后端再一次验证
 */
public class TemUser {
	private String userName;
	private String password;
	private String email;
	private String rePassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

}
