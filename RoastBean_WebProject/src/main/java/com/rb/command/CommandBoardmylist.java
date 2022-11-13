package com.rb.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.rb.dao.DaoBoard;
import com.rb.dao.PageInfo;
import com.rb.dto.DtoBoard;

public class CommandBoardmylist implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int nPage = 1;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
			//int nPage = Integer.parseInt(request.getParameter("page"));
		} catch(Exception e) {
			e.printStackTrace();
		}		
		HttpSession session = null;
		session = request.getSession();
		session.setAttribute("cpage", nPage);
		
		DaoBoard dao = new DaoBoard();
		dao = DaoBoard.getInstance();
		String id = (String)session.getAttribute("ID");
		PageInfo pinfo = dao.myboardpage(id, nPage);
		request.setAttribute("page", pinfo);
		
		nPage = pinfo.getCurPage();
		
		
		ArrayList<DtoBoard> dtos = dao.myboard(id, nPage);
		request.setAttribute("myboardlist", dtos);

	}

}
