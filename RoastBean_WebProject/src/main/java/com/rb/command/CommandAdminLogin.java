package com.rb.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.user.DaoAdminLogin;

public class CommandAdminLogin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String admin_id = request.getParameter("admin_id");
		String admin_pw = request.getParameter("admin_pw");
		DaoAdminLogin dao = new DaoAdminLogin();
		int checkAdmin = dao.loginCheckAdmin(admin_id, admin_pw);
		String page;
		
		if(checkAdmin == 1) {
			request.setAttribute("admin_id", admin_id);
			page = "login_success_admin.rb";
			System.out.println("Asdasd");
		}else {
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
