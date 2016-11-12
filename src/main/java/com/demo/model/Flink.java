package com.demo.model;

public class Flink {

	private int id;
	private String name;
	private String url;
	private String flinkDesc;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFlinkDesc() {
		return flinkDesc;
	}
	public void setFlinkDesc(String flinkDesc) {
		this.flinkDesc = flinkDesc;
	}
	@Override
	public String toString() {
		return "Flink [id=" + id + ", name=" + name + ", url=" + url + ", flinkDesc=" + flinkDesc + "]";
	}

    
	
}
