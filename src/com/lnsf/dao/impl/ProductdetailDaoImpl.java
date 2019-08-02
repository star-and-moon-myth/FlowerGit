package com.lnsf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lnsf.bean.ProductdetailBean;
import com.lnsf.dao.ProductdetailDao;
import com.lnsf.utils.TxQueryRunner;

public class ProductdetailDaoImpl implements ProductdetailDao {
	private static TxQueryRunner qr = new TxQueryRunner();

	@Override
	public int insertRecord(ProductdetailBean record) {
		int row = 0;
		try{
			String sql = "insert into productdetail values(?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int insertSelective(ProductdetailBean record) {
		int row = 0;
		try{
			String sql = "insert into productdetail values(?,?,?,?,?)";
			row = qr.update(sql, record.getAll());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteById(Integer productDetailId) {
		int row = 0;
		try{
			String sql = "update productdetail set flag = 0 where productDetailId = ?";
			row = qr.update(sql, productDetailId);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateByIdSelective(ProductdetailBean record) {
		String sql = "update productdetail set ";
		if(record.getProductId() != null){
			sql += "productId = ?,";
		}
		if(record.getFlowerId() != null){
			sql += "flowerId = ?,";
		}
		if(record.getFlowerNum() != null){
			sql += "flowerNum = ?,";
		}
		if(record.getFlag() != null){
			sql += "flag = ?,";
		}
		sql = sql.substring(0,sql.length()-1) + " where productDetailId = ?";
		int row = 0;
		try{
			row = qr.update(sql, record.getAllbeforeId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateById(ProductdetailBean record) {
		int row = 0;
		try{
			String sql = "update productdetail set productId = ?,flowerId = ?,flowerNum = ?,flag = ? where productDetailId = ?";
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
			String sql = "select count(*) from productdetail";
			//调用方法query,传递结果集处理类ScalarHandler
			count = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int countSelective(ProductdetailBean record) {
		String sql = "select count(*) from productdetail where 1 = 1 ";
		if(record.getProductDetailId()!= null){
			sql += "and productDetailId = '"+record.getProductDetailId()+"'";
		}
		if(record.getProductId() != null){
			sql += "and productId = '"+record.getProductId()+"'";
		}
		if(record.getFlowerId() != null){
			sql += "and flowerId = '"+record.getFlowerId()+"'";
		}
		if(record.getFlowerNum() != null){
			sql += "and flowerNum = '"+record.getFlowerNum()+"'";
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
			String sql = "select max(productDetailId) from productdetail";
			//调用方法query,传递结果集处理类ScalarHandler
			max = qr.query(sql,new ScalarHandler<Integer>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return max;
	}

	@Override
	public ProductdetailBean selectById(Integer productDetailId) {
		ProductdetailBean b = null;
		try {
			String sql = "select * from productdetail where productDetailId = "+productDetailId+" and flag = 1";
			b = qr.query(sql,new BeanHandler<ProductdetailBean>(ProductdetailBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<ProductdetailBean> selectAll() {
		List<ProductdetailBean> list = null;
		try {
			String sql = "select * from productdetail where flag = 1";
			list = qr.query(sql, new BeanListHandler<ProductdetailBean>(ProductdetailBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
