package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoManageProductList;

public class CommandManageUserOrderRanking implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		DaoManageProductList dao = new DaoManageProductList();
		System.out.println("ManageUserOrderRanking.command");
		int order_date_ranking_max = dao.manageuserprderrankingselect_max();
		String order_date_ranking_max_name = dao.manageuserprderrankingselect_max_name();
	    
	
		
		request.setAttribute("order_date_ranking_max", order_date_ranking_max);
		request.setAttribute("order_date_ranking_max_name", order_date_ranking_max_name);
	
		
	
	}

}
