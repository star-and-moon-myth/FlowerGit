package com.lnsf.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lnsf.bean.FlowerBean;
import com.lnsf.bean.OrderdetailBean;
import com.lnsf.bean.OrdersBean;
import com.lnsf.bean.ProductdetailBean;
import com.lnsf.dao.impl.FlowerDaoImpl;
import com.lnsf.dao.impl.OrderdetailDaoImpl;
import com.lnsf.dao.impl.OrdersDaoImpl;
import com.lnsf.dao.impl.ProductdetailDaoImpl;
import com.lnsf.service.FlowerService;
import com.lnsf.service.OrderdetailService;
import com.lnsf.service.OrdersService;
import com.lnsf.service.ProductdetailService;
import com.lnsf.service.impl.FlowerServiceImpl;
import com.lnsf.service.impl.OrderdetailServiceImpl;
import com.lnsf.service.impl.OrdersServiceImpl;
import com.lnsf.service.impl.ProductdetailServiceImpl;
import com.lnsf.utils.C3p0Utils;
import com.lnsf.utils.consoletable.ConsoleTable;
import com.lnsf.utils.consoletable.enums.Align;
import com.lnsf.utils.consoletable.table.Cell;

public class Cart {
	public static List<CartProduct> l = new ArrayList<CartProduct>();
	
	//查询商品
	public static int countById(int productId) {
		int n = 0;
		for (CartProduct cartProduct : l) {
			if(cartProduct.getProductId() == productId){
				n++;
			}
		}
		return n;
	}

	// 添加商品
	public static int add(CartProduct cp) {
		int fff = 0;
		// 判断库存是否满足
		boolean isEnough = true;
		ProductdetailService ps = new ProductdetailServiceImpl(
				new ProductdetailDaoImpl());
		FlowerService fs = new FlowerServiceImpl(new FlowerDaoImpl());
		for (ProductdetailBean pb : ps.selectAll()) {
			if(cp.getProductId() == pb.getProductId()){
				for (FlowerBean fb : fs.selectAll()) {
					if(pb.getFlowerId() == fb.getFlowerId() && (cp.getProductNum()*pb.getFlowerNum()) > fb.getStock()){
						isEnough = false;
					}
				}
			}
		}
		// 添加
		if(isEnough){
			if(l.isEmpty()){
				l.add(cp);
			}else{
				int n = l.indexOf(cp);
				if(n < 0){//若不存在
					l.add(cp);
				}else{//若存在
					l.get(n).setProductNum(l.get(n).getProductNum()+cp.getProductNum());
				}
			}
			fff = 1;
			return fff;
		}else{
			return fff;
		}
	}
	
	//删除商品
	public static void remove(int productId) {
		l.remove(productId);
	}
	
	//清空购物车
	public static void clear() {
		l.clear();
	}
	
	//金额计算
	public static float bill() {
		// 计算金额
		float paynum = 0;
		for (CartProduct cartProduct : l) {
			paynum += cartProduct.getProductPrice()
					* cartProduct.getProductNum();
		}
		
		String strpay = String.valueOf(paynum);
		List<Cell> header = new ArrayList<Cell>() {
			{
				add(new Cell("总金额"));
			}
		};
		List<List<Cell>> body = new ArrayList<List<Cell>>() {
			{
				add(new ArrayList<Cell>() {
					{
						add(new Cell(Align.CENTER, strpay+"元"));
					}
				});
			}
		};
		new ConsoleTable.ConsoleTableBuilder().addHeaders(header).addRows(body).build().print();
		
		return paynum;
	}
	
	//结算
	public static boolean settlement(int conId) {
		boolean sf = false;
		//减库存并插入记录
		ProductdetailService ps = new ProductdetailServiceImpl(
				new ProductdetailDaoImpl());
		FlowerService fs = new FlowerServiceImpl(new FlowerDaoImpl());
		try {
			//减库存
			C3p0Utils.beginTransaction();
			for (CartProduct cartProduct : l) {
				for (ProductdetailBean pb : ps.selectAll()) {
					if(cartProduct.getProductId() == pb.getProductId()){
						FlowerBean fb = new FlowerBean();
						fb = fs.selectById(pb.getFlowerId());
						fb.setStock(fb.getStock()-(cartProduct.getProductNum()*pb.getFlowerNum()));
						fs.updateById(fb);
					}
				}
			}
			//插入订单表
			OrdersService os = new OrdersServiceImpl(new OrdersDaoImpl());
			String orderId = String.valueOf(os.maxId()+1);
			OrdersBean ob = new OrdersBean(orderId,new Date(),null,null,conId,bill(),0,1);
			os.insertRecord(ob);
			//插入订单明细表
			OrderdetailService ods = new OrderdetailServiceImpl(new OrderdetailDaoImpl());
			for (CartProduct cartProduct : l) {
				OrderdetailBean odb = new OrderdetailBean(ods.maxId()+1,orderId,cartProduct.getProductId(),cartProduct.getProductNum(),1);
				ods.insertRecord(odb);
			}
			C3p0Utils.commitTransaction();
			sf = true;
		} catch (SQLException e) {
			try {
				C3p0Utils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
		return sf;
	}
	
}
