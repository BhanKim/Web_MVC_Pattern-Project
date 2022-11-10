package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoUserLogin;

public class CommandUserLogin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); // *******session
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_nick = null;
		
		DaoUserLogin dao = new DaoUserLogin();
		user_nick = dao.loginCheck(user_id, user_pw);

		session.setAttribute("ID", user_id);
		session.setAttribute("NICK", user_nick);

	}

}
