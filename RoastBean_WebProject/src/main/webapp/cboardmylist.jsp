<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Inner Page 샘플입니다. 관련 제목을 입력해주세요.</title>
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

  <!-- =======================================================
  * Template Name: Delicious - v4.9.1
  * Template URL: https://bootstrapmade.com/delicious-free-restaurant-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
<style type="text/css">
.star {
	font-size: 1rem;
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

  <!-- ======= Header ======= -->
	<%@include file = "header_innerpage.jsp" %>
  <!-- End Header -->

  <main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

         <div class="d-flex justify-content-between align-items-center">
			<a class="nav-link scrollto" href="mypage_order_list.do">My information</a>
			<a class="nav-link scrollto" href="myboardlist.do?page=1">My Order List</a>
			<a class="nav-link scrollto" href="mypage_info.do"><font color="8784D6" style="font-size: 1.4em; font-weight: bold;">My Write</font></a>
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
	  <div class="container">
	  		<div class="row">
		    <div class="col">
		    	<h2>&nbsp;&nbsp;${NICK } Board List</h2><br>
		    	<table class="table table-sm table-hover">
					<thead>
						<tr>
							<th scope="col" colspan="2" style="text-align: center;">제목</th>
							<th width=200 style="text-align: center;">작성일</th>
							<th width=70 style="text-align: center;">조회수</th>
							<th width=70 style="text-align: center;">좋아요</th>
						</tr>
					</thead>
					<tbody>
						
						<c:forEach items="${myboardlist }" var="dto">				
						<tr>
								<td width=70 style="text-align: center;">${dto.rownum }</td>				
								<td id="left">
									<c:forEach begin="1" end="${dto.community_indent}">&nbsp;└ </c:forEach>
									<a href="content_view.do?community_id=${dto.community_id }" style="color: #000000;">${dto.community_title }</a></td>
								<td style="text-align: center;">
									<c:choose>
									<c:when test ="${dto.community_updatedate eq null }">
										${dto.community_initdate }
									</c:when>	
									<c:otherwise>
										${dto.community_updatedate }
									</c:otherwise>	
									</c:choose>
								</td>
								
								<td style="text-align: center;">${dto.community_hit }</td>
								<td style="text-align: center;">${dto.community_cnt }</td>
							
						</tr>
						</c:forEach>
						<tr></tr>
						
						<tr>
						<td align="center" colspan="6">
						<c:choose>
							<c:when test="${(page.curPage - 1) < 1 }">
								[ 처음 ]
							</c:when>
							<c:otherwise>
								<a href="myboardlist.do?page=1&pages=<%=request.getParameter("pages") %>">[ 처음 ]</a>
							</c:otherwise>
							</c:choose>
							<!-- 이전 -->
							<c:choose>
							<c:when test="${(page.curPage - 1) < 1 }">
								[ 이전 ]
							</c:when>
							<c:otherwise>
								<a href="myboardlist.do?page=${page.curPage - 1 }&pages=<%=request.getParameter("pages") %>">[ 이전 ]</a>
							</c:otherwise>
							</c:choose>
							
							<!-- 개별 페이지 -->
							<c:forEach var="fEach" begin="${page.startPage }" end="${page.endPage }" step="1">
								<c:choose>
								<c:when test="${page.curPage == fEach}">
									[ ${fEach } ] &nbsp;
								</c:when>
								<c:otherwise>
									<a href="myboardlist.do?page=${fEach }&pages=<%=request.getParameter("pages") %>">[ ${fEach } ]</a>&nbsp;
								</c:otherwise>
								</c:choose>
							</c:forEach>
							
							<!-- 다음 -->
							<c:choose>
							<c:when test="${(page.curPage + 1) > page.totalPage }">
								[ 다음 ]
							</c:when>
							<c:otherwise>
								<a href="myboardlist.do?page=${page.curPage + 1 }&pages=<%=request.getParameter("pages") %>">[ 다음 ]</a>
							</c:otherwise>
							</c:choose>
							<!-- 끝 -->
							<c:choose>
							<c:when test="${page.curPage == page.totalPage }">
								[ 마지막 ]
							</c:when>
							<c:otherwise>
								<a href="myboardlist.do?page=${page.totalPage }&pages=<%=request.getParameter("pages") %>">[ 마지막 ]</a>
							</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</tbody>	
				</table><br>
				</div>
			</div>
	  
	  </div>
	  <div class="container">
	  		<div class="row">
		    <div class="col">
		    	<h2>&nbsp;&nbsp;${NICK } Review List</h2><br>
		    	<table class="table table-sm table-hover">
					<thead>
						<tr>
							<th width=15 style="text-align: center;">번호</th>
							<th width=15 style="text-align: center;">주문번호</th>
							<th width=150 style="text-align: center;">내용</th>
							<th width=70 style="text-align: center;">작성일</th>
							<th width=70 style="text-align: center;">평점</th>
						</tr>
					</thead>
					<tbody>
						
						<c:forEach items="${mylist}" var="dtos">				
						<tr>
								<td width=70 style="text-align: center;">${dtos.rownum}</td>		
								<td width=70 style="text-align: center;">${dtos.order_seq}</td>					
								<td id="left" style="text-align: center;">
									<a href="reviewEdit.do?order_seq=${dtos.order_seq}&review_seq=${dtos.review_seq}" style="color: #000000;">${dtos.review_content }</a></td>
								<td style="text-align: center;">
										<fmt:formatDate value="${dtos.review_date}" pattern="yyyy-MM-dd KK:mm"/>
								</td>
								
								<td style="text-align: center;">
								<c:forEach begin="1" end="${dtos.review_star}">
									<span class="star">★</span>
								</c:forEach>
								<c:forEach begin="${dtos.review_star}" end="4">
									☆
								</c:forEach></td>
							
						</tr>
						</c:forEach>
						<tr></tr>
						
						<tr>
						<td align="center" colspan="6">
						<c:choose>
							<c:when test="${(pages.curPage - 1) < 1 }">
								[ 처음 ]
							</c:when>
							<c:otherwise>
								<a href="myboardlist.do?page=<%=request.getParameter("page") %>&pages=1">[ 처음 ]</a>
							</c:otherwise>
							</c:choose>
							<!-- 이전 -->
							<c:choose>
							<c:when test="${(pages.curPage - 1) < 1 }">
								[ 이전 ]
							</c:when>
							<c:otherwise>
								<a href="myboardlist.do?page=<%=request.getParameter("page") %>&pages=${pages.curPage - 1 }">[ 이전 ]</a>
							</c:otherwise>
							</c:choose>
							
							<!-- 개별 페이지 -->
							<c:forEach var="fEach" begin="${pages.startPage }" end="${pages.endPage }" step="1">
								<c:choose>
								<c:when test="${pages.curPage == fEach}">
									[ ${fEach } ] &nbsp;
								</c:when>
								<c:otherwise>
									<a href="myboardlist.do?page=<%=request.getParameter("page") %>&pages=${fEach }">[ ${fEach } ]</a>&nbsp;
								</c:otherwise>
								</c:choose>
							</c:forEach>
							
							<!-- 다음 -->
							<c:choose>
							<c:when test="${(pages.curPage + 1) > pages.totalPage }">
								[ 다음 ]
							</c:when>
							<c:otherwise>
								<a href="myboardlist.do?page=<%=request.getParameter("page") %>&pages=${pages.curPage + 1 }">[ 다음 ]</a>
							</c:otherwise>
							</c:choose>
							<!-- 끝 -->
							<c:choose>
							<c:when test="${pages.curPage == pages.totalPage }">
								[ 마지막 ]
							</c:when>
							<c:otherwise>
								<a href="myboardlist.do?page=<%=request.getParameter("page") %>&pages=${pages.totalPage }">[ 마지막 ]</a>
							</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</tbody>	
				</table><br>
				</div>
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