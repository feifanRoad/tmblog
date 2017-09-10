/**
 * com.tm.web.user
 * UserController.java
 * 创建人:lifan
 * 时间：2017年09月09日 21:31:59
 */
package com.tm.web.user;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.model.User;
import com.tm.service.user.IAdminUserService;
import com.tm.util.TmConstants;

/**
 * 用户层<BR>
 * UserController<BR>
 * 创建人:lifan<BR>
 * 时间：2017年9月10日-下午4:32:58
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/admin/user")
public class UserController extends TmConstants{
	
	@Autowired
	private IAdminUserService userService;
	
	/**
	 * 保存用户信息<BR>
	 * 方法名：save<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-上午11:08:52
	 * @param adminUser
	 * @return
	 * @throws JSONException String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/save",method = RequestMethod.POST)
	@ResponseBody
	public String save(User adminUser) throws JSONException{
		adminUser = userService.saveAdminUser(adminUser);
		//以json的形式返回保存的数据
		String result = JSONUtil.serialize(adminUser,null,null,false,true);
		return result;
	}
	
	/**
	 * 更新用户信息<BR>
	 * 方法名：update<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-上午11:39:35
	 * @param knowlege
	 * @return
	 * @throws JSONException String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public String update(User adminUser) throws JSONException{
		try {
			if (adminUser!=null && adminUser.getId()!=null) {
				User user = userService.updata(adminUser);
				if (user!=null) {
					String result = JSONUtil.serialize(user,null,null,false,true);
					return result;
				}else {
					return FAIL;
				}
			}else {
				return FAIL;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL;
		}
	}
	
	/**
	 * 删除方法<BR>
	 * 方法名：delete<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-上午11:51:53
	 * @param id
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(User adminUser){
		try {
			if (adminUser!=null && adminUser.getId()!=null) {
				adminUser.setIsDelete(1);
				userService.updata(adminUser);
				return SUCCESS;
			}else {
				return FAIL;
			}
			//真实删除，慎用
			//knowlegeDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL;
		}
	}
	
}
