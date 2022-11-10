package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoUserSignup;

public class CommandUserSignup implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); // *******session

		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String user_pw = request.getParameter("user_pw");
		String user_telno = request.getParameter("user_telno");
		String user_email = request.getParameter("user_email");
		String user_birthday = request.getParameter("user_birthday1")+"-"+request.getParameter("user_birthday2")+"-"+request.getParameter("user_birthday3");
		String user_gender = request.getParameter("user_gender");
		String user_addresszipcode = request.getParameter("user_addresszipcode");
		String user_address1 = request.getParameter("user_address1");
		String user_address2 = request.getParameter("user_address2");
		String user_address3 = request.getParameter("user_address3");
		
		DaoUserSignup dao = new DaoUserSignup();
		dao.signupAction(user_id, user_name, user_nick, user_pw, user_telno, user_email, user_birthday, user_gender, user_addresszipcode, user_address1, user_address2, user_address3);
		
		session.setAttribute("ID", user_id);
		session.setAttribute("NICK", user_nick);

	}

}
