package com.lnsf.service.impl;

import com.lnsf.service.FlowerService;
import com.lnsf.bean.FlowerBean;
import com.lnsf.dao.FlowerDao;
import com.lnsf.dao.impl.FlowerDaoImpl;

import java.util.List;

public class FlowerServiceImpl implements FlowerService {

	private FlowerDao FlowerDao = new FlowerDaoImpl();

	public FlowerDao getFlowerDao() {
		return FlowerDao;
	}

	public FlowerDao setFlowerDao(FlowerDao FlowerDao) {
		return this.FlowerDao = FlowerDao;
	}

	// 添加一条完整记录
	public int insertRecord(FlowerBean record) {
		return FlowerDao.insertRecord(record);
	}

	// 添加指定列的数据
	public int insertSelective(FlowerBean record) {
		return FlowerDao.insertSelective(record);
	}

	// 通过Id(主键)删除一条记录
	public int deleteById(Integer flowerId) {
		return FlowerDao.deleteById(flowerId);
	}

	// 按Id(主键)修改指定列的值
	public int updateByIdSelective(FlowerBean record) {
		return FlowerDao.updateByIdSelective(record);
	}

	// 按Id(主键)修改指定列的值
	public int updateById(FlowerBean record) {
		return FlowerDao.updateById(record);
	}

	// 计算表中的总记录数
	public int countRecord() {
		return FlowerDao.countRecord();
	}

	// 根据条件计算记录条数
	public int countSelective(FlowerBean record) {
		return FlowerDao.countSelective(record);
	}

	// 获得表中的最大Id
	public int maxId() {
		return FlowerDao.maxId();
	}

	// 通过Id(主键)查询一条记录
	public FlowerBean selectById(Integer flowerId) {
		return FlowerDao.selectById(flowerId);
	}

	// 查询所有记录
	public List selectAll() {
		return FlowerDao.selectAll();
	}

}