package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoBoard;
import com.rb.dto.DtoBoard;

public class CommandBoardsearch implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String b_opt = request.getParameter("b_opt");
		String keyword = request.getParameter("keyword");
		
		DaoBoard dao = DaoBoard.getInstance();
		ArrayList<DtoBoard> dtos = dao.bSearch(b_opt, keyword);
		request.setAttribute("bSearch", dtos);


	}

}
