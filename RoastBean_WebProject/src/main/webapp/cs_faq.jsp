<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Roast Bean : FAQ</title>
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


</head>

<body>
  <!-- ======= Header ======= -->
	<%@include file = "header_innerpage.jsp" %>

  <main id="main">
    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">
        <div class="d-flex justify-content-between align-items-center">
			<a class="nav-link scrollto" href="notice_list.do">Notice</a>
			<a class="nav-link scrollto" href="cs_faq.jsp"><font color="8784D6" style="font-size: 1.2em; font-weight: bold;">FAQ</font></a>
			<a class="nav-link scrollto" href="qna_question_by_user.do">QnA</a>
			&emsp;&emsp;&emsp;
			<ol>
				<li><a href="index.jsp">Home</a></li>
				<li>Customer Service</li>
			</ol>
        </div>
      </div>
    </section><!-- End Breadcrumbs Section -->
	<section class="inner-page">
	  <div class="container">
		<h2>&nbsp;&nbsp;FAQ</h2><br>
		<hr style="border: solid 2px red;">
		<br>
		<div class="col">
				<div>
					<table class="table table-hover" style="vertical-align: middle;">
						<thead>
							<tr align="center">
								<th style="width: 10%;">번호</th>
								<th style="width: 30%;">제목</th>
								<th style="width: 60%;">내용</th>
							</tr>
						</thead>
							<tr valign="top">
								<%-- <td>${dto.rownum}<input type="hidden" name="qna_write_seq" value="${dto.notice_write_seq}"></td> --%>
								<td align="center">1</td>
								<td>원두를 구매하려고 하면 어떻게 해야하나요?</td>
								<td>상단에 COFFEE SHOP 을 클릭하면 저희가 판매하는 원두 종류를 볼 수 있고, 구매버튼 및 장바구니로 구매가 가능합니다^^.</td>
							</tr>
							
							<tr valign="top">
								<%-- <td>${dto.rownum}<input type="hidden" name="qna_write_seq" value="${dto.notice_write_seq}"></td> --%>
								<td align="center">2</td>
								<td>제가 무슨 원두를 좋아하는지 모르는데 어떡해야하나요?</td>
								<td>상단에 ABOUT 버튼에 Coffee That Suits Me 란을 클릭하시면 나와 맞는 원두찾기를 하실 수 있습니다. </td>
							</tr>
							
							<tr valign="top">
								<%-- <td>${dto.rownum}<input type="hidden" name="qna_write_seq" value="${dto.notice_write_seq}"></td> --%>
								<td align="center">3</td>
								<td>주문한 내역을 어디서 볼 수 있나요?</td>
								<td>우측 상단에 위치한 본인의 닉네임을 클릭하시면 마이페이지로 이동됩니다. 마이페이지에서 오더리스트를 누르면 보실 수 있습니다.</td>
							</tr>
							
							<tr valign="top">
								<%-- <td>${dto.rownum}<input type="hidden" name="qna_write_seq" value="${dto.notice_write_seq}"></td> --%>
								<td align="center">4</td>
								<td>문의를 하려면 어떻게 해야하나요?</td>
								<td>Customer Service QnA에서 질문하기를 양식에 맞춰 작성해주시면 됩니다.</td>
							</tr>
							
							<tr valign="top">
								<%-- <td>${dto.rownum}<input type="hidden" name="qna_write_seq" value="${dto.notice_write_seq}"></td> --%>
								<td align="center">5</td>
								<td>본사의 위치를 알고 싶어요! 원두도 직접구매가 가능한가요?</td>
								<td>본사의 위치는 ABOUT 에서 Location란에 들어가시면 안내되어있습니다.</td>
							</tr>
							
					</table>
				</div>
				<%-- ******** 페이징부분 아직 적용안됐음 ******** --%>
			 	<%-- <div class="container" align="center">
				<table>
					<tr>
						<td align="center" colspan="6">
						<c:choose>
							<c:when test="${(page.curPage - 1) < 1 }">
								[ 처음 ]
							</c:when>
							<c:otherwise>
								<a href="productDetail.do?page=1&product_id=${productDetail.product_id}">[ 처음 ]</a>
							</c:otherwise>
							</c:choose>
							<!-- 이전 -->
							<c:choose>
							<c:when test="${(page.curPage - 1) < 1 }">
								[ 이전 ]
							</c:when>
							<c:otherwise>
								<a href="productDetail.do?page=${page.curPage - 1 }&product_id=${productDetail.product_id}">[ 이전 ]</a>
							</c:otherwise>
							</c:choose>
							
							<!-- 개별 페이지 -->
							<c:forEach var="fEach" begin="${page.startPage }" end="${page.endPage }" step="1">
								<c:choose>
								<c:when test="${page.curPage == fEach}">
									&nbsp; [ ${fEach } ] &nbsp;
								</c:when>
								<c:otherwise>
									<a href="productDetail.do?page=${fEach }&product_id=${productDetail.product_id}">[ ${fEach } ]</a>&nbsp;
								</c:otherwise>
								</c:choose>
							</c:forEach>
							
							<!-- 다음 -->
							<c:choose>
							<c:when test="${(page.curPage + 1) > page.totalPage }">
								[ 다음 ]
							</c:when>
							<c:otherwise>
								<a href="productDetail.do?page=${page.curPage + 1 }&product_id=${productDetail.product_id}">[ 다음 ]</a>
							</c:otherwise>
							</c:choose>
							<!-- 끝 -->
							<c:choose>
							<c:when test="${page.curPage == page.totalPage }">
								[ 마지막 ]
							</c:when>
							<c:otherwise>
								<a href="productDetail.do?page=${page.totalPage }&product_id=${productDetail.product_id}">[ 마지막 ]</a>
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
				</table>
				</div> --%>
				<%-- ******** 페이징부분 아직 적용안됐음 ******** --%>
			</div>
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