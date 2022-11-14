package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoComment;

public class CommandCommentwrite implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ID");
		String bId = request.getParameter("community_id");
    	String coContent = request.getParameter("community_comment_content");
    	DaoComment dao = DaoComment.getInstance();
    	
    	dao.coWrite( bId, id, coContent);
    	

	}
 
}
