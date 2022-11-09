<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 복사해서 사용하기 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body link="black" vlink="black" alink="navy">
<div style="text-align: center;">
		<br>
		<br> &nbsp;&nbsp;&nbsp;
		<h2>상품정보 리스트</h2>
		&nbsp;&nbsp;&nbsp;
		
		<form action="product_manage_search.do">
		   <br>
		   검색
		   <select name="query">
		      <option value="product_name">브랜드명</option>
		      <option value="product_nation">국가명</option>
		   </select>&nbsp;&nbsp;&nbsp;
		   <input type="text" name="content">
		   <input type="submit" value="검색">
		</form>
		<br>
		<br>
		
		<table style="margin-left: auto; margin-right: auto;" border="1">
		<tr>
		   <th>numder</th>
		   <th>name</th>
		   <th>nation</th>
		   <th>image</th>
		   <th>info</th>
		   <th>stock</th>
		   <th>weight</th>
		   <th>price</th>
		   <th>수정</th>
		   <th>삭제</th>
		</tr>
		<c:forEach items="${product_manage}" var="dto">
		   <tr>
		      <td>${dto.product_id }</td>
		      <td>${dto.product_name }</td>
		      <td>${dto.product_nation }</td>
		      <td><img src="assets/img/product/${dto.product_image }" width="180px" height="200px"></td>
		      <td>${dto.product_info }</td>
		      <td>${dto.product_stock }</td>
		      <td>${dto.product_weight }</td>
		      <td>${dto.product_price }</td>		    
		      <td><a href="product_select_update.do?product_id=${dto.product_id }" style="text-decoration:none">수정</a></td>		    
		      <td><a href="product_delete.do?product_id=${dto.product_id }" style="text-decoration:none">삭제</a></td>		    	    
		   </tr>
		</c:forEach>
		</table>
		<a href="product_insert.do" style="text-decoration:none">상품등록하기</a><br>
	    <a href="###.jsp" style="text-decoration:none">홈으로 돌아가기</a>
</div>

</body>
</html>