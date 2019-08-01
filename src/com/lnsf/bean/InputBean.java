package com.lnsf.bean;

import java.util.Date;

public class InputBean {

	private Integer inputId;
	private Integer flowerId;
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
		if(flowerId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerId;
		}
		if(inputNum != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerId;
		}
		if(intputPrice != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerId;
		}
		if(inputDate != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerId;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerId;
		}
		return o;
	}
	
	public Object[] getAllbeforeId(){
		int c = 0;
		Object[] o = new Object[1];
		if(flowerId != null){
			o[c++] = flowerId;
		}
		if(inputNum != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerId;
		}
		if(intputPrice != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerId;
		}
		if(inputDate != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerId;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerId;
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

	public Integer getFlowerId() {
		return flowerId;
	}

	public Integer getInputNum() {
		return inputNum;
	}

	public Float getIntputPrice() {
		return intputPrice;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setInputId(Integer inputId) {
		this.inputId = inputId;
	}

	public void setFlowerId(Integer flowerId) {
		this.flowerId = flowerId;
	}

	public void setInputNum(Integer inputNum) {
		this.inputNum = inputNum;
	}

	public void setIntputPrice(Float intputPrice) {
		this.intputPrice = intputPrice;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public InputBean() {
		super();
	}

	public InputBean(Integer inputId, Integer flowerId, Integer inputNum,
			Float intputPrice, Date inputDate, Integer flag) {
		super();
		this.inputId = inputId;
		this.flowerId = flowerId;
		this.inputNum = inputNum;
		this.intputPrice = intputPrice;
		this.inputDate = inputDate;
		this.flag = flag;
	}
}