package com.qst.desertduggetserver.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	/**
	 * ��֤�ǳ��Ƿ��Ѿ���ע��
	 * 
	 * @param name
	 *            �ǳ�
	 * @return
	 */
	public static boolean nickNameisExist(String name) {
		String sql = "select count(nickname) from user where nickname='" + name + "'";
		DBHelper helper = new DBHelper();
		ResultSet rs = helper.query(sql);
		int count = 0;
		try {
			if (rs.first())
				count = rs.getInt(1);
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		helper.close();
		return count == 0 ? false : true;

	}

	/**
	 * �û�ע�ᣬ�����ݿ��в���һ����¼
	 * 
	 * @param nickName
	 * @param tel
	 * @param pwd
	 * @return ��ʾ��Ϣ
	 */
	public static boolean insertUser(String nickName, String tel, String pwd) {
		String sql = "INSERT INTO user (nickname,tel,pwd) VALUES " + "('" + nickName + "', '" + tel + "', '" + pwd
				+ "')";
		DBHelper helper = new DBHelper();
		int result = helper.insert(sql);
		helper.close();
		return result <= 0 ? false : true;
	}

	/**
	 * ��֤�����Ƿ���ȷ����֤����ǰ�ȵ���nickNameisExist()�����ж��û����Ƿ����
	 * 
	 * @param nickName
	 * @param pwd
	 * @return
	 */
	public static boolean verifyPwd(String nickName, String pwd) {
		String sql = "select pwd from user where nickname='" + nickName + "'";
		DBHelper db = new DBHelper();
		ResultSet rs = db.query(sql);
		String dbPwd = null;
		try {
			if (rs.first()) {
				dbPwd = rs.getString(1);
				if (rs != null) {
					rs.close();
				}
				db.close();
				if (pwd.equals(dbPwd)) {
					return true;
				}
			}
		} catch (SQLException e) {
			db.close();
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		System.err.println(verifyPwd("����1", "qwe") + "");
	}
}