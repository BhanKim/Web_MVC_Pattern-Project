
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>manege_order_list</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,600,600i,700,700i|Satisfy|Comic+Neue:300,300i,400,400i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
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
						<li><a href="manage_main.jsp">Home</a></li>
						<li>Orders List</li>
					</ol>
				</div>

			</div>
		</section>
		<!-- End Breadcrumbs Section -->
		<!--  ---------------------------------- 정보 쓰기란 시작 ---------------------------------- -->
<div align="center">
		<br>
		<br> &nbsp;&nbsp;&nbsp;
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
		   <input type="submit" value="검색">
		</form>
		<br>
		<br>
		
		<table style="margin-left: auto; margin-right: auto;" border="1" class="table table-hover table-bordered border-secondary">
		<tr>
		   <th>주문 번호</th>
		   <th>회원 아이디</th>
		   <th>제품 번호</th>
		   <th>받는분</th>
		   <th>주소</th>
		   
		   <th>이메일</th>
		   <th>연락처</th>
		   <th>수량</th>
		   <th>가격</th>
		   <th>주문일자</th>
		   
		   
		</tr>
		<c:forEach items="${manage_order_list }" var="dto">
		   <tr> 
		      <td >${dto.order_seq }</td>
		      <td>${dto.user_id }</td>
		      <td>${dto.product_id }</td>
		      
		      <td>${dto.order_name }</td>
		      <td>${dto.order_address}</td>
		      <td>${dto.order_email }</td>
		      <td>${dto.order_telno }</td>
		      <td>${dto.order_qty }</td>
		      <td>${dto.order_price }</td>
		      <td>${dto.order_date }</td>
		      
		   </tr>
		</c:forEach>
		</table>
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