package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoOrder;

public class CommandOrder implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("ID");
		String order_telno = request.getParameter("order_telno1") + request.getParameter("order_telno2") + request.getParameter("order_telno3");
		String order_zipcode = request.getParameter("order_zipcode");
		String order_address1 = request.getParameter("order_address1");
		String order_address2 = request.getParameter("order_address2");
		String order_address3 = request.getParameter("order_address3");
		String order_email = request.getParameter("order_email1") + "@" + request.getParameter("order_email2");
		
		DaoOrder dao = new DaoOrder();
		dao.insertOrder(user_id);
		dao.insertOrderUserInfo(order_telno, order_zipcode, order_address1, order_address2, order_address3, order_email, user_id);
		dao.deleteCart(user_id);

	}

}
