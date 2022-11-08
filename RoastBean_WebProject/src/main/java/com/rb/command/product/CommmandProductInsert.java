package com.rb.command.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.product.DaoProductList;

public class CommmandProductInsert implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String product_name = request.getParameter("product_name");
		String product_nation = request.getParameter("product_nation");
		String product_image = request.getParameter("product_image");
		String product_info = request.getParameter("product_info");
		String product_stock = request.getParameter("product_stock");
		String product_weight = request.getParameter("product_weight");
		String product_price = request.getParameter("product_price");
		
		
		DaoProductList dao = new DaoProductList();
		dao.insert(product_name, product_nation, product_image, product_info, product_stock, product_weight, product_price);
	}

}
