package com.lnsf.bean;

public class OrderdetailBean {

	private Integer orderDetailId;
	private String orderId;
	private Integer productId;
	private Integer productCount;
	private Integer flag;

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