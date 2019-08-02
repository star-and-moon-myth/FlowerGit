package com.lnsf.service.impl;

import com.lnsf.service.LevelService;
import com.lnsf.bean.LevelBean;
import com.lnsf.dao.LevelDao;
import com.lnsf.dao.impl.LevelDaoImpl;

import java.util.List;

public class LevelServiceImpl implements LevelService {

	private LevelDao LevelDao = new LevelDaoImpl();

	public LevelDao getLevelDao() {
		return LevelDao;
	}

	public LevelDao setLevelDao(LevelDao LevelDao) {
		return this.LevelDao = LevelDao;
	}

	// 添加一条完整记录
	public int insertRecord(LevelBean record) {
		return LevelDao.insertRecord(record);
	}

	// 添加指定列的数据
	public int insertSelective(LevelBean record) {
		return LevelDao.insertSelective(record);
	}

	// 通过Id(主键)删除一条记录
	public int deleteById(Integer levelId) {
		return LevelDao.deleteById(levelId);
	}

	// 按Id(主键)修改指定列的值
	public int updateByIdSelective(LevelBean record) {
		return LevelDao.updateByIdSelective(record);
	}

	// 按Id(主键)修改指定列的值
	public int updateById(LevelBean record) {
		return LevelDao.updateById(record);
	}

	// 计算表中的总记录数
	public int countRecord() {
		return LevelDao.countRecord();
	}

	// 根据条件计算记录条数
	public int countSelective(LevelBean record) {
		return LevelDao.countSelective(record);
	}

	// 获得表中的最大Id
	public int maxId() {
		return LevelDao.maxId();
	}

	// 通过Id(主键)查询一条记录
	public LevelBean selectById(Integer levelId) {
		return LevelDao.selectById(levelId);
	}

	// 查询所有记录
	public List selectAll() {
		return LevelDao.selectAll();
	}

}