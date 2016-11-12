package com.demo.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Notice;
import com.demo.service.NoticeService;
import com.demo.util.DateAndStringUtil;

@Controller
public class NoticeController {

	//private Logger logger=LoggerFactory.getLogger(N)
	@Autowired
	private NoticeService noticeService;
	
	/**
	 * 跳转到查看notice添加页面
	 * @return
	 */
	@RequestMapping(value="/Admin/notice")
	public ModelAndView requestNoticeList() {
		
		List<Notice> noticeList=noticeService.queryNoticeList();
		System.out.println("===================="+noticeList.size());
		ModelAndView mav=new ModelAndView();
		mav.addObject("noticeList", noticeList);
		mav.setViewName("/Admin/notice");
		return mav;
	}
	
	/**
	 * 跳转到查看notice页面
	 * @return
	 */
	@RequestMapping(value="/Admin/add-notice")
	public ModelAndView requestNoticeAdd() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/Admin/add-notice");
		return mav;
	}
	
	/**
	 * 保存一条notice记录
	 * @param notice
	 * @return
	 */
	@RequestMapping(value="/Admin/addnotice")
	public ModelAndView requestAddNotice(Notice notice) {
		noticeService.insertNotice(notice);
		return requestNoticeList();
	}
	
	/**
	 * 保存一条notice记录
	 * @param notice
	 * @return
	 */
	@RequestMapping(value="/Admin/notice_delete")
	public ModelAndView requestDeleteNotice(int id) {
		noticeService.deleteNotice(id);
		return requestNoticeList();
	}

}
