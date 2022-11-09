package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoCart;

public class CommandCartDelete implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int product_id = Integer.parseInt(request.getParameter("product_id"));
        
        DaoCart dao = new DaoCart();
        dao.cartDelete(product_id);

	}

}
