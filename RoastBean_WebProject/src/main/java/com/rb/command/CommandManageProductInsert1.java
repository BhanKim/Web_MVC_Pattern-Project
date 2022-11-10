package com.rb.command;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoManageProductList;

public class CommandManageProductInsert1 implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String category_type = request.getParameter("category_type");
		String category_acidity = request.getParameter("category_acidity");
		String category_aroma = request.getParameter("category_aroma");
		String category_body = request.getParameter("category_body");
		String category_sweet = request.getParameter("category_sweet");
		
		System.out.println("CommandManageProductInsert1.command");
		System.out.println(session.getAttribute("product_name"));
		String first_pruduct_name = session.getAttribute("product_name").toString();
		String first_product_nation = session.getAttribute("product_nation").toString();
		String first_product_image = session.getAttribute("product_image").toString();
		String first_product_info = session.getAttribute("product_info").toString();
		String first_product_stock = session.getAttribute("product_stock").toString();
		String first_product_weight = session.getAttribute("product_weight").toString();
		String first_product_price = session.getAttribute("product_price").toString();
		
		System.out.println(first_pruduct_name);
		
		DaoManageProductList dao = new DaoManageProductList();
		
		
		dao.manageproductinsert(first_pruduct_name,first_product_nation,first_product_image,first_product_info, first_product_stock,first_product_weight,first_product_price);
		//DtoManageProductList dtos = dao.manageproductinsertselect();
		int product_id = dao.manageproductinsertselect();
		//String product_id = request.getParameter("product_id");
		//System.out.println(product_id);
		System.out.println(category_type);
		dao.manageproductinsert1(category_type, category_acidity, category_aroma, category_body, category_sweet,product_id);
	}

}
