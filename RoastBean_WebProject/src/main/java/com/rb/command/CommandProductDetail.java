package com.rb.command;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoProductDetail;
import com.rb.dao.PageInfo;
import com.rb.dto.DtoProductList;
import com.rb.dto.DtoReview;

public class CommandProductDetail implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		
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
		
		DaoProductDetail dao = new DaoProductDetail();
        DtoProductList dtos = dao.list(product_id);
        request.setAttribute("productDetail", dtos);
        
        ArrayList<DtoReview> dto = dao.reviewList(product_id, nPage);
        request.setAttribute("reviewList", dto);
        PageInfo pinfo = dao.articlePageReview(nPage, product_id);
		request.setAttribute("page", pinfo);
		
		DtoProductList dtoss = dao.avgCountStar(product_id);
		request.setAttribute("reviewAvg", dtoss);

	}

}