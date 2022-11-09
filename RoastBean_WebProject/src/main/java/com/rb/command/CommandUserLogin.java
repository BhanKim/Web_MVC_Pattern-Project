package com.rb.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.login.DaoUserLogin;

public class CommandUserLogin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); // *******session
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String page;
		int checkUser;
		
		DaoUserLogin dao = new DaoUserLogin();
		checkUser = dao.loginCheck(user_id, user_pw);

		if (checkUser == 1) {
			session.setAttribute("ID", user_id);
			page = "index.jsp";
		}else {
			page = "login.jsp";
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
