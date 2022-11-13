package com.rb.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoQna;
import com.rb.dto.DtoQna;

public class CommandCsQnaList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		DaoQna dao = new DaoQna();
		ArrayList<DtoQna> dtos = dao.qnaListAdmin();
		request.setAttribute("adminQnaList", dtos);
	}

}
