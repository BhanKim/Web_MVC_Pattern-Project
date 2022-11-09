package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoAdminLogin;

public class CommandAdminLogin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(); // *******session
		String admin_id = request.getParameter("admin_id");
		String admin_pw = request.getParameter("admin_pw");
		int checkAdmin;
		
		DaoAdminLogin dao = new DaoAdminLogin();
		checkAdmin = dao.loginCheckAdmin(admin_id, admin_pw);
		
		if(checkAdmin == 1) {
			session.setAttribute("ADMIN", admin_id);
			session.setAttribute("NICK", "관리자");
		}
		
		
	}

}
