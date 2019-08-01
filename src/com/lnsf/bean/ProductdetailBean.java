package com.lnsf.bean;

public class ProductdetailBean {

	private Integer productDetailId;
	private Integer productId;
	private Integer flowerId;
	private Integer flowerNum;
	private Integer flag;

	public Integer getProductDetailId() {
		return productDetailId;
	}

	public Integer getProductId() {
		return productId;
	}

	public Integer getFlowerId() {
		return flowerId;
	}

	public Integer getFlowerNum() {
		return flowerNum;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setProductDetailId(Integer productDetailId) {
		this.productDetailId = productDetailId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setFlowerId(Integer flowerId) {
		this.flowerId = flowerId;
	}

	public void setFlowerNum(Integer flowerNum) {
		this.flowerNum = flowerNum;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public ProductdetailBean() {
		super();
	}

	public ProductdetailBean(Integer productDetailId, Integer productId,
			Integer flowerId, Integer flowerNum, Integer flag) {
		super();
		this.productDetailId = productDetailId;
		this.productId = productId;
		this.flowerId = flowerId;
		this.flowerNum = flowerNum;
		this.flag = flag;
	}
}