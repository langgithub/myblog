package com.demo.dao;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Category;

@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW)
public interface CategoryDao {

	public int insertCategory(Category category);
	public void updateCategory(Category category);
	public int deleteCategory(int id);
	public int queryCategoryId();
	public List<Category> queryCategoryList();
	public Category queryCategoryOne(int id);
}
