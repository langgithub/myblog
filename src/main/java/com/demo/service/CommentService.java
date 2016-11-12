package com.demo.service;

import java.util.List;

import com.demo.model.Comment;

public interface CommentService {

	public void insertComment(Comment comment);
	public List<Comment> queryListByFileId(int fileId);
	public List<Comment> queryList();
	public void deleteCommentById(int id);
}
