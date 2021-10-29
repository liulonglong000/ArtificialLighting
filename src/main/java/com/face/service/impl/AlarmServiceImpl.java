package com.face.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.face.mapper.IgcsBAlarmMapper;
import com.face.model.IgcsBAlarm;
import com.face.model.IgcsBAlarmExample;
import com.face.service.IAlarmService;

@Service
public class AlarmServiceImpl extends BaseServiceImpl implements IAlarmService {
	@Autowired
	private IgcsBAlarmMapper alarmDAO;

	@Override
	public List<IgcsBAlarm> findNewByUserId(String userId) throws Exception {
		IgcsBAlarmExample exp = new IgcsBAlarmExample();
		IgcsBAlarmExample.Criteria cri = exp.createCriteria();
		cri.andRecvUserIdEqualTo(userId);
		cri.andIsReadEqualTo("0");
		exp.setOrderByClause("insert_time asc");
		
		return alarmDAO.selectByExample(exp);
	}

	@Override
	public void updateByAlarmIds(String[] aIdArray) throws Exception {
		for (String aId : aIdArray) {
			IgcsBAlarm alarm = alarmDAO.selectByPrimaryKey(aId);
			alarm.setIsRead("1");
			alarm.setReadTime(new Timestamp(System.currentTimeMillis()));
			alarmDAO.updateByPrimaryKey(alarm);
		}
	}

}
