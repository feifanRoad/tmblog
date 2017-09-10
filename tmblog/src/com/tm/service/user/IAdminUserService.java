package com.tm.service.user;

import com.tm.model.User;
import com.tm.model.TmParams;

/**
 * 
 * IChannelService
 * 创建人:lifan 
 * 时间：2017年07月21日 10:08:22
 * @version 1.0.0
 * 
 */
public interface IAdminUserService {


	/**
	 * 查询用户信息<BR>
	 * 方法名：getAdminUser<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午4:19:34
	 * @param params
	 * @return AdminUser
	 * @exception 
	 * @since  1.0.0
	 */
	public User getAdminUser(TmParams params);
	
	/**
	 * 保存用户信息<BR>
	 * 方法名：saveAdminUser<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午4:57:47
	 * @param params
	 * @return AdminUser
	 * @exception 
	 * @since  1.0.0
	 */
	public User saveAdminUser(User adminUser);
	
	/**
	 * 更新用户信息<BR>
	 * 方法名：updata<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午4:59:00
	 * @param adminUser
	 * @return AdminUser
	 * @exception 
	 * @since  1.0.0
	 */
	public User updata(User adminUser);
	
	/**
	 * 删除用户信息<BR>
	 * 方法名：delete<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午4:59:52
	 * @param id
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean delete(Integer id);
}
