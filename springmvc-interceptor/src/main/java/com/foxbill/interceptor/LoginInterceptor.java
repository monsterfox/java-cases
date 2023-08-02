package com.foxbill.interceptor;

import com.foxbill.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("<------------------------------>");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        if (user != null){
            return true;
        }
        request.setAttribute("msg","您还没有登录，请先登录");
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
        return false;
    }
}
