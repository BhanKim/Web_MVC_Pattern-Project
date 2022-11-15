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
<div align="center">

	  <div class="container">
	  		<div class="row">
		    <div class="col">
				<br> <br> <br> <br> <br>




				<table width="1200" 
					style="margin-left: auto; margin-right: auto; border:none;" border="0"
					class="table table-sm table-hover">


					<tr style="border:none;">
						
						<td width="500" height="50" style="text-align: center;" rowspan='2'><font size="4"><br>금일 매출</font>
						<font size="4"><input type="text" readonly="readonly" size="10" value="${order_date_sum }" style="border: none"></font></td>
						<td width="500" height="50" style="text-align: center;"><font size="4"><br>고객들이 가장 많이 선택한 상품</font></td>
					
					</tr>
					<tr style="border:none;">
						
						<td style="text-align: center;"><font size="4"><input type="text" readonly="readonly" size="3" value=" ${order_date_ranking_max }" style="border: none"></font> 
						<font size="4"><input type="text" readonly="readonly" size="40" value=" ${order_date_ranking_max_name }" style="border: none"></font></td>

					</tr>

					<tr style="border:none;">
						<td>
						<table style="margin-left: auto; margin-right: auto; border:none;" border="1"
					class="table table-sm table-hover">
						<thead style="color: #fff" bgcolor="#F2BCBB">
						<tr>
						<td width="600" height="100" style="text-align: center;" onClick="location.href='ManageProductInsert.do'"><br>PRODUCT INSERT</td>
						<td width="600" height="100" style="text-align: center;" onClick="location.href='manage_chart.jsp'"><br>CHART</td>
						</tr>
						<tr>
						<td width="600" height="100" style="text-align: center;" onClick="location.href='cs_notice.jsp'"><br>NOTICE</td>
						<td width="600" height="100" style="text-align: center;" onClick="location.href='ManageOrdersList.do'"><br>ORDERS LIST</td>
						</tr>
						</thead>
						</table>
						</td>
						<td style="text-align: center;"><img
							src="assets/img/product/${order_date_ranking_max_img }"
							width="180px" height="200px"></td>
					</tr>

				</table>
</div></div></div></div>


			</div>

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