package com.rb.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoUserSignup;


public class CommandUserCheckId implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int check = 0;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		String user_id = request.getParameter("user_id");
		DaoUserSignup dao = new DaoUserSignup();
		check = dao.checkId(user_id);
		
		if(check == 1) {
			writer.println("<html><head></head><body>");
			writer.println("<script language=\"javascript\">");
			writer.println("		alert(\"이미 있는 아이디 입니다.\");");
			writer.println("		history.back();");
			writer.println("</script>");
			writer.println("</body></html>");
			writer.close();
		}
		
		
	}

}
