package com.rb.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.login.DaoAdminLogin;

public class CommandAdminLogin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(); // *******session
		String admin_id = request.getParameter("admin_id");
		String admin_pw = request.getParameter("admin_pw");
		String page;
		int checkAdmin;
		
		DaoAdminLogin dao = new DaoAdminLogin();
		checkAdmin = dao.loginCheckAdmin(admin_id, admin_pw);
		
		if(checkAdmin == 1) {
			session.setAttribute("ID", admin_id);
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
