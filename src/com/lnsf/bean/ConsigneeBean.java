package com.lnsf.bean;

public class ConsigneeBean {

	private Integer conId;
	private String conName;
	private String conTel;
	private String conAddr;
	private String userId;
	private Integer flag;

	public Integer getConId() {
		return conId;
	}

	public String getConName() {
		return conName;
	}

	public String getConTel() {
		return conTel;
	}

	public String getConAddr() {
		return conAddr;
	}

	public String getUserId() {
		return userId;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setConId(Integer conId) {
		this.conId = conId;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public void setConTel(String conTel) {
		this.conTel = conTel;
	}

	public void setConAddr(String conAddr) {
		this.conAddr = conAddr;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public ConsigneeBean() {
		super();
	}

	public ConsigneeBean(Integer conId, String conName, String conTel,
			String conAddr, String userId, Integer flag) {
		super();
		this.conId = conId;
		this.conName = conName;
		this.conTel = conTel;
		this.conAddr = conAddr;
		this.userId = userId;
		this.flag = flag;
	}
}