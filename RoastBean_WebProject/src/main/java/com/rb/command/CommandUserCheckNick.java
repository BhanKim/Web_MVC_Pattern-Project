package com.rb.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoUserSignup;

public class CommandUserCheckNick implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String user_nick = request.getParameter("user_nick");
		DaoUserSignup dao = new DaoUserSignup();
		int checkNickDuplication = dao.checkNick(user_nick);
		request.setAttribute("user_nick", user_nick);
		request.setAttribute("checkNickDuplication", checkNickDuplication);
	}

}
