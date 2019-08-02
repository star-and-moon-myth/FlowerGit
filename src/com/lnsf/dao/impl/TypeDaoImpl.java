package com.lnsf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lnsf.bean.TypeBean;
import com.lnsf.dao.TypeDao;
import com.lnsf.utils.TxQueryRunner;

public class TypeDaoImpl implements TypeDao {
	private static TxQueryRunner qr = new TxQueryRunner();

	@Override
	public int insertRecord(TypeBean record) {
		int row = 0;
		try{
			String sql = "insert into type values(?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int insertSelective(TypeBean record) {
		int row = 0;
		try{
			String sql = "insert into type values(?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteById(Integer typeId) {
		int row = 0;
		try{
			String sql = "update type set flag = 0 where typeId = ?";
			row = qr.update(sql, typeId);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateByIdSelective(TypeBean record) {
		String sql = "update type set ";
		if(record.getTypeName() != null){
			sql += "typeName = ?,";
		}
		if(record.getFlag() != null){
			sql += "flag = ?,";
		}
		sql = sql.substring(0,sql.length()-1) + " where typeId = ?";
		int row = 0;
		try{
			row = qr.update(sql, record.getAllbeforeId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateById(TypeBean record) {
		int row = 0;
		try{
			String sql = "update type set typeName = ?,flag = ? where typeId = ?";
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
			String sql = "select count(*) from type";
			//调用方法query,传递结果集处理类ScalarHandler
			count = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int countSelective(TypeBean record) {
		String sql = "select count(*) from type where 1 = 1 ";
		if(record.getTypeId()!= null){
			sql += "and typeId = '"+record.getTypeId()+"'";
		}
		if(record.getTypeName() != null){
			sql += "and typeName = '"+record.getTypeName()+"'";
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
			String sql = "select max(typeId) from type";
			//调用方法query,传递结果集处理类ScalarHandler
			max = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return max;
	}

	@Override
	public TypeBean selectById(Integer typeId) {
		TypeBean b = null;
		try {
			String sql = "select * from type where typeId = "+typeId+" and flag = 1";
			b = qr.query(sql,new BeanHandler<TypeBean>(TypeBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<TypeBean> selectAll() {
		List<TypeBean> list = null;
		try {
			String sql = "select * from type where flag = 1";
			list = qr.query(sql, new BeanListHandler<TypeBean>(TypeBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
