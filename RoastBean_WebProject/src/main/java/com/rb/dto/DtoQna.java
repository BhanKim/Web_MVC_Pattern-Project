package com.rb.dto;

public class DtoQna {

	int qna_write_seq;
	String user_id;
	String qna_write_category;
	String qna_write_title;
	String qna_write_content;
	String qna_write_initdate;
	String qna_write_updatedate;
	String qna_write_deletedate;
	int qna_write_comment_seq;
	String admin_id;
	String qna_write_comment_content;
	String qna_write_comment_initdate;
	String qna_write_comment_updatedate;
	String qna_write_comment_deletedate;

	public DtoQna(int qna_write_seq, String user_id, String qna_write_category, String qna_write_title,
			String qna_write_content, String qna_write_initdate, String qna_write_updatedate,
			String qna_write_deletedate, int qna_write_comment_seq, String admin_id, String qna_write_comment_content,
			String qna_write_comment_initdate, String qna_write_comment_updatedate,
			String qna_write_comment_deletedate) {
		super();
		this.qna_write_seq = qna_write_seq;
		this.user_id = user_id;
		this.qna_write_category = qna_write_category;
		this.qna_write_title = qna_write_title;
		this.qna_write_content = qna_write_content;
		this.qna_write_initdate = qna_write_initdate;
		this.qna_write_updatedate = qna_write_updatedate;
		this.qna_write_deletedate = qna_write_deletedate;
		this.qna_write_comment_seq = qna_write_comment_seq;
		this.admin_id = admin_id;
		this.qna_write_comment_content = qna_write_comment_content;
		this.qna_write_comment_initdate = qna_write_comment_initdate;
		this.qna_write_comment_updatedate = qna_write_comment_updatedate;
		this.qna_write_comment_deletedate = qna_write_comment_deletedate;
	}



	public DtoQna(int qna_write_seq, String qna_write_category, String qna_write_title, String qna_write_content,
			String qna_write_initdate, String qna_write_comment_content, String qna_write_comment_initdate) {
		super();
		this.qna_write_seq = qna_write_seq;
		this.qna_write_category = qna_write_category;
		this.qna_write_title = qna_write_title;
		this.qna_write_content = qna_write_content;
		this.qna_write_initdate = qna_write_initdate;
		this.qna_write_comment_content = qna_write_comment_content;
		this.qna_write_comment_initdate = qna_write_comment_initdate;
	}



	public DtoQna(int qna_write_seq, String user_id, String qna_write_category, String qna_write_title,
			String qna_write_content, String qna_write_initdate, String qna_write_comment_content,
			String qna_write_comment_initdate, String qna_write_comment_updatedate,
			String qna_write_comment_deletedate) {
		super();
		this.qna_write_seq = qna_write_seq;
		this.user_id = user_id;
		this.qna_write_category = qna_write_category;
		this.qna_write_title = qna_write_title;
		this.qna_write_content = qna_write_content;
		this.qna_write_initdate = qna_write_initdate;
		this.qna_write_comment_content = qna_write_comment_content;
		this.qna_write_comment_initdate = qna_write_comment_initdate;
		this.qna_write_comment_updatedate = qna_write_comment_updatedate;
		this.qna_write_comment_deletedate = qna_write_comment_deletedate;
	}



	public int getQna_write_seq() {
		return qna_write_seq;
	}

	public void setQna_write_seq(int qna_write_seq) {
		this.qna_write_seq = qna_write_seq;
	}

	public String getQna_write_category() {
		return qna_write_category;
	}

	public void setQna_write_category(String qna_write_category) {
		this.qna_write_category = qna_write_category;
	}

	public String getQna_write_title() {
		return qna_write_title;
	}

	public void setQna_write_title(String qna_write_title) {
		this.qna_write_title = qna_write_title;
	}

	public String getQna_write_content() {
		return qna_write_content;
	}

	public void setQna_write_content(String qna_write_content) {
		this.qna_write_content = qna_write_content;
	}

	public String getQna_write_initdate() {
		return qna_write_initdate;
	}

	public void setQna_write_initdate(String qna_write_initdate) {
		this.qna_write_initdate = qna_write_initdate;
	}

	public String getQna_write_updatedate() {
		return qna_write_updatedate;
	}

	public void setQna_write_updatedate(String qna_write_updatedate) {
		this.qna_write_updatedate = qna_write_updatedate;
	}

	public String getQna_write_deletedate() {
		return qna_write_deletedate;
	}

	public void setQna_write_deletedate(String qna_write_deletedate) {
		this.qna_write_deletedate = qna_write_deletedate;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getQna_write_comment_seq() {
		return qna_write_comment_seq;
	}

	public void setQna_write_comment_seq(int qna_write_comment_seq) {
		this.qna_write_comment_seq = qna_write_comment_seq;
	}

	public String getQna_write_comment_content() {
		return qna_write_comment_content;
	}

	public void setQna_write_comment_content(String qna_write_comment_content) {
		this.qna_write_comment_content = qna_write_comment_content;
	}

	public String getQna_write_comment_initdate() {
		return qna_write_comment_initdate;
	}

	public void setQna_write_comment_initdate(String qna_write_comment_initdate) {
		this.qna_write_comment_initdate = qna_write_comment_initdate;
	}

	public String getQna_write_comment_updatedate() {
		return qna_write_comment_updatedate;
	}

	public void setQna_write_comment_updatedate(String qna_write_comment_updatedate) {
		this.qna_write_comment_updatedate = qna_write_comment_updatedate;
	}

	public String getQna_write_comment_deletedate() {
		return qna_write_comment_deletedate;
	}

	public void setQna_write_comment_deletedate(String qna_write_comment_deletedate) {
		this.qna_write_comment_deletedate = qna_write_comment_deletedate;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

}
