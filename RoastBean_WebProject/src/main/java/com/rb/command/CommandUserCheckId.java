package com.rb.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoUserSignup;

public class CommandUserCheckId implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
//		String userId = request.getParameter("user_id");
//		// join.jsp에서 받아온 key값이 userId이고
//		// value값은 유저가 실제로 적은 값, String userId에는 value값이 들어간다.
//				
//		DaoUserSignup dao = new DaoUserSignup();
//				
//		int checkId = dao.checkId(userId);
		
					
		String user_id = request.getParameter("user_id");
		// join.jsp에서 받아온 key값이 userId이고
		// value값은 유저가 실제로 적은 값, String userId에는 value값이 들어간다.
				
		DaoUserSignup dao = new DaoUserSignup();
				
		int idCheck = dao.checkId(user_id);
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(idCheck + ""); // --> ajax 결과값인 result가 됨
			// --> String으로 값을 내보낼 수 있도록 + "" 를 해준다
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

				
	}

}
