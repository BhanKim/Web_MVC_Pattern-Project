<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.*"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>CHART</title>
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
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
<script type="text/javascript">
	window.onload = function() {
<%String dataPoints = null;
  String dataPoints2 = null;
	dataPoints = String.valueOf((request.getAttribute("chartList")));
	dataPoints2 = String.valueOf((request.getAttribute("chartList2")));
	out.print(dataPoints);
	out.print(dataPoints2);
	

if (dataPoints != null) {%>
	var chart = new CanvasJS.Chart("chartContainer", {
			animationEnabled : true,
			exportEnabled : true,
			title : {
				text : "사이트 방문 횟수 대비 매출액 차트",
			},
			axisX : [ {
				title : "일별 사이트 방문 횟수",
				titleFontColor : "#eabebc",
				lineColor : "#eabebc",
				tickColor : "#eabebc",
				labelFontColor : "#eabebc",
				valueFormatString : "##/##",
				interval : 1,
			}, {
				title : "일별 매출액 (천원)",
				titleFontColor : "#8684d0",
				lineColor : "#8684d0",
				tickColor : "#8684d0",
				labelFontColor : "#8684d0",
				valueFormatString : "##/##",
				interval : 1,
			} ],

			data : [ {
				type : "column",
				color : "#eabebc",
				axisXIndex : 0,
				dataPoints :
<%out.print(dataPoints);%>
	,
			}, {
				type : "column",
				axisXIndex : 1, //defaults to 0
				color : "#8684d0",
				dataPoints :
<%out.print(dataPoints2);%>
	}

			

			]
		});

		chart.render();
<%}%>
	}
</script>
</head>
<body>
<%@include file="header_manage.jsp"%>
	<br><br><br><br><br><br>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<br><br>
	<%@include file="footer.jsp"%>
		
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>
