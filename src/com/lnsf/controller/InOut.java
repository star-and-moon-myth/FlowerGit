package com.lnsf.controller;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.ProductDaoImpl;
import com.lnsf.service.ProductService;
import com.lnsf.service.impl.ProductServiceImpl;
import com.lnsf.utils.consoletable.enums.Align;
import com.lnsf.utils.consoletable.table.Cell;

public class InOut {

	String flowerName;
	Integer inNum;
	Float inPrice;
	Float inMoney;
	Integer outNum;
	Float outPrice;
	Float outMoney;
	
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public Integer getInNum() {
		return inNum;
	}
	public void setInNum(Integer inNum) {
		this.inNum = inNum;
	}
	public Float getInPrice() {
		return inPrice;
	}
	public void setInPrice(Float inPrice) {
		this.inPrice = inPrice;
	}
	public Float getInMoney() {
		return inMoney;
	}
	public void setInMoney(Float inMoney) {
		this.inMoney = inMoney;
	}
	public Integer getOutNum() {
		return outNum;
	}
	public void setOutNum(Integer outNum) {
		this.outNum = outNum;
	}
	public Float getOutPrice() {
		return outPrice;
	}
	public void setOutPrice(Float outPrice) {
		this.outPrice = outPrice;
	}
	public Float getOutMoney() {
		return outMoney;
	}
	public void setOutMoney(Float outMoney) {
		this.outMoney = outMoney;
	}
	
	public InOut() {
		super();
	}
	public InOut(String flowerName, Integer inNum, Float inPrice,
			Float inMoney, Integer outNum, Float outPrice, Float outMoney) {
		super();
		this.flowerName = flowerName;
		this.inNum = inNum;
		this.inPrice = inPrice;
		this.inMoney = inMoney;
		this.outNum = outNum;
		this.outPrice = outPrice;
		this.outMoney = outMoney;
	}
	
	public static List<Cell> getHeader() {
		List<Cell> header = new ArrayList<Cell>() {
			{
				add(new Cell("花名FlowerName"));
				add(new Cell("入库数目InNum"));
				add(new Cell("入库单价InPrice"));
				add(new Cell("入库金额InMoney"));
				add(new Cell("出库数目InNum"));
				add(new Cell("出库单价InPrice"));
				add(new Cell("出库金额InMoney"));
			}
		};
		return header;
	}
	
	public List<Cell> getBody() {
		ProductService ps = new ProductServiceImpl(new ProductDaoImpl());
		String str1 = String.valueOf(inNum);
		String str2 = String.valueOf(inPrice);
		String str3 = String.valueOf(inMoney);
		String str4 = String.valueOf(outNum);
		String str5 = String.valueOf(outPrice);
		String str6 = String.valueOf(outMoney);
		List<Cell> body = new ArrayList<Cell>() {
			{
				add(new Cell(Align.CENTER, flowerName));
				add(new Cell(Align.CENTER, str1));
				add(new Cell(Align.CENTER, str2));
				add(new Cell(Align.CENTER, str3));
				add(new Cell(Align.CENTER, str4));
				add(new Cell(Align.CENTER, str5));
				add(new Cell(Align.CENTER, str6));
			}
		};
		return body;
	}

}
