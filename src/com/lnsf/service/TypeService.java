package com.lnsf.service;

import com.lnsf.bean.TypeBean;

import java.util.List;

public interface TypeService {

	public int insertRecord(TypeBean record);// 添加一条完整记录

	public int insertSelective(TypeBean record);// 添加指定列的数据

	public int deleteById(Integer typeId);// 通过Id(主键)删除一条记录

	public int updateByIdSelective(TypeBean record);// 按Id(主键)修改指定列的值

	public int updateById(TypeBean record);// 按Id(主键)修改指定列的值

	public int countRecord();// 计算表中的总记录数

	public int countSelective(TypeBean record);// 根据条件计算记录条数

	public int maxId();// 获得表中的最大Id

	public TypeBean selectById(Integer typeId);// 通过Id(主键)查询一条记录

	public List<TypeBean> selectAll();// 查询所有记录

}