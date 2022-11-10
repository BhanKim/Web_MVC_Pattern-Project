<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 복사해서 사용하기 -->
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
          <h2>Inner Page</h2>
          <ol>
            <li><a href="manage_main.jsp">Home</a></li>
            <li>Inner Page</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->

<!--  ---------------------------------- 정보 쓰기란 시작 ---------------------------------- -->
<div style="text-align: center;">
		<br>
		<br> &nbsp;&nbsp;&nbsp;
		<h2>상품정보 리스트</h2>
		&nbsp;&nbsp;&nbsp;
		
		<form action="ManageProductSearch.do">
		   <br>
		   검색
		   <select name="query">
		      <option value="product_name">브랜드명</option>
		      <option value="product_nation">국가명</option>
		   </select>&nbsp;&nbsp;&nbsp;
		   <input type="text" name="content">
		   <input type="submit" value="검색">
		</form>
		<br>
		<br>
		
		<table style="margin-left: auto; margin-right: auto;" border="1">
		<tr>
		   <!-- product -->
		   <th>numder</th>
		   <th>name</th>
		   <th>nation</th>
		   <th>image</th>
		   <th>info</th>
		   <th>stock</th>
		   <th>weight</th>
		   <th>price</th>
		   <!-- category -->
		   <th>type</th>
		   <th>acidity</th>
		   <th>aroma</th>
		   <th>body</th>
		   <th>sweet</th>
		   <!-- product -->
		   <th>수정</th>
		   <th>삭제</th>
		</tr>
		<c:forEach items="${manage_product_list}" var="dto">
		   <tr>
		      <td>${dto.product_id }</td>
		      <td>${dto.product_name }</td>
		      <td>${dto.product_nation }</td>
		      <td><img src="assets/img/product/${dto.product_image }" width="180px" height="200px"></td>
		      <td>${dto.product_info }</td>
		      <td>${dto.product_stock }</td>
		      <td>${dto.product_weight }</td>
		      <td>${dto.product_price }</td>		    
		      <td><a href="ManageProductUpdateSelete.do?product_id=${dto.product_id }" style="text-decoration:none">수정</a></td>		    
		      <td><a href="ManageProductDelete.do?product_id=${dto.product_id }" style="text-decoration:none">삭제</a></td>		    	    
		   </tr>
		</c:forEach>
		</table>
		<a href="ManageProductInsert.do" style="text-decoration:none">상품등록하기</a><br>
	   
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