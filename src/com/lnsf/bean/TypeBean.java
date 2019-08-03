package com.lnsf.bean;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.utils.consoletable.enums.Align;
import com.lnsf.utils.consoletable.table.Cell;

public class TypeBean {

	private Integer typeId;
	private String typeName;
	private Integer flag;
	
	public Object[] getAll(){
		int c = 0;
		Object[] o = new Object[1];
		if(typeId != null){
			o[c++] = typeId;
		}
		if(typeName != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = typeName;
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
		if(typeName != null){
			o[c++] = typeName;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flag;
		}
		if(typeId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = typeId;
		}
		return o;
	}

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
	
	public static List<Cell> getHeader() {
		List<Cell> header = new ArrayList<Cell>() {
			{
				add(new Cell("ID."));
				add(new Cell("Name"));
			}
		};
		return header;
	}
	
	public List<Cell> getBody() {
		String strId = String.valueOf(typeId);
		List<Cell> body = new ArrayList<Cell>() {
			{
				add(new Cell(Align.CENTER, strId));
				add(new Cell(Align.CENTER, typeName));
			}
		};
		return body;
	}
}