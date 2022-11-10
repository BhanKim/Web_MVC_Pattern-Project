package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoBoard;
import com.rb.dto.DtoBoard;


public class CommandBoardcontent implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String community_id = request.getParameter("community_id");
		DaoBoard dao = DaoBoard.getInstance();
		DtoBoard dto = dao.contentView(community_id);
		
		request.setAttribute("content_view", dto);
	}

}
