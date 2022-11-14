package com.rb.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoReview;
import com.rb.dao.PageInfo;
import com.rb.dto.DtoReview;

public class CommandReviewMyList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("ID");
		DaoReview dao = new DaoReview();
        
		int nPage = 1;
		String sPage = null;
		try {
			if(request.getParameter("pages") == null) {
				sPage = "1";
			} else {
				sPage = request.getParameter("pages");
			}
			nPage = Integer.parseInt(sPage);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<DtoReview> dtos = dao.reviewMyList(user_id, nPage);
        request.setAttribute("mylist", dtos);
        
        PageInfo pinfo = dao.articleMyPageReview(nPage, user_id);
		request.setAttribute("pages", pinfo);
		
	}

}
