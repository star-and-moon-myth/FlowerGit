package com.lnsf.bean;

import java.util.Date;

public class InputBean {

	private Integer inputId;
	private String flowerName;
	private Integer inputNum;
	private Float intputPrice;
	private Date inputDate;
	private Integer flag;
	
	public Object[] getAll(){
		int c = 0;
		Object[] o = new Object[1];
		if(inputId != null){
			o[c++] = inputId;
		}
		if(flowerName != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerName;
		}
		if(inputNum != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = inputNum;
		}
		if(intputPrice != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = intputPrice;
		}
		if(inputDate != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = inputDate;
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
		if(flowerName != null){
			o[c++] = flowerName;
		}
		if(inputNum != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = inputNum;
		}
		if(intputPrice != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = intputPrice;
		}
		if(inputDate != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = inputDate;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = inputDate;
		}
		if(inputId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = inputId;
		}
		return o;
	}

	public Integer getInputId() {
		return inputId;
	}

	public void setInputId(Integer inputId) {
		this.inputId = inputId;
	}

	public String getFlowerName() {
		return flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	public Integer getInputNum() {
		return inputNum;
	}

	public void setInputNum(Integer inputNum) {
		this.inputNum = inputNum;
	}

	public Float getIntputPrice() {
		return intputPrice;
	}

	public void setIntputPrice(Float intputPrice) {
		this.intputPrice = intputPrice;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public InputBean(Integer inputId, String flowerName, Integer inputNum,
			Float intputPrice, Date inputDate, Integer flag) {
		super();
		this.inputId = inputId;
		this.flowerName = flowerName;
		this.inputNum = inputNum;
		this.intputPrice = intputPrice;
		this.inputDate = inputDate;
		this.flag = flag;
	}

	public InputBean() {
		super();
	}

	
}