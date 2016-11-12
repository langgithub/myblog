package com.demo.model;

import java.util.List;

public class FileModel {

	private int id;
	private String title;
	private String content;
	private String keywords;
	private String fileDesc;
	private Category category;//一对一，一篇文章对应一个Category
	private String tags;//
	private String date;//��������
	private String isPublic;//�Ƿ񹫿�
	private int totalComment;
	private int click;
	/**
	 * 一对多关联映射，一篇文章对应多个评论
	 * 插入数据file时不用，查询时候采用
	 */
	private List<Comment> commentList;

	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	public int getTotalComment() {
		return totalComment;
	}
	public void setTotalComment(int totalComment) {
		this.totalComment = totalComment;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	public String getFileDesc() {
		return fileDesc;
	}
	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}
	@Override
	public String toString() {
		return "FileModel [id=" + id + ", title=" + title + ", content=" + content + ", keywords=" + keywords
				+ ", fileDesc=" + fileDesc + ", tags=" + tags 
				+ ", date=" + date + ", isPublic=" + isPublic + ", click=" + click + "]";
	}

	
}
