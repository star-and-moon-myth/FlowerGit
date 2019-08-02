package com.lnsf.service.impl;

import com.lnsf.service.ConsigneeService;
import com.lnsf.bean.ConsigneeBean;
import com.lnsf.bean.UserBean;
import com.lnsf.dao.ConsigneeDao;
import com.lnsf.dao.UserDao;
import com.lnsf.dao.impl.ConsigneeDaoImpl;
import com.lnsf.dao.impl.UserDaoImpl;

import java.util.List;

public class ConsigneeServiceImpl implements ConsigneeService {

	private ConsigneeDao ConsigneeDao;

	public ConsigneeServiceImpl(com.lnsf.dao.ConsigneeDao consigneeDao) {
		super();
		ConsigneeDao = consigneeDao;
	}

	public ConsigneeDao getConsigneeDao() {
		return ConsigneeDao;
	}

	public ConsigneeDao setConsigneeDao(ConsigneeDao ConsigneeDao) {
		return this.ConsigneeDao = ConsigneeDao;
	}

	// 添加一条完整记录
	public int insertRecord(ConsigneeBean record) {
		int lbs = 0;
		UserBean ub = new UserBean();
		ub.setUserId(record.getUserId());
		UserDao ud = new UserDaoImpl();
		if(ud.countSelective(ub) > 0){
			lbs = ConsigneeDao.insertRecord(record);
		}
		return lbs;
	}

	// 添加指定列的数据
	public int insertSelective(ConsigneeBean record) {
		int lbs = 0;
		UserBean ub = new UserBean();
		ub.setUserId(record.getUserId());
		UserDao ud = new UserDaoImpl();
		if(ud.countSelective(ub) > 0){
			lbs = ConsigneeDao.insertSelective(record);
		}
		return lbs;
	}

	// 通过Id(主键)删除一条记录
	public int deleteById(Integer conId) {
		return ConsigneeDao.deleteById(conId);
	}

	// 按Id(主键)修改指定列的值
	public int updateByIdSelective(ConsigneeBean record) {
		int lbs = 0;
		if(record.getUserId() == null){
			lbs = ConsigneeDao.updateByIdSelective(record);
		}else{
			UserBean ub = new UserBean();
			ub.setUserId(record.getUserId());
			UserDao ud = new UserDaoImpl();
			if(ud.countSelective(ub) > 0){
				lbs = ConsigneeDao.updateByIdSelective(record);
			}
		}
		return lbs;
	}

	// 按Id(主键)修改指定列的值
	public int updateById(ConsigneeBean record) {
		int lbs = 0;
		UserBean ub = new UserBean();
		ub.setUserId(record.getUserId());
		UserDao ud = new UserDaoImpl();
		if(ud.countSelective(ub) > 0){
			lbs = ConsigneeDao.updateByIdSelective(record);
		}
		return lbs;
	}

	// 计算表中的总记录数
	public int countRecord() {
		return ConsigneeDao.countRecord();
	}

	// 根据条件计算记录条数
	public int countSelective(ConsigneeBean record) {
		return ConsigneeDao.countSelective(record);
	}

	// 获得表中的最大Id
	public int maxId() {
		return ConsigneeDao.maxId();
	}

	// 通过Id(主键)查询一条记录
	public ConsigneeBean selectById(Integer conId) {
		return ConsigneeDao.selectById(conId);
	}

	// 查询所有记录
	public List selectAll() {
		return ConsigneeDao.selectAll();
	}

}