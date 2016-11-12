package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Flink;
import com.demo.service.FlinkService;

@Controller
public class FlinkController {

	@Autowired
	private FlinkService flinkService;
	
	@RequestMapping(value="/Admin/flink")
	public ModelAndView requestflink(){
		List<Flink> flinkList=flinkService.queryFlinkList();
		ModelAndView mav=new ModelAndView();
		mav.addObject("flinkList", flinkList);
		mav.setViewName("/Admin/flink");
		return mav;
	}
	
	/**
	 * 跳转到添加flink页面
	 * @param flink
	 * @return
	 */
	@RequestMapping(value="/Admin/add-flink")
	public ModelAndView requestaddflinkSetting(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/Admin/add-flink");
		return mav;
	}
	
	/**
	 * 添加flink
	 * @param flink
	 * @return
	 */
	@RequestMapping(value="/Admin/addflink")
	public ModelAndView requestaddflink(Flink flink){
		flinkService.insertFlink(flink);
		return requestflink();
	}
	
	/**
	 * 删除flink
	 * @param flink
	 * @return
	 */
	@RequestMapping(value="/Admin/flinkdelete")
	public ModelAndView requestdeleteflink(int id){
		flinkService.deleteFlink(id);
		return requestflink();
	}
	/**
	 * 跳转到修改flink
	 * @param flink
	 * @return
	 */
	@RequestMapping(value="/Admin/update-flink")
	public ModelAndView requestflinkupdate(int id){
		Flink flink=flinkService.queryOneFlink(id);
		System.out.println("===========requestflinkupdate============"+flink.toString());
		ModelAndView mav=new ModelAndView();
		mav.addObject("flink", flink);
		mav.setViewName("/Admin/update-flink");
		return mav;
	}
	/**
	 * 修改flink
	 * @param flink
	 * @return
	 */
	@RequestMapping(value="/Admin/flinkupdate")
	public ModelAndView requestupdateflink(Flink flink){
		flinkService.updateFlink(flink);
		return requestflink();
	}
}
