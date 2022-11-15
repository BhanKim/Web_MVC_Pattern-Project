<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- ======= Top Bar ======= -->
<section id="topbar" class="d-flex align-items-center fixed-top ">
	<div
		class="container-fluid container-xl d-flex align-items-center justify-content-center justify-content-lg-start">
		<i class="bi bi-phone d-flex align-items-center"><span>02-3687-7577</span></i>
		<i class="bi bi-clock ms-4 d-none d-lg-flex align-items-center"><span>Mon-Sat:
				10:00 AM - 18:00 PM</span></i>
	</div>
</section>
<!-- ======= Header ======= -->
<header id="header" class="fixed-top d-flex align-items-center ">
	<div
		class="container-fluid container-xl d-flex align-items-center justify-content-between">
		<div class="col-lg-4">
			<h1>
				<a href="index.jsp"><img src="assets/img/logo.png" alt=""
					class="img-fluid" width="320" height="72"></a>
			</h1>
		</div>
		<nav id="navbar" class="navbar order-last order-lg-0">
			<ul>
				<li class="dropdown"><a class="nav-link scrollto" href="ManageMain.do">MANAGE MAIN</a>
					<ul>
						<li><a href="manage_chart.do">CHART</a></li>
					</ul> 
				
				<li><a class="nav-link scrollto" href="UserListSelect.do">USER LIST</a></li>
				
				<li class="dropdown"><a href="ManageProductList.do"><span>PRODUCT LIST</span></a>
				   <ul>
				      <li><a href="manage_product_insert.jsp">PRODUCT INSERT</a></li>
				   </ul>
				
				<li><a class="nav-link2 scrollto" href="ManageOrdersList.do">ODERS LIST</a></li>
				<!-- order list.do 입력 -->
				
				<!-- <li><a class="nav-link2 scrollto" href="#coffee_shop">통계</a></li> -->
				
				<li class="dropdown"><a href="#customer_service"><span>CUSTOMER SERVICE</span></a>
					<ul>
						<li><a href="cs_notice.jsp">NOTICE</a></li>
						<li><a href="#faq">FAQ</a></li>
						<li><a href="#qna">QnA</a></li>
					</ul> 
					
					<%
					if (session.getAttribute("ID")==null) {
%>
				<li>&emsp;&emsp;&emsp;</li>
				<li></li>
				<li><a class="nav-link scrollto" href="login.jsp"><font
						color="#F2BCBB" style="font-size: 0.9em">Login</font></a></li>
				<li><a class="nav-link scrollto" href="signup.jsp"><font
						style="font-size: 0.9em">Sign Up</font></a></li>
				<%
          	} else {
%>
				<li>&emsp;&emsp;&emsp;</li>
				<li><a class="nav-link scrollto" href="mypage_main.do"><font
						color="#F2BCBB" style="font-size: 0.9em">${ID}</font></a></li>
				<li><a class="nav-link scrollto" href="cart.do"><font
						style="font-size: 0.9em">Cart</font></a></li>
<%
				if(session.getAttribute("API")==null){
%>
					<li><a class="nav-link scrollto" href="logout.do"><font
							style="font-size: 0.9em">Log Out</font></a></li>
<%					
					}else{
%>						
					<li><a class="nav-link scrollto" href="logoutApi.do"><font
							style="font-size: 0.9em">Log Out</font></a></li>
<%
					}
           	}
%>
			</ul>
			<i class="bi bi-list mobile-nav-toggle"></i>
		</nav>
		<!-- .navbar -->
	</div>
</header>
<!-- End Header -->
