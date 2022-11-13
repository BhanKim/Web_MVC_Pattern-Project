package com.rb.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoEmail;

public class CommandEmail implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String uemail = request.getParameter("user_email");
		
		DaoEmail dao = new DaoEmail();
		String certifyNum = dao.send(uemail);
		
		response.getWriter().write(certifyNum);
	}


}