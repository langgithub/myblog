package com.demo.model;

public class Setting {

	private int id;
	private String title;
	private String fuTitle;
	private String url;
	private String keywords;
	private String settingDesc;
	private String email;
	private String icp;
	private String sessionOut;
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
	public String getFuTitle() {
		return fuTitle;
	}
	public void setFuTitle(String fuTitle) {
		this.fuTitle = fuTitle;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getSettingDesc() {
		return settingDesc;
	}
	public void setSettingDesc(String settingDesc) {
		this.settingDesc = settingDesc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIcp() {
		return icp;
	}
	public void setIcp(String icp) {
		this.icp = icp;
	}
	public String getSessionOut() {
		return sessionOut;
	}
	public void setSessionOut(String sessionOut) {
		this.sessionOut = sessionOut;
	}
	@Override
	public String toString() {
		return "Setting [id=" + id + ", title=" + title + ", fuTitle=" + fuTitle + ", url=" + url + ", keywords="
				+ keywords + ", settingDesc=" + settingDesc + ", email=" + email + ", icp=" + icp + ", sessionOut="
				+ sessionOut + "]";
	}
	
}
