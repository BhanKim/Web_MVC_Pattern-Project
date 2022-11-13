package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoCart;
import com.rb.dao.DaoUserLogin;
import com.rb.dto.DtoCartList;
import com.rb.dto.DtoCartUserInfo;
import com.rb.dto.DtoUser;

public class CommandCartList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("ID");
		
		DaoCart dao = new DaoCart();
        ArrayList<DtoCartList> dtos = dao.cartlist(user_id);
        request.setAttribute("cartlist", dtos);
        
        DtoCartUserInfo dto = dao.userInfo(user_id);
        request.setAttribute("cartUserInfo", dto);
        
        DaoUserLogin daos = new DaoUserLogin();
        DtoUser dtoss = daos.cartCount(user_id);
		session.setAttribute("CARTCOUNT", dtoss);
	}

}
