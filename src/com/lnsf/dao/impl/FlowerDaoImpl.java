package com.lnsf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lnsf.bean.FlowerBean;
import com.lnsf.dao.FlowerDao;
import com.lnsf.utils.TxQueryRunner;

public class FlowerDaoImpl implements FlowerDao {
	private static TxQueryRunner qr = new TxQueryRunner();

	@Override
	public int insertRecord(FlowerBean record) {
		int row = 0;
		try{
			String sql = "insert into flower values(?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int insertSelective(FlowerBean record) {
		int row = 0;
		try{
			String sql = "insert into flower values(?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteById(Integer flowerId) {
		int row = 0;
		try{
			String sql = "update flower set flag = 0 where conId = ?";
			row = qr.update(sql, flowerId);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateByIdSelective(FlowerBean record) {
		String sql = "update flower set ";
		if(record.getFlowerName() != null){
			sql += "conName = ?,";
		}
		if(record.getStock() != null){
			sql += "conTel = ?,";
		}
		if(record.getFlowerPrice() != null){
			sql += "conAddr = ?,";
		}
		if(record.getFlag() != null){
			sql += "flag = ?,";
		}
		sql = sql.substring(0,sql.length()-1) + " where flowerId = ?";
		int row = 0;
		try{
			row = qr.update(sql, record.getAllbeforeId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateById(FlowerBean record) {
		int row = 0;
		try{
			String sql = "update flower set flowerName = ?,stock = ?,flowerPrice = ?,flag = ? where flowerId = ?";
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
			String sql = "select count(*) from flower";
			//调用方法query,传递结果集处理类ScalarHandler
			count = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int countSelective(FlowerBean record) {
		String sql = "select count(*) from flower where 1 = 1 ";
		if(record.getFlowerId() != null){
			sql += "and flowerId = '"+record.getFlowerId()+"'";
		}
		if(record.getFlowerName() != null){
			sql += "and flowerName = '"+record.getFlowerName()+"'";
		}
		if(record.getStock() != null){
			sql += "and stock = '"+record.getStock()+"'";
		}
		if(record.getFlowerPrice() != null){
			sql += "and flowerPrice = '"+record.getFlowerPrice()+"'";
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
			String sql = "select max(conId) from flower";
			//调用方法query,传递结果集处理类ScalarHandler
			max = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return max;
	}

	@Override
	public FlowerBean selectById(Integer flowerId) {
		FlowerBean b = null;
		try {
			String sql = "select * from flower where flowerId = "+flowerId+" and flag = 1";
			b = qr.query(sql,new BeanHandler<FlowerBean>(FlowerBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<FlowerBean> selectAll() {
		List<FlowerBean> list = null;
		try {
			String sql = "select * from flower where flag = 1";
			list = qr.query(sql, new BeanListHandler<FlowerBean>(FlowerBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
