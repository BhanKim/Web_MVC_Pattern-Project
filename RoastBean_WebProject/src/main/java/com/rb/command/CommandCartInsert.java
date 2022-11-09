package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoCart;

public class CommandCartInsert implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("ID");
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        int cart_qty = Integer.parseInt(request.getParameter("cart_qty"));
        
        DaoCart dao = new DaoCart();
        dao.insertCart(product_id, user_id, cart_qty);

	}

}
