package com.rb.dto;

public class DtoBoard {
	
	// F
	int rownum;
	int community_id;
	String community_name;
	String community_title;
	String community_content;
	String community_initdate;
	String community_updatedate;
	String community_deletedate;
	int community_hit;
	int community_group;
	int community_step;
	int community_indent;
	int community_cnt;
	
	public DtoBoard() {
		// TODO Auto-generated constructor stub
	}
	// ALL select
	
	
	public DtoBoard(int rownum, int community_id, String community_name, String community_title,
			String community_content, String community_initdate, String community_updatedate,
			String community_deletedate, int community_hit, int community_group, int community_step,
			int community_indent, int community_cnt) {
		super();
		this.rownum = rownum;
		this.community_id = community_id;
		this.community_name = community_name;
		this.community_title = community_title;
		this.community_content = community_content;
		this.community_initdate = community_initdate;
		this.community_updatedate = community_updatedate;
		this.community_deletedate = community_deletedate;
		this.community_hit = community_hit;
		this.community_group = community_group;
		this.community_step = community_step;
		this.community_indent = community_indent;
		this.community_cnt = community_cnt;
	}
	
	
	public DtoBoard(int community_id, String community_name, String community_title, String community_content,
			String community_initdate, String community_updatedate, String community_deletedate, int community_hit,
			int community_group, int community_step, int community_indent, int community_cnt) {
		super();
		this.community_id = community_id;
		this.community_name = community_name;
		this.community_title = community_title;
		this.community_content = community_content;
		this.community_initdate = community_initdate;
		this.community_updatedate = community_updatedate;
		this.community_deletedate = community_deletedate;
		this.community_hit = community_hit;
		this.community_group = community_group;
		this.community_step = community_step;
		this.community_indent = community_indent;
		this.community_cnt = community_cnt;
	}
	
	// G&S


	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public int getCommunity_id() {
		return community_id;
	}

	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
	}

	public String getCommunity_name() {
		return community_name;
	}

	public void setCommunity_name(String community_name) {
		this.community_name = community_name;
	}

	public String getCommunity_title() {
		return community_title;
	}

	public void setCommunity_title(String community_title) {
		this.community_title = community_title;
	}

	public String getCommunity_content() {
		return community_content;
	}

	public void setCommunity_content(String community_content) {
		this.community_content = community_content;
	}

	public String getCommunity_initdate() {
		return community_initdate;
	}

	public void setCommunity_initdate(String community_initdate) {
		this.community_initdate = community_initdate;
	}

	public String getCommunity_updatedate() {
		return community_updatedate;
	}

	public void setCommunity_updatedate(String community_updatedate) {
		this.community_updatedate = community_updatedate;
	}

	public String getCommunity_deletedate() {
		return community_deletedate;
	}

	public void setCommunity_deletedate(String community_deletedate) {
		this.community_deletedate = community_deletedate;
	}

	public int getCommunity_hit() {
		return community_hit;
	}

	public void setCommunity_hit(int community_hit) {
		this.community_hit = community_hit;
	}

	public int getCommunity_group() {
		return community_group;
	}

	public void setCommunity_group(int community_group) {
		this.community_group = community_group;
	}

	public int getCommunity_step() {
		return community_step;
	}

	public void setCommunity_step(int community_step) {
		this.community_step = community_step;
	}

	public int getCommunity_indent() {
		return community_indent;
	}

	public void setCommunity_indent(int community_indent) {
		this.community_indent = community_indent;
	}

	public int getCommunity_cnt() {
		return community_cnt;
	}

	public void setCommunity_cnt(int community_cnt) {
		this.community_cnt = community_cnt;
	}




	
} // End
