package com.face.service.impl;

import com.face.mapper.SessionMapper;
import com.face.model.Session;
import com.face.model.SessionExample;
import com.face.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SessionServiceImpl implements ISessionService {

    @Autowired
    private SessionMapper sessionMapper;

    @Override
    public Session getSession(String token) {
        return sessionMapper.selectByPrimaryKey(token);
    }

    @Override
    public Session getSessionByUserId(Integer userId) {
        SessionExample example = new SessionExample();
        SessionExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<Session> sessionList = sessionMapper.selectByExample(example);
        if (null == sessionList || sessionList.isEmpty()) {
            return null;
        }
        return sessionList.get(0);
    }

    @Override
    public void deleteSession(String token) {
        sessionMapper.deleteByPrimaryKey(token);
    }

    @Override
    public void addSession(Session session) {
        sessionMapper.insert(session);
    }

    @Override
    public void updateCaptureTime(Integer userId, Date captureTime) {
        // 待更新字段
        Session session = new Session();
        session.setLastCaptureTime(captureTime);

        // 条件
        SessionExample example = new SessionExample();
        SessionExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);

        // 更新
        sessionMapper.updateByExampleSelective(session, example);
    }

    @Override
    public void updateSimilarTime(Integer userId, Date similarTime) {
        // 待更新字段
        Session session = new Session();
        session.setLastAlarmTime(similarTime);

        // 条件
        SessionExample example = new SessionExample();
        SessionExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);

        // 更新
        sessionMapper.updateByExampleSelective(session, example);
    }
    @Override
    public void reflushSession(Session session) {
        sessionMapper.updateByPrimaryKey(session);
    }

    @Override
    public void deleteExpireSession(Date expireTime) {
        SessionExample example = new SessionExample();
        SessionExample.Criteria criteria = example.createCriteria();
        criteria.andLastActiveTimeLessThan(expireTime);
        sessionMapper.deleteByExample(example);
    }
}
