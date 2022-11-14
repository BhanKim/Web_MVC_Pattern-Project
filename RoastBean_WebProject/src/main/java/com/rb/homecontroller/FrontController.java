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
//import com.rb.command.CommandBeanInfoList;
//import com.rb.command.CommandBoardcommentlist;
//import com.rb.command.CommandBoardcontent;
//import com.rb.command.CommandBoarddelete;
//import com.rb.command.CommandBoardlikeboard;
//import com.rb.command.CommandBoardlist;
//import com.rb.command.CommandBoardmylist;
//import com.rb.command.CommandBoardnoticelist;
//import com.rb.command.CommandBoardreply;
//import com.rb.command.CommandBoardsearch;
//import com.rb.command.CommandBoardupdate;
//import com.rb.command.CommandBoardviewreply;
//import com.rb.command.CommandBoardwrite;
//import com.rb.command.CommandCartDelete;
//import com.rb.command.CommandCartInsert;
//import com.rb.command.CommandCartList;
//import com.rb.command.CommandCommentdelete;
//import com.rb.command.CommandCommentupdate;
//import com.rb.command.CommandCommentwrite;
//import com.rb.command.CommandCsNoticeInsertAdmin;
//import com.rb.command.CommandCsNoticeListUser;
//import com.rb.command.CommandCsNoticeUpdateAdmin;
//import com.rb.command.CommandCsQnaAdminAction;
//import com.rb.command.CommandCsQnaList;
//import com.rb.command.CommandCsQnaQuestion;
//import com.rb.command.CommandManageProductDelete;
//import com.rb.command.CommandManageProductInsert;
//import com.rb.command.CommandManageProductInsert1;
//import com.rb.command.CommandManageProductList;
//import com.rb.command.CommandManageProductSearch;
//import com.rb.command.CommandManageProductSeen;
//import com.rb.command.CommandManageProductUpdate;
//import com.rb.command.CommandManageUserList;
//import com.rb.command.CommandMyQnaList;
//import com.rb.command.CommandMyorderlist;
//import com.rb.command.CommandOrder;
//import com.rb.command.CommandOrderInsert;
//import com.rb.command.CommandProductDetail;
//import com.rb.command.CommandProductList;
//import com.rb.command.CommandReview;
//import com.rb.command.CommandReviewDelete;
//import com.rb.command.CommandReviewList;
//import com.rb.command.CommandReviewMyList;
//import com.rb.command.CommandReviewMyListEdit;
//import com.rb.command.CommandReviewUpdate;
//import com.rb.command.CommandUserCheck;
//import com.rb.command.CommandUserCheckId;
//import com.rb.command.CommandUserCheckNick;
//import com.rb.command.CommandUserInfoPwcheck;
//import com.rb.command.CommandUserLogin;
//import com.rb.command.CommandUserLoginApi;
//import com.rb.command.CommandUserSignup;
//import com.rb.command.CommandUserSignupApi;
//import com.rb.command.CommandUserinfo;
//import com.rb.command.CommandUserinfoUpdate;
//
///**
// * Servlet implementation class FrontController
// */
//@WebServlet("*.do")
//public class FrontController extends HttpServlet {
//   private static final long serialVersionUID = 1L;
//
//   /**
//    * @see HttpServlet#HttpServlet()
//    */
//   public FrontController() {
//      super();
//      // TODO Auto-generated constructor stub
//   }
//
//   /**
//    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//    *      response)
//    */
//   protected void doGet(HttpServletRequest request, HttpServletResponse response)
//         throws ServletException, IOException {
//      // TODO Auto-generated method stub
//      actionDo(request, response);
//   }
//
//   /**
//    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//    *      response)
//    */
//   protected void doPost(HttpServletRequest request, HttpServletResponse response)
//         throws ServletException, IOException {
//      // TODO Auto-generated method stub
//      actionDo(request, response);
//   }
//
//   private void actionDo(HttpServletRequest request, HttpServletResponse response)
//         throws ServletException, IOException {
//      request.setCharacterEncoding("utf-8");
//
//      String viewPage = null;
//      Command command = null;
//
//      String uri = request.getRequestURI();
//      String conPath = request.getContextPath();
//      String com = uri.substring(conPath.length());
//
//		// Paging
//		HttpSession session = request.getSession();
//
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
//			int checkLogin = (int) request.getAttribute("checkLogin");
//			if(checkLogin == 1) {
//				viewPage = "index.jsp";
//			}else {
//				viewPage = "login.jsp";
//			}
//			break;
//		// API 로그인 실행
//		case ("/login_api.do"):
//			command = new CommandUserLoginApi();
//			command.execute(request, response);
//			int checkLoginApi = (int) request.getAttribute("checkLoginApi");
//			if(checkLoginApi == 1) {
//				viewPage = "index.jsp";
//			}else {
//				viewPage = "signup_api.jsp";
//			}
//			break;
//		// 관리자 로그인 실행
//		case ("/login_admin.do"):
//			command = new CommandAdminLogin();
//			command.execute(request, response);
//			int checkLoginAdmin = (int) request.getAttribute("checkLoginAdmin");
//			if(checkLoginAdmin == 1) {
//				viewPage = "index.jsp";
//			}else {
//				viewPage = "login.jsp";
//			}
//			break;
//		// 아이디 중복 체크
//		case ("/check_id.do"):
//			command = new CommandUserCheckId();
//			command.execute(request, response);
//			viewPage = "signup.jsp";
//			break;
//		// 닉네임 중복 체크
//		case ("/check_nick.do"):
//			command = new CommandUserCheckNick();
//			command.execute(request, response);
//			viewPage = "signup.jsp";
//			break;
//		// 아이디 중복 체크
//		case ("/check_id_info.do"):
//			command = new CommandUserCheckId();
//			command.execute(request, response);
//			viewPage = "mypage_info_update.jsp";
//			break;
//		// 닉네임 중복 체크
//		case ("/check_nick_info.do"):
//			command = new CommandUserCheckNick();
//			command.execute(request, response);
//			viewPage = "mypage_info_update.jsp";
//			break;
//		// signup 실행
//		case ("/signup.do"):
//			command = new CommandUserSignup();
//			command.execute(request, response);
//			viewPage = "index.jsp";
//			break;
//		// API signup 실행
//		case ("/signup_api.do"):
//			command = new CommandUserSignupApi();
//			command.execute(request, response);
//			viewPage = "index.jsp";
//			break;
//		// 로그아웃 실행
//		case ("/logout.do"):
//			session.invalidate();
//			viewPage = "index.jsp";
//			break;
//		// 마이페이지/내 정보 보기
//		case ("/mypage_info.do"):
//			command = new CommandUserinfo();
//			command.execute(request, response);
//			viewPage = "mypage_info.jsp";
//			break;
//		// 마이페이지/내 정보 보기
//		case ("/mypage_info_pwcheck.do"):
//			command = new CommandUserInfoPwcheck();
//			command.execute(request, response);
//			String page = (String) request.getAttribute("page");
//			viewPage = page;
//			break;
//		// 마이페이지/수정화면에서 내 정보 보기
//		case ("/mypage_info_update_list.do"):
//			command = new CommandUserinfo();
//			command.execute(request, response);
//			viewPage = "mypage_info_update.jsp";
//			break;
//		// 마이페이지/내 정보 수정하기
//		case ("/mypage_info_update.do"):
//			command = new CommandUserinfoUpdate();
//			command.execute(request, response);
//			viewPage = "mypage_info.do";
//			break;
//		// 마이페이지: 내 구매 목록 보기 / 완료 22.11.12_SangwonKim
//		case ("/mypage_order_list.do"):
//			command = new CommandMyorderlist();
//			command.execute(request, response);
//			viewPage = "mypage_order_list.jsp";
//			break;
//		// 마이페이지:My QnA List 가져오기 / 완료 22.11.13_2:20_SangwonKim
//		case ("/mypage_qna_list.do"): // 클릭시 질문내용 바꿔주고, 다시 클릭시 내용숨기기 추가하기
//			command = new CommandMyQnaList();
//			command.execute(request, response);
//			viewPage = "mypage_qna_list.jsp";
//			break;
//		// QnA:유저:질문하기 Insert / 완료 22.11.13_18:00_SangwonKim
//		case ("/qna_question_by_user.do"):
//			command = new CommandCsQnaQuestion();
//			command.execute(request, response);
//			viewPage = "cs_qna.jsp";
//			break;
//		// QnA:관리자:전체리스트 불러오기 Select / 완료 22.11.13_21:50_SangwonKim
//		case ("/qna_list_by_admin.do"):
//			command = new CommandCsQnaList();
//			command.execute(request, response);
//			viewPage = "cs_qna_admin.jsp";
//			break;
//		// QnA:관리자:질문에 답변하기,수정하기 Insert&Update / 완료 22.11.13_11:00_SangwonKim
//		case ("/qna_answer_by_admin.do"):
//			command = new CommandCsQnaAdminAction();
//			command.execute(request, response);
//			viewPage = "qna_list_by_admin.do";
//			break;
//		// Notice 불러오기 Select / 완료 22.11.14_06:00_SangwonKim
//		case ("/notice_list.do"): //user,admin list
//			command = new CommandCsNoticeListUser();
//			command.execute(request, response);
//			viewPage = "cs_notice.jsp";
//			break;
//		// Notice Update / 완료 22.11.14_16:00_SangwonKim
//		case ("/notice_update_by_admin.do"): // Update, Delete
//			command = new CommandCsNoticeUpdateAdmin();
//			command.execute(request, response);
//			viewPage = "notice_list.do";
//			break;
//		// Notice Insert / 완료 22.11.14_21:00_SangwonKim
//		case ("/notice_insert_by_admin.do"): // Update, Delete
//			command = new CommandCsNoticeInsertAdmin();
//			command.execute(request, response);
//			viewPage = "notice_list.do";
//			break;
//		// --------------------- 상원 Controller End -----------------------
//
//		// --------------------- 성진 Controller Start -----------------------
//		// 원두 정보 페이지
//		case ("/beaninfo.do"):
//			request.setAttribute("nav_beaninfo", "#f2bcbb");
//			command = new CommandBeanInfoList();
//			command.execute(request, response);
//			viewPage = "beaninfo.jsp";
//			break;
//		// --------------------- 성진 Controller End -----------------------
//  
//		// --------------------- 윤현 Controller Start ---------------------
//		case ("/productList.do"):
//			command = new CommandProductList();
//			command.execute(request, response);
//			viewPage = "productList.jsp";
//			break;
//		case ("/productDetail.do"):
//			command = new CommandProductDetail();
//			command.execute(request, response);
//			viewPage = "productDetail.jsp";
//			break;
//		case ("/cartOrderInsert.do"):
//			command = new CommandCartInsert();
//			command.execute(request, response);
//			viewPage = "cartOrder.do";
//			break;
//		case ("/cartOrder.do"):
//			command = new CommandCartList();
//			command.execute(request, response);
//			viewPage = "cartOrder.jsp";
//			break;
//		case ("/insertCart.do"):
//			command = new CommandCartInsert();
//			command.execute(request, response);
//			viewPage = "productDetail.do";
//			break;
//		case ("/deleteCart.do"):
//			command = new CommandCartDelete();
//			command.execute(request, response);
//			viewPage = "cartOrder.do";
//			break;
//		case ("/order.do"):
//			command = new CommandOrderInsert();
//			command.execute(request, response);
//			viewPage = "orderUpdate.do";
//			break;
//		case ("/orderUpdate.do"):
//			command = new CommandOrder();
//			command.execute(request, response);
//			viewPage = "index.jsp";
//			break;
//		case ("/productReview.do"):
//			command = new CommandReviewList();
//			command.execute(request, response);
//			viewPage = "productReview.jsp";
//			break;
//		case ("/reviewInsert.do"):
//			command = new CommandReview();
//			command.execute(request, response);
//			viewPage = "mypage_order_list.do";
//			break;
//		case ("/deleteReview.do"):
//			command = new CommandReviewDelete();
//			command.execute(request, response);
//			viewPage = "productDetail.do?product_id="+request.getParameter("product_id");
//			break;
//		case ("/findPwUserCheck.do"):
//			command = new CommandUserCheck();
//			command.execute(request, response);
//			viewPage = "find_pw.jsp";
//			break;
//		case ("/myboardreviewlist.do"):
//			command = new CommandReviewMyList();
//			command.execute(request, response);
//			viewPage = "cboardmylist.jsp";
//			break;
//		case ("/reviewEdit.do"):
//			command = new CommandReviewList();
//			command.execute(request, response);
//			viewPage = "reviewUpdateEdit.do";
//			break;
//		case ("/reviewUpdateEdit.do"):
//			command = new CommandReviewMyListEdit();
//			command.execute(request, response);
//			viewPage = "productReviewUpdate.jsp";
//			break;
//		case ("/reviewDelete.do"):
//			command = new CommandReviewDelete();
//			command.execute(request, response);
//			viewPage = "myboardlist.do";
//			break;
//		case ("/reviewUpdate.do"):
//			command = new CommandReviewUpdate();
//			command.execute(request, response);
//			viewPage = "myboardlist.do";
//			break;
//		// --------------------- 윤현 Controller End -----------------------
//			
//		// --------------------- 수빈 Controller Start ---------------------
//		case ("/UserListSelect.do"): // 홈에서 관리자가 고객리스트 보기 버튼을 클릭시 do가 실행
//			command = new CommandManageUserList();
//			command.execute(request, response);
//			viewPage = "manage_user_list.jsp";
//			break;
//			case ("/ManageProductList.do"): // 상품 리스트 select
//			command = new CommandManageProductList();
//			command.execute(request, response);
//			viewPage = "manage_product_list.jsp";
//			break;
//			case ("/ManageProductInsert.do"):
//			viewPage = "manage_product_insert.jsp";
//			break;
//			case ("/ManageProductListInsert.do"): // 관리자 상품 등록 글 작성
//			command = new CommandManageProductInsert();
//			command.execute(request, response);
//			viewPage = "manage_product_insert1.jsp";
//			break;
//			case ("/ManageProductListInsert1.do"): // 관리자 상품 등록 글 작성
//			command = new CommandManageProductInsert1();
//			command.execute(request, response);
//			viewPage = "ManageProductList.do";
//			break;
//			case ("/ManageProductDelete.do"): // 관리자 상품 삭제
//			command = new CommandManageProductDelete();
//			command.execute(request, response);// 넣음
//			viewPage = "ManageProductList.do";
//			break;
//			case ("/ManageProductUpdateSelete.do"): // 수정하기
//			command = new CommandManageProductSeen();
//			command.execute(request, response);// 넣음
//			viewPage = "manage_product_update.jsp";
//			break;
//			case ("/ManageProductUpdate.do"):// 관리자 상품 수정
//			command = new CommandManageProductUpdate();
//			command.execute(request, response);// 넣음
//			viewPage = "ManageProductList.do";
//			break;
//			case ("/ManageProductSearch.do"):// 입력으로 검색
//			command = new CommandManageProductSearch();
//			command.execute(request, response);
//			viewPage = "manage_product_list.jsp";
//			break;
////		case ("/ManageUserOrderSum.do"): // 관리자 메인에서 일일매출
////			command = new CommandManageUserOrderSum();
////			command.execute(request, response);
////			viewPage = "manage_main.jsp";
////			break;
//		// --------------------- 수빈 Controller End -----------------------
//			
//		// --------------------- 혁&티뱃 Controller Start ---------------------
//		// 자유게시판 게시글 list 불러오기
//		case("/list.do"):
//			command = new CommandBoardlist();
//			command.execute(request, response);
//			command = new CommandBoardnoticelist();
//			command.execute(request, response);
//			viewPage = "cboardlist.jsp";
//			break;
//			// case("/nList.do"):
//			// command = new CommandBoardnoticelist();
//			// command.execute(request, response);
//			// viewPage = "cboardlist.jsp";
//			// break;
//		// 글쓰기 페이지로 이동
//		case("/boardwrite_view.do"):
//			viewPage = "cboardwrite_view.jsp";
//			break;
//		// 글쓰기
//		case("/boardwrite.do"):
//			command = new CommandBoardwrite();
//			command.execute(request, response);
//			viewPage = "list.do?page=" + curPage;
//			break;
//		// 검색기능
//		case ("/bSearch.do"):
//			command = new CommandBoardsearch();
//			command.execute(request, response);
//			viewPage = "cboardsearch.jsp";
//			break;
//		// Detail Page & comment list
//		case ("/content_view.do"):
//			command = new CommandBoardcontent();
//			command.execute(request, response);
//			command = new CommandBoardcommentlist();
//			command.execute(request, response);
//			viewPage = "cboardcontent_view.jsp";
//			break;
//		// 수정하기 page
//		case ("/modify_view.do"):
//			command = new CommandBoardcontent();
//			command.execute(request, response);
//			viewPage = "cboardupdate.jsp";
//			break;
//		// 수정하기
//		case ("/modify.do"):
//			command = new CommandBoardupdate();
//			command.execute(request, response);
//			command = new CommandBoardcontent();
//			command.execute(request, response);
//			viewPage = "cboardcontent_view.jsp";
//			break;
//		// 삭제 page
//		case ("/communitydelete.do"):
//			command = new CommandBoarddelete();
//			command.execute(request, response);
//			viewPage = "list.do?page=" + curPage;
//			break;
//		// 좋아요기능
//		case ("/boardlike.do"):
//			command = new CommandBoardlikeboard();
//			command.execute(request, response);
//			viewPage = "content_view.do";
//			break;
//		// view reply[답글페이지보기] Page
//		case ("/reply_view.do"):
//			command = new CommandBoardviewreply();
//			command.execute(request, response);
//			viewPage = "cboardreply_view.jsp";
//			break;
//		// 답글달기
//		case ("/reply.do"):
//			command = new CommandBoardreply();
//			command.execute(request, response);
//			viewPage = "list.do?page=" + curPage;
//			break;
//		//Community Notice 자유게시판 공지사항
//		case ("/cboardnotice.do"):
//			command=new CommandBoardnoticelist();
//			command.execute(request, response);
//			viewPage="cboardnotice.jsp";
//			break;
//		// ----------- Comment ------------
//		// 댓글달기
//		case ("/coWrite.do"):
//			command = new CommandCommentwrite();
//			command.execute(request, response);
//			viewPage = "content_view.do";
//			break;
//		// 댓글삭제
//		case ("/coDelete.do"):
//			command = new CommandCommentdelete();
//			command.execute(request, response);
//			viewPage = "content_view.do";
//			break;
//		// 댓글수정
//		case ("/coModify.do"):
//			command = new CommandCommentupdate();
//			command.execute(request, response);
//			viewPage = "content_view.do";
//			break;
//		// 내가 쓴 게시글 리스트
//			case ("/myboardlist.do"):
//			command = new CommandBoardmylist();
//			command.execute(request, response);
//			viewPage = "myboardreviewlist.do";
//			break;
//		// --------------------- 혁&티뱃 Controller End -----------------------
//
//      } // switch
//
//      RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
//      dispatcher.forward(request, response);
//   }
//
//} // End