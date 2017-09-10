package com.tm.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tm.model.User;
import com.tm.util.TmConstants;


/**
 * 登陆拦截器<BR>
 * LoginInterceptor<BR>
 * 创建人:lifan<BR>
 * 时间：2017年9月10日-下午4:05:14
 * @version 1.0.0
 *
 */
public class LoginInterceptor extends TmConstants implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		User adminUser = (User) request.getSession().getAttribute(SESSION_USER);
		String requestType = request.getHeader("X-Requested-With");//告诉：是一个ajax请求 XMLHttpRequest
		//获取工程的相对路径
		String basePath = request.getContextPath();
		//session为空
		if (adminUser == null) {
			if (requestType != null && requestType.equals("XMLHttpRequest")) {
				//如果是ajax返回源代码，那么直接返回字符串logout
				response.getWriter().print(LOGOUT);
			}else{
				response.sendRedirect(basePath+"/login");// 跳转到登陆页去
			}
			return false;
		} else {
			return true;// 让下一个拦截器去执行
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
