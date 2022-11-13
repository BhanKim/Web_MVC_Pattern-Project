package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoCart;
import com.rb.dao.DaoUserLogin;
import com.rb.dto.DtoUser;

public class CommandCartDelete implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("ID");
		
        DaoCart dao = new DaoCart();
        dao.cartDelete(product_id);
        
        DaoUserLogin daos = new DaoUserLogin();
        DtoUser dtos = daos.cartCount(user_id);
		session.setAttribute("CARTCOUNT", dtos);

	}

}
