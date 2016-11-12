package com.demo.model;

public class Comment {

	private int id;
	private String comment;
	private String date;
	//如果userid=-1，表示是一游客
	private int userId;
	private int fileId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", date=" + date + ", userId=" + userId + ", fileId="
				+ fileId + "]";
	}
	
}
