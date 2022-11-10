<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h2>제품 등록하기</h2>
		&nbsp;&nbsp;&nbsp;
	</div>
	<form action="ManageProductListInsert1.do" method="post" name="Member">
	   <table style="margin-left: auto; margin-right: auto;">
	      <tr>
	         <td align=center>원두 설명</td>
	         <td><input type="text" name="category_type" size="40"></td>
	      </tr>
	      <tr> 
	         <td align=center>산미</td>
	         <td>
	            <select name="category_acidity" style="WIDTH: 210pt; HEIGHT: 18pt">
	               <option value="미선택" selected="selected" >미선택</option>
	               <option value="1">1</option>
	               <option value="1.5">1.5</option>
	               <option value="2">2</option>
	               <option value="2.5">2.5</option>
	               <option value="3">3</option>
	               <option value="3.5">3.5</option>
	               <option value="4">4</option>
	               <option value="4.5">4.5</option>
	               <option value="5">5</option>
	            </select>
	         </td>
	      </tr>
	      <tr> 
	         <td align=center>바디감</td>
	         <td>
	            <select name="category_body" style="WIDTH: 210pt; HEIGHT: 18pt">
	               <option value="미선택" selected="selected">미선택</option>
	               <option value="1">1</option>
	               <option value="1.5">1.5</option>
	               <option value="2">2</option>
	               <option value="2.5">2.5</option>
	               <option value="3">3</option>
	               <option value="3.5">3.5</option>
	               <option value="4">4</option>
	               <option value="4.5">4.5</option>
	               <option value="5">5</option>
	            </select>
	         </td>
	      </tr>
	      <tr> 
	         <td align=center>단맛</td>
	         <td>
	            <select name="category_sweet" style="WIDTH: 210pt; HEIGHT: 18pt">
	               <option value="미선택" selected="selected">미선택</option>
	               <option value="1">1</option>
	               <option value="1.5">1.5</option>
	               <option value="2">2</option>
	               <option value="2.5">2.5</option>
	               <option value="3">3</option>
	               <option value="3.5">3.5</option>
	               <option value="4">4</option>
	               <option value="4.5">4.5</option>
	               <option value="5">5</option>
	            </select>
	         </td>
	      </tr>
	      <tr> 
	         <td align=center>아로마</td>
	         <td>
	            <select name="category_aroma" style="WIDTH: 210pt; HEIGHT: 18pt">
	               <option value="미선택" selected="selected">미선택</option>
	               <option value="1">1</option>
	               <option value="1.5">1.5</option>
	               <option value="2">2</option>
	               <option value="2.5">2.5</option>
	               <option value="3">3</option>
	               <option value="3.5">3.5</option>
	               <option value="4">4</option>
	               <option value="4.5">4.5</option>
	               <option value="5">5</option>
	            </select>
	         </td>
	      </tr>
	        <tr>
	         <td></td>
	         <td><input type="submit" value="저장하기" style="WIDTH: 210pt; HEIGHT: 18pt"></td>
	      </tr>
	      <tr></tr>
	          <tr>
	         <td></td>
	         <td align=center>
	            <a href="ManageProductList.do" style="text-decoration:none">상품리스트로 돌아가기</a><br>
	            <a href="manage_main.jsp" style="text-decoration: none;">관리자 홈으로 돌아가기</a>
	         </td>
	      </tr>
	   </table>
	</form>
</body>
</html>