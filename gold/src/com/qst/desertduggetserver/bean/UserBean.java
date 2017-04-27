package com.qst.desertduggetserver.bean;

public class UserBean {
	private String nickname;    //昵称昵称
	private String tel;			//电话
	private String pwd;			//密码
	private int g_id;			//加入的游戏id
	private String g_name; 		//加入的游戏
	private int score;			//游戏得分
	
	public UserBean(){}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}	
}
