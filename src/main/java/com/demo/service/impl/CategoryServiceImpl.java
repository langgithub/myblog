package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.dao.CategoryDao;
import com.demo.model.Category;
import com.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
    @Qualifier("categoryDao")
    private CategoryDao categoryDao;

	public void insert(Category category) {
		// TODO Auto-generated method stub
		categoryDao.insertCategory(category);
	}

	public void update(Category category) {
		// TODO Auto-generated method stub
		categoryDao.updateCategory(category);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryDao.deleteCategory(id);
	}

	public int queryCategoryId() {
		// TODO Auto-generated method stub
		return categoryDao.queryCategoryId();
	}

	public List<Category> queryCategoryList() {
		// TODO Auto-generated method stub
		return categoryDao.queryCategoryList();
	}

	public Category queryCategoryOne(int id) {
		// TODO Auto-generated method stub
		return categoryDao.queryCategoryOne(id);
	}

}
