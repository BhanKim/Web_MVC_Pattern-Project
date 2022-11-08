<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="description">
<meta content="" name="keywords">
<title>Roast Bean : Admin Login</title>
<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,600,600i,700,700i|Satisfy|Comic+Neue:300,300i,400,400i,700,700i" rel="stylesheet">
<!-- Vendor CSS Files -->
<link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet"> <link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
<link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style_rb.css" rel="stylesheet">
</head>
<body>
	<!-- ======= Header ======= -->
	<%-- <%@include file="header_innerpage.jsp"%> --%>
	<!-- End Header -->
	<main id="main">
		<div class="container text-center">
			<div style="height: 100px;"></div>
			<div align="center">
				<a href="index.jsp"><img alt="" src="assets/img/logo.png" width="320" height="68"></a>
			</div>
			<div style="height: 40px;"></div>
			<div class="row align-items-center">
				<div class="col align-items-start"></div>
				<div class="col align-items-center">
					<div class="col"
						style="border-style: solid; border-radius: 12px; border-width: thin; border-color: #CFD4D9; padding: 40px;">
						<form action="login_admin.do" method="post">
							<div style="width: 380px;">
								<div class="mb-3">
									<input type="text" class="form-control" id="admin_id"
										name="admin_id" placeholder="Admin ID" maxlength="41"
										aria-describedby="idHelp" style="height: 48px;">
								</div>
								<div class="mb-3">
									<input type="password" class="form-control" id="admin_pw"
										name="admin_pw" placeholder="Admin Password" maxlength="16"
										aria-describedby="passwordHelpBlock" style="height: 48px;">
								</div>
								<div class="mb-3">
									<button type="submit" class="btn "
										style="width: 380px; color: #fff; background-color: #F2BCBB; height: 48px; font-weight: normal; font-size: large;">Login</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="col align-items-end"></div>
			</div>
			<div class="row align-items-end"></div>
		</div>
	</main>
	<!-- ======= Footer ======= -->
	<%-- <%@include file="footer.jsp"%> --%>
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