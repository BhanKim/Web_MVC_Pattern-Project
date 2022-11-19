package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoManageProductList;
import com.rb.dao.DaoManageUserList;
import com.rb.dao.DaoNotice;
import com.rb.dao.DaoQna;
import com.rb.dto.hosik_test_dto;

public class CommandManageMainUserOrder implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		System.out.println("ManageMain.command , jsp: CommandManageMainUserOrder start ");
		DaoManageProductList dao = new DaoManageProductList();
		DaoManageUserList userdao = new DaoManageUserList();
		DaoNotice noticedao = new DaoNotice();
		DaoQna qnadao = new DaoQna();

		/* 1 Day */
		System.out.println(">>>>>>>>>>>>>>");
		System.out.println("1day start");
		System.out.println(">>>>>>>>>>>>>>");
		int count_new_users = userdao.count_new_users(); // 신규 가입자 수 
		hosik_test_dto dto1 = dao.todate_order_product_info(); // dto 연결 
		String order_todate_best_name = dto1.getProduct_name(); // 가장 많이 팔린 상품의 이름 
		int order_todate_quantity_sum = dto1.getOrder_qty(); // 가장 많이 팔린 상품의 판매수량 
		int order_todate_price_sum = dto1.getOrder_price(); // 하루 총 매출 
		
		// 7일간 많은 매출
		System.out.println(">>>>>>>>>>>>>>");
		System.out.println("7day price start");
		System.out.println(">>>>>>>>>>>>>>");
		hosik_test_dto dto7_price = dao.week_order_product_info_price(); // dto 연결 
		String order_week_bestprice_name = dto7_price.getProduct_name(); // 가장 많이 팔린 상품의 이름 
		int order_week_price_quantity_sum = dto7_price.getOrder_qty(); // 가장 많이 팔린 상품의 판매수량 
		int order_week_price_price_sum = dto7_price.getOrder_price(); // 하루 총 매출 
		
		// 7일간 많이 팔린 
		System.out.println(">>>>>>>>>>>>>>");
		System.out.println("7day quantity start");
		System.out.println(">>>>>>>>>>>>>>");
		hosik_test_dto dto7_qty = dao.week_order_product_info_qty(); // dto 연결 
		String order_week_bestqty_name = dto7_qty.getProduct_name(); // 가장 많이 팔린 상품의 이름 
		int order_week_qty_quantity_sum = dto7_qty.getOrder_qty(); // 가장 많이 팔린 상품의 판매수량 
		int order_week_qty_price_sum = dto7_qty.getOrder_price(); // 하루 총 매출 
		
		/* 1 Week */
		int order_week_sum = dao.order_week_sum();
		
		
		/* All Day */
		int order_date_ranking_max = dao.manageuserprderrankingselect_max(); // 22-11-19 호식 - 가장 많이 팔린 상품 만들고 싶었나봄 
		String order_date_ranking_max_img = dao.manageuserprderrankingselect_max_img();
		
		
		//qna
		int qna_date_sum = qnadao.qna_date_sum(); //신규 qna문의 수 
		int finish_count = qnadao.qna_anwer_sum();
		int qna_total_sum = qnadao.qna_total_sum();
		
		
		// community
		int today_sum_community = noticedao.sum_today_community();
		
		System.out.println(">>>>>>>>>>>>>>");
		System.out.println("request start");
		System.out.println(">>>>>>>>>>>>>>");
		
		// product 1day 
		request.setAttribute("order_todate_best_name", order_todate_best_name); //22-11-19 호식 curdate 많이팔린 상품이름
		request.setAttribute("order_todate_quantity_sum", order_todate_quantity_sum); //22-11-19 호식 curdate 팔린 총 가격
		request.setAttribute("order_todate_price_sum", order_todate_price_sum); //22-11-19 호식 curdate 팔린 총 가격
		
		//product 7day price
		request.setAttribute("order_week_bestprice_name", order_week_bestprice_name); //22-11-19 호식 7일간 높은 매출의 상품이름
		request.setAttribute("order_week_price_quantity_sum", order_week_price_quantity_sum); //22-11-19 호식 7주일간 높은 매출의 판매수량 
		request.setAttribute("order_week_price_price_sum", order_week_price_price_sum); //22-11-19 호식 7주일간 높은 매출의 판매액
		//product 7day quantity
		request.setAttribute("order_week_bestqty_name", order_week_bestqty_name); //22-11-19 호식 7일간 많이팔린 상품이름
		request.setAttribute("order_week_qty_quantity_sum", order_week_qty_quantity_sum); //22-11-19 호식 7일간 많이팔린 상품의 판매수량
		request.setAttribute("order_week_qty_price_sum", order_week_qty_price_sum); //22-11-19 호식 7일간 많이팔린 상품의  총 가격
		
		
		
		request.setAttribute("order_week_sum", order_week_sum); //22-11-19 호식 recently week 팔린 총 가격
		request.setAttribute("order_date_ranking_max", order_date_ranking_max);
		request.setAttribute("order_date_ranking_max_img", order_date_ranking_max_img);
		request.setAttribute("count_new_users", count_new_users);
		
		// qna , community 
		request.setAttribute("qna_date_sum", qna_date_sum);
		request.setAttribute("qna_total_sum", qna_total_sum);
		request.setAttribute("finish_count", finish_count);
		request.setAttribute("today_sum_community", today_sum_community);

	}

}
