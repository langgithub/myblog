package com.demo.model;

public class LoginLog {

	private int id;
	private int userId;
	private String ip;
	private String date;
	private int userIdIsAdmin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUserIdIsAdmin() {
		return userIdIsAdmin;
	}
	public void setUserIdIsAdmin(int userIdIsAdmin) {
		this.userIdIsAdmin = userIdIsAdmin;
	}
	@Override
	public String toString() {
		return "LoginLog [id=" + id + ", userId=" + userId + ", ip=" + ip + ", date=" + date + ", userIdIsAdmin="
				+ userIdIsAdmin + "]";
	}
	
}
