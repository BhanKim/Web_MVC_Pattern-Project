package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoProductList;
import com.rb.dao.PageInfo;
import com.rb.dto.DtoProductList;

public class CommandProductList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String category_type = request.getParameter("category_type");
		
		DaoProductList dao = new DaoProductList();
        
		int nPage = 1;
		String sPage = null;
		try {
			if(request.getParameter("page") == null) {
				sPage = "1";
			} else {
				sPage = request.getParameter("page");
			}
			nPage = Integer.parseInt(sPage);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<DtoProductList> dtos = dao.list(nPage, category_type);
        request.setAttribute("list", dtos);
		PageInfo pinfo = dao.articlePageProduct(nPage, category_type);
		request.setAttribute("page", pinfo);

	}

}