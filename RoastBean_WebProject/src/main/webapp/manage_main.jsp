<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <!-- test -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

  <title>Manage_orders_list</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,600,600i,700,700i|Satisfy|Comic+Neue:300,300i,400,400i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Delicious - v4.9.1
  * Template URL: https://bootstrapmade.com/delicious-free-restaurant-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->


</head>

<body>

	<!-- ======= Header ======= -->
	<c:if test="${ADMIN != 'admin'}">
		<%@include file = "header_innerpage.jsp" %>
	</c:if>	
	
	<!-- 22.11.19 Hosik - Can view manage_main.jsp just got Admin session -->
	<c:if test="${ADMIN == 'admin'}">
	<%@include file="header_manage2.jsp"%>
	
	<!-- End Header -->

	<main id="main">

		<!-- ======= Breadcrumbs Section ======= -->
		 <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Manage Mode</h2>
          <ol>
            <li><a href="manage_main.jsp">Home</a></li>
            <li>Inner Page</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->

		<!--  ---------------------------------- 정보 쓰기란 시작 ---------------------------------- -->
		<section class="inner-page">
			<div class="container">
			<div align="center">
			
				  <div class="container">
				  		<div class="row">
					    <div class="col">
			
				
							<table style="margin-left: auto; margin-right: auto; border:none;" border="1"
									class="table table-sm table-hover">
									<thead >
									<tr>
										<td width="400" height="100" style="text-align: center; vertical-align:middle; ">
											금일 많이 팔린 상품 : ${order_todate_best_name }<br>
											금일 총 판매금액  : <fmt:formatNumber value="${order_todate_price_sum }" pattern="#,###"/>원<br>
											팔린 갯수 : ${order_todate_quantity_sum }<br>
										</td>	
										<td width="400" height="100" style="text-align: center; vertical-align:middle; ">
											지난 1주일간 총  판매금액 : <fmt:formatNumber value="${order_week_sum }" pattern="#,###"/>원
										
											
										</td>
									</tr>
									<tr>
										<td width="400" height="100" style="text-align: center; vertical-align:middle; ">
											금일 신규 회원 수 : ${count_new_users }
											<br>금일 신규 Qna : ${qna_date_sum }
											<br>답장을 기다리고 있는 Qna : ${qna_total_sum - finish_count}
											<br>금일 신규 게시글 : ${today_sum_community }
										</td>
										<td width="400" height="100" style="text-align: center; vertical-align:middle; "> 
											 지난 1주일간 매출량 대비 상승률 , 가장 많은 매출상품  /<!--  /  1:1 QNA신규 확인   -->
											 <!--  신규 회원ㄱ입 수 --> <!--   / 신규 문의 수 -->  <!--  가장 많이 팔린 상품 --> <!-- 주간매출/ -->
										</td>
									</tr>
									<tr>
										<td>
											1주일간 가장 높은 매출 상픔 
											<br>${order_week_bestprice_name }
											<br>${order_week_price_quantity_sum }
											<br>${order_week_price_price_sum }
										</td>
										<td>
											1주일간 가장 많이 팔린 상픔 
											<br>${order_week_bestqty_name }
											<br>${order_week_qty_quantity_sum }
											<br>${order_week_qty_price_sum }
										</td>
									</tr>
									<tr>
										<td colspan="2">
											chart 예정<br>
										</td>
									</tr>
								</thead>
							</table>
								
							<table style="margin-left: auto; margin-right: auto; border:none;" border="1"
									class="table table-sm table-hover">
									<thead >
									<tr>
										<td width="400" height="100" style="text-align: center; vertical-align:middle; color: #fff; background-color:#5f5f5f;" onClick="location.href='ManageProductInsert.do'">PRODUCT INSERT</td>	
										<td width="400" height="100" style="text-align: center; vertical-align:middle; color: #fff; background-color:#F2BCBB;" onClick="location.href='manage_chart.jsp'">CHART</td>
									</tr>
									<tr>	
										<td width="400" height="100" style="text-align: center; vertical-align:middle; color: #fff; background-color:#F2BCBB;" onClick="location.href='cs_notice.jsp'">NOTICE</td>
										<td width="400" height="100" style="text-align: center; vertical-align:middle; color: #fff; background-color:#5f5f5f;" onClick="location.href='ManageOrdersList.do'">ORDERS LIST</td>
									</tr>
								</thead>
							</table>
				
					</div></div></div></div>
			</div>
		</section>

		<!--  ---------------------------------- 정보 쓰기란 종료 ----------------------------------  -->
	</main>
</c:if>		

	<!-- 22.11.19 Hosik - Can view manage_main.jsp just got Admin session End  -->
	<!-- End #main -->
	<c:if test="${ADMIN != 'admin'}">
		<%@include file = "header_innerpage.jsp" %>
		<main id="main">

		<!-- ======= Breadcrumbs Section ======= -->
		 <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Error</h2>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->

		<!--  ---------------------------------- 정보 쓰기란 시작 ---------------------------------- -->
		<section class="inner-page">
			<div class="container">

					<h2> 잘못된 접근 입니다.</h2>
					<a href="index.jsp">메인 화면으로 돌아가기</a>

			</div> 
		</section>
	</c:if>	
	
	

	<!-- ======= Footer ======= -->
	<%@include file="footer.jsp"%>
	<!-- End Footer -->

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>

</body>

</html>