package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoUserLogin;
import com.rb.dto.DtoUser;
import com.rb.dto.DtoUserLogin;

public class CommandUserLoginApi implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); // *******session
		
		String api_email = request.getParameter("api_email");
		DaoUserLogin dao = new DaoUserLogin();
		DtoUserLogin dto = dao.loginCheckApi(api_email);
		int checkLoginApi = dto.getCheck();

		if(checkLoginApi == 1) {
			session.setAttribute("ID", api_email);
			session.setAttribute("NICK", dto.getUser_nick());
			session.setAttribute("API", "1");
			checkLoginApi = 1;
		}else {
			checkLoginApi = 0;
			request.setAttribute("api_email", api_email);
		}
		request.setAttribute("checkLoginApi", checkLoginApi);
		
		String user_id = (String) session.getAttribute("ID");
        DaoUserLogin daos = new DaoUserLogin();
        DtoUser dtos = daos.cartCount(user_id);
		session.setAttribute("CARTCOUNT", dtos);
	}
	
}
