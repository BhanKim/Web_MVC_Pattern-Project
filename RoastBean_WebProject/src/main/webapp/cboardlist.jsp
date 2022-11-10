<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<!-- test -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

<title>Community</title>
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

<!-- =======================================================
  * Template Name: Delicious - v4.9.1
  * Template URL: https://bootstrapmade.com/delicious-free-restaurant-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

	<!-- ======= Header ======= -->
	<%@include file="header_innerpage.jsp"%>
	<!-- End Header -->

	<main id="main">

		<!-- ======= Breadcrumbs Section ======= -->
		<section class="breadcrumbs">
			<div class="container">

				<div class="d-flex justify-content-between align-items-center">
					<h2>Community</h2>
					<ol>
						<li><a href="index.jsp">Home</a></li>
						<li>Community</li>
					</ol>
				</div>

			</div>
		</section>
		<!-- End Breadcrumbs Section -->

		<section class="inner-page">
			<div class="container">

				<div class="row">
					<div class="col">
						<h2>&nbsp;&nbsp;Community Forum</h2>
						<br>
						<table class="table table-sm table-hover">
							<thead>
								<tr>
									<th scope="col" colspan="2" style="text-align: center;">제목</th>
									<th width=150 style="text-align: center;">작성자</th>
									<th width=200 style="text-align: center;">작성일</th>
									<th width=70 style="text-align: center;">조회수</th>
									<th width=70 style="text-align: center;">좋아요</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${nList }" var="dto">
									<tr>
										<td id="left" colspan="2">&nbsp; <span
											class="badge badge badge-danger">&nbsp;&nbsp;공지&nbsp;&nbsp;</span>
											<a href="content_view.do?bId=${dto.community_id }"
											style="color: #000000;">&nbsp;&nbsp;${dto.community_title }</a>
										</td>
										<td id="left" style="text-align: center;">${dto.community_name }</td>
										<td style="text-align: center;">${dto.community_initdate }</td>
										<td style="text-align: center;">${dto.community_hit }</td>
										<td style="text-align: center;">${dto.community_cnt }</td>
									</tr>
								</c:forEach>


								<c:forEach items="${list }" var="dto">
									<tr>
										<c:if test="${dto.community_name != 'admin' }">
											<td width=70 style="text-align: center;">${dto.community_id }</td>
											<td id="left"><c:forEach begin="1"
													end="${dto.community_indent}">&nbsp;└ </c:forEach> <a
												href="content_view.do?community_id=${dto.community_id }"
												style="color: #000000;">${dto.community_title }</a></td>
											<td id="left" style="text-align: center;">${dto.community_name }</td>

											<td style="text-align: center;"><c:choose>
													<c:when test="${dto.community_updatedate eq null }">
										${dto.community_initdate }
									</c:when>
													<c:otherwise>
										${dto.community_updatedate }
									</c:otherwise>
												</c:choose></td>

											<td style="text-align: center;">${dto.community_hit }</td>
											<td style="text-align: center;">${dto.community_cnt }</td>
										</c:if>

									</tr>
								</c:forEach>
								<tr></tr>

								<tr>
									<td id="left" colspan="6">&nbsp; <c:choose>
											<c:when test="${ID != null }">
												<a href="boardwrite_view.do" class="btn"
													style="background: #F2BCBB; border: 0; padding: 2px 10px; color: #fff; transition: 0.4s; border-radius: 50px;">글쓰기</a>
											</c:when>
											<c:otherwise>
												<a href="login.jsp" class="btn"
													style="background: #F2BCBB; border: 0; padding: 2px 10px; color: #fff; transition: 0.4s; border-radius: 50px;">로그인하고
													글쓰기</a>
											</c:otherwise>
										</c:choose>
									</td>
								</tr>



								<tr>
									<td align="center" colspan="6"><c:choose>
											<c:when test="${(page.curPage - 1) < 1 }">
								[ 처음 ]
							</c:when>
											<c:otherwise>
												<a href="list.do?page=1">[ 처음 ]</a>
											</c:otherwise>
										</c:choose> <!-- 이전 --> <c:choose>
											<c:when test="${(page.curPage - 1) < 1 }">
								[ 이전 ]
							</c:when>
											<c:otherwise>
												<a href="list.do?page=${page.curPage - 1 }">[ 이전 ]</a>
											</c:otherwise>
										</c:choose> <!-- 개별 페이지 --> <c:forEach var="fEach"
											begin="${page.startPage }" end="${page.endPage }" step="1">
											<c:choose>
												<c:when test="${page.curPage == fEach}">
									[ ${fEach } ] &nbsp;
								</c:when>
												<c:otherwise>
													<a href="list.do?page=${fEach }">[ ${fEach } ]</a>&nbsp;
								</c:otherwise>
											</c:choose>
										</c:forEach> <!-- 다음 --> <c:choose>
											<c:when test="${(page.curPage + 1) > page.totalPage }">
								[ 다음 ]
							</c:when>
											<c:otherwise>
												<a href="list.do?page=${page.curPage + 1 }">[ 다음 ]</a>
											</c:otherwise>
										</c:choose> <!-- 끝 --> <c:choose>
											<c:when test="${page.curPage == page.totalPage }">
								[ 마지막 ]
							</c:when>
											<c:otherwise>
												<a href="list.do?page=${page.totalPage }">[ 마지막 ]</a>
											</c:otherwise>
										</c:choose></td>
								</tr>
							</tbody>
						</table>
						<br>

						<form action="bSearch.do" method="post"
							style="text-align: center;">
							<select name="b_opt">
								<option value="1">제목+내용</option>
								<option value="2">제목</option>
								<option value="3">내용</option>
								<option value="4">작성자</option>
							</select>&nbsp; <input type="text" name="keyword" size="20">&nbsp;
							<input type="submit" class="btn" value="검색"
								style="background: #F2BCBB; border: 0; padding: 3px 12px; color: #fff; transition: 0.4s; border-radius: 50px;">
						</form>
					</div>
				</div>
			</div>
		</section>


	</main>
	<!-- End #main -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	<!-- ======= Footer ======= -->
	<%@include file="footer.jsp"%>
	<!-- End Footer -->

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>

</body>