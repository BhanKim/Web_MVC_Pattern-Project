package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoUserLogin;
import com.rb.dto.DtoUser;
import com.rb.dto.DtoUserLogin;

public class CommandUserLogin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); // *******session
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");

		DaoUserLogin dao = new DaoUserLogin();
		DtoUserLogin dto = dao.loginCheck(user_id, user_pw);
		int checkLogin = dto.getCheck();

		if (checkLogin == 1) {
			session.setAttribute("ID", user_id);
			session.setAttribute("NICK", dto.getUser_nick());
			checkLogin = 1;
		} else {
			checkLogin = 0;
		}
		request.setAttribute("checkLogin", checkLogin);
		
		DtoUser dtos = dao.cartCount(user_id);
		session.setAttribute("CARTCOUNT", dtos);
	}

}
