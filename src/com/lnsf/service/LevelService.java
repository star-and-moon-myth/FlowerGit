package com.lnsf.service;

import com.lnsf.bean.LevelBean;

import java.util.List;

public interface LevelService {

	public int insertRecord(LevelBean record);// 添加一条完整记录

	public int insertSelective(LevelBean record);// 添加指定列的数据

	public int deleteById(Integer levelId);// 通过Id(主键)删除一条记录

	public int updateByIdSelective(LevelBean record);// 按Id(主键)修改指定列的值

	public int updateById(LevelBean record);// 按Id(主键)修改指定列的值

	public int countRecord();// 计算表中的总记录数

	public int countSelective(LevelBean record);// 根据条件计算记录条数

	public int maxId();// 获得表中的最大Id

	public LevelBean selectById(Integer levelId);// 通过Id(主键)查询一条记录

	public List<LevelBean> selectAll();// 查询所有记录

}