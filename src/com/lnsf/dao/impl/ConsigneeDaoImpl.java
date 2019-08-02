package com.lnsf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lnsf.bean.ConsigneeBean;
import com.lnsf.dao.ConsigneeDao;
import com.lnsf.utils.TxQueryRunner;

public class ConsigneeDaoImpl implements ConsigneeDao {
	private static TxQueryRunner qr = new TxQueryRunner();

	// 添加一条完整记录
	@Override
	public int insertRecord(ConsigneeBean record) {
		int row = 0;
		try{
			String sql = "insert into consignee values(?,?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	// 添加指定列的数据
	@Override
	public int insertSelective(ConsigneeBean record) {
		int row = 0;
		try{
			String sql = "insert into consignee values(?,?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	// 通过Id(主键)删除一条记录
	@Override
	public int deleteById(Integer conId) {
		int row = 0;
		try{
			String sql = "update consignee set flag = 0 where conId = ?";
			row = qr.update(sql, conId);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	// 按Id(主键)修改指定列的值
	@Override
	public int updateByIdSelective(ConsigneeBean record) {
		String sql = "update consignee set ";
		if(record.getConName() != null){
			sql += "conName = ?,";
		}
		if(record.getConTel() != null){
			sql += "conTel = ?,";
		}
		if(record.getConAddr() != null){
			sql += "conAddr = ?,";
		}
		if(record.getUserId() != null){
			sql += "userId = ?,";
		}
		if(record.getFlag() != null){
			sql += "flag = ?,";
		}
		sql = sql.substring(0,sql.length()-1) + " where conId = ?";
		int row = 0;
		try{
			row = qr.update(sql, record.getAllbeforeId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	// 按Id(主键)修改全部列的值
	@Override
	public int updateById(ConsigneeBean record) {
		int row = 0;
		try{
			String sql = "update consignee set conName = ?,conTel = ?,conAddr = ?,userId = ?,flag = ? where conId = ?";
			row = qr.update(sql, record.getAllbeforeId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	// 计算表中的总记录数
	@Override
	public int countRecord() {
		int count = 0;
		try {
			String sql = "select count(*) from consignee";
			//调用方法query,传递结果集处理类ScalarHandler
			count = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// 根据条件计算记录条数
	@Override
	public int countSelective(ConsigneeBean record) {
		String sql = "select count(*) from consignee where 1 = 1 ";
		if(record.getConId() != null){
			sql += "and conId = '"+record.getConId()+"'";
		}
		if(record.getConName() != null){
			sql += "and conName = '"+record.getConName()+"'";
		}
		if(record.getConTel() != null){
			sql += "and conTel = '"+record.getConTel()+"'";
		}
		if(record.getConAddr() != null){
			sql += "and conAddr = '"+record.getConAddr()+"'";
		}
		if(record.getUserId() != null){
			sql += "and userId = '"+record.getUserId()+"'";
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

	// 获得表中的最大Id
	@Override
	public int maxId() {
		int max = 0;
		try {
			String sql = "select max(conId) from consignee";
			//调用方法query,传递结果集处理类ScalarHandler
			max = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return max;
	}

	// 通过Id(主键)查询一条记录
	@Override
	public ConsigneeBean selectById(Integer conId) {
		ConsigneeBean cb = null;
		try {
			String sql = "select * from consignee where conId = "+conId+" and flag = 1";
			cb = qr.query(sql,new BeanHandler<ConsigneeBean>(ConsigneeBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cb;
	}

	// 查询所有记录
	@Override
	public List<ConsigneeBean> selectAll() {
		List<ConsigneeBean> list = null;
		try {
			String sql = "select * from consignee where flag = 1";
			list = qr.query(sql, new BeanListHandler<ConsigneeBean>(ConsigneeBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
