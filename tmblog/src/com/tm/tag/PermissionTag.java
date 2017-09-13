package com.tm.tag;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tm.service.permission.IPermissionService;
import com.tm.util.TmStringUtils;


/**
 * 内容tag
 * 类名: ContentBeanTag
 * 创建人:lifan 
 * 时间：2017年9月1日 下午5:27:15 
 * @version 1.0.0
 *
 */
public class PermissionTag extends BodyTagSupport {
	
	private String var;// 变量的对象名称

	public int doStartTag() throws JspException {
		ServletContext context = this.pageContext.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		IPermissionService permissionService = (IPermissionService) ctx.getBean("permissionServiceImpl");
		List<Object[]> permissionList = permissionService.findPermissionByUserId(1);
		if (TmStringUtils.isEmpty(var))var = "permissionList";
		pageContext.setAttribute(var, permissionList);
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	public void setVar(String var) {
		this.var = var;
	}
	
}
