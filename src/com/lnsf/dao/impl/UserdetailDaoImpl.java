package com.lnsf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lnsf.bean.UserdetailBean;
import com.lnsf.dao.UserdetailDao;
import com.lnsf.utils.TxQueryRunner;

public class UserdetailDaoImpl implements UserdetailDao {
	private static TxQueryRunner qr = new TxQueryRunner();

	@Override
	public int insertRecord(UserdetailBean record) {
		int row = 0;
		try{
			String sql = "insert into userdetail values(?,?,?,?,?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int insertSelective(UserdetailBean record) {
		int row = 0;
		try{
			String sql = "insert into userdetail values(?,?,?,?,?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteById(Integer userDetailId) {
		int row = 0;
		try{
			String sql = "update userdetail set flag = 0 where userDetailId = ?";
			row = qr.update(sql, userDetailId);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateByIdSelective(UserdetailBean record) {
		String sql = "update userdetail set ";
		if(record.getUserId() != null){
			sql += "userId = ?,";
		}
		if(record.getUserTel() != null){
			sql += "userTel = ?,";
		}
		if(record.getUserSex() != null){
			sql += "userSex = ?,";
		}
		if(record.getUserPoint() != null){
			sql += "userPoint = ?,";
		}
		if(record.getRegisterTime() != null){
			sql += "registerTime = ?,";
		}
		if(record.getLoginCount() != null){
			sql += "loginCount = ?,";
		}
		if(record.getLoginTime() != null){
			sql += "loginTime = ?,";
		}
		if(record.getFlag() != null){
			sql += "flag = ?,";
		}
		sql = sql.substring(0,sql.length()-1) + " where userDetailId = ?";
		int row = 0;
		try{
			row = qr.update(sql, record.getAllbeforeId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateById(UserdetailBean record) {
		int row = 0;
		try{
			String sql = "update userdetail set userId = ?,userTel = ?,userSex = ?,userPoint = ?,registerTime = ?,loginCount = ?,loginTime = ?,flag = ? where userDetailId = ?";
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
			String sql = "select count(*) from userdetail";
			//调用方法query,传递结果集处理类ScalarHandler
			count = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int countSelective(UserdetailBean record) {
		String sql = "select count(*) from userdetail where 1 = 1 ";
		if(record.getUserDetailId()!= null){
			sql += "and userDetailId = '"+record.getUserDetailId()+"'";
		}
		if(record.getUserId() != null){
			sql += "and userId = '"+record.getUserId()+"'";
		}
		if(record.getUserTel() != null){
			sql += "and userTel = '"+record.getUserTel()+"'";
		}
		if(record.getUserSex() != null){
			sql += "and userSex = '"+record.getUserSex()+"'";
		}
		if(record.getUserPoint() != null){
			sql += "and userPoint = '"+record.getUserPoint()+"'";
		}
		if(record.getRegisterTime() != null){
			sql += "and registerTime = '"+record.getRegisterTime()+"'";
		}
		if(record.getLoginCount() != null){
			sql += "and loginCount = '"+record.getLoginCount()+"'";
		}
		if(record.getLoginTime() != null){
			sql += "and loginTime = '"+record.getLoginTime()+"'";
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
			String sql = "select max(userDetailId) from userdetail";
			//调用方法query,传递结果集处理类ScalarHandler
			max = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return max;
	}

	@Override
	public UserdetailBean selectById(Integer userDetailId) {
		UserdetailBean b = null;
		try {
			String sql = "select * from userdetail where userDetailId = "+userDetailId+" and flag = 1";
			b = qr.query(sql,new BeanHandler<UserdetailBean>(UserdetailBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<UserdetailBean> selectAll() {
		List<UserdetailBean> list = null;
		try {
			String sql = "select * from userdetail where flag = 1";
			list = qr.query(sql, new BeanListHandler<UserdetailBean>(UserdetailBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
