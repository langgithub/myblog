package com.demo.service;

import java.util.List;

import com.demo.model.Notice;

public interface NoticeService {

	public void insertNotice(Notice notice);
	public List<Notice> queryNoticeList();
	public void deleteNotice(int id);
}
