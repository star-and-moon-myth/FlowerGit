package com.lnsf.service;

import com.lnsf.bean.InputBean;

import java.util.List;

public interface InputService {

	public int insertRecord(InputBean record);// 添加一条完整记录

	public int insertSelective(InputBean record);// 添加指定列的数据

	public int deleteById(Integer inputId);// 通过Id(主键)删除一条记录

	public int updateByIdSelective(InputBean record);// 按Id(主键)修改指定列的值

	public int updateById(InputBean record);// 按Id(主键)修改指定列的值

	public int countRecord();// 计算表中的总记录数

	public int countSelective(InputBean record);// 根据条件计算记录条数

	public int maxId();// 获得表中的最大Id

	public InputBean selectById(Integer inputId);// 通过Id(主键)查询一条记录

	public List<InputBean> selectAll();// 查询所有记录

}