package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.rb.dao.DaoManageProductList;

public class CommandManageProductInsert implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String product_name = request.getParameter("product_name");
		String product_nation = request.getParameter("product_nation");
		String product_image = request.getParameter("product_image");
		String product_info = request.getParameter("product_info");
		int product_stock = Integer.parseInt(request.getParameter("product_stock"));
		int product_weight = Integer.parseInt(request.getParameter("product_weight"));
		int product_price = Integer.parseInt(request.getParameter("product_price"));
		System.out.println("ManageProductListInsert.command");
		System.out.println(product_stock);
		System.out.println(product_name);
		
		HttpSession session = request.getSession();
		session.setAttribute("product_name", product_name);
		session.setAttribute("product_nation", product_nation);
		session.setAttribute("product_image", product_image);
		session.setAttribute("product_info", product_info);
		session.setAttribute("product_stock", product_stock);
		session.setAttribute("product_weight", product_weight);
		session.setAttribute("product_price", product_price);

//		String category_type = request.getParameter("category_type");
//		String category_acidity = request.getParameter("category_acidity");
//		String category_body = request.getParameter("category_body");
//		String category_sweet = request.getParameter("category_sweet");
//		String category_aroma = request.getParameter("category_aroma");
//		System.out.println("ManageProductListInsert1.command");
	

		//dao.manageproductinsert1(category_type, category_acidity, category_body, category_sweet, category_aroma);
	}

}
