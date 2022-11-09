package com.rb.command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.product.DaoProductManageList;
import com.rb.dto.product.DtoProductManageList;



public class CommmandProductList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DaoProductManageList dao = new DaoProductManageList();
		System.out.println("product_manage.dao");
		ArrayList<DtoProductManageList>dtos = dao.productList();
		request.setAttribute("product_manage", dtos);
	}

}
