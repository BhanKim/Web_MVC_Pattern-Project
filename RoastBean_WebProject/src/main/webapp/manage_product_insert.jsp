<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import="java.sql.*"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<!-- test -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

<title>Manage_product_list</title>
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
<script type="text/javascript">
	function onlyNum(event) {

		event = event || window.event;

		var key = (event.which) ? event.which : event.keyCode;

		if ((key >= 48 && key <= 57) || (key >= 96 && key <= 105) || key == 8)

		{

			return true;

		} else {

			alert("숫자만 입력해주세요.");

			return false;

		}

	}
</script>
<body link="black" vlink="black" alink="navy">
	<!-- ======= Header ======= -->
	<%@include file="header_manage.jsp"%>
	<!-- End Header -->

	<main id="main">

		<!-- ======= Breadcrumbs Section ======= -->
		<section class="breadcrumbs">
			<div class="container">

				<div class="d-flex justify-content-between align-items-center">
					<h2>product insert</h2>
					<ol>
						<li><a href="manage_main.jsp">Home</a></li>
						<li>product insert</li>
					</ol>
				</div>

			</div>
		</section>
		<!-- End Breadcrumbs Section -->

		<!--  ---------------------------------- 정보 쓰기란 시작 ---------------------------------- -->

		<div style="text-align: center;">
			

								<h2>제품 등록하기</h2>
								&nbsp;&nbsp;&nbsp;
							</div>
							<form action="ManageProductListInsert.do" method="post"
								name="Member">
								<table style="margin-left: auto; margin-right: auto;">
									<tr>
										<td style="text-align: center;">제품명</td>
										<td><input type="text" name="product_name" size="34"></td>
									</tr>
									<!-- <tr>
										<td style="text-align: center;">원산지</td>
										<td><select name="product_nation"
											style="WIDTH: 208pt; HEIGHT: 23pt">
												<option value="미선택" selected="selected">미선택</option>
												<option value="케냐">케냐</option>
												<option value="에티오피아">에티오피아</option>
												<option value="멕시코">멕시코</option>
												<option value="콜롬비아">콜롬비아</option>
										</select></td>
									</tr> -->
									<tr>
										<td style="text-align: center;">제품 이미지</td>
										<td><input type="file" name="product_image"></td>
									</tr>
									<tr>
										<td style="text-align: center;">제품 설명</td>
										<td><textarea rows="5" cols="33" name="product_info"></textarea></td>
									</tr>
									<tr>
										<td style="text-align: center;">제품 수량</td>
										<td><input type="text" name="product_stock" size="34"
											onkeydown="return onlyNum(event)"></td>
									</tr>
									<tr>
										<td style="text-align: center;">제품 중량</td>
										<td><input type="text" name="product_weight" size="34"
											onkeydown="return onlyNum(event)"></td>
									</tr>
									<tr>
										<td style="text-align: center;">제품 가격</td>
										<td><input type="text" name="product_price" size="34"
											onkeydown="return onlyNum(event)"></td>
									</tr>
									<tr>
										<td></td>
										<td><input type="submit" value="다음으로" class="btn"
											style="color: #fff; transition: 0.4s; border-radius: 50px; background: #F2BCBB; border: 0; WIDTH: 210pt; HEIGHT: 25pt"></td>
									</tr>
									<tr></tr>
									<tr>
										<td></td>
										<td align=center><br>
										<a href="ManageProductList.do" style="text-decoration: none">상품리스트로 돌아가기</a><br> 
											<a href="manage_main.jsp" style="text-decoration: none;">관리자 홈으로 돌아가기</a></td>
									</tr>
								</table>
								<br>
								
							</form>
		
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