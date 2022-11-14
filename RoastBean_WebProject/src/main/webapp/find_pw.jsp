<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Roast Bean</title>
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
<style type="text/css">
.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
}
.pagination a.active {
    padding-bottom: 6px;
    border-bottom: 3px solid #111;
}
.pagination a:hover:not(.active) {background-color: #ddd;}
</style>
</head>
<body>
<script type="text/javascript">
$(document).ready(function() {
		$('#findPw').click(function(){
		   
		       var user_id = $('#user_id').val();
		       var user_name = $('#user_name').val();
		       var user_email = $('#user_email').val();
		        
		       if(user_email=="") {
				   alert("이메일을 입력해주세요");
		       } else if(user_name=="") {
		    	   alert("이름을 입력해주세요");
		       } else if(user_id=="") {
		    	   alert("아이디를 입력해주세요");
		       } else {
		    	   alert("이메일 전송이 완료되었습니다.\n이메일을 확인해 주세요.");
		           $.ajax({
		              url:'http://localhost:8080/RoastBean_WebProject/FindPw',
		              type:'POST',
		              data:{user_id : user_id, 
		            	  	user_name : user_name,
		            	  	user_email : user_email},
		              success:function(response)
		              {
		            	  document.findPw.submit();
		              }
		           })
		       }
		        
			})
})
</script>

	<!-- ======= Header ======= -->
	<%@include file = "header_innerpage.jsp" %>
  	<!-- End Header -->
  	
  	<main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Find Password</h2>
          <ol>
            <li><a href="index.jsp">Home</a></li>
            <li>Find Password</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->
    
	<section id="why-us" class="why-us">
		<div class="container">
			<div class="row" align="center">
				<form action="login.jsp" method="post" name="findPw">
							<div class="col" style="width: 380px;">
							<div class="mb-3">
									<input type="text" class="form-control" id="user_id"
										name="user_id" placeholder="ID" maxlength="41"
										aria-describedby="idHelp" style="height: 48px;">
								</div>
								<div class="mb-3">
									<input type="text" class="form-control" id="user_name"
										name="user_name" placeholder="Name" maxlength="41"
										aria-describedby="idHelp" style="height: 48px;">
								</div>
								<div class="mb-3">
									<input type="text" class="form-control" id="user_email"
										name="user_email" placeholder="Email" maxlength="16"
										aria-describedby="passwordHelpBlock" style="height: 48px;">
								</div>
								<div class="mb-3">
									<button type="button" class="btn" id="findPw"
										style="width: 380px; color: #fff; background-color: #F2BCBB; height: 48px; font-weight: normal; font-size: large;">Find Password</button>
								</div>
							</div>
						</form>
			</div>
		</div>
	</section>
	
	</main>
	
	<%@include file="footer.jsp"%>
	
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