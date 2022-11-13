package com.rb.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoCart;
import com.rb.dao.DaoReview;

public class CommandReview implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("ID");
		int order_seq = Integer.parseInt(request.getParameter("order_seq"));
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String review_content = request.getParameter("review_content");
		int review_star = Integer.parseInt(request.getParameter("review_star"));
		
		DaoReview dao = new DaoReview();
        dao.insertReview(user_id, order_seq, product_id, review_content, review_star);

	}

}
