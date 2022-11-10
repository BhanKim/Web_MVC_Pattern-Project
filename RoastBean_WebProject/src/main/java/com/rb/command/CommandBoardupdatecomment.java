package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoComment;
import com.rb.dto.DtoComment;


public class CommandBoardupdatecomment implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String community_comment_cono = request.getParameter("community_comment_cono");
		String community_comment_content = request.getParameter("community_comment_content");
		
		DaoComment dao = DaoComment.getInstance();
		dao.coModify(community_comment_cono, community_comment_content);
		
		ArrayList<DtoComment> dtos = dao.commentList(community_comment_cono);
		request.setAttribute("cList", dtos);

	}

}
