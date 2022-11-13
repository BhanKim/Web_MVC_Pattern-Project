<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>manege_main</title>
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
<body link="black" vlink="black" alink="navy">
<!-- ======= Header ======= -->
	<%@include file = "header_manage.jsp" %>
  <!-- End Header -->

  <main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>User List</h2>
          <ol>
            <li><a href="manage_main.jsp">Home</a></li>
            <li>Inner Page</li>
          </ol>
        </div>

      </div>
    </section> 
    <!--End Breadcrumbs Section -->

<!--  ---------------------------------- 정보 쓰기란 시작 ---------------------------------- -->
	<div style="text-align: center;">
	   <br>
	   <br> 
<!-- 	      &nbsp;&nbsp;&nbsp;<h2>회원정보 리스트</h2>&nbsp;&nbsp;&nbsp;
 -->	      
	      <table style="margin-left: auto; margin-right: auto;" border="1">
	         <tr>
		        <td>아이디</td>
		        <td>비밀번호</td>
		        <td>이름</td>
		        <td>생년월일</td>
		        <td>성별</td>
		        <td>이메일</td>
		        <td>전화번호</td>
		     </tr>
		     <c:forEach items="${manageuserlist}" var="dto">
		      <tr>
		         <td>${dto.user_id }</td>
		         <td>${dto.user_pw }</td>
		         <td>${dto.user_name }</td>
		         <td>${dto.user_birthday }</td>
		         <td>${dto.user_gender }</td>
		         <td>${dto.user_email }</td>
		         <td>${dto.user_telno }</td>		      
		      </tr>
		      </c:forEach>
	      </table>
	      <br>
	      <br>
	      
	</div>
	<!--  ---------------------------------- 정보 쓰기란 종료 ----------------------------------  -->


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