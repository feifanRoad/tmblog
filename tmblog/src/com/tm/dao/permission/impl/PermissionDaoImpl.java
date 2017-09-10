package com.tm.dao.permission.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tm.core.dao.TmBaseDao;
import com.tm.dao.permission.IPermissionDao;
import com.tm.model.Permission;

@Repository
public class PermissionDaoImpl extends TmBaseDao<Permission, Integer> implements IPermissionDao{

	@Override
	public List<HashMap<String, Object>> findPermissionByUserId(Integer userId) {
		String sql = "SELECT DISTINCT t5.`name`,t5.url,t5.model,t5.method"+
					 " FROM tm_admin_role t1"+
					 " LEFT JOIN tm_admin_role_user t2 ON t1.id = t2.role_id"+
					 " LEFT JOIN tm_admin_user t3 ON t3.id = t2.user_id"+
					 " LEFT JOIN tm_admin_role_permission t4 ON t2.role_id = t4.role_id"+
					 " LEFT JOIN tm_admin_permission t5 ON t4.permission_id = t5.id"+
					 " WHERE t3.id = ? ORDER BY t1.id ";
				return getSession().createSQLQuery(sql).setInteger(0, userId).list();
	}

	@Override
	public List<Permission> findRoot() {
		return getSession().createQuery("FROM Permission WHERE isDelete =0 AND parent.id= 1").list();
	}

	@Override
	public List<Permission> findChildrens(Integer parentId) {
		return getSession().createQuery("FROM Permission WHERE isDelete =0 and parent.id = "+parentId).list();
	}

}
