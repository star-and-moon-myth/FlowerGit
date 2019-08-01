package com.lnsf.bean;

public class FlowerBean {

	private Integer flowerId;
	private String flowerName;
	private Integer stock;
	private Float flowerPrice;
	private Integer flag;
	
	public Object[] getAll(){
		int c = 0;
		Object[] o = new Object[1];
		if(flowerId != null){
			o[c++] = flowerId;
		}
		if(flowerName != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerName;
		}
		if(stock != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = stock;
		}
		if(flowerPrice != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerPrice;
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
		if(stock != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = stock;
		}
		if(flowerPrice != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerPrice;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flag;
		}
		if(flowerId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flowerId;
		}
		return o;
	}

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