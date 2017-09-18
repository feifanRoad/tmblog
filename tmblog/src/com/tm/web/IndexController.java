/**
 * com.tm.web
 * IndexController.java
 * 创建人:lifan
 * 时间：2017年09月09日 21:31:59
 */
package com.tm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户控制层<BR>
 * UserController<BR>
 * 创建人:lifan<BR>
 * 时间：2017年9月10日-下午4:32:58
 * @version 1.0.0
 *
 */
@Controller
public class IndexController{
	
	/**
	 * 跳转到登陆页面<BR>
	 * 方法名：login<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午4:34:37
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
