package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoBoard;

public class CommandBoardwrite implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
//    	request.setCharacterEncoding("UTF-8");
		System.out.println("write command 왔음");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ID");
//		DaoCustomer mdao = DaoCustomer.getInstance();
//		DtoCustomer mdto = mdao.getMember(id);
//		String bName = mdto.getcId();
//		System.out.println(bName);
		
//    	String bName = request.getParameter("bName");
    	String bTitle = request.getParameter("bTitle");
    	String bContent = request.getParameter("bContent");
    	
    	DaoBoard dao = DaoBoard.getInstance();
    	dao.write(id, bTitle, bContent);

	}

}
