package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.FlinkDao;
import com.demo.model.Flink;
import com.demo.service.FlinkService;

@Service
public class FlinkServiceimpl implements FlinkService {

	@Autowired
	private FlinkDao flinkDao;
	
	public void insertFlink(Flink flink) {
	   	// TODO Auto-generated method stub
        flinkDao.insertFlink(flink);
	}

	public List<Flink> queryFlinkList() {
		// TODO Auto-generated method stub
		return flinkDao.queryFlinkList();
	}

	public void deleteFlink(int id) {
		// TODO Auto-generated method stub
		flinkDao.deleteFlink(id);
	}

	public void updateFlink(Flink flink) {
		// TODO Auto-generated method stub
		flinkDao.updateFlink(flink);
	}

	public Flink queryOneFlink(int id) {
		// TODO Auto-generated method stub
		return flinkDao.queryOneFlink(id);
	}

}
