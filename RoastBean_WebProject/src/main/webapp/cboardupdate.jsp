<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>글 수정하기</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <script src="https://cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>

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
	<%@include file = "header_innerpage.jsp" %>
  <!-- End Header -->

  <main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
<div class="row">
		<div class="col">
	    	<h2>&nbsp;&nbsp;글쓰기</h2><br>
			<table width="1100" border="1">
				<form name="modify_form" action="modify.do" method="post">
					<input type="hidden" name="community_id" value="${content_view.community_id }">
					<tr>
						<th width="100" height="40">제목</th>
						<td><input type="text" name="community_title" size="140" value="${content_view.community_title }"></td>
					</tr>
					<tr>
						<th width="100" height="40">작성자</th>
						<td> &nbsp;&nbsp;${ID } </td>
					</tr>
					<tr>
						<th width="100" height="320">내용</th>
						<td>
						<textarea name=community_content id="community_content">${content_view.community_content }</textarea>
						<script>CKEDITOR.replace('community_content');</script>
						</td>
					</tr>
					<tr>
						<td colspan="2" height="40">
							&nbsp;&nbsp;<input type="submit" class="btn btn-success" style="padding:2px 10px" value="수정">&nbsp;
							<a href="cboardcontent_view.do?community_id=${content_view.community_id }" class="btn btn-secondary" style="padding:2px 10px">취소</a>&nbsp;
							<a href="list.do?page=<%= session.getAttribute("cpage") %>" class="btn btn-secondary" style="padding:2px 10px">목록</a>&nbsp;
						</td>
					</tr>
				</form>	
			</table>
		</div>
	</div>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->

---------------------------------- 정보 쓰기란 시작 ----------------------------------
	<section class="inner-page">
	  <div class="container">
	  	<p>
		  이너 페이지 샘플입니다.<br>
		  이너 페이지 샘플입니다.
		  이너 페이지 샘플입니다.<br>
		  위의 class="inner=page" / class="container" 지워도 상관없습니다.<br>
		  자유롭게 작성해주세요.
		</p>
	  </div>
	</section>
	
<h3>jsp 파일 새로 복사해서 작업해주세요!</h3><br>
정보는 이 공간에 넣어서 실험해보시면 됩니다!<br>
자유롭게 작성해주세요.<br>
cf. 기존의 부트스트랩을 사용하여 디자인 하실 분은 해당 부트스트랩 링크 위에 추가 하시면 되겠습니다.
    
    <section class="inner-page">
      <div class="container">
        <p>
          Example inner page template
        </p>
      </div>
    </section>
---------------------------------- 정보 쓰기란 종료 ----------------------------------

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
	<%@include file = "footer.jsp" %>
  <!-- End Footer -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

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