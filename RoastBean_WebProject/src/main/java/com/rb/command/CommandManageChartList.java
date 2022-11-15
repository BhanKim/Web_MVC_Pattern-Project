package com.rb.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoManageChartList;
import com.rb.dao.DaoManageUserList;
import com.rb.dto.DtoManageChartList;
import com.rb.dto.DtoManageUserList;

public class CommandManageChartList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		DaoManageChartList dao = new DaoManageChartList();
		String dtos = dao.chartList();
		request.setAttribute("chartList", dtos);

	}

}
