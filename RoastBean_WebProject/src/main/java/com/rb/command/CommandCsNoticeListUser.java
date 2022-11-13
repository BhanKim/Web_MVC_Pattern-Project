package com.rb.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoNotice;
import com.rb.dto.DtoNotice;

public class CommandCsNoticeListUser implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		DaoNotice dao = new DaoNotice();
		ArrayList<DtoNotice> dtos = dao.list();
		request.setAttribute("userNoticeList", dtos);

	}

}
