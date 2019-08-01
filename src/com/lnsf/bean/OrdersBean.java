package com.lnsf.bean;

import java.util.Date;
import java.util.Date;
import java.util.Date;

public class OrdersBean {

	private String orderId;
	private Date orderDate;
	private Date deliverDate;
	private Date finishDate;
	private Integer conId;
	private Float orderPrice;
	private Integer state;
	private Integer flag;
	
	public Object[] getAll(){
		int c = 0;
		Object[] o = new Object[1];
		if(orderId != null){
			o[c++] = orderId;
		}
		if(orderDate != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = orderDate;
		}
		if(deliverDate != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = deliverDate;
		}
		if(finishDate != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = finishDate;
		}
		if(conId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = conId;
		}
		if(orderPrice != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = orderPrice;
		}
		if(state != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = state;
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
		if(orderDate != null){
			o[c++] = orderDate;
		}
		if(deliverDate != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = deliverDate;
		}
		if(finishDate != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = finishDate;
		}
		if(conId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = conId;
		}
		if(orderPrice != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = orderPrice;
		}
		if(state != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = state;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flag;
		}
		if(orderId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = orderId;
		}
		return o;
	}

	public String getOrderId() {
		return orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Date getDeliverDate() {
		return deliverDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public Integer getConId() {
		return conId;
	}

	public Float getOrderPrice() {
		return orderPrice;
	}

	public Integer getState() {
		return state;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public void setConId(Integer conId) {
		this.conId = conId;
	}

	public void setOrderPrice(Float orderPrice) {
		this.orderPrice = orderPrice;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public OrdersBean() {
		super();
	}

	public OrdersBean(String orderId, Date orderDate, Date deliverDate,
			Date finishDate, Integer conId, Float orderPrice, Integer state,
			Integer flag) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.deliverDate = deliverDate;
		this.finishDate = finishDate;
		this.conId = conId;
		this.orderPrice = orderPrice;
		this.state = state;
		this.flag = flag;
	}
}