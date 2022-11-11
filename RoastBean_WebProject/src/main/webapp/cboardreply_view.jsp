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
		<div class="row">
			<div class="col">
		    	<h2>&nbsp;&nbsp;글쓰기</h2><br>
				<table width="1100" border="1">
					<form action="reply.do" method="post">
						<input type="hidden" name="community_id" value="${cboardreply_view.community_id}">
						<input type="hidden" name="community_group" value="${cboardreply_view.community_group}">
						<input type="hidden" name="community_step" value="${cboardreply_view.community_step}">
						<input type="hidden" name="community_indent" value="${cboardreply_view.community_indent}">
						<tr>
							<th  width="100" height="40">제목</th>
							<td><input type="text" name="community_title" size="140" value="${cboardreply_view.community_title}"></td>
						</tr>
						<tr>
							<th width="100" height="40">작성자</th>
							<td> &nbsp;&nbsp;${ID } </td>
						</tr>
						<tr>
							<th>내용</th>
							<td>
							<textarea name="community_content" id="community_content" rows="10" cols="30"></textarea>
							<script>CKEDITOR.replace('community_content');</script>
							</td>
						</tr>
						<tr>
							<td colspan="2" height="40">
								&nbsp;&nbsp;<input type="submit" class="btn btn-success" style="padding:2px 10px" value="등록">&nbsp;
								<a href="list.do?page=<%= session.getAttribute("cpage") %>" class="btn btn-secondary" style="padding:2px 10px">취소</a>&nbsp;
							</td>
						</tr>
					</form>	
				</table>
		    </div>
	    </div>
	</div>
   </section><!-- End Breadcrumbs Section -->

    

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