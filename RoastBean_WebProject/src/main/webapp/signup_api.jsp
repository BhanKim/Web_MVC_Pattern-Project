<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 복사해서 사용하기 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="description">
<meta content="" name="keywords">
<title>Roast Bean : Sign Up</title>
<style>
.form-control2 {
	  padding: 0.375rem 0.75rem;
	  font-size: 1rem;
	  font-weight: 400;
	  line-height: 1em;
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
	  vertical-align: middle;
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
<link href="assets/css/style_rb.css" rel="stylesheet">
</head>
<body>
	<!-- ======= Header ======= -->
	<%-- <%@include file="header_innerpage.jsp"%> --%>
	<main id="main">
		<div class="container text-center">
			<div style="height: 100px;"></div>
			<div align="center">
				<a href="index.jsp"><img alt="" src="assets/img/logo.png" width="320" height="68"></a>
			</div>
			<div style="height: 40px;"></div>
			<div class="row align-items-center">
				<div class="col align-items-start"></div>
				<div class="col align-items-center">
					<div class="col"
						style="border-style: solid; border-radius: 12px; border-width: thin; border-color: #CFD4D9; padding: 40px;">
						<form action="signup_api.do" method="post" name="Member">
							<div style="width: 400px;">
								<table class="col">
									<tr class="mb-3">
										<td align="left">Name&emsp;&emsp;&emsp;
										<td><input type="text" class="form-control" name="user_name" value="${user_name}" placeholder="한글로 입력해주세요." style="height: 32px;"></td>
									</tr>
									<tr height="10"></tr>
									<tr>
										<td align="left">Nick Name</td>
										<td class="col" align="left">
											<input class="form-control2" type="text" name="user_nick" value="${user_nick}" placeholder="필수사항입니다." maxlength="41" style="height: 32px;">
											<input class="form-control3" type="button" onclick="checkNick()" value="중복체크">
										</td>
									</tr>
									<tr height="10"></tr>
									<tr class="mb-3">
										<td align="left">Tel</td>
										<td align="left">
<!-- 											<select class="form-control2" name="user_telno1" style="height: 32px; vertical-align: middle;">
												<option value="010">010</option>
												<option value="011">011</option>
												<option value="016">016</option>
												<option value="017">017</option>
												<option value="019">019</option>
											</select>
 -->										
											<input class="form-control2" size="4" type="tel" name="user_telno1" value="${user_telno1}" style="height: 32px;">
											-
											<input class="form-control2" size="8" type="tel" name="user_telno2" value="${user_telno2}" style="height: 32px;">
											-
											<input class="form-control2" size="8" type="tel" name="user_telno3" value="${user_telno3}" style="height: 32px;">
										</td>
									</tr>
									<tr height="10"></tr>
									<tr class="mb-3">
										<td align="left">Email</td>
										<td><input type="email" class="form-control" name="user_email" value="${api_email }${user_email}" readonly="readonly"
											placeholder="필수사항입니다." style="height: 32px;"></td>
									</tr>
									<tr height="10"></tr>
									<tr class="mb-3">
										<td align="left">Birthday</td>
										<td align="left">
											<input class="form-control2" size="4" type="text" name="user_birthday1" value="${user_birthday1}" style="height: 32px;">
											년
											<input class="form-control2" size="4" type="text" name="user_birthday2" value="${user_birthday2}" style="height: 32px;">
											월
											<input class="form-control2" size="4" type="text" name="user_birthday3" value="${user_birthday3}" style="height: 32px;">
											일
<%-- 											<select class="form-control2" name="user_birthday1" style="height: 32px;">
												<option selected="selected">선택</option>
												<c:forEach var="cnt" begin="1950" end="2022">
												<option value="${cnt}" selected="selected">${cnt}</option>
												</c:forEach>
											</select> 년&emsp;
											<select class="form-control2" name="user_birthday2" style="height: 32px;">
												<c:forEach var="cnt" begin="1" end="12">
												<option value="${cnt}">${cnt}</option>
												</c:forEach>
											</select> 월&emsp;
											<select class="form-control2" name="user_birthday3" style="height: 32px;">
												<c:forEach var="cnt" begin="1" end="31">
												<option value="${cnt}">${cnt}</option>
												</c:forEach>
											</select> 일
 --%>
 									</tr>
									<tr height="10"></tr>
									<tr class="mb-3">
										<td align="left">Gender</td>
										<td align="left">
											<input type="radio" name="user_gender" value="남자"> 남자
											&emsp;<input type="radio" name="user_gender" value="여자"> 여자
										</td>
									</tr>
									<tr height="10"></tr>
									<tr>
										<td align="left" valign="top">Address</td>
										<td align="left">
											<input class="form-control2 mb-1" style="height: 32px;" type="text" id="sample4_postcode" name="user_addresszipcode" readonly="readonly" placeholder="우편번호">
											<input class="form-control3" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
											<input class="form-control2 mb-1" size="36" style="height: 32px;" class="mb-1" type="text" id="sample4_roadAddress" name="user_address1" readonly="readonly" placeholder="도로명주소">
											<input class="form-control2 mb-1" size="36" style="height: 32px;" class="mb-1" type="text" id="sample4_jibunAddress" name="user_address2" readonly="readonly" placeholder="지번주소">
											<span id="guide" style="color:#999;display:none"></span><br>
											<input class="form-control2" size="36" type="text" name="user_address3" placeholder="상세주소">
										</td>
									</tr>
								</table>	
								<div class="my-3">
									<button type="button" class="btn " onclick="checkMember()"
										style="width: 380px; color: #fff; background-color: #F2BCBB; height: 48px; font-weight: normal; font-size: large;">Sign up</button>
								</div>
							</div>
							<div class="mb-3">
								<div>Already have an account? <a href="login.jsp" tabindex="-1" style="color: #5464F9;">Login</a></div>
							</div>
							<div class="mb-3">
								<span style="font-size: small;">By clicking "Create account", I agree to
									Roast Bean's <a target="_blank" rel="noopener" tabindex="-1"
									href="policy_tos.jsp" style="color: #5464F9;">TOS</a> and <a target="_blank"
									rel="noopener" tabindex="-1" href="policy_privacy.jsp" style="color: #5464F9;">Privacy Policy</a>.
								</span>
							</div>
						</form>
					</div>
				</div>
				<div class="col align-items-end"></div>
			</div>
			<div class="row align-items-end"></div>
			<div style="height: 100px;"></div>
		</div>
	</main>

	<script type="text/javascript">
	function checkId() {
		var Member = document.Member;
		
		Member.action = "check_id.do";
		Member.submit();
	}
	
	function checkNick() {
		var Member = document.Member;
		
		Member.action = "check_nick.do";
		Member.submit();
	}
	</script>
	
	<!-- 카카오 주소찾기 API -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<!-- 정규화 검사 -->
	<script src="assets/js/signup_api.js"></script>
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