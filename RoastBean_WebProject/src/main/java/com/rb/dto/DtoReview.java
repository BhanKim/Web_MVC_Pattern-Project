package com.rb.dto;

import java.sql.Timestamp;

public class DtoReview {
	
	int rownum;
	Timestamp review_date;
	String review_content;
	int review_star;
	String user_nick;
	
	public DtoReview(int rownum, Timestamp review_date, String review_content, int review_star, String user_nick) {
		super();
		this.rownum = rownum;
		this.review_date = review_date;
		this.review_content = review_content;
		this.review_star = review_star;
		this.user_nick = user_nick;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public Timestamp getReview_date() {
		return review_date;
	}

	public void setReview_date(Timestamp review_date) {
		this.review_date = review_date;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public int getReview_star() {
		return review_star;
	}

	public void setReview_star(int review_star) {
		this.review_star = review_star;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	
}
