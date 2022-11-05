<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Roast Bean : Sign Up</title>
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
<link href="assets/css/style_rb.css" rel="stylesheet">

</head>

<body>

	<!-- ======= Header ======= -->
	<%-- <%@include file="header_innerpage.jsp"%> --%>
	<!-- End Header -->

	<main id="main">

		<!-- ======= Breadcrumbs Section ======= -->
		<!-- <section class="breadcrumbs">
			<div class="container">

				<div class="d-flex justify-content-between align-items-center">
					<h2>Inner Page</h2>
					<ol>
						<li><a href="index.jsp">Home</a></li>
						<li>Inner Page</li>
					</ol>
				</div>

			</div>
		</section> -->
		<!-- End Breadcrumbs Section -->
		<!-- <div style="margin: auto;"> -->


		<!-- <form>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> <input type="email" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
				<div id="emailHelp" class="form-text">We'll never share your
					email with anyone else.</div>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" class="form-control"
					id="exampleInputPassword1">
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Check me
					out</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form> -->


		<!-- <label for="inputPassword5" class="form-label">Password</label> <input
			type="password" id="inputPassword5" class="form-control"
			aria-describedby="passwordHelpBlock">
		<div id="passwordHelpBlock" class="form-text">Your password must
			be 8-20 characters long, contain letters and numbers, and must not
			contain spaces, special characters, or emoji.</div>


		<div class="row g-3 align-items-center">
			<div class="col-auto">
				<label for="inputPassword6" class="col-form-label">Password</label>
			</div>
			<div class="col-auto">
				<input type="password" id="inputPassword6" class="form-control"
					aria-describedby="passwordHelpInline">
			</div>
			<div class="col-auto">
				<span id="passwordHelpInline" class="form-text"> Must be 8-20
					characters long. </span>
			</div>
		</div> -->

		<div class="container text-center">
			<div style="height: 100px;"></div>
			<div align="center">
				<img alt="" src="assets/img/logo.png" width="320" height="68">
			</div>
			<div style="height: 40px;"></div>
			<div class="row align-items-center">
				<div class="col align-items-start"></div>
				<div class="col align-items-center">
					<div class="col"
						style="border-style: solid; border-radius: 12px; border-width: thin; border-color: #CFD4D9; padding: 40px;">
						<div style="width: 380px;">
							<div class="mb-3">
								<input type="text" class="form-control"
									value="Continue with Google" style="height: 48px;">
							</div>
							<div class="mb-3">
								<input type="text" class="form-control"
									value="Continue with Naver" style="height: 48px;">
							</div>
							<div class="mb-3">
								<input type="text" class="form-control"
									value="Continue with Kakao" style="height: 48px;">
							</div>
							<div class="mb-3">
								<font style="color: #6E757C;">or</font>
							</div>
							<div class="mb-3">
								<!-- <label for="exampleInputEmail1" class="form-label">Email</label>  -->
								<input type="text" class="form-control" id="id" name="id"
									placeholder="ID" maxlength="41" aria-describedby="idHelp"
									style="height: 48px;">
								<!-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
							</div>
							<div class="mb-3">
								<!-- <label for="exampleInputEmail1" class="form-label">Email</label>  -->
								<input type="email" class="form-control" id="email" name="email"
									placeholder="Email : not use now" aria-describedby="emailHelp"
									style="height: 48px;">
								<!-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
							</div>
							<div class="mb-3">
								<!-- <label for="inputPassword5" class="form-label">Password</label>  -->
								<input type="password" class="form-control" id="pw" name="pw"
									placeholder="Password" maxlength="16"
									aria-describedby="passwordHelpBlock" style="height: 48px;">
								<!-- <div id="passwordHelpBlock" class="form-text">Your password
							must be 8-20 characters long, contain letters and numbers, and
							must not contain spaces, special characters, or emoji.</div> -->
							</div>
							<div class="login_error_wrap" id="err_capslock"
								style="display: none;">
								<div class="error_message">
									<strong>CapsLock</strong>이 켜져 있습니다.
								</div>
							</div>
							<div class="login_error_wrap" id="err_empty_id"
								style="display: none;">
								<div class="error_message">
									<strong>아이디</strong>를 입력해 주세요.
								</div>
							</div>
							<div class="login_error_wrap" id="err_empty_pw"
								style="display: none;">
								<div class="error_message">
									<strong>비밀번호</strong>를 입력해 주세요.
								</div>
							</div>
							<div class="login_error_wrap" id="err_common"
								style="display: none;">
								<div class="error_message" style="width: 90%"></div>
							</div>
							<div class="mb-3">
								<button type="submit" class="btn "
									style="width: 380px; color: #fff; background-color: #F2BCBB; height: 48px; font-weight: normal; font-size: large;">Log
									in</button>
							</div>
						</div>
						<div class="mb-3">
							<div>
								Already have an account? <a href="login.jsp" tabindex="-1"
									style="color: #5464F9;">Login</a>
							</div>
						</div>
						<div class="mb-3">
							<span style="font-size: small;">By clicking "Create account", I agree to
								Roast Bean's <a target="_blank" rel="noopener" tabindex="-1"
								href="/summary-of-policy" style="color: #5464F9;">TOS</a> and <a target="_blank"
								rel="noopener" tabindex="-1" href="/privacy" style="color: #5464F9;">Privacy Policy</a>.
							</span>
						</div>
					</div>
				</div>
				<div class="col align-items-end"></div>
			</div>
			<div class="row align-items-end"></div>
		</div>
		<!-- </div> -->
	</main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<%-- <%@include file="footer.jsp"%> --%>
	<!-- End Footer -->

	<!-- <a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a> -->

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