package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoBoard;

public class CommandBoardupdate implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bId = request.getParameter("community_id");
		String bTitle = request.getParameter("community_title");
		String bContent = request.getParameter("community_content");
		
		DaoBoard dao = DaoBoard.getInstance();
		dao.modify(bId, bTitle, bContent);

	}

}
