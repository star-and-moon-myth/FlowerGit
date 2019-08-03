package com.lnsf.service;

import com.lnsf.bean.OrderdetailBean;

import java.util.List;

public interface OrderdetailService {

	public int insertRecord(OrderdetailBean record);// 添加一条完整记录

	public int insertSelective(OrderdetailBean record);// 添加指定列的数据

	public int deleteById(Integer orderDetailId);// 通过Id(主键)删除一条记录

	public int updateByIdSelective(OrderdetailBean record);// 按Id(主键)修改指定列的值

	public int updateById(OrderdetailBean record);// 按Id(主键)修改指定列的值

	public int countRecord();// 计算表中的总记录数

	public int countSelective(OrderdetailBean record);// 根据条件计算记录条数

	public int maxId();// 获得表中的最大Id

	public OrderdetailBean selectById(Integer orderDetailId);// 通过Id(主键)查询一条记录

	public List<OrderdetailBean> selectAll();// 查询所有记录

}