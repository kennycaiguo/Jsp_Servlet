package com.exam.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        // 获得请求的URI
        String path = request.getRequestURI();
        // 从session里获取filmId
        String filmId = (String) session.getAttribute("filmId");

        // 登陆页面无需过滤
        if (path.indexOf("/login.jsp") > -1) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 判断如果没有取到员工信息,就跳转到登陆页面
        if (filmId == null || "".equals(filmId)) {
            // 跳转到登陆页面
            response.sendRedirect("/login.jsp");
        } else {
            // 已经登陆,继续此次请求
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
