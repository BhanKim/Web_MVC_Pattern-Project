package com.rb.command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.product.DaoProductList;
import com.rb.dto.product.DtoProductList;



public class CommmandProductList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DaoProductList dao = new DaoProductList();
		System.out.println("product_manage.dao");
		ArrayList<DtoProductList>dtos = dao.productList();
		request.setAttribute("product_manage", dtos);
	}

}
