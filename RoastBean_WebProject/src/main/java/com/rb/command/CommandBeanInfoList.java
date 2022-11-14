package com.rb.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.BeanInfo;
import com.rb.dao.DaoBeanInfo;
import com.rb.dao.DaoBoard;
import com.rb.dao.PageInfo;
import com.rb.dto.DtoBeanInfo;
import com.rb.dto.DtoBoard;

public class CommandBeanInfoList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
		
		DaoBeanInfo dao = new DaoBeanInfo();
		dao = DaoBeanInfo.getInstance();
		BeanInfo binfo = dao.articlePage(nPage);
		request.setAttribute("page", binfo);

		nPage = binfo.getCurPage();

		HttpSession session = null;
		session = request.getSession();
		session.setAttribute("cpage", nPage);

		ArrayList<DtoBeanInfo> dtos = dao.list(nPage);
		request.setAttribute("list", dtos);

	} // Method

}
