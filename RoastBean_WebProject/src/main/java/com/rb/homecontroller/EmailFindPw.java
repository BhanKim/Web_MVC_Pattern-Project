package com.rb.homecontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoEmailFindPw;


/**
 * Servlet implementation class Email
 */
@WebServlet("/FindPw")
public class EmailFindPw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmailFindPw() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		
		DaoEmailFindPw dao = new DaoEmailFindPw();
		dao.findPw(user_id, user_name, user_email);
		
		response.getWriter().write(dao.findPw(user_id, user_name, user_email) + "");
		
	}

}