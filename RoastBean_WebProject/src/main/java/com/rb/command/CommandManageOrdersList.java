package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoManageProductList;
import com.rb.dto.DtoManageProductList;

public class CommandManageOrdersList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DaoManageProductList dao = new DaoManageProductList();
		System.out.println("ManageOrdersList.command");
		ArrayList<DtoManageProductList> dtos = dao.manageorderslistselete();
		request.setAttribute("manage_order_list", dtos);

	}

}
