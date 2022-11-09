 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: center;">
		<br>
		<br> &nbsp;&nbsp;&nbsp;
		<h2>상품 수정하기</h2>
		&nbsp;&nbsp;&nbsp;
	</div>
	
	<form action="product_update.do" method="post">
	   
	   <table style="margin-left: auto; margin-right: auto;">
	      <tr>
	         <td>상품번호</td>
	         <td><input type="text" name="product_id" size="40" value="${product_select.product_id }" readonly="readonly"></td>
	      </tr>
	      <tr>
	         <td>제품명</td>
	         <td><input type="text" name="product_name" size="40" value="${product_select.product_name }"></td>
	      </tr>
	      <tr>
	         <td>원산지</td>
	         <td>
	           <select name="product_nation">
	               <option value="미선택" selected="selected" value="${product_select.product_nation }">${product_select.product_nation }</option>
	               <option value="케냐">케냐</option>
	               <option value="에티오피아">에티오피아</option>
	               <option value="멕시코">멕시코</option>
	               <option value="콜롬비아">콜롬비아</option>
	            </select>
	         </td>
	      </tr> 
	      <tr>
	         <td>제품 이미지</td>
	         <td><img src="assets/img/product/${product_select.product_image }" width="300px" height="200px"></td>
	      </tr>
	      <tr>
	         <td></td>
	         <td><input type="file" name="product_image" size="40"></td>
	      </tr>
	      <tr>
	         <td>제품 설명</td>
	         <td><textarea rows="10" cols="32" name="product_info" value = "${product_select.product_info}"></textarea></td>
	      </tr>
	      <tr>
	         <td>제품 수량</td>
	         <td><input type="text" name="product_stock" size="40" value="${product_select.product_stock }"></td>
	      </tr>
	      <tr>
	         <td>제품 중량</td>
	         <td><input type="text" name="product_weight" size="40" value="${product_select.product_weight }"></td>
	      </tr>
	      <tr>
	         <td>제품 가격</td>
	         <td><input type="text" name="product_price" size="40" value="${product_select.product_price }"></td>
	      </tr>
	     
	      <tr>
	         <td></td>
	         <td><input type="submit" value="저장하기"></td>
	      </tr>
	   </table>
	</form>
</body>
</html>