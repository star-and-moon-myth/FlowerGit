package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lnsf.bean.OrdersBean;
import com.lnsf.dao.OrdersDao;
import com.lnsf.utils.C3p0Utils;
import com.lnsf.utils.TxQueryRunner;

public class OrdersDaoImpl implements OrdersDao {
	private static TxQueryRunner qr = new TxQueryRunner();
	
	public boolean insert(OrdersBean o) {
		String sql = "insert into orders(orderId,orderDate,conId,orderPrice,state,flag) values(?,?,?,?,?,?)";
		String order_id = o.getOrderId();
		String order_date = o.getOrderDate();
		int con_id = o.getConId();
		float order_price = o.getOrderPrice();
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = C3p0Utils.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, order_id);
			prepstat.setString(2, order_date);
			prepstat.setInt(3, con_id);
			prepstat.setFloat(4, order_price);
			prepstat.setInt(5, 0);
			prepstat.setInt(6, 1);
			prepstat.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(prepstat!=null)
					prepstat.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public int insertRecord(OrdersBean record) {
		int row = 0;
		try{
			String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int insertSelective(OrdersBean record) {
		int row = 0;
		try{
			String sql = "insert into orders(orderId,orderDate,conId,orderPrice,state,flag) values(?,?,?,?,?,?)";
			row = qr.update(sql, record.getOrderId(),record.getOrderDate(),record.getConId(),record.getOrderPrice(),record.getState(),record.getFlag());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteById(String orderId) {
		int row = 0;
		try{
			String sql = "update orders set flag = 0 where orderId = ?";
			row = qr.update(sql, orderId);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateByIdSelective(OrdersBean record) {
		String sql = "update orders set ";
		if(record.getOrderDate() != null){
			sql += "orderDate = ?,";
		}
		if(record.getDeliverDate() != null){
			sql += "deliverDate = ?,";
		}
		if(record.getFinishDate() != null){
			sql += "finishDate = ?,";
		}
		if(record.getConId() != null){
			sql += "conId = ?,";
		}
		if(record.getOrderPrice() != null){
			sql += "orderPrice = ?,";
		}
		if(record.getState() != null){
			sql += "state = ?,";
		}
		if(record.getFlag() != null){
			sql += "flag = ?,";
		}
		sql = sql.substring(0,sql.length()-1) + " where orderId = ?";
		int row = 0;
		try{
			row = qr.update(sql, record.getAllbeforeId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateById(OrdersBean record) {
		int row = 0;
		try{
			String sql = "update orders set orderDate = ?,deliverDate = ?,finishDate = ?,conId = ?,orderPrice = ?,state = ?,flag = ? where orderId = ?";
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
			String sql = "select count(*) from orders";
			//调用方法query,传递结果集处理类ScalarHandler
			count = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public long countRecord2() {
		long count = 0;
		try {
			String sql = "select count(*) from orders";
			//调用方法query,传递结果集处理类ScalarHandler
			count = (long)qr.query(sql,new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int countSelective(OrdersBean record) {
		String sql = "select count(*) from orders where 1 = 1 ";
		if(record.getOrderId()!= null){
			sql += "and orderId = '"+record.getOrderId()+"'";
		}
		if(record.getOrderDate() != null){
			sql += "and orderDate = '"+record.getOrderDate()+"'";
		}
		if(record.getDeliverDate() != null){
			sql += "and deliverDate = '"+record.getDeliverDate()+"'";
		}
		if(record.getFinishDate() != null){
			sql += "and finishDate = '"+record.getFinishDate()+"'";
		}
		if(record.getConId() != null){
			sql += "and conId = '"+record.getConId()+"'";
		}
		if(record.getOrderPrice() != null){
			sql += "and orderPrice = '"+record.getOrderPrice()+"'";
		}
		if(record.getState() != null){
			sql += "and state = '"+record.getState()+"'";
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
			String sql = "select max(orderId) from orders";
			//调用方法query,传递结果集处理类ScalarHandler
			max = Integer.valueOf(qr.query(sql,new ScalarHandler<String>()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return max;
	}

	@Override
	public OrdersBean selectById(String orderId) {
		OrdersBean b = null;
		try {
			String sql = "select * from orders where orderId = "+orderId+" and flag = 1";
			b = qr.query(sql,new BeanHandler<OrdersBean>(OrdersBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<OrdersBean> selectAll() {
		List<OrdersBean> list = null;
		try {
			String sql = "select * from orders where flag = 1";
			list = qr.query(sql, new BeanListHandler<OrdersBean>(OrdersBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
