/**
 * com.tm.web.user
 * UserController.java
 * 创建人:lifan
 * 时间：2017年09月09日 21:31:59
 */
package com.tm.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.model.User;
import com.tm.model.TmParams;
import com.tm.service.user.IAdminUserService;
import com.tm.util.TmConstants;
import com.tm.util.TmStringUtils;

/**
 * 用户层<BR>
 * UserController<BR>
 * 创建人:lifan<BR>
 * 时间：2017年9月10日-下午4:32:58
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping
public class LoginController extends TmConstants{
	
	@Autowired
	private IAdminUserService userService;
	
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
	
	/**
	 * 登陆方法<BR>
	 * 方法名：logined<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午4:35:43
	 * @param params
	 * @param request
	 * @return AdminUser
	 * @exception 
	 * @since  1.0.0
	 */
	@ResponseBody
	@RequestMapping(value="/logined",method=RequestMethod.POST)
	public String logined(TmParams params, HttpServletRequest request){
		//参数不为空时
		if (params!=null) {
			//用户不为空才进行操作
			if (TmStringUtils.isNotEmpty(params.getAccount()) && TmStringUtils.isNotEmpty(params.getPassword())) {
				//先将密码加密
				params.setPassword(TmStringUtils.md5Base64(params.getPassword()));
				//根据账号和密码查询用户是否存在
				User user = userService.getAdminUser(params);
				
				if (user!=null) {
					if (user.getForbiden()==0) {
						return FORBIDEN;
					}else {
						//拿到请求用户的ip地址
						//String address = TmIpUtil.ipLocation(request);
						user = getSessionUser(user);//用户信息存储
						//将用户信息存入session中
						request.getSession().setAttribute(SESSION_USER, user);
						return SUCCESS;
					}
				}else {//不存在该用户时
					return FAIL;
				}
			}else {//用户名、密码为空时
				return STRNULL;
			}
		}else {
			return ERROR;
		}
	}
	
	/**
	 * 退出登陆<BR>
	 * 方法名：logout<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午4:56:36
	 * @param request
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/logout")
	@ResponseBody
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return SUCCESS;
	}
	
	/**
	 * 存放session的用户信息方法<BR>
	 * 方法名：getSessionUser<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午4:44:02
	 * @param adminUser
	 * @return AdminUser
	 * @exception 
	 * @since  1.0.0
	 */
	public User getSessionUser(User adminUser){
		User user = new User();
		user.setAccount(adminUser.getAccount());
		user.setHeaderPic(adminUser.getHeaderPic());
		user.setId(adminUser.getId());
		user.setMale(adminUser.getMale());
		user.setUsername(adminUser.getUsername());
		return user;
	}
}
