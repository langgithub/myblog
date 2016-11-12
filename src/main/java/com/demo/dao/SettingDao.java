package com.demo.dao;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Setting;

@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW)
public interface SettingDao {

	public Setting querySetting();
	public void updateSetting(Setting setting);
}
