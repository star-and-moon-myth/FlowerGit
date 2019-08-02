package com.lnsf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lnsf.bean.OrderdetailBean;
import com.lnsf.dao.OrderdetailDao;
import com.lnsf.utils.TxQueryRunner;

public class OrderDetailDaoImpl implements OrderdetailDao {
	private static TxQueryRunner qr = new TxQueryRunner();

	@Override
	public int insertRecord(OrderdetailBean record) {
		int row = 0;
		try{
			String sql = "insert into orderdetail values(?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int insertSelective(OrderdetailBean record) {
		int row = 0;
		try{
			String sql = "insert into orderdetail values(?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteById(Integer orderDetailId) {
		int row = 0;
		try{
			String sql = "update orderdetail set flag = 0 where orderDetailId = ?";
			row = qr.update(sql, orderDetailId);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateByIdSelective(OrderdetailBean record) {
		String sql = "update orderdetail set ";
		if(record.getOrderId() != null){
			sql += "orderId = ?,";
		}
		if(record.getProductId() != null){
			sql += "productId = ?,";
		}
		if(record.getProductCount() != null){
			sql += "productCount = ?,";
		}
		if(record.getFlag() != null){
			sql += "flag = ?,";
		}
		sql = sql.substring(0,sql.length()-1) + " where orderDetailId = ?";
		int row = 0;
		try{
			row = qr.update(sql, record.getAllbeforeId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateById(OrderdetailBean record) {
		int row = 0;
		try{
			String sql = "update orderdetail set orderId = ?,productId = ?,productCount = ?,flag = ? where orderDetailId = ?";
			row = qr.update(sql, record.getAllbeforeId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int countRecord() {
		int count = 0;
		try {
			String sql = "select count(*) from orderdetail";
			//调用方法query,传递结果集处理类ScalarHandler
			count = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int countSelective(OrderdetailBean record) {
		String sql = "select count(*) from orderdetail where 1 = 1 ";
		if(record.getOrderDetailId()!= null){
			sql += "and orderDetailId = '"+record.getOrderDetailId()+"'";
		}
		if(record.getOrderId() != null){
			sql += "and orderId = '"+record.getOrderId()+"'";
		}
		if(record.getProductId() != null){
			sql += "and productId = '"+record.getProductId()+"'";
		}
		if(record.getProductCount() != null){
			sql += "and productCount = '"+record.getProductCount()+"'";
		}
		if(record.getFlag() != null){
			sql += "and flag = '"+record.getFlag()+"'";
		}
		int count = 0;
		try {
			//调用方法query,传递结果集处理类ScalarHandler
			count = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int maxId() {
		int max = 0;
		try {
			String sql = "select max(orderDetailId) from orderdetail";
			//调用方法query,传递结果集处理类ScalarHandler
			max = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return max;
	}

	@Override
	public OrderdetailBean selectById(Integer orderDetailId) {
		OrderdetailBean b = null;
		try {
			String sql = "select * from orderdetail where orderDetailId = "+orderDetailId+" and flag = 1";
			b = qr.query(sql,new BeanHandler<OrderdetailBean>(OrderdetailBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<OrderdetailBean> selectAll() {
		List<OrderdetailBean> list = null;
		try {
			String sql = "select * from orderdetail where flag = 1";
			list = qr.query(sql, new BeanListHandler<OrderdetailBean>(OrderdetailBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
