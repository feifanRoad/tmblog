package com.tm.service.permission.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.permission.IPermissionDao;
import com.tm.dao.user.IUserDao;
import com.tm.model.Permission;
import com.tm.model.User;
import com.tm.model.TmParams;
import com.tm.service.permission.IAdminPermissionService;
import com.tm.service.user.IAdminUserService;

/**
 * 权限service实现类<BR>
 * AdminPermissionServiceImpl<BR>
 * 创建人:lifan<BR>
 * 时间：2017年9月10日-下午11:22:22
 * @version 1.0.0
 *
 */
@Service
public class AdminPermissionServiceImpl implements IAdminPermissionService{

	@Autowired
	private IPermissionDao permissionDao;
	
	@Override
	public List<HashMap<String, Object>> findPermissionByUserId(Integer userId) {
		return permissionDao.findPermissionByUserId(userId);
	}

	@Override
	public List<Permission> findRoot() {
		return permissionDao.findRoot();
	}

	@Override
	public List<Permission> findChildrens(Integer parentId) {
		return permissionDao.findChildrens(parentId);
	}



}
