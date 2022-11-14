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
import com.rb.command.CommandManageMainUserOrder;
import com.rb.command.CommandManageOrdersList;
import com.rb.command.CommandManageOrdersSearch;
import com.rb.command.CommandManageProductDelete;
import com.rb.command.CommandManageProductInsert;
import com.rb.command.CommandManageProductInsert1;
import com.rb.command.CommandManageProductList;
import com.rb.command.CommandManageProductSearch;
import com.rb.command.CommandManageProductSeen;
import com.rb.command.CommandManageProductUpdate;
import com.rb.command.CommandManageUserList;

import com.rb.command.CommandUserLogin;
import com.rb.command.CommandUserLoginApi;

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

		// --------------------- 윤현 Controller Start ---------------------

		// --------------------- 윤현 Controller End -----------------------

		// --------------------- 수빈 Controller Start ---------------------
		case ("/UserListSelect.do"): // 홈에서 관리자가 고객리스트 보기 버튼을 클릭시 do가 실행
			command = new CommandManageUserList();
			command.execute(request, response);
			viewPage = "manage_user_list.jsp";
			break;

		case ("/ManageProductList.do"): // 상품 리스트 select
			command = new CommandManageProductList();
			command.execute(request, response);
			viewPage = "manage_product_list.jsp";
			break;

		case ("/ManageProductInsert.do"):
			viewPage = "manage_product_insert.jsp";
			break;

		case ("/ManageProductListInsert.do"): // 관리자 상품 등록 글 작성
			command = new CommandManageProductInsert();
			command.execute(request, response);
			viewPage = "manage_product_insert1.jsp";
			break;
		case ("/ManageProductListInsert1.do"): // 관리자 상품 등록 글 작성
			command = new CommandManageProductInsert1();
			command.execute(request, response);
			viewPage = "ManageProductList.do";
			break;

		case ("/ManageProductDelete.do"): // 관리자 상품 삭제
			command = new CommandManageProductDelete();
			command.execute(request, response);// 넣음
			viewPage = "ManageProductList.do";
			break;

		case ("/ManageProductUpdateSelete.do"): // 수정하기
			command = new CommandManageProductSeen();
			command.execute(request, response);// 넣음
			viewPage = "manage_product_update.jsp";
			break;
		case ("/ManageProductUpdate.do"):// 관리자 상품 수정
			command = new CommandManageProductUpdate();
			command.execute(request, response);// 넣음
			viewPage = "ManageProductList.do";
			break;
		case ("/ManageProductSearch.do"):// 입력으로 검색
			command = new CommandManageProductSearch();
			command.execute(request, response);
			viewPage = "manage_product_list.jsp";
			break;
//		case ("/ManageUserOrderSum.do"): // 관리자 메인에서 일일매출
//			System.out.println("ManageUserOrderSum.controller");
//			command = new CommandManageUserOrderSum();
//			command.execute(request, response);
//			viewPage = "manage_main.jsp";
//			break;
//		case ("/ManageUserOrderRanking.do"): // 관리자 메인에서 상품 순위
//			System.out.println("ManageUserOrderRanking.controller");
//			command = new CommandManageUserOrderRanking();
//			command.execute(request, response);
//			viewPage = "manage_main.jsp";
//			break;
		case ("/ManageMain.do"): // main페이지에 보여주기
			System.out.println("ManageMain.controller");
			command = new CommandManageMainUserOrder();
			command.execute(request, response);
			viewPage = "manage_main.jsp";
			break;
		case ("/ManageOrdersList.do"): // product orders list
			System.out.println("ManageOrdersList.do");
			command = new CommandManageOrdersList();
			command.execute(request, response);
			viewPage = "manage_orders_list.jsp";
			break;
		case ("/ManageOrdersListSearch.do"):// orders list입력으로 검색
			command = new CommandManageOrdersSearch();
			command.execute(request, response);
			viewPage = "manage_orders_list.jsp";
			break;

		// --------------------- 수빈 Controller End -----------------------

		} // switch

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

} // End
