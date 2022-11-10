package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoProductList;
import com.rb.dto.DtoProductList;

public class CommandProductList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		DaoProductList dao = new DaoProductList();
        ArrayList<DtoProductList> dtos = dao.list();
        request.setAttribute("list", dtos);

	}

}