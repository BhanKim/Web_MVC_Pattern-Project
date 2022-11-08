<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<input type="text" id="sample4_postcode" readonly="true" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample4_roadAddress" readonly="true" placeholder="도로명주소">
<input type="text" id="sample4_jibunAddress" readonly="true" placeholder="지번주소">
<span id="guide" style="color:#999;display:none"></span><br>
<input type="text" id="sample4_detailAddress" placeholder="상세주소">

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
 

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            }
        }).open();
    }
</script>



jsp

<div class="container">
    <div class="row">
       <div class="col" style="text-align:center;"><br>
          <h1>회원가입</h1><br>
         <form action="joinOk.doU" method="post" name="reg_frm">
         <!-- 완벽한 기입을 완료했을 때 joinOk.doU로 넘어가겠다고 선언 -->
            아이디<br><input type="text" name="id" size="25"><br><br>
            비밀번호<br><input type="password" name="pw" size="25"><br><br>
            비밀번호 확인<br><input type="password" name="pw_check" size="25"><br><br>
            이름<br><input type="text" name="name" size="25"><br><br>
            본인 확인 이메일<br><input type="text" name="eMail" size="25"><br><br>
            주소<br><input type="text" name="address" size="50"><br><br>
            <input type="button" class="btn btn-outline-primary" value="가입하기" onclick="infoConfirm()">&nbsp;&nbsp;
            <!-- memberdao에 있음 members.js로 회원 인적사항을 확인하는 검사를 진행하고 넘어감 -->
            <input type="button" class="btn btn-outline-primary" value="로그인" onclick="javascript:window.location='login.jsp'">
            <!-- login.jsp로 넘어가겠다고 선언 -->
         </form><br>
         <img src="./img/Eclipse-luna.png" alt="이클립스" width="100">&nbsp;
         <img src="./img/1_zKnKunxf74dpaMMtcKrB9g.png" alt="jsp/servlet" width="170">&nbsp;
         <img src="./img/1508213062.563510_.png" alt="오라클" width="170">&nbsp;
         <img src="./img/sql-developer.png" alt="오라클" width="220">
       </div>
    </div>
</div>


<script>
//인적사항, 입력사항 확인하기 위한 javascript

function infoConfirm() {
 if(document.reg_frm.id.value.length == 0) {
    alert("아이디는 필수사항입니다.");
    reg_frm.id.focus();
    return;
 }
 
 if(document.reg_frm.id.value.length < 4) {
    alert("아이디는 4글자 이상이어야 합니다.");
    reg_frm.id.focus();
    return;
 }
 
 if(document.reg_frm.pw.value.length == 0) {
    alert("비밀번호는 필수사항입니다.");
    reg_frm.pw.focus();
    return;
 }
 
 if(document.reg_frm.pw.value != document.reg_frm.pw_check.value) {
    alert("비밀번호가 일치하지 않습니다.");
    reg_frm.pw.focus();
    return;
 }
 
 if(document.reg_frm.name.value.length == 0) {
    alert("이름은 필수사항입니다.");
    reg_frm.name.focus();
    return;
 }
 
 if(document.reg_frm.eMail.value.length == 0) {
    alert("메일은 필수사항입니다.");
    reg_frm.eMail.focus();
    return;
 }
 
 document.reg_frm.submit();   
}

function updateInfoConfirm() {
 if(document.reg_frm.pw.value == "") {
    alert("비밀번호를 입력하세요.");
    document.reg_frm.pw.focus();
    return;
 }
 
 if(document.reg_frm.pw.value != document.reg_frm.pw_check.value) {
    alert("비밀번호가 일치하지 않습니다.");
    reg_frm.pw.focus();
    return;
 }
 
 if(document.reg_frm.eMail.value.length == 0) {
    alert("메일은 필수사항입니다.");
    reg_frm.eMail.focus();
    return;
 }
 
 document.reg_frm.submit();
}



</script>








</body>
</html>