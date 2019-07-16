package server.reaptheflag.reaptheflag.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import server.reaptheflag.reaptheflag.service.NetworkConditionChecker;
import server.reaptheflag.reaptheflag.util.DateToolUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UdpServerInitializationInterceptor implements HandlerInterceptor {

    private NetworkConditionChecker networkConditionChecker;
    private Logger LOGGER = LogManager.getLogger(UdpServerInitializationInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("a login connection detected, ip: " + request.getRemoteAddr() + "at : " + DateToolUtil.logCurrentDate());
        if(!networkConditionChecker.getUdpCondition()) {
            LOGGER.info("user login failed ip: " + request.getRemoteAddr() + "at : " + DateToolUtil.logCurrentDate());
            response.setStatus(501);
            return false;
        }
        return true;
    }
    @Autowired
    public void setNetworkConditionChecker(NetworkConditionChecker networkConditionChecker) {
        this.networkConditionChecker = networkConditionChecker;
    }

}
