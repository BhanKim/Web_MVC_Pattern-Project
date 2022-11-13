package com.rb.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoComment;
import com.rb.dto.DtoComment;

public class CommandCommentupdate implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("commnet update");
		String community_comment_cono = request.getParameter("community_comment_cono");
		String community_comment_content = request.getParameter("community_comment_content");
		
		System.out.println(community_comment_cono);
		System.out.println(community_comment_content);
		
		DaoComment dao = DaoComment.getInstance();
		dao.coModify(community_comment_cono, community_comment_content);
		
		ArrayList<DtoComment> dtos = dao.commentList(community_comment_cono);
		request.setAttribute("cList", dtos);

	}

}
