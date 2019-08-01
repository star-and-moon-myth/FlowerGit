package com.lnsf.bean;

public class TypeBean {

	private Integer typeId;
	private String typeName;
	private Integer flag;

	public Integer getTypeId() {
		return typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public TypeBean() {
		super();
	}

	public TypeBean(Integer typeId, String typeName, Integer flag) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.flag = flag;
	}
}