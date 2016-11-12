package com.demo.service;

import java.util.List;

import com.demo.model.Category;

public interface CategoryService {
	public void insert(Category category);
	public void update(Category category);
	public void delete(int id);
	public int queryCategoryId();
	public List<Category> queryCategoryList();
	public Category queryCategoryOne(int id);
}
