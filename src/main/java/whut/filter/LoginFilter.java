package whut.filter;

import whut.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * example2
 * 2020/8/16 8:40
 * 过滤器
 *
 * @author 李俊秋
 **/

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器执行");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");


        /*request.getRequestURL() 返回全路径

         request.getRequestURI() 返回除去host（域名或者ip）部分的路径

         request.getContextPath() 返回工程名部分，如果工程映射为/，此处返回则为空

         request.getServletPath() 返回除去host和工程名部分的路径*/

        String uri = request.getRequestURI();
        System.out.println("uri:" + uri);
        StringBuffer url = request.getRequestURL();
        System.out.println("url:" + url);


        if (username == null && uri.indexOf("login.do") == -1) {
            System.out.println("未登录");
            //返回项目路径
            response.sendRedirect(request.getContextPath() + "/pages/login.jsp");

        } else {
            System.out.println("登陆成功");
            filterChain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
