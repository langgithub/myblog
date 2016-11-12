package com.demo.model;

/**
 * 用户表
 */
public class User {

	private int id;
	private String name;
	private String password;
	private String qq;
	private String date;
	private String email;
	private int isRegister;
	

	
	public int getIsRegister() {
		return isRegister;
	}

	public void setIsRegister(int isRegister) {
		this.isRegister = isRegister;
	}


	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", qq=" + qq + ", date=" + date
				+ ", email=" + email + ", isRegister=" + isRegister + "]";
	}
    

	
}