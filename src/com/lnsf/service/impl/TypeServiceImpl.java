package com.lnsf.service.impl;

import com.lnsf.service.TypeService;
import com.lnsf.bean.TypeBean;
import com.lnsf.dao.TypeDao;
import com.lnsf.dao.impl.TypeDaoImpl;

import java.util.List;

public class TypeServiceImpl implements TypeService {

	private TypeDao TypeDao;

	public TypeServiceImpl(com.lnsf.dao.TypeDao typeDao) {
		super();
		TypeDao = typeDao;
	}

	public TypeDao getTypeDao() {
		return TypeDao;
	}

	public TypeDao setTypeDao(TypeDao TypeDao) {
		return this.TypeDao = TypeDao;
	}

	// 添加一条完整记录
	public int insertRecord(TypeBean record) {
		return TypeDao.insertRecord(record);
	}

	// 添加指定列的数据
	public int insertSelective(TypeBean record) {
		return TypeDao.insertSelective(record);
	}

	// 通过Id(主键)删除一条记录
	public int deleteById(Integer typeId) {
		return TypeDao.deleteById(typeId);
	}

	// 按Id(主键)修改指定列的值
	public int updateByIdSelective(TypeBean record) {
		return TypeDao.updateByIdSelective(record);
	}

	// 按Id(主键)修改指定列的值
	public int updateById(TypeBean record) {
		return TypeDao.updateById(record);
	}

	// 计算表中的总记录数
	public int countRecord() {
		return TypeDao.countRecord();
	}

	// 根据条件计算记录条数
	public int countSelective(TypeBean record) {
		return TypeDao.countSelective(record);
	}

	// 获得表中的最大Id
	public int maxId() {
		return TypeDao.maxId();
	}

	// 通过Id(主键)查询一条记录
	public TypeBean selectById(Integer typeId) {
		return TypeDao.selectById(typeId);
	}

	// 查询所有记录
	public List<TypeBean> selectAll() {
		return TypeDao.selectAll();
	}

}