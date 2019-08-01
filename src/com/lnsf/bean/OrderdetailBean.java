package com.lnsf.bean;

public class OrderdetailBean {

	private Integer orderDetailId;
	private String orderId;
	private Integer productId;
	private Integer productCount;
	private Integer flag;
	
	public Object[] getAll(){
		int c = 0;
		Object[] o = new Object[1];
		if(orderDetailId != null){
			o[c++] = orderDetailId;
		}
		if(orderId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = orderId;
		}
		if(productId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = productId;
		}
		if(productCount != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = productCount;
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
		if(orderId != null){
			o[c++] = orderId;
		}
		if(productId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = productId;
		}
		if(productCount != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = productCount;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flag;
		}
		if(orderDetailId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = orderDetailId;
		}
		return o;
	}

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public String getOrderId() {
		return orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public OrderdetailBean() {
		super();
	}

	public OrderdetailBean(Integer orderDetailId, String orderId,
			Integer productId, Integer productCount, Integer flag) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.productId = productId;
		this.productCount = productCount;
		this.flag = flag;
	}
}