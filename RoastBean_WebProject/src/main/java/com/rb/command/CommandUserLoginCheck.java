package com.rb.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoUserLogin;

public class CommandUserLoginCheck implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String page;
		
		int checkUser;

		DaoUserLogin dao = new DaoUserLogin();
		
		checkUser = dao.loginCheck(user_id, user_pw);

		if (checkUser == 1) {
			page = "login_success.do";
			request.setAttribute("user_id", user_id);
		} else {
			page = "index.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
