<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action = "JoinService" method = "post">
	<table>
		<tr>
		<td>ID</td>
		<td>
			<input type = "text" name = "id" class = "input_id">
			<font id = "checkId" size = "2"></font>
		</td>
		</tr>		
	</table>
</form>

<script src = "js/jquery-3.6.0.min.js"></script>
<script>
	$('.input_id').focusout(function(){
		let userId = $('.input_id').val(); // input_id에 입력되는 값
		
		$.ajax({
			url : "IdCheckService",
			type : "post",
			data : {userId: userId},
			dataType : 'json',
			success : function(result){
				if(result == 0){
					$("#checkId").html('사용할 수 없는 아이디입니다.');
					$("#checkId").attr('color','red');
				} else{
					$("#checkId").html('사용할 수 있는 아이디입니다.');
					$("#checkId").attr('color','green');
				} 
			},
			error : function(){
				alert("서버요청실패");
			}
		})
		 
	})
 </script>


</body>
</html>