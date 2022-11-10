package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoManageProductList;
import com.rb.dto.DtoManageProductList;
import com.rb.dto.DtoManageUserList;

public class CommandManageProductList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DaoManageProductList dao = new DaoManageProductList();
		System.out.println("ManageProductList.command");
		ArrayList<DtoManageProductList> dtos = dao.manageproductlist();
		request.setAttribute("manage_product_list", dtos);
	}

}
