package com.tm.dao.user;

import com.tm.model.TmParams;
import com.tm.model.User;

public interface IUserDao {

	/**
	 * 查询用户信息<BR>
	 * 方法名：getAdminUser<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午10:43:55
	 * @param params
	 * @return User
	 * @exception 
	 * @since  1.0.0
	 */
	public User getAdminUser(TmParams params);
	
	/**
	 * 保存用户信息<BR>
	 * 方法名：saveAdminUser<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午10:45:12
	 * @param adminUser
	 * @return User
	 * @exception 
	 * @since  1.0.0
	 */
	public User saveAdminUser(User adminUser);
	
	/**
	 * 更新用户信息<BR>
	 * 方法名：updata<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午10:45:34
	 * @param adminUser
	 * @return User
	 * @exception 
	 * @since  1.0.0
	 */
	public User updata(User adminUser);
	
	/**
	 * 删除用户信息(真实删除)<BR>
	 * 方法名：delete<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午10:46:07
	 * @param id
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean delete(Integer id);
}
