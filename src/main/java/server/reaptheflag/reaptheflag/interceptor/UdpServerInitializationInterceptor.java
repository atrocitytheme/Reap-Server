package server.reaptheflag.reaptheflag.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import server.reaptheflag.reaptheflag.service.NetworkConditionChecker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UdpServerInitializationInterceptor implements HandlerInterceptor {

    private NetworkConditionChecker networkConditionChecker;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!networkConditionChecker.getUdpCondition()) {
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
