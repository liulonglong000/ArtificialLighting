package com.face.common;

import com.face.model.Session;
import com.face.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class WebInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ISessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
     Session session = sessionService.getSession(request.getParameter("token"));
        if (null == session) {
            throw new FaceException(ResultCode.UNLOGIN);
        } else {
            session.setLastActiveTime(new Date());
            sessionService.reflushSession(session);
            request.setAttribute("face_session", session);
            return true;
        }
    	
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

    @Override
    public void afterConcurrentHandlingStarted(
            HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    }

}
