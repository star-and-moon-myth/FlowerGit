package com.lnsf.controller;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.utils.consoletable.enums.Align;
import com.lnsf.utils.consoletable.table.Cell;

public class CartProduct {

	private Integer productId;
	private String productName;
	private Float productPrice;
	private Integer productNum;
	
	public CartProduct() {
		super();
	}

	public CartProduct(Integer productId, String productName,
			Float productPrice, Integer productNum) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productNum = productNum;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductNum() {
		return productNum;
	}

	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartProduct other = (CartProduct) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}

	public static List<Cell> getHeader() {
		List<Cell> header = new ArrayList<Cell>() {
			{
				add(new Cell("ID."));
				add(new Cell("Name"));
				add(new Cell("Price"));
				add(new Cell("Number"));
			}
		};
		return header;
	}
	
	public List<Cell> getBody() {
		String strId = String.valueOf(productId);
		String strPrice = String.valueOf(productPrice);
		String strNum = String.valueOf(productNum);
		List<Cell> body = new ArrayList<Cell>() {
			{
				add(new Cell(Align.CENTER, strId));
				add(new Cell(Align.CENTER, productName));
				add(new Cell(Align.CENTER, strPrice));
				add(new Cell(Align.CENTER, strNum));
			}
		};
		return body;
	}

}
