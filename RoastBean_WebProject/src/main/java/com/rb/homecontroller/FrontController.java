package com.rb.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.command.product.Command;
import com.rb.command.product.CommandProductDelete;
import com.rb.command.product.CommandProductSearch;
import com.rb.command.product.CommandProductSeen;
import com.rb.command.product.CommandProductUpdate;
import com.rb.command.product.CommandUserList;
import com.rb.command.product.CommmandProductInsert;
import com.rb.command.product.CommmandProductList;

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
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");

		String viewPage = null;
		Command command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		System.out.println(com);

		switch (com) {
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
		case ("/product_delete.do"): // 관리자 상품 삭제
			System.out.println("product_delete.do");
			command = new CommandProductDelete();
			command.execute(request, response);// 넣음
			viewPage = "product_manage.do";// 보여주기
			break;
		case ("/product_update.do"): // 관리자 상품 수정
			System.out.println("product_update.do");
			System.out.println(request.getParameter("product_id") + "product_update.do");
			command = new CommandProductUpdate();
			command.execute(request, response);// 넣음
			viewPage = "product_manage.do";// 보여주기
			break;
		case ("/product_select_update.do"): // 수정하기
			System.out.println("product_select_update.do");
			command = new CommandProductSeen();
			command.execute(request, response);// 넣음
			viewPage = "product_update.jsp"; // 수정하는 jsp로 이동
			break;
		case ("/product_manage_search.do"): //입력으로 검색
			System.out.println("product_manage_search.do");
			command = new CommandProductSearch();
			command.execute(request, response);
			viewPage = "product_manage.jsp";
			break;
		} // switch

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

} // End
