package com.tm.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.user.IUserDao;
import com.tm.model.User;
import com.tm.model.TmParams;
import com.tm.service.user.IAdminUserService;

/**
 * channel管理serviceImpl
 * IChannelService
 * 创建人:lifan 
 * 时间：2017年07月21日 10:08:22
 * @version 1.0.0
 * 
 */
@Service
public class AdminUserServiceImpl implements IAdminUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User getAdminUser(TmParams params) {
		return userDao.getAdminUser(params);
	}

	@Override
	public User saveAdminUser(User adminUser) {
		return userDao.saveAdminUser(adminUser);
	}

	@Override
	public User updata(User adminUser) {
		return userDao.updata(adminUser);
	}

	@Override
	public boolean delete(Integer id) {
		return userDao.delete(id);
	}


}
