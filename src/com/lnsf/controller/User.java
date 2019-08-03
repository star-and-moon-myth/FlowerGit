package com.lnsf.controller;

import java.util.Date;

import com.lnsf.bean.UserBean;
import com.lnsf.bean.UserdetailBean;
import com.lnsf.dao.impl.UserDaoImpl;
import com.lnsf.dao.impl.UserdetailDaoImpl;
import com.lnsf.service.UserService;
import com.lnsf.service.UserdetailService;
import com.lnsf.service.impl.UserServiceImpl;
import com.lnsf.service.impl.UserdetailServiceImpl;

public class User {
	private static String userId;
	private static String userName;
	private static String password;
	private static Integer role;
	private static String userSex;
	private static Integer userPoint;
	private static Integer loginCount;
	private static Date loginTime;
	
	public static String getUserId() {
		if(userId == null && userName == null){
			return null;
		}
		return userId;
	}
	public static void setUserId(String userId) {
		User.userId = userId;
	}
	public static String getUserName() {
		if(userId == null && userName == null){
			return null;
		}
		return userName;
	}
	public static void setUserName(String userName) {
		User.userName = userName;
	}
	public static String getPassword() {
		if(userId == null && userName == null){
			return null;
		}
		return password;
	}
	public static void setPassword(String password) {
		User.password = password;
	}
	public static Integer getRole() {
		if(userId == null && userName == null){
			return null;
		}
		return role;
	}
	public static void setRole(Integer role) {
		User.role = role;
	}
	public static String getUserSex() {
		if(userId == null && userName == null){
			return null;
		}
		return userSex;
	}
	public static void setUserSex(String userSex) {
		User.userSex = userSex;
	}
	public static Integer getUserPoint() {
		if(userId == null && userName == null){
			return null;
		}
		return userPoint;
	}
	public static void setUserPoint(Integer userPoint) {
		User.userPoint = userPoint;
	}
	public static Integer getLoginCount() {
		if(userId == null && userName == null){
			return null;
		}
		return loginCount;
	}
	public static void setLoginCount(Integer loginCount) {
		User.loginCount = loginCount;
	}
	public static Date getLoginTime() {
		if(userId == null && userName == null){
			return null;
		}
		return loginTime;
	}
	public static void setLoginTime(Date loginTime) {
		User.loginTime = loginTime;
	}
	
	public static int login() {
		int flag = 0;
		if (userId == null && userName == null) {
			return 0;
		} else {
			UserService us = new UserServiceImpl(new UserDaoImpl());
			UserdetailService uds = new UserdetailServiceImpl(
					new UserdetailDaoImpl());
			for (UserBean ub1 : us.selectAll()) {
				if((ub1.getUserId().equals(userId) || ub1.getUserName().equals(userName)) && ub1.getPassword().equals(password)
						 && ub1.getFlag() == 1){
					User.userId = ub1.getUserId();
					User.userName = ub1.getUserName();
					User.role = ub1.getRole();
					flag = 1;
				}
			}
			if(flag == 1){
				UserdetailBean udb1 = new UserdetailBean();
				for (UserdetailBean udb : uds.selectAll()) {
					if (udb.getUserId().equals(userId)) {
						User.userSex = udb.getUserSex();
						User.userPoint = udb.getUserPoint();
						User.loginCount = udb.getLoginCount()+1;
						User.loginTime = new Date();
						udb1.setUserDetailId(udb.getUserDetailId());
					}
				}
				udb1.setLoginCount(loginCount);
				udb1.setLoginTime(loginTime);
				uds.updateByIdSelective(udb1);
			}
		}
		return flag;
	}
	
	public static void logout(){
		User.userId = null;
		User.userName = null;
		User.password = null;
		User.role = null;
		User.userSex = null;
		User.userPoint = null;
		User.loginCount = null;
		User.loginTime = null;
	}
}
