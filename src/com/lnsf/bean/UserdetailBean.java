package com.lnsf.bean;

import java.util.Date;
import java.util.Date;

public class UserdetailBean {

	private Integer userDetailId;
	private String userId;
	private String userTel;
	private String userSex;
	private Integer userPoint;
	private Date registerTime;
	private Integer loginCount;
	private Date loginTime;
	private Integer flag;
	
	public Object[] getAll(){
		int c = 0;
		Object[] o = new Object[1];
		if(userDetailId != null){
			o[c++] = userDetailId;
		}
		if(userId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = userId;
		}
		if(userTel != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = userTel;
		}
		if(userSex != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = userSex;
		}
		if(userPoint != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = userPoint;
		}
		if(registerTime != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = registerTime;
		}
		if(loginCount != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = loginCount;
		}
		if(loginTime != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = loginTime;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flag;
		}
		return o;
	}
	
	public Object[] getAllbeforeId(){
		int c = 0;
		Object[] o = new Object[1];
		if(userId != null){
			o[c++] = userId;
		}
		if(userTel != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = userTel;
		}
		if(userSex != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = userSex;
		}
		if(userPoint != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = userPoint;
		}
		if(registerTime != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = registerTime;
		}
		if(loginCount != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = loginCount;
		}
		if(loginTime != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = loginTime;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flag;
		}
		if(userDetailId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = userDetailId;
		}
		return o;
	}

	public Integer getUserDetailId() {
		return userDetailId;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserTel() {
		return userTel;
	}

	public String getUserSex() {
		return userSex;
	}

	public Integer getUserPoint() {
		return userPoint;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setUserDetailId(Integer userDetailId) {
		this.userDetailId = userDetailId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public void setUserPoint(Integer userPoint) {
		this.userPoint = userPoint;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public UserdetailBean() {
		super();
	}

	public UserdetailBean(Integer userDetailId, String userId, String userTel,
			String userSex, Integer userPoint, Date registerTime,
			Integer loginCount, Date loginTime, Integer flag) {
		super();
		this.userDetailId = userDetailId;
		this.userId = userId;
		this.userTel = userTel;
		this.userSex = userSex;
		this.userPoint = userPoint;
		this.registerTime = registerTime;
		this.loginCount = loginCount;
		this.loginTime = loginTime;
		this.flag = flag;
	}
}