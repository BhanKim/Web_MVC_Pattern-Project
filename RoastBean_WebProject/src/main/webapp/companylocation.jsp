<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Location Roastbean</title>
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
  
  <!-- Map API -->
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=79cc95a0154045598e5c05072effa0f2"></script>

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
          <h2>Location</h2>
          <ol>
            <li><a href="index.jsp">Home</a></li>
            <li>Location</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->
    


    <section class="inner-page">
      <div class="container">
	<div align="left">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="assets/img/logo.png" alt="" class="img-fluid" width="320" height="72"></div> <br>
	<hr align="center" style="border: solid 3px #F2BCBB; width: 80%;">
	<div align="left">
	<h7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;서울특별시 강남구 강남대로 78길 8 (한국빌딩) 4층</h7><br>
	<h7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[2호선,신분당선]강남역 4번출구 90m</h7><br>
	<h7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tel.010-3684-6726 &nbsp;&nbsp;&nbsp; Fax.02-111-1111</h7>
	</div>
	<div align="right">
	<a href="https://map.kakao.com/link/roadview/37.494753466226925,127.03002602066344" class="btn" style="background: #F2BCBB; border: 0; padding:2px 10px; color: #fff; transition: 0.4s; border-radius: 50px;">Roadview</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<hr align="center" style="border: solid 3px #F2BCBB; width: 80%;">
	<br>
	</div>
	<div id="map" style="width:1200px;height:1000px; margin: auto;"></div>

		<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(37.494753466226925, 127.03002602066344),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
		
		var markerPosition  = new kakao.maps.LatLng(37.494753466226925, 127.03002602066344);
		var marker = new kakao.maps.Marker({
			position: markerPosition 
		});
		    marker.setMap(map); 
		var iwContent = '<div style="padding:5px;">Roast Bean<br><a href="https://map.kakao.com/link/map/Roast Bean Company,37.494753466226925,127.03002602066344" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Roast Bean Company,37.494753466226925,127.03002602066344" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		    iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다

		// 인포윈도우를 생성합니다
		var infowindow = new kakao.maps.InfoWindow({
		    position : iwPosition, 
		    content : iwContent 
		});
		  
		// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
		infowindow.open(map, marker); 
		
	</script>
	
	<br><br><br>
	
	
	
	
	
	
	
      </div>
    </section>

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