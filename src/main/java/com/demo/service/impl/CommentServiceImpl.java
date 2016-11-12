package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.CommentDao;
import com.demo.model.Comment;
import com.demo.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	
	public void insertComment(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.insertComment(comment);
	}


	public List<Comment> queryListByFileId(int fileId) {
		// TODO Auto-generated method stub
		return commentDao.queryListByFileId(fileId);
	}


	public List<Comment> queryList() {
		// TODO Auto-generated method stub
		return commentDao.queryList();
	}


	public void deleteCommentById(int id) {
		// TODO Auto-generated method stub
		commentDao.deleteCommentById(id);
	}

}
