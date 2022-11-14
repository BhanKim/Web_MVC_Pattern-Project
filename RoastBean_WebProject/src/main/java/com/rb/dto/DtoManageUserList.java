package com.rb.dto;

public class DtoManageUserList {
	String user_id;
	String user_pw;
	String user_name;
	String user_birthday;
	String user_gender;
	String user_email;
	String user_telno;
	public DtoManageUserList(String user_id, String user_pw, String user_name, String user_birthday,
			String user_gender, String user_email, String user_telno) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_birthday = user_birthday;
		this.user_gender = user_gender;
		this.user_email = user_email;
		this.user_telno = user_telno;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_telno() {
		return user_telno;
	}
	public void setUser_telno(String user_telno) {
		this.user_telno = user_telno;
	}
	
	

}
