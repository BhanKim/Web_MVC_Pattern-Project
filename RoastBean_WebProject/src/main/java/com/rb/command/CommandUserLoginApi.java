package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoUserLogin;

public class CommandUserLoginApi implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); // *******session
		String api_email = request.getParameter("api_email");
		String user_nick = null;
		
		DaoUserLogin dao = new DaoUserLogin();
		user_nick = dao.loginCheckApi(api_email);

		session.setAttribute("ID", api_email);
		session.setAttribute("NICK", user_nick);
		session.setAttribute("API", "1");

	}

}
