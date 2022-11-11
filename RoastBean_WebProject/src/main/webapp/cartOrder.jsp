<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

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

</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
 

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            }
        }).open();
    }
</script>
	<script type="text/javascript">
		function mailcheck() {
			i = document.join.email3.selectedIndex 
			var email = document.join.email3.options[i].value
			document.join.email2.value = email
			
			if(document.join.email2.value == "etc") {
				$("#email2").removeAttr("readonly")
				document.join.email2.value = ""
			} else {
				$("#email2").attr("readonly",true)
			}
		}
	</script>
	<!-- ======= Header ======= -->
	<%@include file = "header_innerpage.jsp" %>
	
	<main id="main">
	
  	<!-- End Header -->

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Coffee Shop</h2>
          <ol>
            <li><a href="index.jsp">Home</a></li>
            <li>Coffee Shop</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->
    
	<section id="contact" class="contact">
	
	<div class="container py-5" align="center">
			<div class="col-lg-10">
				<h4>장바구니</h4><hr style="border: solid 2px red;"><br>
				<form id="join" name="join" action="order.do" method="post">
				<table class="table table-hover">
					<thead>
						<tr align="center">
							<th>상품 이미지</th>
							<th>상품 이름</th>
							<th>상품 수량</th>
							<th>상품 가격</th>
							<th>상품 삭제</th>
						</tr>
					</thead>
					<c:forEach items="${cartlist}" var="dto">
						<tr align="center" valign="middle">
							<td><img width="100" height="100" src="assets/img/product/${dto.product_image}"></td>
							<td>${dto.product_name}</td>
							<td>${dto.cart_qty}</td>
							<td><fmt:formatNumber value="${dto.product_price * dto.cart_qty}" groupingUsed="true" /> 원</td>
							<td><a href="deleteCart.do?product_id=${dto.product_id}" class="text-decoration-none"><span class="material-symbols-outlined">삭제</span></a></td>
						</tr>
					</c:forEach>
					<tr align="center">
						<td></td>
						<td></td>
						<td></td>
						<td><h5>총 금액 : </h5></td>
						<td>
						<c:set var = "total" value = "0" />
							<c:forEach items="${cartlist}" var="dto">
								<c:set var= "total" value="${total + (dto.product_price * dto.cart_qty)}"/>
							</c:forEach>
							<fmt:formatNumber value="${total}" groupingUsed="true" /> 원
						</td>
					</tr>
				</table><br><hr style="border: solid 2px red;"><br><br><br><br>
				<div class="container">
					<h4>배송지 정보</h4>
					<hr style="border: solid 2px red;"><br>
					<table class="table" style="vertical-align:middle;">
						<tr>
							<td align="center" style="background: #FBFAFA" width="150">주문하시는 분</td>
							<td align="left"><input type="text" size="20" name="order_name"></td>
						</tr>
						<tr>
							<td align="center" style="background: #FBFAFA" >주소</td>
							<td align="left">
								<input name="order_zipcode" class="mb-1" size="20" id="sample4_postcode" readonly="true" placeholder="우편번호" type="text"> - 
								<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호" style="background: #F2BCBB; border: 0; padding: 3px 20px; color: #fff; transition: 0.4s; border-radius: 50px;"><br>
								<input name="order_address1" class="mb-1" size="50" id="sample4_roadAddress" readonly="true" placeholder="도로명주소" type="text"><br>
								<input name="order_address2" class="mb-1" size="50" id="sample4_jibunAddress" readonly="true" placeholder="지번주소" type="text"><br>
								<span id="guide" style="color:#999;display:none"></span>
								<input name="order_address3"  size="50" type="text" id="sample4_detailAddress" placeholder="상세주소">
							</td>
						</tr>
						<tr>
							<td align="center" style="background: #FBFAFA">전화번호</td>
							<td align="left">
								<select name="order_telno1">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="018">018</option>
									<option value="019">019</option>
								</select> - 
								<input name="order_telno2" type="text" size="5" maxlength='4'> - 
								<input name="order_telno3" type="text" size="5" maxlength='4'>
							</td>
						</tr>
						<tr>
							<td align="center" style="background: #FBFAFA">이메일</td>
							<td align="left"><input type="text" name="order_email1"> @ 
								<input name="order_email2" value="" type="text" id="email2" readonly="true">
							<select id="email3" onChange="mailcheck()">
								<option value="" selected="selected">- 이메일 선택 -</option>
								<option value="naver.com">naver.com</option>
								<option value="daum.net">daum.net</option>
								<option value="nate.com">nate.com</option>
								<option value="hotmail.com">hotmail.com</option>
								<option value="yahoo.com">yahoo.com</option>
								<option value="empas.com">empas.com</option>
								<option value="korea.com">korea.com</option>
								<option value="dreamwiz.com">dreamwiz.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="etc">직접입력</option>
							</select><br>
							이메일을 통해 주문처리과정을 보내드립니다.<br>
							이메일 주소란에는 반드시 수신가능한 이메일주소를 입력해 주세요.
							</td>
						</tr>
					</table><br><hr style="border: solid 2px red;">
				</div>
				<div align="center">
				<button type="button" style="background: #F2BCBB; border: 0; padding: 10px 24px; color: #fff; transition: 0.4s; border-radius: 50px;" onclick="location.href='productList.do'">취소</button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" style="background: #F2BCBB; border: 0; padding: 10px 24px; color: #fff; transition: 0.4s; border-radius: 50px;" onclick="location.href='order.do'">구매</button>&nbsp;&nbsp;&nbsp;&nbsp;
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