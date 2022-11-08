package com.rb.homecontroller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.command.Command;
import com.rb.command.CommandAdminLogin;
import com.rb.command.CommandBeanInfo;
import com.rb.command.CommandUserLoginCheck;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String viewPage = null;
		Command command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		HttpSession session = request.getSession(); // *******session
		System.out.println(com);

		switch (com) {
		// --------------------- 상원 Controller Start ---------------------
		// 로그인 실행
		case ("/login.do"):
			command = new CommandUserLoginCheck();
			command.execute(request, response);
			break;
		// 관리자 로그인 실행
		case ("/login_admin.do"):
			command = new CommandAdminLogin();
			command.execute(request, response);
			break;
		// 유저 로그인 성공 *** id 세션값부여 ***
		case ("/login_success.do"):
			session.setAttribute("id", request.getAttribute("user_id"));
			viewPage = "index.jsp";
			break;
		// 관리자 로그인 성공 *** id 세션값부여 ***
		case ("/login_success_admin.do"):
			session.setAttribute("id", request.getAttribute("admin_id"));
			viewPage = "index.jsp";
			break;
		// 로그아웃 실행
		case ("/logout.do"):
			System.out.println("logout");
			session.invalidate();
			viewPage = "index.jsp";
			break;
		// --------------------- 상원 Controller End -----------------------

		// --------------------- 성진 Controller Start -----------------------

		// 원두 정보 페이지
		case ("/beaninfo.do"):
			System.out.println("beaninfo");
			request.setAttribute("nav_beaninfo", "#f2bcbb");
			command = new CommandBeanInfo();
			command.execute(request, response);
			viewPage = "beaninfo.jsp";
			break;

		// --------------------- 성진 Controller End -----------------------

		} // switch

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

} // End
