package com.rb.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandUserSignupList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String user_pw = request.getParameter("user_pw");

		request.setAttribute("user_id", user_id);
		request.setAttribute("user_name", user_name);
		request.setAttribute("user_nick", user_nick);
		request.setAttribute("user_pw", user_pw);
		
	}

}
