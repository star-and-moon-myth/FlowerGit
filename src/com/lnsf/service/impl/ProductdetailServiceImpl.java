package com.lnsf.service.impl;

import com.lnsf.service.ProductdetailService;

import com.lnsf.bean.ProductdetailBean;

import com.lnsf.dao.ProductdetailDao;

import java.util.List;

public class ProductdetailServiceImpl implements ProductdetailService {

	private ProductdetailDao ProductdetailDao;

	public ProductdetailDao getProductdetailDao() {
		return ProductdetailDao;
	}

	public ProductdetailDao setProductdetailDao(
			ProductdetailDao ProductdetailDao) {
		return this.ProductdetailDao = ProductdetailDao;
	}

	// 添加一条完整记录
	public int insertRecord(ProductdetailBean record) {
		return ProductdetailDao.insertRecord(record);
	}

	// 添加指定列的数据
	public int insertSelective(ProductdetailBean record) {
		return ProductdetailDao.insertSelective(record);
	}

	// 通过Id(主键)删除一条记录
	public int deleteById(Integer productDetailId) {
		return ProductdetailDao.deleteById(productDetailId);
	}

	// 按Id(主键)修改指定列的值
	public int updateByIdSelective(ProductdetailBean record) {
		return ProductdetailDao.updateByIdSelective(record);
	}

	// 按Id(主键)修改指定列的值
	public int updateById(ProductdetailBean record) {
		return ProductdetailDao.updateById(record);
	}

	// 计算表中的总记录数
	public int countRecord() {
		return ProductdetailDao.countRecord();
	}

	// 根据条件计算记录条数
	public int countSelective(ProductdetailBean record) {
		return ProductdetailDao.countSelective(record);
	}

	// 获得表中的最大Id
	public int maxId() {
		return ProductdetailDao.maxId();
	}

	// 通过Id(主键)查询一条记录
	public ProductdetailBean selectById(Integer productDetailId) {
		return ProductdetailDao.selectById(productDetailId);
	}

	// 查询所有记录
	public List selectAll() {
		return ProductdetailDao.selectAll();
	}

}