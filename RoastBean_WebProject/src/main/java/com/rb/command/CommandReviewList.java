package com.rb.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoReview;
import com.rb.dto.DtoProductList;

public class CommandReviewList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		int order_seq = Integer.parseInt(request.getParameter("order_seq"));
		
		DaoReview dao = new DaoReview();
		DtoProductList dtos = dao.listReview(order_seq);
        request.setAttribute("review", dtos);
		
	}

}
