package com.rb.dto;

public class DtoNotice {

	int rownumber;
	int notice_write_seq;
	String admin_id;
	String notice_write_title;
	String notice_write_content;
	String notice_write_initdate;
	String notice_write_updatedate;
	String notice_write_deletedate;
	
	public DtoNotice() {
		// TODO Auto-generated constructor stub
	}

	public DtoNotice(int notice_write_seq, String admin_id, String notice_write_title, String notice_write_content,
			String notice_write_initdate, String notice_write_updatedate, String notice_write_deletedate) {
		super();
		this.notice_write_seq = notice_write_seq;
		this.admin_id = admin_id;
		this.notice_write_title = notice_write_title;
		this.notice_write_content = notice_write_content;
		this.notice_write_initdate = notice_write_initdate;
		this.notice_write_updatedate = notice_write_updatedate;
		this.notice_write_deletedate = notice_write_deletedate;
	}

	public DtoNotice(int rownumber, int notice_write_seq, String notice_write_title, String notice_write_content,
			String notice_write_initdate, String notice_write_updatedate) {
		super();
		this.rownumber = rownumber;
		this.notice_write_seq = notice_write_seq;
		this.notice_write_title = notice_write_title;
		this.notice_write_content = notice_write_content;
		this.notice_write_initdate = notice_write_initdate;
		this.notice_write_updatedate = notice_write_updatedate;
	}

	// modify(updateBtn)
	public DtoNotice(int notice_write_seq, String notice_write_title, String notice_write_content) {
		super();
		this.notice_write_seq = notice_write_seq;
		this.notice_write_title = notice_write_title;
		this.notice_write_content = notice_write_content;
	}
	
	// modify(deleteBtn)
	public DtoNotice(int notice_write_seq) {
		super();
		this.notice_write_seq = notice_write_seq;
	}

	public int getRownumber() {
		return rownumber;
	}
	
	public void setRownumber(int Rownumber) {
		this.rownumber = Rownumber;
	}

	public int getNotice_write_seq() {
		return notice_write_seq;
	}

	public void setNotice_write_seq(int notice_write_seq) {
		this.notice_write_seq = notice_write_seq;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getNotice_write_title() {
		return notice_write_title;
	}

	public void setNotice_write_title(String notice_write_title) {
		this.notice_write_title = notice_write_title;
	}

	public String getNotice_write_content() {
		return notice_write_content;
	}

	public void setNotice_write_content(String notice_write_content) {
		this.notice_write_content = notice_write_content;
	}

	public String getNotice_write_initdate() {
		return notice_write_initdate;
	}

	public void setNotice_write_initdate(String notice_write_initdate) {
		this.notice_write_initdate = notice_write_initdate;
	}

	public String getNotice_write_updatedate() {
		return notice_write_updatedate;
	}

	public void setNotice_write_updatedate(String notice_write_updatedate) {
		this.notice_write_updatedate = notice_write_updatedate;
	}

	public String getNotice_write_deletedate() {
		return notice_write_deletedate;
	}

	public void setNotice_write_deletedate(String notice_write_deletedate) {
		this.notice_write_deletedate = notice_write_deletedate;
	}

	
	
}
