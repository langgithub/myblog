package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Category;
import com.demo.service.CategoryService;

/**
 * category控制器
 * @author lang
 *
 */
@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 查询Categorylist
	 * @return
	 */
    @RequestMapping(value="/Admin/category")
    public ModelAndView requestCategory(){
    	List<Category> categoryList=categoryService.queryCategoryList();
        ModelAndView mav=new ModelAndView();
        mav.addObject("categoryList", categoryList);
        mav.setViewName("/Admin/category");
        return mav;
    }
	/**
	 * 添加Category
	 * @return
	 */
	@RequestMapping(value="/Admin/category_add")
	public ModelAndView requestCategoryAdd(Category category){
		categoryService.insert(category);
		return requestCategory();
	}
	/**
	 * 调到Category修改页面
	 * @return
	 */
	@RequestMapping(value="/Admin/category_update",method=RequestMethod.GET)
	public ModelAndView requestUpdateCategoryPage(int id){
		Category category=categoryService.queryCategoryOne(id);
		ModelAndView mav=new ModelAndView();
	    mav.setViewName("update-category");
	    mav.addObject("category", category);
		return mav;
	}
	/**
	 * 跟新Category
	 * @return
	 */
	@RequestMapping(value="/Admin/updateCategory",method=RequestMethod.POST)
	public ModelAndView requestUpdateCategory(Category category){
		categoryService.update(category);
		return requestCategory();
	}
	/**
	 * 删除Category
	 * @return
	 */
	@RequestMapping(value="/Admin/category_delete",method=RequestMethod.GET)
	public ModelAndView requestDeleteCategory(int id){
		categoryService.delete(id);
		return requestCategory();
	}
}
