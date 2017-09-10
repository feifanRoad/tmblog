package com.tm.web.permission;

import java.util.List;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.dao.PermissionDao;

@Controller
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionDao permissionDao;
	
	@ResponseBody
	@RequestMapping("/list")
	public String findPermission() throws JSONException {
		List<Object[]> list = permissionDao.findPermissionByUserId(1);
		String result = JSONUtil.serialize(list,null,null,false,true);
		return result;
	}
}
