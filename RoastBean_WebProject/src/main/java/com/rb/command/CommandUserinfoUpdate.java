package com.rb.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoUserInfo;
import com.rb.dao.DaoUserSignup;

public class CommandUserinfoUpdate implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(); // *******session

		String user_id = request.getParameter("user_id");
		String user_nick = request.getParameter("user_nick");
		String user_telno = request.getParameter("user_telno");
		String user_email = request.getParameter("user_email");
		String user_addresszipcode = request.getParameter("user_addresszipcode");
		String user_address1 = request.getParameter("user_address1");
		String user_address2 = request.getParameter("user_address2");
		String user_address3 = request.getParameter("user_address3");
		
		DaoUserInfo dao = new DaoUserInfo();
		
		dao.userInfoUpdate(user_id, user_nick, user_telno, user_email, user_addresszipcode, user_address1, user_address2, user_address3);
		session.setAttribute("NICK", user_nick);

	}

}
