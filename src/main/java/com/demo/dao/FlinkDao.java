package com.demo.dao;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Flink;

@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW)
public interface FlinkDao {

	public void insertFlink(Flink flink);
	public List<Flink> queryFlinkList();
	public Flink queryOneFlink(int id);
	public void deleteFlink(int id);
	public void updateFlink(Flink flink);
}
