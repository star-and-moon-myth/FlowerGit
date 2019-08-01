package com.lnsf.dao;

import com.lnsf.bean.ProductdetailBean;

import java.util.List;

public interface ProductdetailDao {

	public int insertRecord(ProductdetailBean record);// 添加一条完整记录

	public int insertSelective(ProductdetailBean record);// 添加指定列的数据

	public int deleteById(Integer productDetailId);// 通过Id(主键)删除一条记录

	public int updateByIdSelective(ProductdetailBean record);// 按Id(主键)修改指定列的值

	public int updateById(ProductdetailBean record);// 按Id(主键)修改指定列的值

	public int countRecord();// 计算表中的总记录数

	public int countSelective(ProductdetailBean record);// 根据条件计算记录条数

	public int maxId();// 获得表中的最大Id

	public ProductdetailBean selectById(Integer productDetailId);// 通过Id(主键)查询一条记录

	public List selectAll();// 查询所有记录

}