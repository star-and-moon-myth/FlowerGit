package com.lnsf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lnsf.bean.ProductBean;
import com.lnsf.dao.ProductDao;
import com.lnsf.utils.TxQueryRunner;

public class ProductDaoImpl implements ProductDao {
	private static TxQueryRunner qr = new TxQueryRunner();

	@Override
	public int insertRecord(ProductBean record) {
		int row = 0;
		try{
			String sql = "insert into product values(?,?,?,?,?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int insertSelective(ProductBean record) {
		int row = 0;
		try{
			String sql = "insert into product values(?,?,?,?,?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteById(Integer productId) {
		int row = 0;
		try{
			String sql = "update product set flag = 0 where productId = ?";
			row = qr.update(sql, productId);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateByIdSelective(ProductBean record) {
		String sql = "update product set ";
		if(record.getProductName() != null){
			sql += "productName = ?,";
		}
		if(record.getProductPrice() != null){
			sql += "productPrice = ?,";
		}
		if(record.getRemark() != null){
			sql += "remark = ?,";
		}
		if(record.getUseId() != null){
			sql += "useId = ?,";
		}
		if(record.getObjectId() != null){
			sql += "objectId = ?,";
		}
		if(record.getFestivalId() != null){
			sql += "festivalId = ?,";
		}
		if(record.getSomId() != null){
			sql += "somId = ?,";
		}
		if(record.getFlag() != null){
			sql += "flag = ?,";
		}
		sql = sql.substring(0,sql.length()-1) + " where productId = ?";
		int row = 0;
		try{
			row = qr.update(sql, record.getAllbeforeId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateById(ProductBean record) {
		int row = 0;
		try{
			String sql = "update product set productName = ?,productPrice = ?,remark = ?,useId = ?,objectId = ?,festivalId = ?,somId = ?,flag = ? where productId = ?";
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
			String sql = "select count(*) from product";
			//调用方法query,传递结果集处理类ScalarHandler
			count = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int countSelective(ProductBean record) {
		String sql = "select count(*) from product where 1 = 1 ";
		if(record.getProductId()!= null){
			sql += "and productId = '"+record.getProductId()+"'";
		}
		if(record.getProductName() != null){
			sql += "and productName = '"+record.getProductName()+"'";
		}
		if(record.getProductPrice() != null){
			sql += "and productPrice = '"+record.getProductPrice()+"'";
		}
		if(record.getRemark() != null){
			sql += "and remark = '"+record.getRemark()+"'";
		}
		if(record.getUseId() != null){
			sql += "and useId = '"+record.getUseId()+"'";
		}
		if(record.getObjectId() != null){
			sql += "and objectId = '"+record.getObjectId()+"'";
		}
		if(record.getFestivalId() != null){
			sql += "and festivalId = '"+record.getFestivalId()+"'";
		}
		if(record.getSomId() != null){
			sql += "and somId = '"+record.getSomId()+"'";
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
			String sql = "select max(productId) from product";
			//调用方法query,传递结果集处理类ScalarHandler
			max = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return max;
	}

	@Override
	public ProductBean selectById(Integer productId) {
		ProductBean b = null;
		try {
			String sql = "select * from product where productId = "+productId+" and flag = 1";
			b = qr.query(sql,new BeanHandler<ProductBean>(ProductBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<ProductBean> selectAll() {
		List<ProductBean> list = null;
		try {
			String sql = "select * from product where flag = 1";
			list = qr.query(sql, new BeanListHandler<ProductBean>(ProductBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
