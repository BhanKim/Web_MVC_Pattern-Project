<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Roast Bean : My page</title>
  <meta content="" name="description">
  <meta content="" name="keywords">
<style>
.form-control2 {
	  padding: 0.375rem 0.75rem;
	  font-size: 1rem;
	  font-weight: 400;
	  line-height: 1em;
	  text-align-center;
	  color: #212529;
	  background-color: #fff;
	  background-clip: padding-box;
	  border: 1px solid #ced4da;
	  -webkit-appearance: none;
	  -moz-appearance: none;
	  appearance: none;
	  border-radius: 0.375rem;
	  transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
	}
.form-control3 {
	  padding: 0.375rem 0.75rem;
	  font-size: 1rem;
	  font-weight: 400;
  	  line-height: 1em;
  	  text-align-center;
	  color: #212529;
	  background-color: #CFD4D9;
	  background-clip: padding-box;
	  border: 1px solid #ced4da;
	  -webkit-appearance: none;
	  -moz-appearance: none;
	  appearance: none;
	  border-radius: 0.375rem;
	  transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
	  height: 32px; 
	}
</style>
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
			<a class="nav-link scrollto" href="mypage_info.do"><font color="8784D6" style="font-size: 1.4em; font-weight: bold;">내 정보</font></a>
			<a class="nav-link scrollto" href="mypage_order_list.do">내 구매 목록</a>
			<a class="nav-link scrollto" href="mypage_write_list.do">내가 쓴 글</a>
			<a class="nav-link scrollto" href="mypage_qna_list.do">내 질문</a>
			&emsp;&emsp;&emsp;
			<ol>
				<li><a href="index.jsp">Home</a></li>
				<li>My page</li>
			</ol>
        </div>
      </div>
    </section><!-- End Breadcrumbs Section -->

	<section class="inner-page">
		<div class="row align-items-center">
			<div class="col"></div>
				<div class="col-4">
					<form action="mypage_info_pwcheck.do" method="post" name="Member">
						<input type="hidden" name="currentPage" value="mypage_info_update.jsp">
						  	<table class="table" >
						  		<tr>
									<td width="200"> Password</td>
									<td><input type="password" class="form-control" name="user_pw" placeholder="Password를 입력해주세요." style="height: 32px;"></td>
						  		</tr>
						  	</table>
					  	<div align="right"><button class="form-control3" type="submit">확인하기</button></div>
				  	</form>
				</div>
			<div class="col"></div>
		</div>
	</section>
  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <%@include file = "footer.jsp" %>
  <!-- End Footer -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>
  
  <!-- 카카오 주소찾기 API -->
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <!-- 정규화 검사 -->
  <script src="assets/js/mypage_info_update.js"></script>

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