package com.qst.desertduggetserver.bean;

public class GameBean {
	private String name; // ��Ϸ��
	private String pwd; // ��Ϸ��������
	private int create_name; // �������ǳ�

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