package com.rb.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoUserSignup;


public class CommandUserCheckId implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String user_name = request.getParameter("user_name");
		request.setAttribute("user_name", user_name);
		
		String user_id = request.getParameter("user_id");
		DaoUserSignup dao = new DaoUserSignup();
		int checkIdDuplication = dao.checkId(user_id);
		request.setAttribute("user_id", user_id);
		request.setAttribute("checkIdDuplication", checkIdDuplication);
		
	}

}
