package com.rb.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoQna;
import com.rb.dto.DtoQna;

public class CommandMyQnaList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("ID");
		
		DaoQna dao = new DaoQna();
		ArrayList<DtoQna> dtos = dao.qnaList(user_id);
		request.setAttribute("myQnaList", dtos);
	}

}
