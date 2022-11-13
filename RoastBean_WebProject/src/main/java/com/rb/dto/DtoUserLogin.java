package com.rb.dto;

public class DtoUserLogin {
	
	int check;
	String user_nick;
	String user_id;
	String user_pw;
	String user_email;
	String user_emailhash;
	String user_name;
	String user_address;
	String user_birthdate;
	String user_gender;
	String user_telno;
	String user_initdate;
	String user_updatedate;
	String user_deletedate;
	
	public DtoUserLogin() {
		// TODO Auto-generated constructor stub
	}
	
	public DtoUserLogin(int check, String user_nick, String user_id, String user_pw, String user_email,
			String user_emailhash, String user_name, String user_address, String user_birthdate, String user_gender,
			String user_telno, String user_initdate, String user_updatedate, String user_deletedate) {
		super();
		this.check = check;
		this.user_nick = user_nick;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_email = user_email;
		this.user_emailhash = user_emailhash;
		this.user_name = user_name;
		this.user_address = user_address;
		this.user_birthdate = user_birthdate;
		this.user_gender = user_gender;
		this.user_telno = user_telno;
		this.user_initdate = user_initdate;
		this.user_updatedate = user_updatedate;
		this.user_deletedate = user_deletedate;
	}

	public DtoUserLogin(int check, String user_nick) {
		super();
		this.check = check;
		this.user_nick = user_nick;
	}
	
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
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
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_emailhash() {
		return user_emailhash;
	}
	public void setUser_emailhash(String user_emailhash) {
		this.user_emailhash = user_emailhash;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_birthdate() {
		return user_birthdate;
	}
	public void setUser_birthdate(String user_birthdate) {
		this.user_birthdate = user_birthdate;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_telno() {
		return user_telno;
	}
	public void setUser_telno(String user_telno) {
		this.user_telno = user_telno;
	}
	public String getUser_initdate() {
		return user_initdate;
	}
	public void setUser_initdate(String user_initdate) {
		this.user_initdate = user_initdate;
	}
	public String getUser_updatedate() {
		return user_updatedate;
	}
	public void setUser_updatedate(String user_updatedate) {
		this.user_updatedate = user_updatedate;
	}
	public String getUser_deletedate() {
		return user_deletedate;
	}
	public void setUser_deletedate(String user_deletedate) {
		this.user_deletedate = user_deletedate;
	}
	
}