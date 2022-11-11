<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Content View Page</title>
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

	<%@include file="header_innerpage.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col">
				<br> <br> <br> <br> <br> <br> <br>
				<br>
				<h2>&nbsp;&nbsp;자유게시판</h2>
				<br>
				<table class="table table-sm table-bordered" border="1">
					<thead>
						<tr>
							<th id="left" style="font-size: 23px; padding: 10px;">${content_view.community_title }</th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td id="left" style="font-size: 14px; padding: 10px;">
								<form action="boardlike.do" method="post">
									<span style="font-size: 17px; font-weight: bold;">${content_view.community_name }</span>&nbsp;&nbsp;
									${content_view.community_initdate }<br>
									조회&nbsp;${content_view.community_hit }&nbsp;&nbsp; 
									<input type="hidden" name="community_id" value="${content_view.community_id }"> 
									<input type="hidden" name="community_name" value="${ID }"> 
									<input type="submit" class="btn btn-outline-danger"	value="♥ 좋아요 ${content_view.community_cnt }" style="padding: 0px 4px; font-size: 13px">
								</form>
							</td>
						</tr>
						<tr>
							<td id="left" style="padding: 20px">${content_view.community_content }</td>
						</tr>
						<tr>
							<td id="left" style="padding: 10px"><c:choose>
									<c:when test="${ID != null }">
										<a href="boardwrite_view.do" class="btn btn-success"
											style="padding: 2px 10px">글쓰기</a>
										<a
											href="reply_view.do?community_id=${content_view.community_id }"
											class="btn btn-secondary" style="padding: 2px 10px"> 답글</a>
									</c:when>
									<c:otherwise>
										<a href="login.jsp" class="btn btn-success"
											style="background: #F2BCBB; border: 0; padding:2px 10px; color: #fff; transition: 0.4s; border-radius: 50px; ">로그인하고 글쓰기</a>
									</c:otherwise>
								</c:choose> <c:if test="${ID == content_view.community_name }">
									<a
										href="modify_view.do?community_id=${content_view.community_id }"
										class="btn btn-secondary" style="padding: 2px 10px"> 수정</a>
									<a
										href="communitydelete.do?community_id=${content_view.community_id }"
										class="btn btn-secondary" style="padding: 2px 10px"> 삭제</a>
								</c:if> <a href="list.do?page=<%=session.getAttribute("cpage")%>"
								class="btn btn-secondary" style="padding: 2px 10px"> 목록</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <c:if test="${ID == 'admin' }">
									<a
										href="communitydelete.do?community_id=${content_view.community_id }"
										class="btn btn-danger" style="padding: 2px 10px"> (관리자) 삭제</a>
								</c:if></td>
						</tr>
					</tbody>
				</table>
				<hr>



				<table class="table table-sm">
					<thead>
						<tr>
							<th colspan="5" style="font-size: 20px; text-align: left;">댓글</th>
						</tr>
					</thead>
					<c:forEach items="${cList }" var="dto">
						<tbody>
							<tr>
								<td width="150">${dto.community_comment_name }</td>
								<td style="text-align: left">&nbsp;${dto.community_comment_content }</td>
								<td width="100"><c:if
										test="${ID == dto.community_comment_name }">
										<form id="coModifySet" style="display: block;">
											<input type="button" class="btn btn-primary mb-1" value="수정" onclick="coModifyOn()"
												class="btn btn-light" style="padding: 2px 10px">
										</form>
										<form action="coModify.do" method="post" id="coModifyDo"
											style="display: none;">
											<textarea name="community_comment_content" rows="2" cols="50">${dto.community_comment_content }</textarea>
											<input type="hidden" name="community_id" value="${content_view.community_id }"> 
											<input type="hidden" name="community_comment_cono" value="${dto.community_comment_cono }"> 
											<input type="submit" value="수정" onclick="coModifyOut()" class="btn btn-success" style="padding: 2px 10px"> 
											<input type="button" value="취소" onclick="coModifyOut()" class="btn btn-light" style="padding: 2px 10px">
										</form>
										<form action="coDelete.do" method="post" id="coModifyDo2"
											style="display: block;">
											<input type="hidden" name="community_id" value="${content_view.community_id }"> 
											<input type="hidden" name="community_comment_cono" value="${dto.community_comment_cono }"> 
											<input type="submit" value="삭제" class="btn btn-danger" style="padding: 2px 10px">
										</form>
									</c:if></td>
								<td width="100" style="font-size: 12px;">${dto.community_comment_codate }</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
				<br>
				<c:if test="${ID != null }">
					<form action="coWrite.do" method="post" style="text-align: center;">
						<input type="hidden" name="community_id" value="${content_view.community_id }"> 
						<input type="hidden" name="community_comment_name" value="${ID } }">
						<textarea name="community_comment_content" rows="4" cols="120" placeholder="${ID }님 댓글을 작성해주세요"></textarea>
						&nbsp;<input type="submit" value="등록" class="btn btn-outline-dark"	style="padding: 2px 10px"><br>
						<br>
					</form>
				</c:if>
			</div>
		</div>
	</div>

	<script>
		function coModifyOn() {
			$('#coModifySet').css('display', 'none');
			$('#coModifyDo').css('display', 'block');
			$('#coModifyDo2').css('display', 'none');
		}

		function coModifyOut() {
			$('#coModifySet').css('display', 'block');
			$('#coModifyDo').css('display', 'none');
			$('#coModifyDo2').css('display', 'block');
		}
	</script>



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
</html>