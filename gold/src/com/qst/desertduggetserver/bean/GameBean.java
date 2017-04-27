package com.qst.desertduggetserver.bean;

public class GameBean {
	private String name; // 游戏名
	private String pwd; // 游戏房间密码
	private int create_name; // 创建人昵称

	public GameBean() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getCreate_name() {
		return create_name;
	}

	public void setCreate_name(int create_name) {
		this.create_name = create_name;
	}
}