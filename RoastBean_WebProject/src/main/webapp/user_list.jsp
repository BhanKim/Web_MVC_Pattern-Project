<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body link="black" vlink="black" alink="navy">
	<div style="text-align: center;">
	   <br>
	   <br> 
	      &nbsp;&nbsp;&nbsp;<h2>회원정보 리스트</h2>&nbsp;&nbsp;&nbsp;
	      
	      <table style="margin-left: auto; margin-right: auto;" border="1">
	         <tr>
		        <td>아이디</td>
		        <td>비밀번호</td>
		        <td>이름</td>
		        <td>생년월일</td>
		        <td>성별</td>
		        <td>이메일</td>
		        <td>전화번호</td>
		     </tr>
		     <c:forEach items="${userlist}" var="dto">
		      <tr>
		         <td>${dto.user_id }</td>
		         <td>${dto.user_pw }</td>
		         <td>${dto.user_name }</td>
		         <td>${dto.user_birthdate }</td>
		         <td>${dto.user_gender }</td>
		         <td>${dto.user_email }</td>
		         <td>${dto.user_telno }</td>		      
		      </tr>
		      </c:forEach>
	      </table>
	      <br>
	      <br>
	      <a href="product_main.jsp" style="text-decoration:none">홈으로 돌아가기</a>
	</div>
</body>
</html>