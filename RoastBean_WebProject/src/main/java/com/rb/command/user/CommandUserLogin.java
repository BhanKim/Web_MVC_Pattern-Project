package com.rb.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.command.Command;
import com.rb.dao.user.DaoUserLogin;

public class CommandUserLogin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); // *******session
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		int checkUser;
		
		DaoUserLogin dao = new DaoUserLogin();
		checkUser = dao.loginCheck(user_id, user_pw);

		if (checkUser == 1) {
			session.setAttribute("ID", user_id);
		}	

	}

}
