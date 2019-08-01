package com.lnsf.service.impl;

import com.lnsf.service.OrdersService;

import com.lnsf.bean.OrdersBean;

import com.lnsf.dao.OrdersDao;

import java.util.List;

public class OrdersServiceImpl implements OrdersService {

	private OrdersDao OrdersDao;

	public OrdersDao getOrdersDao() {
		return OrdersDao;
	}

	public OrdersDao setOrdersDao(OrdersDao OrdersDao) {
		return this.OrdersDao = OrdersDao;
	}

	// 添加一条完整记录
	public int insertRecord(OrdersBean record) {
		return OrdersDao.insertRecord(record);
	}

	// 添加指定列的数据
	public int insertSelective(OrdersBean record) {
		return OrdersDao.insertSelective(record);
	}

	// 通过Id(主键)删除一条记录
	public int deleteById(String orderId) {
		return OrdersDao.deleteById(orderId);
	}

	// 按Id(主键)修改指定列的值
	public int updateByIdSelective(OrdersBean record) {
		return OrdersDao.updateByIdSelective(record);
	}

	// 按Id(主键)修改指定列的值
	public int updateById(OrdersBean record) {
		return OrdersDao.updateById(record);
	}

	// 计算表中的总记录数
	public int countRecord() {
		return OrdersDao.countRecord();
	}

	// 根据条件计算记录条数
	public int countSelective(OrdersBean record) {
		return OrdersDao.countSelective(record);
	}

	// 获得表中的最大Id
	public int maxId() {
		return OrdersDao.maxId();
	}

	// 通过Id(主键)查询一条记录
	public OrdersBean selectById(String orderId) {
		return OrdersDao.selectById(orderId);
	}

	// 查询所有记录
	public List selectAll() {
		return OrdersDao.selectAll();
	}

}