package com.tm.core;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class TmBasePathExposer implements ServletContextAware{

	private ServletContext servletContext;
	private String basePath;

	public void init() {

		getServletContext().setAttribute("basePath",
				getServletContext().getContextPath());

	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	
}
