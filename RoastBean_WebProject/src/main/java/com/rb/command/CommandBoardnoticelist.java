package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoBoard;
import com.rb.dto.DtoBoard;

public class CommandBoardnoticelist implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		DaoBoard dao = DaoBoard.getInstance();
		ArrayList<DtoBoard> dtos = dao.noticeList();
		request.setAttribute("nList", dtos);


	}

}
