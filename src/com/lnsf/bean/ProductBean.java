package com.lnsf.bean;

public class ProductBean {

	private Integer productId;
	private String productName;
	private Float productPrice;
	private String remark;
	private Integer useId;
	private Integer objectId;
	private Integer festivalId;
	private Integer somId;
	private Integer flag;

	public Integer getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public String getRemark() {
		return remark;
	}

	public Integer getUseId() {
		return useId;
	}

	public Integer getObjectId() {
		return objectId;
	}

	public Integer getFestivalId() {
		return festivalId;
	}

	public Integer getSomId() {
		return somId;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setUseId(Integer useId) {
		this.useId = useId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public void setFestivalId(Integer festivalId) {
		this.festivalId = festivalId;
	}

	public void setSomId(Integer somId) {
		this.somId = somId;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public ProductBean() {
		super();
	}

	public ProductBean(Integer productId, String productName,
			Float productPrice, String remark, Integer useId, Integer objectId,
			Integer festivalId, Integer somId, Integer flag) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.remark = remark;
		this.useId = useId;
		this.objectId = objectId;
		this.festivalId = festivalId;
		this.somId = somId;
		this.flag = flag;
	}
}