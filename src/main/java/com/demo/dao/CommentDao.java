package com.demo.dao;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Comment;

@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW)
public interface CommentDao {

	public void insertComment(Comment comment);
	public List<Comment> queryListByFileId(int fileId);
	public List<Comment> queryList();
	public void deleteCommentById(int id);
}
