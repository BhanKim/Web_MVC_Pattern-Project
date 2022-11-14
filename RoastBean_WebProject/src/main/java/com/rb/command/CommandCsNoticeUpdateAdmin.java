package com.rb.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoNotice;

public class CommandCsNoticeUpdateAdmin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String notice_write_seq = request.getParameter("notice_write_seq");
		String notice_write_title = request.getParameter("notice_write_title");
		String notice_write_content = request.getParameter("notice_write_content");
		String btnType = request.getParameter("btnType");

		DaoNotice dao = new DaoNotice();

		if(btnType.equals("수정")) {
			dao.modify(notice_write_title, notice_write_content, notice_write_seq);
			System.out.println("update");
		}else {
			dao.modifyDelete(notice_write_seq);
			System.out.println("delete");
		}
		
	}

}
