package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoBoard;
import com.rb.dao.DaoUserLogin;
import com.rb.dto.DtoUserLogin;



public class CommandBoardreply implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String ID = (String)session.getAttribute("ID");
//		DaoUserLogin mdao = DaoUserLogin.getInstance();
//		DtoUserLogin mdto = mdao.getMember(ID);
//		String community_name = mdto.getUser_id();
		
//		String bName = request.getParameter("bName");
		String community_id = request.getParameter("community_id");
		String community_title = request.getParameter("community_title");
		String community_content = request.getParameter("community_content");
		String community_group = request.getParameter("community_group");
		String community_step = request.getParameter("community_step");
		String community_indent = request.getParameter("community_indent");
		
		
//		DaoBoard dao = DaoBoard.getInstance();
		DaoBoard dao = new DaoBoard();
		dao.replyShape(community_group, community_step);
		dao.reply(community_id, ID, community_title, community_content.trim(), community_group, community_step, community_indent);

	}

}
