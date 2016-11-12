package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.NoticeDao;
import com.demo.model.Notice;
import com.demo.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;
	
	public void insertNotice(Notice notice) {
		// TODO Auto-generated method stub
		noticeDao.insertNotice(notice);
	}

	public List<Notice> queryNoticeList() {
		// TODO Auto-generated method stub
		return noticeDao.queryNoticeList();
	}

	public void deleteNotice(int id) {
		// TODO Auto-generated method stub
		noticeDao.deleteNotice(id);
	}

}
