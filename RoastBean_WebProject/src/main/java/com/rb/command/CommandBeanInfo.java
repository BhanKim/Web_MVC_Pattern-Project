package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoBeanInfo;
import com.rb.dto.DtoBeanInfo;

public class CommandBeanInfo implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DaoBeanInfo dao = new DaoBeanInfo();
		ArrayList<DtoBeanInfo> dtos = dao.list();

		request.setAttribute("list", dtos);

	}

}
