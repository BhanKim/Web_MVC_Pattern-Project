package com.rb.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoBoard;
import com.rb.dao.DaoReview;

public class CommandReviewUpdate implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		int review_seq = Integer.parseInt(request.getParameter("review_seq"));
		String review_content = request.getParameter("review_content");
		int review_star = Integer.parseInt(request.getParameter("review_star"));
		
		DaoReview dao = new DaoReview();
		dao.reviewUpdate(review_content, review_star, review_seq);

	}

}
