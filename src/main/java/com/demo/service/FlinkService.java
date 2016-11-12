package com.demo.service;

import java.util.List;

import com.demo.model.Flink;

public interface FlinkService {

	public void insertFlink(Flink flink);
	public List<Flink> queryFlinkList();
	public Flink queryOneFlink(int id);
	public void deleteFlink(int id);
	public void updateFlink(Flink flink);
}
