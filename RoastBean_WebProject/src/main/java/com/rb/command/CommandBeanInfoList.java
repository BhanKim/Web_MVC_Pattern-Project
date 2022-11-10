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
		System.out.println("beaninfo boardlist enter");
		int nPage = 1;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
			System.out.println(sPage + "spage");

		} catch (Exception e) {
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
