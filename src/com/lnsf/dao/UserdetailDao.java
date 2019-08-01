package com.lnsf.dao;

import com.lnsf.bean.UserdetailBean;

import java.util.List;

public interface UserdetailDao {

	public int insertRecord(UserdetailBean record);// 添加一条完整记录

	public int insertSelective(UserdetailBean record);// 添加指定列的数据

	public int deleteById(Integer userDetailId);// 通过Id(主键)删除一条记录

	public int updateByIdSelective(UserdetailBean record);// 按Id(主键)修改指定列的值

	public int updateById(UserdetailBean record);// 按Id(主键)修改指定列的值

	public int countRecord();// 计算表中的总记录数

	public int countSelective(UserdetailBean record);// 根据条件计算记录条数

	public int maxId();// 获得表中的最大Id

	public UserdetailBean selectById(Integer userDetailId);// 通过Id(主键)查询一条记录

	public List selectAll();// 查询所有记录

}