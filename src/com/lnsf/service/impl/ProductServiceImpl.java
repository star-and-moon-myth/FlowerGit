package com.lnsf.service.impl;

import com.lnsf.service.ProductService;

import com.lnsf.bean.ProductBean;

import com.lnsf.dao.ProductDao;

import java.util.List;

public class ProductServiceImpl implements ProductService {

	private ProductDao ProductDao;

	public ProductDao getProductDao() {
		return ProductDao;
	}

	public ProductDao setProductDao(ProductDao ProductDao) {
		return this.ProductDao = ProductDao;
	}

	// 添加一条完整记录
	public int insertRecord(ProductBean record) {
		return ProductDao.insertRecord(record);
	}

	// 添加指定列的数据
	public int insertSelective(ProductBean record) {
		return ProductDao.insertSelective(record);
	}

	// 通过Id(主键)删除一条记录
	public int deleteById(Integer productId) {
		return ProductDao.deleteById(productId);
	}

	// 按Id(主键)修改指定列的值
	public int updateByIdSelective(ProductBean record) {
		return ProductDao.updateByIdSelective(record);
	}

	// 按Id(主键)修改指定列的值
	public int updateById(ProductBean record) {
		return ProductDao.updateById(record);
	}

	// 计算表中的总记录数
	public int countRecord() {
		return ProductDao.countRecord();
	}

	// 根据条件计算记录条数
	public int countSelective(ProductBean record) {
		return ProductDao.countSelective(record);
	}

	// 获得表中的最大Id
	public int maxId() {
		return ProductDao.maxId();
	}

	// 通过Id(主键)查询一条记录
	public ProductBean selectById(Integer productId) {
		return ProductDao.selectById(productId);
	}

	// 查询所有记录
	public List selectAll() {
		return ProductDao.selectAll();
	}

}