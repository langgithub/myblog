package com.demo.model;

public class PageSearch {

	//默认查询一次查询多少页
	private  int pageRow=5;
	
	//要查询的当前页，根据currentpage 放回first
	private int currentPage;
	//计算要查询的其实点
	private int firstRow;
	
	//总共多少条记录
	private int totalCount;
	//总共的页数
	private int pages;
	
	public int getPages() {
		return pages;
	}
	
	public int getFirstRow() {
		return firstRow;
	}
    
	public int getPageRow() {
		return pageRow;
	}

	public PageSearch(int pageRow, int currentPage, int totalCount) {
		super();
		this.pageRow = pageRow;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		jisuan();
	}

	public PageSearch(int currentPage, int totalCount) {
		super();
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		jisuan();
	}
	
	private void jisuan(){
		pages=totalCount/pageRow;
		int yushu=totalCount%pageRow;
		if(yushu!=0){
			pages++;
		}
		firstRow=(currentPage-1)*pageRow;
	}
	
	
    
	
	

	
}
