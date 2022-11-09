package com.rb.homecontroller;

import java.io.IOException;

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
import com.rb.command.CommandProductDelete;
import com.rb.command.CommandProductUpdate;
import com.rb.command.CommandUserList;
import com.rb.command.CommandUserLogin;
import com.rb.command.CommandUserLoginApi;
import com.rb.command.CommmandProductInsert;
import com.rb.command.CommmandProductList;

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
			command = new CommandUserLogin();
			command.execute(request, response);
			request.getAttribute("page");
			viewPage = "page";
			break;
			// 로그인 실행
		case ("/loginApi.do"):
			command = new CommandUserLoginApi();
			command.execute(request, response);
			viewPage = "index.jsp";
			break;
		// 관리자 로그인 실행
		case ("/login_admin.do"):
			command = new CommandAdminLogin();
			command.execute(request, response);
			request.getAttribute("page");
			viewPage = "page";
		break;
		// 로그아웃 실행
		case ("/logout.do"):
			command = new CommandAdminLogin();
			command.execute(request, response);
			session.invalidate();
			viewPage = "index.jsp";
			break;
		// --------------------- 상원 Controller End -----------------------
		// --------------------- 수빈 Controller Start -----------------------
		// 전체 내용 검색
		case ("/UserListSelect.do"): // 홈에서 관리자가 고객리스트 보기 버튼을 클릭시 do가 실행
			System.out.println("user_list_select.do");
			command = new CommandUserList();
			command.execute(request, response);
			viewPage = "user_list.jsp";
			break;
		case ("/product_manage.do"): // 상품 리스트 select
			System.out.println("product_manage.do");
			command = new CommmandProductList();
			command.execute(request, response);
			viewPage = "product_manage.jsp";
			break;
		case ("/product_insert.do"):
			viewPage = "product_insert.jsp";
			break;
		case ("/product_manage_insert.do"): // 관리자 상품 등록 글 작성
			System.out.println("product_manage_insert.do");
			command = new CommmandProductInsert();
			command.execute(request, response);
			viewPage = "product_manage.jsp";
		case ("/product_delete.do"):
			System.out.println("product_delete.do");
			command = new CommandProductDelete();
			command.execute(request, response);// 넣음
			viewPage = "product_manage.do";// 보여주기
			break;
		case ("/product_update.do"):
			System.out.println("product_update.do");
			command = new CommandProductUpdate();
			command.execute(request, response);// 넣음
			viewPage = "product_manage.do";// 보여주기
			break;
		// --------------------- 수빈 Controller Start -----------------------
			

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
