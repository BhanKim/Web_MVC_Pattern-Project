package com.rb.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoReview;
import com.rb.dto.DtoReview;

public class CommandReviewMyListEdit implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		int review_seq = Integer.parseInt(request.getParameter("review_seq"));
		
		DaoReview dao = new DaoReview();
		DtoReview dtos = dao.listMyReviewEdit(review_seq);
        request.setAttribute("mylistEdit", dtos);

	}

}
