package com.qst.desertduggetserver.bean;

public class UserBean {
	private String nickname;    //�ǳ��ǳ�
	private String tel;			//�绰
	private String pwd;			//����
	private int g_id;			//�������Ϸid
	private String g_name; 		//�������Ϸ
	private int score;			//��Ϸ�÷�
	
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
