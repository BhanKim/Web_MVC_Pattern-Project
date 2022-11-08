package com.rb.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.command.Command;
import com.rb.command.CommandCartDelete;
import com.rb.command.CommandCartInsert;
import com.rb.command.CommandCartList;
import com.rb.command.CommandOrder;
import com.rb.command.CommandProductDetail;
import com.rb.command.CommandProductList;


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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		Command command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		System.out.println(com);
		
		switch(com) {
		// 전체 내용 검색
		case ("/productList.do"):
			command = new CommandProductList();
			command.execute(request, response);
			viewPage = "productList.jsp";
			break;
		case ("/productDetail.do"):
			command = new CommandProductDetail();
			command.execute(request, response);
			viewPage = "productDetail.jsp";
			break;
		case ("/cartOrderInsert.do"):
			command = new CommandCartInsert();
			command.execute(request, response);
			viewPage = "cartOrder.do";
			break;
		case ("/cartOrder.do"):
			command = new CommandCartList();
			command.execute(request, response);
			viewPage = "cartOrder.jsp";
			break;
		case ("/insertCart.do"):
			command = new CommandCartInsert();
			command.execute(request, response);
			viewPage = "productDetail.do";
			break;
		case ("/deleteCart.do"):
			command = new CommandCartDelete();
			command.execute(request, response);
			viewPage = "cartOrder.do";
			break;
		case ("/order.do"):
			command = new CommandOrder();
			command.execute(request, response);
			viewPage = "index.jsp";
			break;
		} //switch
		System.out.println(viewPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
} // End
