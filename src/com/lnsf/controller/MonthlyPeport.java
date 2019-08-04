package com.lnsf.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lnsf.utils.C3p0Utils;
import com.lnsf.utils.TxQueryRunner;

public class MonthlyPeport {

	// 返回该月份进销情况
	public List<InOut> all(int month) {
		/*String sql = "select t1.flowerName, t1.inputNum, t1.price, t1.money ,t2.outputNum, t2.price, t2.money "
				+ "from (select flowerName, inputNum, inputPrice/inputNum price, inputPrice money "
				+ "from input where month(inputDate) = "+month+") t1, "
				+ "(select a.flowerName flowerName, b.output outputNum, b.price price, b.money money "
				+ "from flower a LEFT JOIN (select flowerName, sum(flowerNum) output, flowerPrice price, flowerPrice*sum(flowerNum) money "
				+ "from orders o, orderdetail od, product p, productdetail pd, flower f "
				+ "where o.orderId = od.orderId and od.productId = p.productId "
				+ "and p.productId = pd.productId and pd.flowerId = f.flowerId "
				+ "and month(o.deliverDate)="+month+" group by flowerName) b on a.flowerName = b.flowerName) t2 "
				+ "where t1.flowerName = t2.flowerName";
		List<InOut> list = new ArrayList<InOut>();// 新建对象数组，存放得到的结果集
		TxQueryRunner qr = new TxQueryRunner();
		try {
			list = qr.query(sql, new BeanListHandler<InOut>(InOut.class));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;// 返回最终得到的对象数组*/
		
		String sql = "select t1.flowerName, t1.inputNum, t1.price, t1.money ,t2.outputNum, t2.price, t2.money "
				+ "from (select flowerName, inputNum, inputPrice/inputNum price, inputPrice money "
				+ "from input where month(inputDate) = ?) t1, "
				+ "(select a.flowerName flowerName, b.output outputNum, b.price price, b.money money "
				+ "from flower a LEFT JOIN (select flowerName, sum(flowerNum) output, flowerPrice price, flowerPrice*sum(flowerNum) money "
				+ "from orders o, orderdetail od, product p, productdetail pd, flower f "
				+ "where o.orderId = od.orderId and od.productId = p.productId "
				+ "and p.productId = pd.productId and pd.flowerId = f.flowerId "
				+ "and month(o.deliverDate)=? group by flowerName) b on a.flowerName = b.flowerName) t2 "
				+ "where t1.flowerName = t2.flowerName;";
		List<InOut> list = new ArrayList<InOut>();// 新建对象数组，存放得到的结果集
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = C3p0Utils.getConnection();// 连接数据库
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setInt(1, month);
			prepstat.setInt(2, month);
			rs = prepstat.executeQuery();// 执行SQL语句，得到结果集
			while (rs.next()) {
				// 新建对象，并通过构造方法，将结果集中的每一条记录封装成一个对象
				InOut io = new InOut(rs.getString("t1.flowerName"),
						rs.getInt("t1.inputNum"), rs.getFloat("t1.price"), rs.getFloat("t1.money"), 
						rs.getInt("t2.outputNum"), rs.getFloat("t2.price"), rs.getFloat("t2.money"));
				// 将得到的对象添加到对象数组
				list.add(io);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(prepstat!=null)
					prepstat.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;// 返回最终得到的对象数组
	}
}
