package com.qst.desertduggetserver.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class DBHelper {
	public final static String DRIVER = "com.mysql.jdbc.Driver";
	public final static String URL = "jdbc:mysql://127.0.0.1:3306/desertnuggetdb";
	public final static String USERNAME = "root";
	public final static String PWD = "qweasd";

	private Connection connection = null;
	private boolean connected = false;

	public DBHelper() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PWD);
			connected = true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行插入操作
	 * @param sql
	 * @return
	 */
	public int insert(String sql) {
		int lineNum = 0;
		if (!connected)
			return -1;
		try {
			PreparedStatement preStmt = (PreparedStatement) connection.prepareStatement(sql);
			lineNum = preStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lineNum;
	}

	/**
	 * 执行修改操作
	 * @param sql
	 * @return
	 */
	public int update(String sql) {
		int lineNum = 0;
		if (!connected)
			return 0;
		try {
			PreparedStatement preStmt = (PreparedStatement) connection.prepareStatement(sql);
			lineNum = preStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lineNum;
	}

	/**
	 * 执行删除表中数据
	 * @param sql
	 */
	public int delete(String sql) {
		int lineNum = 0;
		try {
			Statement stmt = connection.createStatement();
			lineNum = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lineNum;
	}

	/**
	 * 执行查询语句
	 * @param sql
	 * @return 结果集
	 */
	public ResultSet query(String sql) {
		ResultSet rs = null;
		Statement statement;
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 关闭数据库连接
	 */
	public void close(){
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}