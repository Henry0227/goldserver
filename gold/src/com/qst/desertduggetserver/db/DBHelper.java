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
	 * ִ�в������
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
	 * ִ���޸Ĳ���
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
	 * ִ��ɾ����������
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
	 * ִ�в�ѯ���
	 * @param sql
	 * @return �����
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
	 * �ر����ݿ�����
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