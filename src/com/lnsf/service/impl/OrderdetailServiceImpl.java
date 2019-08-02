package com.lnsf.service.impl;

import com.lnsf.service.OrderdetailService;
import com.lnsf.bean.OrderdetailBean;
import com.lnsf.dao.OrderdetailDao;
import com.lnsf.dao.impl.OrderdetailDaoImpl;

import java.util.List;

public class OrderdetailServiceImpl implements OrderdetailService {

	private OrderdetailDao OrderdetailDao = new OrderdetailDaoImpl();

	public OrderdetailDao getOrderdetailDao() {
		return OrderdetailDao;
	}

	public OrderdetailDao setOrderdetailDao(OrderdetailDao OrderdetailDao) {
		return this.OrderdetailDao = OrderdetailDao;
	}

	// 添加一条完整记录
	public int insertRecord(OrderdetailBean record) {
		return OrderdetailDao.insertRecord(record);
	}

	// 添加指定列的数据
	public int insertSelective(OrderdetailBean record) {
		return OrderdetailDao.insertSelective(record);
	}

	// 通过Id(主键)删除一条记录
	public int deleteById(Integer orderDetailId) {
		return OrderdetailDao.deleteById(orderDetailId);
	}

	// 按Id(主键)修改指定列的值
	public int updateByIdSelective(OrderdetailBean record) {
		return OrderdetailDao.updateByIdSelective(record);
	}

	// 按Id(主键)修改指定列的值
	public int updateById(OrderdetailBean record) {
		return OrderdetailDao.updateById(record);
	}

	// 计算表中的总记录数
	public int countRecord() {
		return OrderdetailDao.countRecord();
	}

	// 根据条件计算记录条数
	public int countSelective(OrderdetailBean record) {
		return OrderdetailDao.countSelective(record);
	}

	// 获得表中的最大Id
	public int maxId() {
		return OrderdetailDao.maxId();
	}

	// 通过Id(主键)查询一条记录
	public OrderdetailBean selectById(Integer orderDetailId) {
		return OrderdetailDao.selectById(orderDetailId);
	}

	// 查询所有记录
	public List selectAll() {
		return OrderdetailDao.selectAll();
	}

}