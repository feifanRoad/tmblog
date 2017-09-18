package com.tm.core.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tm.model.User;
import com.tm.service.permission.IPermissionService;
import com.tm.util.TmConstants;

/**
 * 权限拦截器<BR>
 * PermissionFilter<BR>
 * 创建人:lifan<BR>
 * 时间：2017年9月14日-下午8:11:39
 * @version 1.0.0
 *
 */
public class PermissionFilter extends TmConstants implements Filter{

	private ServletContext sc;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//		this.sc = filterConfig.getServletContext();
//		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
//		IPermissionService permissionService = (IPermissionService) context.getBean("permissionServiceImpl");
//		System.out.println(permissionService);
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String basePath = request.getContextPath();
		User user = (User) request.getSession().getAttribute(SESSION_USER);
		if (user!=null) {
			Integer userId = user.getId();
			String uri = request.getRequestURI();//相对路径
			List<Object[]> perList = (List<Object[]>) request.getSession().getAttribute(SESSION_PERMISSION_ROLE);
			if (isPermission(uri, perList)) {
				//权限让步
				chain.doFilter(request, response);
			}else {
				response.sendRedirect(basePath+"/error.jsp");
			}
		}else {
			response.sendRedirect(basePath+"/login");
		}
	}
	
	@Override
	public void destroy() {
		
	}
	
	/**
	 * 判断是否有权限<BR>
	 * 方法名：isPermission<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月14日-下午10:08:25
	 * @param uri
	 * @param objects
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	private boolean isPermission(String uri, List<Object[]> objects){
		if ((objects == null) || (objects!=null && objects.size()==0)) return false;
		boolean flag = false;
		for (Object[] objects2 : objects) {
			String puri = String.valueOf(objects2[0]);
			if (uri.indexOf(puri)!=-1) {
				flag = true;
				break;//当前请求的uri在数据库中有,说明有这项权限，那就了跳出，不再循环
			}
//			String model = String.valueOf(objects2[1]);
//			String method = String.valueOf(objects2[2]);
		}
		return flag;
	}

}
