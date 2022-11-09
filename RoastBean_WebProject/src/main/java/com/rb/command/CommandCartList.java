package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoCart;
import com.rb.dto.DtoCartList;

public class CommandCartList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("ID");
		
		DaoCart dao = new DaoCart();
        ArrayList<DtoCartList> dtos = dao.cartlist(user_id);
        request.setAttribute("cartlist", dtos);
	}

}
