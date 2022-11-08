<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Roast Bean</title>
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
	<%@include file = "header_innerpage.jsp" %>
  	<!-- End Header -->
  	
  	<main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Coffee Shop</h2>
          <ol>
            <li><a href="index.jsp">Home</a></li>
            <li>Coffee Shop</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->
    
	<section id="why-us" class="why-us">
		<div class="container">
			<div class="row">
				<div class="xans-element- xans-product xans-product-headcategory title" align="center">
					<h2>
						<span class="tit_n1" style="font-weight: bold;">원두전체</span>
					</h2>
					<p class="banner"></p>
				</div>
				<c:forEach items="${list}" var="dto">
				<div class="col-lg-4">
				 <div class="card mb-4 product-wap rounded-0">
					<div class="box" align="center"><a href="productDetail.do?product_id=${dto.product_id}">
						<img class="card-img rounded-0 img-fluid" src="assets/img/product/${dto.product_name}.png"></a>
						<h5>${dto.product_name}</h5>
						<p>${dto.product_info}</p>
						<h6><fmt:formatNumber value="${dto.product_price}" groupingUsed="true" /> 원</h6>
					</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</section>
	
	</main>
	
	<%@include file="footer.jsp"%>
	
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