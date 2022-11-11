package com.rb.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.rb.dao.DaoUserInfo;
import com.rb.dto.DtoUser;

public class CommandUserinfo implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String user_id = (String) session.getAttribute("ID");
		DaoUserInfo dao = new DaoUserInfo();
		DtoUser dto = dao.userInfoList(user_id);
		
		request.setAttribute("userinfo_list", dto);

	}

}
