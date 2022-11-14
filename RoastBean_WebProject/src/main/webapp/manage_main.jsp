<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>manege_main</title>
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

</head>

<body>

	<!-- ======= Header ======= -->
	<%@include file="header_manage.jsp"%>
	<!-- End Header -->

	<main id="main">
	
		<!-- ======= Breadcrumbs Section ======= -->
		<!-- <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Inner Page</h2>
          <ol>
            <li><a href="manage_main.jsp">Home</a></li>
            <li>Inner Page</li>
          </ol>
        </div>

      </div>
    </section> End Breadcrumbs Section -->

		<!--  ---------------------------------- 정보 쓰기란 시작 ---------------------------------- -->
		<section class="inner-page">
			<div class="container">

				<br> <br> <br> <br> <br>


				<table width="1200" height="500"
					style="margin-left: auto; margin-right: auto;" border="1">
					<tr>
						<td>
							<form action="ManageUserOrderSum.do" method="post">
								<table style="margin-left: auto; margin-right: auto;">
									<tr>
										<td width="100" height="50"><font size="5">금일 매출</font></td>
										<td><font size="5"><input type="text"
												readonly="readonly" size="10" value="${order_date_sum }"
												style="border: none"></font></td>
									</tr>
									<tr>
										<!-- 차트 -->
									</tr>
								</table>

							</form>
						</td>

						<!-- --------------------------------------------------------------- -->

						<td>
							<!-- 상품 순위 -->
							<table style="margin-left: auto; margin-right: auto;">
								<tr>
									<td colspan="2"><font size="5">고객들이 가장 많이 선택한 상품</font></td>
								</tr>
								<tr>
									<td><font size="5"><input type="text"
											readonly="readonly" size="5"
											value=" ${order_date_ranking_max }" style="border: none"></font></td>
									<td><font size="5"><input type="text"
											readonly="readonly" size="30"
											value=" ${order_date_ranking_max_name }" style="border: none"></font></td>
								</tr>
								<tr>

									<td><img
										src="assets/img/product/${order_date_ranking_max_img }"
										width="180px" height="200px"></td>
								</tr>

							</table>

						</td>
					</tr>
				</table>

			</div>
						<div id="chartContainer" style="height: 370px; width: 100%;"></div>
			<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

		</section>

		<!--  
    <section class="inner-page">
      <div class="container">
        <p>
          Example inner page template
        </p>
      </div>
    </section> -->
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