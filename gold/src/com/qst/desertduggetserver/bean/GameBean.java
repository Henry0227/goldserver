package com.qst.desertduggetserver.bean;

public class GameBean {
	private String name; // ��Ϸ��
	private String pwd; // ��Ϸ��������
	private int create_id; // ������id

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

	public int getCreate_id() {
		return create_id;
	}

	public void setCreate_id(int create_id) {
		this.create_id = create_id;
	}
}