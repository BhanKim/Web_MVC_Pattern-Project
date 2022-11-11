package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoBoard;


public class CommandBoarddelete implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String community_id = request.getParameter("community_id");
		DaoBoard dao = DaoBoard.getInstance();
		dao.delete(community_id);

	}

}
