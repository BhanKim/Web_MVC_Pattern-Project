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
.star {
	font-size: 1rem;
	color: red;
}

.star2 {
	font-size: 2rem;
	color: red;
}

.star span {
	width: 0;
	left: 0;
	color: red;
	pointer-events: none;
}
.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
}
.pagination a.active {
    padding-bottom: 6px;
    border-bottom: 3px solid #111;
}
</style>
</head>
<body>
<script type="text/javascript">
	function buySubmit() {
		var buyFrom = document.cartForm
		if(${ID == null}) {
			buyFrom.action = 'login.jsp'
			alert('로그인을 먼저 해주세요.')
			buyFrom.submit()
		} else {
			if(${productDetail.product_stock} < parseInt(document.getElementById('cQty').value)){
				alert('재고가 없습니다.')
			} else {
				buyFrom.action = 'cartOrderInsert.do'
				buyFrom.submit()
			}
		}
	}
	function buyCart() {
		var buyFrom = document.cartForm
		if(${ID == null}) {
			buyFrom.action = 'login.jsp'
			alert('로그인을 먼저 해주세요.')
			buyFrom.submit()
		} else {
			if(${productDetail.product_stock} < parseInt(document.getElementById('cQty').value)){
				alert('재고가 없습니다.')
			} else {
				alert('장바구니에 추가되었습니다.')
				buyFrom.action = 'insertCart.do?product_id=<%=request.getParameter("product_id")%>'
				buyFrom.submit()
			}
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
			<div class="container pb-5">
				<div class="row">
					<div class="col-lg-5 mt-5">
						<div class="card mb-3">
							<img class="card-img img-fluid"
								src="assets/img/product/${productDetail.product_image}"
								alt="Card image cap" id="product-detail">
						</div>
					</div>
					<div class="col-lg-7 mt-5">
						<form action="cartOrderInsert.do" method="post" name="cartForm">
							<div class="">
								<div class="card-body">
									<h1 class="h2">${productDetail.product_name}</h1>
									<p class="h3 py-2">
										<fmt:formatNumber value="${productDetail.product_price}"
											groupingUsed="true" />
										원
									</p>
									<ul class="list-inline">
										<li class="list-inline-item"></li>
									</ul>
									<h6>상품설명:</h6>
									<p>${productDetail.product_info}</p>


									<input type="hidden" name="product_price"
										value="${productDetail.product_price}"> <input
										type="hidden" name="product-title" value="Activewear">
									<input type="hidden" name="product_price"
										value="${productDetail.product_price}">
									<div class="row">
										<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item"><b>용량 : </b> <input
													type="hidden" name="product_weight" id="product-size"
													value="S"></li>
												<li class="list-inline-item">${productDetail.product_weight}g</li>
											</ul>
										</div>
										<p>
										<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item text-right"><b>구매가능 수량
														: ${productDetail.product_stock}</b> <input type="hidden"
													name="product_stock" id="product-quanity" value="1">
												</li>
											</ul>
										</div>
										<p>
											<script type="text/javascript">
                                    	function increaseCQty() {
                                    		document.getElementById('cQty').value = parseInt(document.getElementById('cQty').value) + parseInt(1);
                                    		document.getElementById('var-value').innerHTML = document.getElementById('cQty').value
                                    		document.getElementById('totalPrice').innerHTML = ${productDetail.product_price} * parseInt(document.getElementById('cQty').value)
										}
                                    	function decreaseCQty() {
                                    		if(parseInt(document.getElementById('cQty').value) <= 1){
                                    			document.getElementById("cQty").value = 1
                                    			document.getElementById('var-value').innerHTML = document.getElementById('cQty').value
                                    			document.getElementById('totalPrice').innerHTML = document.getElementById('totalPrice').innerHTML
                                    		} else {
                                				document.getElementById("cQty").value = parseInt(document.getElementById('cQty').value) - parseInt(1);
                                				document.getElementById('var-value').innerHTML = document.getElementById('cQty').value
                                				document.getElementById('totalPrice').innerHTML = document.getElementById('totalPrice').innerHTML - ${productDetail.product_price} 
                                    		}
										}
                                    </script>
										<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item text-right"><b>수량 :</b> <input
													type="hidden" name="cart_qty" id="cQty" value="1">
												</li>
												<li class="list-inline-item"><span
													class="btn btn-outline-danger" id="btn-minus"
													onclick="decreaseCQty()">-</span></li>
												<li class="list-inline-item"><h5>
														<span class="badge bg-danger" id="var-value">1</span>
													</h5></li>
												<li class="list-inline-item"><span
													class="btn btn-outline-danger" id="btn-plus"
													onclick="increaseCQty()">+</span></li>
											</ul>
										</div>
									</div>
									<p>
										총 상품 금액 : <span id="totalPrice"><fmt:formatNumber
												value="${productDetail.product_price}" groupingUsed="true" /></span>
										원
									</p>
									<input type="hidden" name="product_id"
										value='<%=request.getParameter("product_id")%>'>
									<div class="row pb-3">
										<div class="col d-grid">
											<button
												style="background: #F2BCBB; border: 0; padding: 10px 24px; color: #fff; transition: 0.4s; border-radius: 50px;"
												type="button" name="insertbuy" value="buy"
												onclick="buySubmit()">구매</button>
										</div>
										<div class="col d-grid">
											<button
												style="background: #F2BCBB; border: 0; padding: 10px 24px; color: #fff; transition: 0.4s; border-radius: 50px;"
												type="button" name="insertcart" value="addtocart"
												onclick="buyCart()">장바구니
												담기</button>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="container">
				<table class="table">
				<tr>
					<td align="left"><h2 style="display:inline;">&nbsp;&nbsp;&nbsp;w${reviewAvg.sumReview}</h2><h5 style="display:inline; color: rgb(123, 132, 141);">&nbsp;&nbsp;reviews</h5></td>
					<td align="right"><h2><span class="star2">★</span>&nbsp;&nbsp;${reviewAvg.avgStar}</h2><td>
				</tr>
				</table>
				<hr style="border: solid 2px red;">
				<br>
				<table class="table table-hover">
					<thead>
						<tr align="center">
							<th style="width: 10%;">번호</th>
							<th style="width: 45%;">내용</th>
							<th style="width: 15%;">작성자</th>
							<th style="width: 15%;">작성일</th>
							<th style="width: 15%;">평점</th>
						</tr>
					</thead>
					<c:forEach items="${reviewList}" var="dto">
						<tr align="center">
							<td>${dto.rownum}</td>
							<td>${dto.review_content}</td>
							<td>${dto.user_nick}</td>
							<td><fmt:formatDate value="${dto.review_date}" pattern="yyyy-MM-dd KK:mm"/></td>
							<td>
								<c:forEach begin="1" end="${dto.review_star}">
									<span class="star">★</span>
								</c:forEach>
								<c:forEach begin="${dto.review_star}" end="4">
									☆
								</c:forEach>
							</td>
							<c:if test="${ID == 'admin'}">
								<td>
									<a href="deleteReview.do?review_seq=${dto.review_seq}&product_id=<%=request.getParameter("product_id")%>" class="text-decoration-none"><span class="material-symbols-outlined">삭제</span></a>
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
				<div class="container" align="center">
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<c:choose>
								<c:when test="${(page.curPage - 1) < 1 }">
									<li class="page-item disabled"><a class="page-link">처음</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="productDetail.do?page=1&product_id=${productDetail.product_id}">처음</a>
									</li>
								</c:otherwise>
							</c:choose>
							<!-- 이전 -->
							<c:choose>
								<c:when test="${(page.curPage - 1) < 1 }">
									<li class="page-item disabled"><a class="page-link">이전</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="productDetail.do?page=${page.curPage - 1 }&product_id=${productDetail.product_id}">이전</a>
									</li>
								</c:otherwise>
							</c:choose>
							<!-- 개별 페이지 -->
							<c:forEach var="fEach" begin="${page.startPage }"
								end="${page.endPage }" step="1">
								<c:choose>
									<c:when test="${page.curPage == fEach}">
										<li class="page-item disabled"><a class="page-link active">&nbsp;${fEach }&nbsp;</a>
										</li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="productDetail.do?page=${fEach }&product_id=${productDetail.product_id}">&nbsp;${fEach }&nbsp;</a>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<!-- 다음 -->
							<c:choose>
								<c:when test="${(page.curPage + 1) > page.totalPage }">
									<li class="page-item disabled"><a class="page-link">다음</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="productDetail.do?page=${page.curPage + 1 }&product_id=${productDetail.product_id}">다음</a>
									</li>
								</c:otherwise>
							</c:choose>
							<!-- 끝 -->
							<c:choose>
								<c:when test="${page.curPage == page.totalPage }">
									<li class="page-item disabled"><a class="page-link">마지막</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="productDetail.do?page=${page.totalPage }&product_id=${productDetail.product_id}">마지막</a>
									</li>
								</c:otherwise>
							</c:choose>
						</ul>
					</nav>
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