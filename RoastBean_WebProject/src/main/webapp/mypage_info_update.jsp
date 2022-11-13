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
			<a class="nav-link scrollto" href="mypage_info.do"><font color="8784D6" style="font-size: 1.4em; font-weight: bold;">My Information</font></a>
			<a class="nav-link scrollto" href="mypage_order_list.do">My Order List</a>
			<a class="nav-link scrollto" href="mypage_write_list.do">My Write</a>
			<a class="nav-link scrollto" href="mypage_qna_list.do">My QnA</a>
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
			<form action="mypage_info_update.do" method="post" name="Member">
			<input type="hidden" name="currentPage" value="mypage_info_update.jsp">
		  	<table class="table" >
		  		<tr>
					<td width="200">ID</td>	  		
		  			<td>${userinfo_list.user_id}${user_id}<input type="hidden" name="user_id" value="${userinfo_list.user_id}${user_id}"></td>
		  			<td></td>
		  		</tr>
		  		<tr>
					<td>Name</td>
					<td colspan="2"><input type="text" class="form-control" name="user_name" value="${userinfo_list.user_name}${user_name}" placeholder="한글로 입력해주세요." style="height: 32px;"></td>
		  		</tr>
		  		<tr>
					<td>Nick Name</td>
					<td><input class="form-control" type="text" name="user_nick" value="${userinfo_list.user_nick}${user_nick}" placeholder="필수사항입니다." maxlength="41" style="height: 32px;">
					<td><input class="form-control3" type="button" onclick="checkNick()" value="중복체크">	</td>
		  		</tr>
		  		<tr>
					<td>E-mail</td>	  		
					<td colspan="2"><input class="form-control" type="text" name="user_email" value="${userinfo_list.user_email}${user_email}" placeholder="필수사항입니다." maxlength="41" style="height: 32px;"></td>
		  		</tr>
		  		<tr>
					<td>Tel Number</td>	
					<td colspan="2"><input class="form-control" type="text" name="user_telno" value="${userinfo_list.user_telno}${user_telno}" placeholder="필수사항입니다." maxlength="41" style="height: 32px;"></td>
		  		</tr>
		  		<tr>
					<td>Address</td>
					<td align="left" colspan="2">
						<input class="form-control2 mb-1" style="height: 32px;" type="text" id="sample4_postcode" name="user_addresszipcode" value="${userinfo_list.user_addresszipcode}${user_addresszipcode}" readonly="readonly" placeholder="우편번호">
						<input class="form-control3" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
						<input class="form-control2 mb-1" size="36" style="height: 32px;" class="mb-1" type="text" id="sample4_roadAddress" name="user_address1" value="${userinfo_list.user_address1}${user_address1}" readonly="readonly" placeholder="도로명주소"><br>
						<input class="form-control2 mb-1" size="36" style="height: 32px;" class="mb-1" type="text" id="sample4_jibunAddress" name="user_address2" value="${userinfo_list.user_address2}${user_address2}" readonly="readonly" placeholder="지번주소">
						<span id="guide" style="color:#999;display:none"></span><br>
						<input class="form-control2" size="36" style="height: 32px;" type="text" name="user_address3" value="${userinfo_list.user_address3}${user_address3}" placeholder="상세주소">
					</td>
		  		</tr>
		  		<tr>
					<td>Birthday</td>	  		
		  			<td colspan="2">${userinfo_list.user_birthday}${user_birthday}<input type="hidden" name="user_birthday" value="${userinfo_list.user_birthday}${user_birthday}"></td>
		  		</tr>
		  		<tr>
					<td>Gender</td>	  		
		  			<td colspan="2">${userinfo_list.user_gender}${user_gender}<input type="hidden" name="user_gender" value="${userinfo_list.user_gender}${user_gender}"></td>
		  		</tr>
		  		<tr>
					<td>Join Date</td>	  		
		  			<td colspan="2">${userinfo_list.user_initdate}${user_initdate}<input type="hidden" name="user_initdate" value="${userinfo_list.user_initdate}${user_initdate}"></td>
		  		</tr>
		  	</table>
		  	<div class="my-2" style="text-align: center;">
				<!-- Nick Name -->
				<c:if test="${checkNickDuplication == null}">
					<input type="hidden" name="nickDuplication" value="0">
				</c:if>
				<c:if test="${checkNickDuplication == 0}">
					<span style="color: blue;">사용 가능한 Nick Name입니다.</span>
					<input type="hidden" name="nickDuplication" value="1">
				</c:if>
				<c:if test="${checkNickDuplication == 1}">
					<span style="color: red;">사용 불가능한 Nick Name입니다.</span>
					<input type="hidden" name="nickDuplication" value="2">
				</c:if>
			</div>
		  	<div align="right"><button class="form-control3" type="button" onclick="location='mypage_info.do'">뒤로가기</button>  <button class="form-control3" type="button" onclick="checkMember()">저장하기</button></div>
		  	<!-- <input class="form-control3" type="submit" value="저장하기"> -->
		  	</form>
		</div>
		<div class="col"></div>
		</div>
	</section>
  </main><!-- End #main -->
  
  	<script type="text/javascript">
	function checkId() {
		var Member = document.Member;
		
		Member.action = "check_id_info.do";
		Member.submit();
		
	}
	
	function checkNick() {
		var Member = document.Member;
		
		Member.action = "check_nick_info.do";
		Member.submit();
		
	}
	
	</script>
  

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