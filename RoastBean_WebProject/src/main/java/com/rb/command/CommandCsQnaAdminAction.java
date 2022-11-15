package com.rb.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoQna;

public class CommandCsQnaAdminAction implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		String admin_id = (String) session.getAttribute("ADMIN");
		String submit_type = request.getParameter("submit_type");
		String qna_write_seq = request.getParameter("qna_write_seq");
		String qna_write_comment_content = request.getParameter("qna_write_comment_content");
		
		DaoQna dao = new DaoQna();
		
		if(submit_type.equals("insert")) {
			dao.adminAnswerInsert(admin_id, qna_write_seq, qna_write_comment_content);
		}else {
			dao.adminAnswerUpdate(qna_write_seq, qna_write_comment_content);
		}
	}

}
