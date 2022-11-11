//package com.rb.homecontroller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.rb.command.Command;
//import com.rb.command.CommandAdminLogin;
//import com.rb.command.CommandBeanInfo;
//import com.rb.command.CommandBoardcommentlist;
//import com.rb.command.CommandBoardcontent;
//import com.rb.command.CommandBoarddelete;
//import com.rb.command.CommandBoardlikeboard;
//import com.rb.command.CommandBoardlist;
//import com.rb.command.CommandBoardnoticelist;
//import com.rb.command.CommandBoardreply;
//import com.rb.command.CommandBoardsearch;
//import com.rb.command.CommandBoardupdate;
//import com.rb.command.CommandBoardviewreply;
//import com.rb.command.CommandBoardwrite;
//import com.rb.command.CommandCartDelete;
//import com.rb.command.CommandCartInsert;
//import com.rb.command.CommandCartList;
//import com.rb.command.CommandCommentwrite;
//import com.rb.command.CommandOrder;
//import com.rb.command.CommandUserLogin;
//import com.rb.command.CommandUserLoginApi;
//
///**
// * Servlet implementation class FrontController
// */
//@WebServlet("*.do")
//public class FrontController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public FrontController() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		actionDo(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		actionDo(request, response);
//	}
//
//	private void actionDo(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//
//		String viewPage = null;
//		Command command = null;
//
//		String uri = request.getRequestURI();
//		String conPath = request.getContextPath();
//		String com = uri.substring(conPath.length());
//		
//		// Paging
//		HttpSession session = null;
//		session = request.getSession();
//		int curPage = 1;
//		if(session.getAttribute("cpage") != null) {
//			curPage = (int)session.getAttribute("cpage");
//		}
//
//		switch (com) {
//		// --------------------- 상원 Controller Start ---------------------
//		// 로그인 실행
//		case ("/login.do"):
//			command = new CommandUserLogin();
//			command.execute(request, response);
//			viewPage = "index.jsp";
//			break;
//			// 로그인 실행
//		case ("/loginApi.do"):
//			command = new CommandUserLoginApi();
//			command.execute(request, response);
//			viewPage = "index.jsp";
//			break;
//		// 관리자 로그인 실행
//		case ("/login_admin.do"):
//			command = new CommandAdminLogin();
//			command.execute(request, response);
//			request.getAttribute("page");
//			viewPage = "page";
//		break;
//		// 로그아웃 실행
//		case ("/logout.do"):
//			command = new CommandAdminLogin();
//			command.execute(request, response);
//			session.invalidate();
//			viewPage = "index.jsp";
//			break;
//		// --------------------- 상원 Controller End -----------------------
//			
//
//		// --------------------- 성진 Controller Start -----------------------
//
//		// 원두 정보 페이지
//		case ("/beaninfo.do"):
//			System.out.println("beaninfo");
//			request.setAttribute("nav_beaninfo", "#f2bcbb");
//			command = new CommandBeanInfo();
//			command.execute(request, response);
//			viewPage = "beaninfo.jsp";
//			break;
//
//		// --------------------- 성진 Controller End -----------------------
//    
//		// --------------------- 윤현 Controller Start ---------------------
//
//		// --------------------- 윤현 Controller End -----------------------
//			
//		// --------------------- 수빈 Controller Start ---------------------
//			
//		// --------------------- 수빈 Controller End -----------------------
//		// --------------------- 혁&티뱃 Controller Start ---------------------
//	    
//		// 자유게시판 게시글 list 불러오기
//		case("/list.do"):
//	      	 command = new CommandBoardlist();
//	      	 command.execute(request, response);
//	      	  
//	      	 command = new CommandBoardnoticelist();
//	      	 command.execute(request, response);
//	      	 viewPage = "cboardlist.jsp";
//	      	 break;
//	      	 
//	    // 글쓰기 페이지로 이동  	 
//		case("/boardwrite_view.do"):
//			 viewPage = "cboardwrite_view.jsp";
//			 break;
//		
//		// 글쓰기	 
//		case("/boardwrite.do"):
//			command = new CommandBoardwrite();
//			command.execute(request, response);
//			viewPage = "list.do?page=" + curPage;
//			break;
//			
//			// 검색기능
//		case ("/bSearch.do"):
//			command  = new CommandBoardsearch();
//			command.execute(request, response);
//			viewPage = "cboardsearch.jsp";
//			break;	
//			
//		// Detail Page
//		case ("/content_view.do"):
//			command = new CommandBoardcontent();
//			command.execute(request, response);
//
//			command = new CommandBoardcommentlist();
//			command.execute(request, response);
//			viewPage = "cboardcontent_view.jsp";
//			break;
//
//		// 수정하기 page
//		case ("/modify_view.do"):
//			command = new CommandBoardcontent();
//			command.execute(request, response);
//			viewPage = "cboardupdate.jsp";
//			break;
//			
//		// 수정하기
//		case ("/modify.do"):
//			command = new CommandBoardupdate();
//			command.execute(request, response);
//
//			command = new CommandBoardcontent();
//			command.execute(request, response);
//			viewPage = "cboardcontent_view.jsp";
//			break;
//
//		// 삭제 page
//		case ("/communitydelete.do"):
//			command = new CommandBoarddelete();
//			command.execute(request, response);
//			viewPage = "list.do?page=" + curPage;
//			break;
//
//		// 좋아요기능
//		case ("/boardlike.do"):
//			command = new CommandBoardlikeboard();
//			command.execute(request, response);
//			viewPage = "content_view.do";
//			break;
//		
//		// 댓글달기
//		case ("/coWrite.do"):
//			command = new CommandCommentwrite();
//			command.execute(request, response);
//			viewPage = "content_view.do";
//			break;
//
//		// view reply[답글페이지보기] Page
//		case ("/reply_view.do"):
//			command = new CommandBoardviewreply();
//			command.execute(request, response);
//			viewPage = "cboardreply_view.jsp";
//			break;
//
//		// 답글달기
//		case ("/reply.do"):
//			command = new CommandBoardreply();
//			command.execute(request, response);
//			viewPage = "list.do?page=" + curPage;
//			break;
//			
//		// --------------------- 혁&티뱃 Controller End -----------------------
//			
//			
//			
//		} // switch
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
//		dispatcher.forward(request, response);
//	}
//
//} // End
