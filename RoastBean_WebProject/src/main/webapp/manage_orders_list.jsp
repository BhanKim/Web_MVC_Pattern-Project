
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<%@include file="header_manage.jsp"%>
	<!-- End Header -->

	<main id="main">

		<!-- ======= Breadcrumbs Section ======= -->
		<section class="breadcrumbs">
			<div class="container">

				<div class="d-flex justify-content-between align-items-center">
					<h2>Orders List</h2>
					<ol>
						<li><a href="ManageMain.do">Home</a></li>
						<li>Orders List</li>
					</ol>
				</div>

			</div>
		</section>
		<!-- End Breadcrumbs Section -->
		<!--  ---------------------------------- 정보 쓰기란 시작 ---------------------------------- -->
<div align="center">
	<section class="inner-page">
	  <div class="container">
	  		<div class="row">
		    <div class="col">
		
		<h2>고객 주문 리스트</h2>
		&nbsp;&nbsp;&nbsp;
		
		<form action="ManageOrdersListSearch.do">
		   <br>
		   검색
		   <select name="query">
		      <option value="user_id">회원 아이디</option>
		      <option value="order_name">받는분</option>
		      <option value="order_telno">연락처</option>
		   </select>&nbsp;&nbsp;&nbsp;
		   <input type="text" name="content">
		   <input type="submit" value="검색" class="btn" style="background: #F2BCBB; border: 0; padding:3px 12px; color: #fff; transition: 0.4s; border-radius: 50px;">
		</form>
		<br>
		<br>
		
		<table style="margin-left: auto; margin-right: auto; border:none;" border="1" class="table table-sm table-hover">
		<thead style="color: #fff" bgcolor="#F2BCBB">
		<tr style="border:none;">
		   <th style="text-align: center;">주문 번호</th>
		   <th style="text-align: center;">회원 아이디</th>
		   <th style="text-align: center;">제품 번호</th>
		   <th style="text-align: center;">받는분</th>
		   
		   <th style="text-align: center;">지번</th>
		   <th style="text-align: center;">주소1</th>
		   <th style="text-align: center;">주소2</th>
		   <th style="text-align: center;">주소3</th>
		   
		   <th style="text-align: center;">이메일</th>
		   <th style="text-align: center;">연락처</th>
		   <th style="text-align: center;">수량</th>
		   <th style="text-align: center;">가격</th>
		   <th style="text-align: center;">주문일자</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${manage_order_list }" var="dto">
		   <tr style="border:none;"> 
		      <td style="text-align: center;">${dto.order_seq }</td>
		      <td style="text-align: center;">${dto.user_id }</td>
		      <td style="text-align: center;">${dto.product_id }</td>
		      <td style="text-align: center;">${dto.order_name }</td>
		      
		      <td style="text-align: center;">${dto.order_addresszipcode}</td>
		      
		      <td style="text-align: center;">${dto.order_address1}</td>
		      <td style="text-align: center;">${dto.order_address2}</td>
		      <td style="text-align: center;">${dto.order_address3}</td>
		      
		      <td style="text-align: center;">${dto.order_email }</td>
		      <td style="text-align: center;">${dto.order_telno }</td>
		      <td style="text-align: center;">${dto.order_qty }</td>
		      <td style="text-align: center;">${dto.order_price }</td>
		      <td style="text-align: center;">${dto.order_date }</td>
		      
		   </tr>
		</c:forEach>
		<tr></tr>
						
				<%-- 		<tr>
						<td align="center" colspan="10">
						<c:choose>
							<c:when test="${(page.curPage - 1) < 1 }">
								[ 처음 ]
							</c:when>
							<c:otherwise>
								<a href="myboardlist.do?page=1">[ 처음 ]</a>
							</c:otherwise>
							</c:choose>
							<!-- 이전 -->
							<c:choose>
							<c:when test="${(page.curPage - 1) < 1 }">
								[ 이전 ]
							</c:when>
							<c:otherwise>
								<a href="myboardlist.do?page=${page.curPage - 1 }">[ 이전 ]</a>
							</c:otherwise>
							</c:choose>
							
							<!-- 개별 페이지 -->
							<c:forEach var="fEach" begin="${page.startPage }" end="${page.endPage }" step="1">
								<c:choose>
								<c:when test="${page.curPage == fEach}">
									[ ${fEach } ] &nbsp;
								</c:when>
								<c:otherwise>
									<a href="myboardlist.do?page=${fEach }">[ ${fEach } ]</a>&nbsp;
								</c:otherwise>
								</c:choose>
							</c:forEach>
							
							<!-- 다음 -->
							<c:choose>
							<c:when test="${(page.curPage + 1) > page.totalPage }">
								[ 다음 ]
							</c:when>
							<c:otherwise>
								<a href="myboardlist.do?page=${page.curPage + 1 }">[ 다음 ]</a>
							</c:otherwise>
							</c:choose>
							<!-- 끝 -->
							<c:choose>
							<c:when test="${page.curPage == page.totalPage }">
								[ 마지막 ]
							</c:when>
							<c:otherwise>
								<a href="myboardlist.do?page=${page.totalPage }">[ 마지막 ]</a>
							</c:otherwise>
							</c:choose>
							</td>
						</tr> --%>
					</tbody>	
		</table></div></div></div></section>
		<br>
		<br>
		<br>
		</div>
		<!--  ---------------------------------- 정보 쓰기란 종료 ----------------------------------  -->


	</main>
	<!-- End #main -->

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