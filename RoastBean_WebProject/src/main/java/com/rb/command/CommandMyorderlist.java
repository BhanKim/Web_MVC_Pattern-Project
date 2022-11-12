package com.rb.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoMyOrderlist;
import com.rb.dto.DtoMyOrderlist;

public class CommandMyorderlist implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("ID");
		
		DaoMyOrderlist dao = new DaoMyOrderlist();
		ArrayList<DtoMyOrderlist> dtos = dao.myOrderList(user_id);
		request.setAttribute("myOrderList", dtos);
	}

}
