package com.rb.dto;

public class DtoComment {
	// F
	
	int community_comment_cono;
	int community_comment_id; // FK 값
	String community_comment_name;
	String community_comment_content;
	String community_comment_codate;

	// C
	public DtoComment() {
		// TODO Auto-generated constructor stub
	}

	public DtoComment(int community_comment_cono, int community_comment_id, String community_comment_name,
			String community_comment_content, String community_comment_codate) {
		super();
		this.community_comment_cono = community_comment_cono;
		this.community_comment_id = community_comment_id;
		this.community_comment_name = community_comment_name;
		this.community_comment_content = community_comment_content;
		this.community_comment_codate = community_comment_codate;
	}

	// G&S
	public int getCommunity_comment_cono() {
		return community_comment_cono;
	}

	public void setCommunity_comment_cono(int community_comment_cono) {
		this.community_comment_cono = community_comment_cono;
	}

	public int getCommunity_comment_id() {
		return community_comment_id;
	}

	public void setCommunity_comment_id(int community_comment_id) {
		this.community_comment_id = community_comment_id;
	}

	public String getCommunity_comment_name() {
		return community_comment_name;
	}

	public void setCommunity_comment_name(String community_comment_name) {
		this.community_comment_name = community_comment_name;
	}

	public String getCommunity_comment_content() {
		return community_comment_content;
	}

	public void setCommunity_comment_content(String community_comment_content) {
		this.community_comment_content = community_comment_content;
	}

	public String getCommunity_comment_codate() {
		return community_comment_codate;
	}

	public void setCommunity_comment_codate(String community_comment_codate) {
		this.community_comment_codate = community_comment_codate;
	}

} // END
