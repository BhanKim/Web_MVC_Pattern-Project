<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="ko" dir="ltr">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <!-- test -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

  <title>나와 맞는 원두 찾기</title>
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
  
<!--   <link rel="stylesheet" href="./css/default.css"> -->
  <link rel="stylesheet" href="./css/main.css">
  <link rel="stylesheet" href="./css/qna.css">
  <link rel="stylesheet" href="./css/animation.css">
  <link rel="stylesheet" href="./css/result.css">
  <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
  <script>
  	Kakao.init('a7b8bc03426ed02bbebd51f832e8625c');
  	Kakao.isInitialized();
  </script>
</head>

<body>

	<%@include file = "header_innerpage.jsp" %>
	
  <div class="container">
    <section id="main" class="mx-auto my-5 py-5 px-3">
      <br>
      <br>
      <br>
      <br>
      <h1>나와 맞는 원두 찾기</h1>
      <div class="col-lg-6 col-md-8 col-sm-10 col-12 mx-auto">
        <img src="./img/pickbean.png" alt="mainImage" class="img-fluid">
      </div>
      <h5>
        나와 맞는 원두 찾기 사이트입니다! <br>
        아래 시작하기 버튼을 눌러 자신과 맞는 원두를 찾아보세요!!
      </h5>
      <button type="button" class="btn btn-outline-danger mt-3" onclick="js:begin()">시작하기</button>
    </section>

    <section id="qna">
      <br>
      <br>
      <br>
      <div class="status mx-auto mt-5">
        <div class="statusBar">
        </div>
      </div>
      <div class="qBox my-5 py-3 mx-auto">

      </div>
	<!-- 그림 선택하는 부분 -->
      <div class="row row-cols-1 row-cols-md-3 g-3 answerBox mx-auto"><!-- 선택하는 이미지의 간격 -->
      
        <div class="col">
          <div class="card">
            <img src="./img/pickbean.png" class="card-img-top leftImage" alt="...">
          </div>
        </div>
        <!-- leftImage로 왼쪽에 해당하는 이미지를 호출 -->
         <div class="col">
          <div class="card">
            <img src="./img/pickbean.png" class="card-img-top middleImage" alt="...">
          </div>
        </div>
        <!-- middleImage로 중앙에 해당하는 이미지를 호출 -->
        <div class="col">
          <div class="card">
            <img src="./img/pickbean.png" class="card-img-top rightImage" alt="...">
          </div>
        </div>
        <!-- rightImage로 오른쪽에 해당하는 이미지를 호출 -->
      </div>

    </section>
    <section id="result" class="mx-auto my-5 py-5 px-3">
      <br>
      <br>
      <br>
      <h1>당신의 결과는?!</h1>
      <div class="resultname">

      </div>
      <div id="resultImg" class="my-3 col-lg-6 col-md-8 col-sm-10 col-12 mx-auto">

      </div>
      <div class="resultDesc">

      </div>
      <button type="button" class="kakao mt-3 py-2 px-3" onclick="js:kakaoShare()">공유하기</button>
    
    </section>
    </div>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
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
  
    <script src="./js/data.js" charset="utf-8"></script>
    <script src="./js/start.js" charset="utf-8"></script>
    <script src="./js/share.js" charset="utf-8"></script>
  
</body>
</html>