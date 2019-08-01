package com.lnsf.bean;

public class FlowerBean {

	private Integer flowerId;
	private String flowerName;
	private Integer stock;
	private Float flowerPrice;
	private Integer flag;

	public Integer getFlowerId() {
		return flowerId;
	}

	public String getFlowerName() {
		return flowerName;
	}

	public Integer getStock() {
		return stock;
	}

	public Float getFlowerPrice() {
		return flowerPrice;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlowerId(Integer flowerId) {
		this.flowerId = flowerId;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void setFlowerPrice(Float flowerPrice) {
		this.flowerPrice = flowerPrice;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public FlowerBean() {
		super();
	}

	public FlowerBean(Integer flowerId, String flowerName, Integer stock,
			Float flowerPrice, Integer flag) {
		super();
		this.flowerId = flowerId;
		this.flowerName = flowerName;
		this.stock = stock;
		this.flowerPrice = flowerPrice;
		this.flag = flag;
	}
}