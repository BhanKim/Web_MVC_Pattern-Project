package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoComment;

public class CommandCommentwrite implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Enter comment writecommand");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ID");
		System.out.println(id + "session");
		String bId = request.getParameter("community_id");
		System.out.println(bId + "communityid");
    	String coContent = request.getParameter("community_comment_content");
    	System.out.println(coContent + "내용");
    	DaoComment dao = DaoComment.getInstance();
    	
    	dao.coWrite( bId, id, coContent);
    	

	}
 
}
