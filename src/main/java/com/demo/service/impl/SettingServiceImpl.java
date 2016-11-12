package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.SettingDao;
import com.demo.model.Setting;
import com.demo.service.SettingService;

@Service
public class SettingServiceImpl implements SettingService{

	@Autowired
	private SettingDao settingDao;
	
	public Setting querySetting() {
		// TODO Auto-generated method stub
		return settingDao.querySetting();
	}

	public void updateSetting(Setting setting) {
		// TODO Auto-generated method stub
		settingDao.updateSetting(setting);
	}

}
