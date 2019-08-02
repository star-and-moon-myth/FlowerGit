package com.lnsf.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author 从C3P0连接池获取连接 getDateSource返回连接池对象
 */
public class C3p0Utils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource(
			"mysql");
	// 为了并发安全，使用ThreadLocal对象
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	/**
	 * 
	 * @return
	 * @throws SQLException
	 *             返回连接，首先判断线程是否含有连接，如果没有，则新建连接
	 */
	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();
		if (con != null)
			return con;
		return dataSource.getConnection();
	}

	/**
	 * 开启事务
	 * 
	 * @throws SQLException
	 */
	public static void beginTransaction() throws SQLException {
		Connection con = tl.get();
		if (con != null)
			throw new RuntimeException("已经开启了事务");
		con = getConnection();
		con.setAutoCommit(false);
		tl.set(con);
	}

	/**
	 * @throws SQLException
	 *             提交事务
	 */
	public static void commitTransaction() throws SQLException {
		Connection con = tl.get();
		if (con == null)
			throw new RuntimeException("没有事务");
		con.commit();
		con.close();
		tl.remove();
	}

	/**
	 * @throws SQLException
	 *             回滚事务
	 */
	public static void rollbackTransaction() throws SQLException {
		Connection con = tl.get();
		if (con == null)
			throw new RuntimeException("没有事务");
		con.rollback();
		con.close();
		tl.remove();
	}

	/**
	 * 
	 * @param connection
	 * @throws SQLException
	 *             判断是否能够关闭连接，如果不属于事务那么就关闭。
	 */
	public static void releaseConnection(Connection connection)
			throws SQLException {
		Connection con = tl.get();
		if (con == null)
			connection.close();
		if (con != connection)
			connection.close();
	}

	/**
	 * 
	 * @return 返回连接池对象
	 */
	public static DataSource getDataSource() {
		return dataSource;

	}
}