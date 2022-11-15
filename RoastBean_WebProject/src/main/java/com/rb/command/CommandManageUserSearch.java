package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.rb.dao.DaoManageUserList;

import com.rb.dto.DtoManageUserList;

public class CommandManageUserSearch implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String queryname = request.getParameter("query");
		String querycontent = request.getParameter("content");
		
		System.out.println("ManageUserListSearch.command");
		DaoManageUserList dao = new DaoManageUserList();
		ArrayList<DtoManageUserList> dtos = dao.manageusersearch(queryname, querycontent);
		request.setAttribute("manageuserlist", dtos);
	}

}
