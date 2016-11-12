package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.FileDao;
import com.demo.model.FileModel;
import com.demo.model.PageSearch;
import com.demo.service.FileService;

@Service
public class FileServiceImpl implements FileService{
    
	@Autowired
	private FileDao fileDao;
	
	public void insertFile(FileModel file) {
		// TODO Auto-generated method stub
		fileDao.insertFile(file);
	}

	public List<FileModel> queryFileList() {
		// TODO Auto-generated method stub
		return fileDao.queryFileList();
	}

	public FileModel queryFileOne(int id) {
		// TODO Auto-generated method stub
		return fileDao.queryFileOne(id);
	}

	public void deleteFileOne(int id) {
		// TODO Auto-generated method stub
		fileDao.deleteFileOne(id);
	}

	public int totalRow() {
		// TODO Auto-generated method stub
		return fileDao.totalRow();
	}

	public List<FileModel> queryFileListPage(PageSearch pageSearch) {
		// TODO Auto-generated method stub
		return fileDao.queryFileListPage(pageSearch);
	}

	public void updateFile(FileModel fileModel) {
		// TODO Auto-generated method stub
		fileDao.updateFile(fileModel);
	}

	
}
