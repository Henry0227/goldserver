package com.qst.desertduggetserver.db;

import com.qst.desertduggetserver.bean.UserBean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    /**
     * 验证昵称是否已经被注册
     *
     * @param name 昵称
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
     * 用户注册，向数据库中插入一条记录
     *
     * @return
     */
    public static int insertUser(UserBean ub) {
        String sql = "INSERT INTO user (nickname,tel,pwd) VALUES " + "('" + ub.getNickname() + "', '" + ub.getTel() + "', '" + ub.getPwd()
                + "')";
        DBHelper helper = new DBHelper();
        int result = helper.insert(sql);

        helper.close();
        return result;
    }

    /**
     * 验证密码是否正确，验证密码前先调用nickNameisExist()方法判断用户名是否存在
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
        UserBean ub = new UserBean();
        ub.setNickname("hello");
        ub.setPwd("aaa");
        ub.setTel("123");
  //      System.err.println(ins + "");
    }
}