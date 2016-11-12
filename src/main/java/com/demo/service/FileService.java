package com.demo.service;

import java.util.List;

import com.demo.model.FileModel;
import com.demo.model.PageSearch;

public interface FileService {

	public void insertFile(FileModel file);
	public List<FileModel> queryFileList();
	public List<FileModel> queryFileListPage(PageSearch pageSearch);
	public FileModel queryFileOne(int id);
	public void deleteFileOne(int id);
	public int totalRow();
	public void updateFile(FileModel fileModel);
}
