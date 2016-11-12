package com.demo.dao;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.FileModel;
import com.demo.model.PageSearch;

@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW)
public interface FileDao {

	public void insertFile(FileModel file);
	public List<FileModel> queryFileList();
	public List<FileModel> queryFileListPage(PageSearch pageSearch);
	public FileModel queryFileOne(int id);
	public void deleteFileOne(int id);
	public int totalRow();
	public void updateFile(FileModel fileModel);
}
