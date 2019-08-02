package com.lnsf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lnsf.bean.InputBean;
import com.lnsf.dao.InputDao;
import com.lnsf.utils.TxQueryRunner;

public class InputDaoImpl implements InputDao {
	private static TxQueryRunner qr = new TxQueryRunner();

	@Override
	public int insertRecord(InputBean record) {
		int row = 0;
		try{
			String sql = "insert into input values(?,?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int insertSelective(InputBean record) {
		int row = 0;
		try{
			String sql = "insert into input values(?,?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteById(Integer inputId) {
		int row = 0;
		try{
			String sql = "update input set flag = 0 where inputId = ?";
			row = qr.update(sql, inputId);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateByIdSelective(InputBean record) {
		String sql = "update input set ";
		if(record.getFlowerId() != null){
			sql += "flowerId = ?,";
		}
		if(record.getInputNum() != null){
			sql += "inputNum = ?,";
		}
		if(record.getIntputPrice() != null){
			sql += "intputPrice = ?,";
		}
		if(record.getInputDate() != null){
			sql += "inputDate = ?,";
		}
		if(record.getFlag() != null){
			sql += "flag = ?,";
		}
		sql = sql.substring(0,sql.length()-1) + " where inputId = ?";
		int row = 0;
		try{
			row = qr.update(sql, record.getAllbeforeId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateById(InputBean record) {
		int row = 0;
		try{
			String sql = "update input set flowerId = ?,inputNum = ?,intputPrice = ?,inputDate = ?,flag = ? where inputId = ?";
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
			String sql = "select count(*) from input";
			//调用方法query,传递结果集处理类ScalarHandler
			count = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int countSelective(InputBean record) {
		String sql = "select count(*) from input where 1 = 1 ";
		if(record.getInputId()!= null){
			sql += "and inputId = '"+record.getInputId()+"'";
		}
		if(record.getFlowerId() != null){
			sql += "and flowerId = '"+record.getFlowerId()+"'";
		}
		if(record.getInputNum() != null){
			sql += "and inputNum = '"+record.getInputNum()+"'";
		}
		if(record.getIntputPrice() != null){
			sql += "and intputPrice = '"+record.getIntputPrice()+"'";
		}
		if(record.getInputDate() != null){
			sql += "and inputDate = '"+record.getInputDate()+"'";
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
			String sql = "select max(inputId) from input";
			//调用方法query,传递结果集处理类ScalarHandler
			max = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return max;
	}

	@Override
	public InputBean selectById(Integer inputId) {
		InputBean b = null;
		try {
			String sql = "select * from input where inputId = "+inputId+" and flag = 1";
			b = qr.query(sql,new BeanHandler<InputBean>(InputBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<InputBean> selectAll() {
		List<InputBean> list = null;
		try {
			String sql = "select * from input where flag = 1";
			list = qr.query(sql, new BeanListHandler<InputBean>(InputBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
