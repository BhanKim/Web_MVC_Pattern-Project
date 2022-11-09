package com.rb.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.command.Command;
import com.rb.dao.user.DaoUserLogin;

public class CommandUserLoginApi implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); // *******session
		String api_email = request.getParameter("api_email");
		String page;
		int checkUserApi;
		
		DaoUserLogin dao = new DaoUserLogin();
		checkUserApi = dao.loginCheckApi(api_email);

		if (checkUserApi == 1) {
			session.setAttribute("ID", api_email);
			session.setAttribute("API", "1");
		} 

	}

}
