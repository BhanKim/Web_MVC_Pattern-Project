package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoBoard;
import com.rb.dao.PageInfo;
import com.rb.dto.DtoBoard;

public class CommandBoardlist implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("command boardlist enter");
		int nPage = 1;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
			System.out.println(sPage + "spage");
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
		DaoBoard dao = new DaoBoard();
		dao = DaoBoard.getInstance();
		PageInfo pinfo = dao.articlePage(nPage);
		request.setAttribute("page", pinfo);
		
		nPage = pinfo.getCurPage();
		
		HttpSession session = null;
		session = request.getSession();
		session.setAttribute("cpage", nPage);
		
		ArrayList<DtoBoard> dtos = dao.list(nPage);
		request.setAttribute("list", dtos);

		dtos = dao.noticeList();
		request.setAttribute("nList", dtos);

	} // Method

	

}
