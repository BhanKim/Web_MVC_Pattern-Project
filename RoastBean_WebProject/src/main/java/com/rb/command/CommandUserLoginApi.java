package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoUserLogin;
import com.rb.dto.DtoUserLogin;

public class CommandUserLoginApi implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); // *******session
		
		String api_email = request.getParameter("api_email");
		DaoUserLogin dao = new DaoUserLogin();
		DtoUserLogin dto = dao.loginCheckApi(api_email);
		int check = dto.getCheck();

		if(check == 1) {
			session.setAttribute("ID", api_email);
			session.setAttribute("NICK", dto.getUser_nick());
			session.setAttribute("API", "1");
			check = 1;
		}else {
			check = 0;
			request.setAttribute("api_email", api_email);
		}
		request.setAttribute("check", check);
	}
	
	// check가 1이면 > ID,NICK에 세션 / index로
	// check가 null이면 > signupApi.jsp로 > 작성완료해서 버튼누르면 인서트 & index로

}
