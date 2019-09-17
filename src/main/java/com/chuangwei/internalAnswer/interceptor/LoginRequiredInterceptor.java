package com.chuangwei.internalAnswer.interceptor;

import com.chuangwei.internalAnswer.model.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (hostHolder.getUser() == null) {
            String s=httpServletRequest.getRequestURI();
           //System.out.println(s);
            /*String queryString = httpServletRequest.getQueryString();
            String s1=s;*/
//            httpServletResponse.sendRedirect("/reglogin?next=" + httpServletRequest.getRequestURI()
//                    +"&queryString="+ queryString);
            httpServletRequest.setAttribute("next",httpServletRequest.getRequestURI());
            httpServletRequest.getRequestDispatcher("/reglogin").forward(httpServletRequest,httpServletResponse);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
