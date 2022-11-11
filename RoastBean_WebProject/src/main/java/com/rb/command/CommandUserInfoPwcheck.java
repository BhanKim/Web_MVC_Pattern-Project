package com.rb.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoUserInfo;

public class CommandUserInfoPwcheck implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();

		String user_id = (String) session.getAttribute("ID");
		String user_pw = request.getParameter("user_pw");
		String page = null;
		
		DaoUserInfo dao = new DaoUserInfo();
		
		if(dao.userPwCheck(user_id, user_pw) == 1) {
			page = "mypage_info_update_list.do";
		}else {
			page = "mypage_info.do";
		}
		request.setAttribute("page", page);
	}

}
