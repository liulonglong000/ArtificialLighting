package com.face.service;

import com.face.model.Session;

import java.util.Date;

public interface ISessionService {
    Session getSession(String token);
    Session getSessionByUserId(Integer userId);
    void deleteSession(String token);
    void addSession(Session session);
    void updateCaptureTime(Integer userId, Date captureTime);
    void reflushSession(Session session);
    void deleteExpireSession(Date expireTime);
	void updateSimilarTime(Integer userId, Date lastTime);
}
