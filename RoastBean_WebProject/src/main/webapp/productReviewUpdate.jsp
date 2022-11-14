Ï<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<style type="text/css">
#myform fieldset{
    display: inline-block;
    direction: rtl;
    border:0;
}
#myform fieldset legend{
    text-align: right;
}
#myform input[type=radio]{
    display: none;
}
#myform label{
    font-size: 3em;
    color: transparent;
    text-shadow: 0 0 0 #f0f0f0;
}
#myform label:hover{
    text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
}
#myform label:hover ~ label{
    text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
}
#myform input[type=radio]:checked ~ label{
    text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
}
#reviewContents {
    width: 100%;
    height: 150px;
    padding: 10px;
    box-sizing: border-box;
    border: solid 1.5px #D3D3D3;
    border-radius: 5px;
    font-size: 16px;
    resize: none;
}
</style>
</head>
<body>
	<script type="text/javascript">
		function updateReview() {
			document.myform.action = 'reviewUpdate.do?review_seq=<%=request.getParameter("review_seq")%>'
			document.myform.submit()
		}
		
		function deleteReview() {
			document.myform.action = 'reviewDelete.do?review_seq=<%=request.getParameter("review_seq")%>'
			document.myform.submit()
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
          <h2>Review</h2>
          <ol>
            <li><a href="index.jsp">Home</a></li>
            <li>Review</li>
          </ol>
        </div>
      </div>
    </section><!-- End Breadcrumbs Section -->
    <section id="contact" class="contact">
    	<div class="container">
	      	<div class="row">
	      		<h3>&nbsp;&nbsp;&nbsp;&nbsp;후기수정</h3>
				<hr style="border: solid 2px red;">
				<div class="card mb-3">
					<table class="table" style="vertical-align: middle;">
					<thead>
						<tr align="center">
							<th style="width: 15%;">상품이미지</th>
							<th style="width: 15%;">상품이름</th>
							<th style="width: 15%;">상품수량</th>
							<th style="width: 15%;">주문금액</th>
							<th style="width: 15%;">상품무게</th>
						</tr>
					</thead>
						<tr align="center">
							<td><img width="100" height="100" alt="" src="assets/img/product/${review.product_image}"></td>
							<td>${review.product_name}</td>
							<td>${review.order_seq}</td>
							<td><fmt:formatNumber value="${review.order_price}" groupingUsed="true" />원</td>
							<td>${review.product_weight}</td>
						</tr>
				</table>
					</div>
					<form class="mb-3" name="myform" id="myform" action="reviewInsert.do?order_seq=${review.order_seq}&product_id=${review.product_id}" method="post">
							<table>
								<tr>
									<td style="width: 20%;">
										<span class="text-bold">별점을 선택해주세요</span> 
									</td>
									<td style="width: 8	0%;">
									<fieldset>
										<input type="radio" name="review_star" value="5" id="rate1"> <label for="rate1">★</label> 
										<input type="radio" name="review_star" value="4" id="rate2"> <label for="rate2">★</label> 
										<input type="radio" name="review_star" value="3" id="rate3"> <label for="rate3">★</label> 
										<input type="radio" name="review_star" value="2" id="rate4"> <label for="rate4">★</label> 
										<input type="radio" name="review_star" value="1" id="rate5" checked="checked"> <label for="rate5">★</label>
									</fieldset>
									</td>
								</tr>
								<tr>
									<td>
										<span class="text-bold">후기 내용</span>
									</td>
									<td>
										<textarea name="review_content" class="col-auto form-control mb-2" id="review_content" placeholder="상품에 대한 평가를 작성해 주세요." cols="100">${mylistEdit.review_content}</textarea>
									</td>
								</tr>
								<tr>
									<td>
									</td>
									<td>
										<input type="button" value="수정" style="background: #F2BCBB; border: 0; padding: 3px 20px; color: #fff; transition: 0.4s; border-radius: 50px;" onclick="updateReview()">
										<input type="button" value="삭제" style="background: #F2BCBB; border: 0; padding: 3px 20px; color: #fff; transition: 0.4s; border-radius: 50px;" onclick="deleteReview()">
									</td>
								</tr>
							</table>
					</form>
				</div>
      	</div>
    </section>
		<section id="contact" class="contact">
			
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