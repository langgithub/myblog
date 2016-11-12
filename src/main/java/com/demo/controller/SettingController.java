package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Setting;
import com.demo.service.SettingService;

@Controller
public class SettingController {

	@Autowired
	private SettingService settingService;
	
	@RequestMapping(value="/Admin/setting")
	public ModelAndView requestBaseSetting(){
		Setting setting=settingService.querySetting();
		System.out.println("========================"+setting.toString());
		ModelAndView mav=new ModelAndView();
		mav.addObject("setting", setting);
		mav.setViewName("/Admin/setting");
		return mav;
	}
	
	
	@RequestMapping(value="Admin/updateSetting")
	public ModelAndView requestUserSetting(Setting setting){
		System.out.println("============usersetting================="+setting.toString());
		
		settingService.updateSetting(setting);

		Setting settingShow=settingService.querySetting();
		System.out.println(settingShow==null);
		ModelAndView mav=new ModelAndView();
		mav.addObject("setting", settingShow);
		mav.addObject("core", "200");
		mav.setViewName("/Admin/setting");
		return mav;
	}


}
