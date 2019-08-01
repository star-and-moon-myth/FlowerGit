package com.lnsf.bean;

public class ProductdetailBean {

	private Integer productDetailId;
	private Integer productId;
	private Integer flowerId;
	private Integer flowerNum;
	private Integer flag;
	
	public Object[] getAll(){
		int c = 0;
		Object[] o = new Object[1];
		if(productDetailId != null){
			o[c++] = productDetailId;
		}
		if(productId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = productId;
		}
		if(flowerId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerId;
		}
		if(flowerNum != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerNum;
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
		if(productId != null){
			o[c++] = productId;
		}
		if(flowerId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerId;
		}
		if(flowerNum != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerNum;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flag;
		}
		if(productDetailId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = productDetailId;
		}
		return o;
	}

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