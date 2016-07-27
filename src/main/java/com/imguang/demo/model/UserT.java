package com.imguang.demo.model;

public class UserT {
	private Integer id;

	private String userName;

	private String password;

	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	@Override
	public String toString() {
		return "UserT [id=" + id + ", userName=" + userName + ", password="
				+ password + ", email=" + email + "]";
	}

}