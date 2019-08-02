package com.lnsf.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class TxQueryRunner extends QueryRunner {
	@Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        // TODO Auto-generated method stub
        Connection con=C3p0Utils.getConnection();
        int[] result=super.batch(con,sql, params);
        C3p0Utils.releaseConnection(con);
        return result;
    }

    @Override
    public int execute(String sql, Object... params) throws SQLException {
        // TODO Auto-generated method stub
        Connection con=C3p0Utils.getConnection();
        int result=super.execute(con,sql, params);
        C3p0Utils.releaseConnection(con);
        return result;
        
    }

    @Override
    public <T> List<T> execute(String sql, ResultSetHandler<T> rsh,
            Object... params) throws SQLException {
        // TODO Auto-generated method stub
        Connection con=C3p0Utils.getConnection();
        List<T> result=super.execute(con,sql, rsh, params);
        C3p0Utils.releaseConnection(con);
        return result;
        
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params)
            throws SQLException {
        // TODO Auto-generated method stub
        Connection con=C3p0Utils.getConnection();
        T result=super.insert(con,sql, rsh, params);
        C3p0Utils.releaseConnection(con);
        return result;

    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh)
            throws SQLException {
        // TODO Auto-generated method stub
        Connection con=C3p0Utils.getConnection();
        T result=super.insert(con,sql, rsh);
        C3p0Utils.releaseConnection(con);
        return result;
        
    }

    @Override
    public <T> T insertBatch(String sql, ResultSetHandler<T> rsh,
            Object[][] params) throws SQLException {
        // TODO Auto-generated method stub
        Connection con=C3p0Utils.getConnection();
        T result=super.insertBatch(con,sql, rsh, params);
        C3p0Utils.releaseConnection(con);
        return result;
        
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
            throws SQLException {
        // TODO Auto-generated method stub
        Connection con=C3p0Utils.getConnection();
        T result=super.query(con,sql, rsh, params);
        C3p0Utils.releaseConnection(con);
        return result;
        
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh)
            throws SQLException {
        Connection con=C3p0Utils.getConnection();
        T result=super.query(con, sql, params, rsh);
        C3p0Utils.releaseConnection(con);
        return result;
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public <T> T query(String sql, Object param, ResultSetHandler<T> rsh)
            throws SQLException {
        Connection con=C3p0Utils.getConnection();
        T result=super.query(con, sql, param, rsh);
        C3p0Utils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        // TODO Auto-generated method stub
        Connection con=C3p0Utils.getConnection();
        T result= super.query(con,sql, rsh);
        C3p0Utils.releaseConnection(con);
        return result;
        
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        // TODO Auto-generated method stub
        Connection con=C3p0Utils.getConnection();
        int result= super.update(con,sql, params);
        C3p0Utils.releaseConnection(con);
        return result;
    
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        // TODO Auto-generated method stub
        Connection con=C3p0Utils.getConnection();
        int result= super.update(con,sql, param);
        C3p0Utils.releaseConnection(con);
        return result;
        
    }

    @Override
    public int update(String sql) throws SQLException {
        // TODO Auto-generated method stub
        Connection con=C3p0Utils.getConnection();
        int result=super.update(con,sql);
        C3p0Utils.releaseConnection(con);
        return result;
     
    }

}
