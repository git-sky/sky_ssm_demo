package cn.com.sky.src.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AdminFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();

		String contextPath = req.getContextPath();

		/* 过滤对admin文件夹下所有的jsp和action的访问，只有管理员登录不被拦截 */

		//System.out.println(uri.startsWith(contextPath + "/admin/"));
	
		//System.out.println(req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/index.html");
		System.out.println("filter>>>>>>>>>>>>>>>>>>>>>>>>>>>...............................");
		if (uri.startsWith(contextPath + "/admin/")
				&& uri.compareToIgnoreCase("/web/admin/adminLogin.jsp") != 0) {

			if (null == req.getSession().getAttribute("admin")) {
						req.getRequestDispatcher("/index.html").forward(request,
						response);
						System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				return;
			}
		}

		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}


}
