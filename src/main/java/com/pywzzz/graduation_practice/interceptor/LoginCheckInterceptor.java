package com.pywzzz.graduation_practice.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


      //定义登陆校验拦截器，对访问系统的请求进行拦截检查
public class LoginCheckInterceptor implements HandlerInterceptor {
    /**
     * 在预处理拦截方法中进行请求的登陆校验
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session对象
        HttpSession session = request.getSession();
        //检查session是否有登陆信息
        if(session.getAttribute("loginEmp")==null){
            //如果session中没有记录登陆信息，说明该请求是非法请求，需要将请求重定向到登陆
            response.sendRedirect("/forward/toLogin");
            //返回false，阻止处理继续执行
            return false;
        }
        //对请求放行
        return true;
    }
}
