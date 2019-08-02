package com.lnsf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lnsf.bean.LevelBean;
import com.lnsf.dao.LevelDao;
import com.lnsf.utils.TxQueryRunner;

public class LevelDaoImpl implements LevelDao {
	private static TxQueryRunner qr = new TxQueryRunner();

	@Override
	public int insertRecord(LevelBean record) {
		int row = 0;
		try{
			String sql = "insert into level values(?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int insertSelective(LevelBean record) {
		int row = 0;
		try{
			String sql = "insert into level values(?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteById(Integer levelId) {
		int row = 0;
		try{
			String sql = "update level set flag = 0 where inputId = ?";
			row = qr.update(sql, levelId);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateByIdSelective(LevelBean record) {
		String sql = "update level set ";
		if(record.getLevelName() != null){
			sql += "levelName = ?,";
		}
		if(record.getLowPoint() != null){
			sql += "lowPoint = ?,";
		}
		if(record.getHighPoint() != null){
			sql += "highPoint = ?,";
		}
		if(record.getFlag() != null){
			sql += "flag = ?,";
		}
		sql = sql.substring(0,sql.length()-1) + " where levelId = ?";
		int row = 0;
		try{
			row = qr.update(sql, record.getAllbeforeId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateById(LevelBean record) {
		int row = 0;
		try{
			String sql = "update level set levelName = ?,lowPoint = ?,highPoint = ?,flag = ? where levelId = ?";
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
			String sql = "select count(*) from level";
			//调用方法query,传递结果集处理类ScalarHandler
			count = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int countSelective(LevelBean record) {
		String sql = "select count(*) from level where 1 = 1 ";
		if(record.getLevelId()!= null){
			sql += "and levelId = '"+record.getLevelId()+"'";
		}
		if(record.getLevelName() != null){
			sql += "and levelName = '"+record.getLevelName()+"'";
		}
		if(record.getLowPoint() != null){
			sql += "and lowPoint = '"+record.getLowPoint()+"'";
		}
		if(record.getHighPoint() != null){
			sql += "and highPoint = '"+record.getHighPoint()+"'";
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
			String sql = "select max(levelId) from level";
			//调用方法query,传递结果集处理类ScalarHandler
			max = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return max;
	}

	@Override
	public LevelBean selectById(Integer levelId) {
		LevelBean b = null;
		try {
			String sql = "select * from level where levelId = "+levelId+" and flag = 1";
			b = qr.query(sql,new BeanHandler<LevelBean>(LevelBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<LevelBean> selectAll() {
		List<LevelBean> list = null;
		try {
			String sql = "select * from level where flag = 1";
			list = qr.query(sql, new BeanListHandler<LevelBean>(LevelBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
