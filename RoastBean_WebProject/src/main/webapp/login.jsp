<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Roast Bean : Login</title>
<meta content="" name="description">
<meta content="" name="keywords">
<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,600,600i,700,700i|Satisfy|Comic+Neue:300,300i,400,400i,700,700i" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
<!-- Vendor CSS Files -->
<link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
<link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">
<!-- 추가한 CSS File -->
<link href="assets/css/style_rb.css" rel="stylesheet">

</head>

<body>
	<%-- <%@include file="header_innerpage.jsp"%> --%>
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
						<form action="login.do" method="post">
							<div class="col" style="width: 380px;">
								<!-- API 로그인 Start -->
								<div class="col mb-3" id="google-button"></div><!-- ***** -->
								<!-- <div class="mb-3">
									<input type="text" class="form-control"
										value="Continue with Naver" style="height: 48px;">
								</div>
								<div class="mb-3">
									<input type="text" class="form-control"
										value="Continue with Kakao" style="height: 48px;">
								</div> -->
								<!-- API 로그인 End -->
								<div class="mb-3">
									<font style="color: #6E757C;">or</font>
								</div>
								<div class="mb-3">
									<input type="text" class="form-control" id="user_id"
										name="user_id" placeholder="ID" maxlength="41"
										aria-describedby="idHelp" style="height: 48px;">
								</div>
								<div class="mb-3">
									<input type="password" class="form-control" id="user_pw"
										name="user_pw" placeholder="Password" maxlength="16"
										aria-describedby="passwordHelpBlock" style="height: 48px;">
								</div>
								<div class="mb-3">
									<button type="submit" class="btn "
										style="width: 380px; color: #fff; background-color: #F2BCBB; height: 48px; font-weight: normal; font-size: large;">Login</button>
								</div>
							</div>
						</form>
						<div class="mb-3">
							<a a href="find_pw.jsp" tabindex="-1" style="color: #5464F9;">Forgot
								password?</a>
						</div>
						<div class="mb-3">
							<div>
								No account? <a a href="signup.jsp" tabindex="-1"
									style="color: #5464F9;">Create one</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col align-items-end"></div>
			</div>
			<div class="row align-items-end"></div>
			<div style="height: 100px;"></div>
		</div>
	</main>
	<!-- ======= Footer ======= -->
	<%-- <%@include file="footer.jsp"%> --%>
	<!-- End Footer -->
    <!-- <button onClick="signOut()">Sign Out</button> -->
	<!-- Google API Start -->
	<script src="assets/js/login.js"></script>
    <script src="https://accounts.google.com/gsi/client" async defer></script>
    <!-- Google API End -->

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