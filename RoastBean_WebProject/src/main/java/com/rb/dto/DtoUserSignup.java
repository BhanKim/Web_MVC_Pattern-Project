package com.rb.dto;

public class DtoUserSignup {
	
	String user_id;
	String user_name;
	String user_nick;
	String user_pw;
	String user_telno;
	String user_email;
	String user_birthday;
	String user_gender;
	String user_addresszipcode;
	String user_address1;
	String user_address2;
	String user_address3;
	
	public DtoUserSignup(String user_id, String user_name, String user_nick, String user_pw, String user_telno,
			String user_email, String user_birthday, String user_gender, String user_addresszipcode,
			String user_address1, String user_address2, String user_address3) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_nick = user_nick;
		this.user_pw = user_pw;
		this.user_telno = user_telno;
		this.user_email = user_email;
		this.user_birthday = user_birthday;
		this.user_gender = user_gender;
		this.user_addresszipcode = user_addresszipcode;
		this.user_address1 = user_address1;
		this.user_address2 = user_address2;
		this.user_address3 = user_address3;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_telno() {
		return user_telno;
	}
	public void setUser_telno(String user_telno) {
		this.user_telno = user_telno;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
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
	public String getUser_addresszipcode() {
		return user_addresszipcode;
	}
	public void setUser_addresszipcode(String user_addresszipcode) {
		this.user_addresszipcode = user_addresszipcode;
	}
	public String getUser_address1() {
		return user_address1;
	}
	public void setUser_address1(String user_address1) {
		this.user_address1 = user_address1;
	}
	public String getUser_address2() {
		return user_address2;
	}
	public void setUser_address2(String user_address2) {
		this.user_address2 = user_address2;
	}
	public String getUser_address3() {
		return user_address3;
	}
	public void setUser_address3(String user_address3) {
		this.user_address3 = user_address3;
	}
	
	
	
}