package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.LoginLog;
import com.demo.service.LoginLogService;

@Controller
public class LoginLogController {

	@Autowired
	private LoginLogService loginLogService;
	/**
	 * log管理页面
	 * @return
	 */
	@RequestMapping(value="/Admin/loginlog")
	public ModelAndView requestLoginlogSetting(){
		
		List<LoginLog> loginLogList=loginLogService.queryLoginLogList();
		System.out.println("===========requestLoginlogSetting=============="+loginLogList.size());
		ModelAndView mav=new ModelAndView();
		mav.addObject("loginLogList", loginLogList);
		mav.setViewName("/Admin/loginlog");
		return mav;
	}
	
	
	@RequestMapping(value="/Admin/deletLoginLog")
	public ModelAndView requestDeleteLoginlog(int id){
		System.out.println("===========requestDeleteLoginlog==============");
		loginLogService.deleteLoginOne(id);
		return requestLoginlogSetting();
	}
}
