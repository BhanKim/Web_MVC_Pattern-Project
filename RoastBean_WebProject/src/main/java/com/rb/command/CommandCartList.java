package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoCart;
import com.rb.dto.DtoCartList;

public class CommandCartList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DaoCart dao = new DaoCart();
        ArrayList<DtoCartList> dtos = dao.cartlist();
        request.setAttribute("cartlist", dtos);
	}

}
