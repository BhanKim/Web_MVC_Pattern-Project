package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoManageUserList;
import com.rb.dto.DtoManageUserList;

public class CommandManageUserList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DaoManageUserList dao = new DaoManageUserList();
		System.out.println("user_list_dao");
		ArrayList<DtoManageUserList> dtos = dao.manageuserlist();
		request.setAttribute("manageuserlist", dtos);

	}

}
