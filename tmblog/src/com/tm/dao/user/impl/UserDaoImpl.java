package com.tm.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.tm.core.dao.TmBaseDao;
import com.tm.dao.user.IUserDao;
import com.tm.model.TmParams;
import com.tm.model.User;

@Repository
public class UserDaoImpl extends TmBaseDao<User, Integer> implements IUserDao {

	@Override
	public User getAdminUser(TmParams params) {
		User adminUser = (User) getSession()
				.createQuery("FROM User WHERE account = ? AND password = ? AND isDelete = 0")
				.setString(0, params.getAccount())
				.setString(1, params.getPassword())
				.uniqueResult();
		System.out.println("+++++++++++++++++++查询成功");
		return adminUser;
	}

	@Override
	public User saveAdminUser(User adminUser) {
		try {
			getSession().save(adminUser);
			return adminUser;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("保存数据失败");
		}
	}

	@Override
	public User updata(User adminUser) {
		try {
			updateDefault(adminUser);
			return adminUser;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("更新数据失败");
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			User adminUser= (User) getSession().load(User.class, id);
			getSession().delete(adminUser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
