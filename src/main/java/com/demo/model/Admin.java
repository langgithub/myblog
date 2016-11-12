package com.demo.model;

public class Admin {

	private int id;
	private String username;
	private String name;
	private String pwd;
	private String phone;
	
	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", name=" + name + ", pwd=" + pwd + ", phone=" + phone
				+ "]";
	}
	
}
