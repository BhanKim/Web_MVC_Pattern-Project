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
			<a class="nav-link scrollto" href="faq_list_by_user.do">Notice</a>
			<a class="nav-link scrollto" href="notice_list_by_user.do"><font color="8784D6" style="font-size: 1.2em; font-weight: bold;">FAQ</font></a>
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
							<tr style="background-color: #A3A7AB;"><td colspan="3"></td></tr>
							<tr align="center" valign="top">
								<%-- <td>${dto.rownum}<input type="hidden" name="qna_write_seq" value="${dto.notice_write_seq}"></td> --%>
								<td>1</td>
								<td>제목 : 1번 제목</td>
								<td align="left">내용 : 1번 내용</td>
							</tr>
							
							<tr style="background-color: #A3A7AB;"><td colspan="3"></td></tr>
							<tr align="center" valign="top">
								<%-- <td>${dto.rownum}<input type="hidden" name="qna_write_seq" value="${dto.notice_write_seq}"></td> --%>
								<td>2</td>
								<td>제목 : 2번 제목</td>
								<td align="left">내용 : 2번 내용</td>
							</tr>
							
							<tr style="background-color: #A3A7AB;"><td colspan="3"></td></tr>
							<tr align="center" valign="top">
								<%-- <td>${dto.rownum}<input type="hidden" name="qna_write_seq" value="${dto.notice_write_seq}"></td> --%>
								<td>3</td>
								<td>제목 : 3번 제목</td>
								<td align="left">내용 : 3번 내용</td>
							</tr>
							
							<tr style="background-color: #A3A7AB;"><td colspan="3"></td></tr>
							<tr align="center" valign="top">
								<%-- <td>${dto.rownum}<input type="hidden" name="qna_write_seq" value="${dto.notice_write_seq}"></td> --%>
								<td>4</td>
								<td>제목 : 4번 제목</td>
								<td align="left">내용 : 4번 내용</td>
							</tr>
							
							<tr style="background-color: #A3A7AB;"><td colspan="3"></td></tr>
							<tr align="center" valign="top">
								<%-- <td>${dto.rownum}<input type="hidden" name="qna_write_seq" value="${dto.notice_write_seq}"></td> --%>
								<td>5</td>
								<td>제목 : 5번 제목</td>
								<td align="left">내용 : 5번 내용</td>
							</tr>
							
							<tr style="background-color: #A3A7AB;"><td colspan="3"></td></tr>
							<tr align="center" valign="top">
								<%-- <td>${dto.rownum}<input type="hidden" name="qna_write_seq" value="${dto.notice_write_seq}"></td> --%>
								<td>6</td>
								<td>제목 : 6번 제목</td>
								<td align="left">내용 : 6번 내용</td>
							</tr>
							
							<tr style="background-color: #A3A7AB;"><td colspan="3"></td></tr>
							<tr align="center" valign="top">
								<%-- <td>${dto.rownum}<input type="hidden" name="qna_write_seq" value="${dto.notice_write_seq}"></td> --%>
								<td>7</td>
								<td>제목 : 7번 제목</td>
								<td align="left">내용 : 7번 내용</td>
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