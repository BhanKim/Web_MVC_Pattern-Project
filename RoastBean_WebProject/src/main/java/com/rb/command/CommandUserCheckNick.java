package com.rb.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoUserSignup;

public class CommandUserCheckNick implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		PrintWriter writer = response.getWriter();
		String user_nick = request.getParameter("user_nick");
		DaoUserSignup dao = new DaoUserSignup();
		int check = dao.checkNick(user_nick);
		
		if(check == 1) {
			writer.println("<html><head></head><body>");
			writer.println("<script language=\"javascript\">");
			writer.println("		alert(\"이미 있는 닉네임 입니다.\");");
			writer.println("		history.back();");
			writer.println("</script>");
			writer.println("</body></html>");
			writer.close();
		}
	}

}
