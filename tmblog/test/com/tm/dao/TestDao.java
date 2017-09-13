package com.tm.dao;

import java.util.List;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tm.dao.permission.IPermissionDao;
import com.tm.service.permission.IPermissionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestDao {

	@Autowired
	private  IPermissionService permissionService;
	
	@Test
	public void handel() throws JSONException{
		List<Object[]> objects = permissionService.findPermissionByUserId(1);
		System.out.println(JSONUtil.serialize(objects));
	}
}
