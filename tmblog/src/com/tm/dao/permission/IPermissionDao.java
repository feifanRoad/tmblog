package com.tm.dao.permission;

import java.util.HashMap;
import java.util.List;

import com.tm.model.Permission;


public interface IPermissionDao {

	/**
	 * 根据用户id查询出用户所有的权限<BR>
	 * 方法名：findPermissionByUserId<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午11:08:45
	 * @param userId
	 * @return List<Object[]>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Object[]> findPermissionByUserId(Integer userId);
	
	/**
	 * 查找权限根目录<BR>
	 * 方法名：findRoot<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午11:15:22
	 * @return List<Permission>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Permission> findRoot();
	
	/**
	 * 查询出子目录<BR>
	 * 方法名：findChildrens<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-下午11:15:55
	 * @param parentId
	 * @return List<Permission>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Permission> findChildrens(Integer parentId);
	
}
