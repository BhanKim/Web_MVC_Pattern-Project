package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoUserList;
import com.rb.dto.DtoUserList;



public class CommandUserList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		DaoUserList dao = new DaoUserList();
		System.out.println("user_list_dao");
		ArrayList<DtoUserList> dtos = dao.userlist();
		request.setAttribute("userlist", dtos);
		

	}

}
