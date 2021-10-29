package com.face.service;

import java.util.List;

import com.face.model.IgcsBAlarm;

public interface IAlarmService {

	List<IgcsBAlarm> findNewByUserId(String userId) throws Exception;

	void updateByAlarmIds(String[] aIdArray) throws Exception;

}
