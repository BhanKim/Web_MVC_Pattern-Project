package com.rb.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoQna;

public class CommandCsQnaQuestion implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String user_id = (String) session.getAttribute("ID");
		String qna_write_category = request.getParameter("qna_write_category");
		String qna_write_title = request.getParameter("qna_write_title");
		String qna_write_content = request.getParameter("qna_write_content");

		DaoQna dao = new DaoQna();
		dao.userQuestionInsert(user_id, qna_write_category, qna_write_title, qna_write_content);
	}

}
