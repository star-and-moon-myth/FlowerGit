package com.lnsf.bean;

public class UserBean {

	private String userId;
	private String userName;
	private String password;
	private Integer role;
	private Integer flag;
	
	public Object[] getAll(){
		int c = 0;
		Object[] o = new Object[1];
		if(userId != null){
			o[c++] = userId;
		}
		if(userName != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = userName;
		}
		if(password != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = password;
		}
		if(role != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = role;
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
		if(userName != null){
			o[c++] = userName;
		}
		if(password != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = password;
		}
		if(role != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = role;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flag;
		}
		if(userId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = userId;
		}
		return o;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Integer getRole() {
		return role;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public UserBean() {
		super();
	}

	public UserBean(String userId, String userName, String password,
			Integer role, Integer flag) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.flag = flag;
	}
}