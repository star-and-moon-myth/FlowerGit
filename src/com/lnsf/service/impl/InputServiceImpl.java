package com.lnsf.service.impl;

import com.lnsf.service.InputService;

import com.lnsf.bean.InputBean;

import com.lnsf.dao.InputDao;

import java.util.List;

public class InputServiceImpl implements InputService {

	private InputDao InputDao;

	public InputDao getInputDao() {
		return InputDao;
	}

	public InputDao setInputDao(InputDao InputDao) {
		return this.InputDao = InputDao;
	}

	// 添加一条完整记录
	public int insertRecord(InputBean record) {
		return InputDao.insertRecord(record);
	}

	// 添加指定列的数据
	public int insertSelective(InputBean record) {
		return InputDao.insertSelective(record);
	}

	// 通过Id(主键)删除一条记录
	public int deleteById(Integer inputId) {
		return InputDao.deleteById(inputId);
	}

	// 按Id(主键)修改指定列的值
	public int updateByIdSelective(InputBean record) {
		return InputDao.updateByIdSelective(record);
	}

	// 按Id(主键)修改指定列的值
	public int updateById(InputBean record) {
		return InputDao.updateById(record);
	}

	// 计算表中的总记录数
	public int countRecord() {
		return InputDao.countRecord();
	}

	// 根据条件计算记录条数
	public int countSelective(InputBean record) {
		return InputDao.countSelective(record);
	}

	// 获得表中的最大Id
	public int maxId() {
		return InputDao.maxId();
	}

	// 通过Id(主键)查询一条记录
	public InputBean selectById(Integer inputId) {
		return InputDao.selectById(inputId);
	}

	// 查询所有记录
	public List selectAll() {
		return InputDao.selectAll();
	}

}