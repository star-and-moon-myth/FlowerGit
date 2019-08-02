package com.lnsf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lnsf.bean.UserBean;
import com.lnsf.dao.UserDao;
import com.lnsf.utils.TxQueryRunner;

public class UserDaoImpl implements UserDao {
	private static TxQueryRunner qr = new TxQueryRunner();

	@Override
	public int insertRecord(UserBean record) {
		int row = 0;
		try{
			String sql = "insert into user values(?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int insertSelective(UserBean record) {
		int row = 0;
		try{
			String sql = "insert into user values(?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteById(String userId) {
		int row = 0;
		try{
			String sql = "update user set flag = 0 where userId = ?";
			row = qr.update(sql, userId);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateByIdSelective(UserBean record) {
		String sql = "update user set ";
		if(record.getUserName() != null){
			sql += "userName = ?,";
		}
		if(record.getPassword() != null){
			sql += "password = ?,";
		}
		if(record.getRole() != null){
			sql += "role = ?,";
		}
		if(record.getFlag() != null){
			sql += "flag = ?,";
		}
		sql = sql.substring(0,sql.length()-1) + " where userId = ?";
		int row = 0;
		try{
			row = qr.update(sql, record.getAllbeforeId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateById(UserBean record) {
		int row = 0;
		try{
			String sql = "update user set userName = ?,password = ?,role = ?,flag = ? where userId = ?";
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
			String sql = "select count(*) from user";
			//调用方法query,传递结果集处理类ScalarHandler
			count = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int countSelective(UserBean record) {
		String sql = "select count(*) from user where 1 = 1 ";
		if(record.getUserId()!= null){
			sql += "and userId = '"+record.getUserId()+"'";
		}
		if(record.getUserName() != null){
			sql += "and userName = '"+record.getUserName()+"'";
		}
		if(record.getPassword() != null){
			sql += "and password = '"+record.getPassword()+"'";
		}
		if(record.getRole() != null){
			sql += "and role = '"+record.getRole()+"'";
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
			String sql = "select max(userId) from user";
			//调用方法query,传递结果集处理类ScalarHandler
			max = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return max;
	}

	@Override
	public UserBean selectById(String userId) {
		UserBean b = null;
		try {
			String sql = "select * from user where userId = "+userId+" and flag = 1";
			b = qr.query(sql,new BeanHandler<UserBean>(UserBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<UserBean> selectAll() {
		List<UserBean> list = null;
		try {
			String sql = "select * from user where flag = 1";
			list = qr.query(sql, new BeanListHandler<UserBean>(UserBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
