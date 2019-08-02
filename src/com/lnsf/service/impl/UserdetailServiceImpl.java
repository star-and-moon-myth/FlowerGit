package com.lnsf.service.impl;

import com.lnsf.service.UserdetailService;
import com.lnsf.bean.UserdetailBean;
import com.lnsf.dao.UserdetailDao;
import com.lnsf.dao.impl.UserdetailDaoImpl;

import java.util.List;

public class UserdetailServiceImpl implements UserdetailService {

	private UserdetailDao UserdetailDao;

	public UserdetailServiceImpl(com.lnsf.dao.UserdetailDao userdetailDao) {
		super();
		UserdetailDao = userdetailDao;
	}

	public UserdetailDao getUserdetailDao() {
		return UserdetailDao;
	}

	public UserdetailDao setUserdetailDao(UserdetailDao UserdetailDao) {
		return this.UserdetailDao = UserdetailDao;
	}

	// 添加一条完整记录
	public int insertRecord(UserdetailBean record) {
		return UserdetailDao.insertRecord(record);
	}

	// 添加指定列的数据
	public int insertSelective(UserdetailBean record) {
		return UserdetailDao.insertSelective(record);
	}

	// 通过Id(主键)删除一条记录
	public int deleteById(Integer userDetailId) {
		return UserdetailDao.deleteById(userDetailId);
	}

	// 按Id(主键)修改指定列的值
	public int updateByIdSelective(UserdetailBean record) {
		return UserdetailDao.updateByIdSelective(record);
	}

	// 按Id(主键)修改指定列的值
	public int updateById(UserdetailBean record) {
		return UserdetailDao.updateById(record);
	}

	// 计算表中的总记录数
	public int countRecord() {
		return UserdetailDao.countRecord();
	}

	// 根据条件计算记录条数
	public int countSelective(UserdetailBean record) {
		return UserdetailDao.countSelective(record);
	}

	// 获得表中的最大Id
	public int maxId() {
		return UserdetailDao.maxId();
	}

	// 通过Id(主键)查询一条记录
	public UserdetailBean selectById(Integer userDetailId) {
		return UserdetailDao.selectById(userDetailId);
	}

	// 查询所有记录
	public List selectAll() {
		return UserdetailDao.selectAll();
	}

}