package com.lnsf.test;

import java.awt.AWTException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lnsf.bean.ConsigneeBean;
import com.lnsf.controller.Cart;
import com.lnsf.controller.ManagerController;
import com.lnsf.controller.UserController;
import com.lnsf.dao.ConsigneeDao;
import com.lnsf.dao.impl.ConsigneeDaoImpl;
import com.lnsf.service.ConsigneeService;
import com.lnsf.service.impl.ConsigneeServiceImpl;
import com.lnsf.utils.C3p0Utils;
import com.lnsf.utils.consoletable.ConsoleTable;
import com.lnsf.utils.consoletable.enums.Align;
import com.lnsf.utils.consoletable.table.Cell;

public class dbutilsTest {
	private int a = -1;

	public void testSelect() throws AWTException {
		/*try {
			// 数据库连接
			// Connection conn = DataAccess.getConnection();
			// 创建QueryRunner类对象
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// SQL语句
			String sql = "SELECT * FROM user";
			// 查询到的结果保存在集合中
			// List<User> users = qr.query(conn,sql,new
			// BeanListHandler<User>(User.class));
			List<User> users = qr.query(sql, new BeanListHandler<User>(
					User.class));
			// 输出查询结果
			DataAccess.clear();
			for (User user : users) {
				System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	public static void main(String[] args) throws AWTException {
//		dbutilsTest du = new dbutilsTest();
		// du.testSelect();
		// du.setA(0);
		// System.out.println(du.getA());
		
		int flag;
		ConsigneeService cs = new ConsigneeServiceImpl(new ConsigneeDaoImpl());
		ConsigneeDao cd = new ConsigneeDaoImpl();
		ConsigneeBean cb1 = new ConsigneeBean(cd.maxId()+1,"A","123","B","2017764511",1);
		ConsigneeBean cb2 = new ConsigneeBean(cd.maxId(),"C",null,"D",null,1);
		
		//插入测试
//		flag = cd.insertRecord(cb1);
//		System.out.println(flag);
		
//		for (Object o : cb2.getAllbeforeId()) {
//			System.out.println(o);
//		}
		
		//修改测试
//		flag = cd.updateByIdSelective(cb2);
//		System.out.println(flag);
		
		//删除测试
//		flag = cd.deleteById(cd.maxId());
//		System.out.println(flag);
		
		//查询测试
//		System.out.println(cs.selectById(8));
//		List<ConsigneeBean> cl = new ArrayList<ConsigneeBean>();
//		cl = cs.selectAll();
//		List<Cell> header = new ArrayList<Cell>() {
//			{
//				add(new Cell("姓名name"));
//				add(new Cell("电子邮箱email"));
//				add(new Cell("电话号码tel"));
//			}
//		};
//		for (ConsigneeBean cb : cl) {
//			List<List<Cell>> body = new ArrayList<List<Cell>>();
//			body.add(new ArrayList<Cell>() {
//					{
//						add(new Cell(cb.getConName()));
//					}
//				});
//			new ConsoleTable.ConsoleTableBuilder().addRows(body).build().print();
//		}
		
//		String str = "2017764511";
//		str = String.valueOf(Integer.valueOf(str)+1);
//		System.out.println(str);
		
//		UserController.nologMenu();
		ManagerController.managerMenu();
		
//		String strAddr = cs.selectById(8).getConAddr();
//		System.out.println(strAddr);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

}
