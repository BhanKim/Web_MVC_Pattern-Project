package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoComment;
import com.rb.dto.DtoComment;


public class CommandBoardcommentlist implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String community_id = request.getParameter("community_id");
		
		DaoComment dao = DaoComment.getInstance();
		ArrayList<DtoComment> dtos = dao.commentList(community_id);
		request.setAttribute("cList", dtos);
	}

}
