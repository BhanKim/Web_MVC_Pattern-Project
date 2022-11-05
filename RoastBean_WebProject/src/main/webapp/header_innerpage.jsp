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
				<li><a class="nav-link scrollto" href="#about">ABOUT</a></li>
				<li><a class="nav-link scrollto" href="#community">COMMUNITY</a></li>
				<li><a class="nav-link2 scrollto" href="#coffee_information">COFFEE
						INFORMATION</a></li>
				<li><a class="nav-link2 scrollto" href="#coffee_shop">COFFEE
						SHOP</a></li>
				<li class="dropdown"><a href="#customer_service"><span>CUSTOMER
							SERVICE</span></a>
					<ul>
						<li><a href="#notice">NOTICE</a></li>
						<li><a href="#faq">FAQ</a></li>
						<li><a href="#qna">QnA</a></li>

						<!-- <li><a href="#">Drop Down 4</a></li>
              <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li> -->

					</ul> <%
			if (session.getAttribute("cId")==null) {
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
				<li><a class="nav-link scrollto" href="mypage_main.rb"><font
						color="#F2BCBB" style="font-size: 0.9em">Welcome
							${user_id}!</font></a></li>
				<li><a class="nav-link scrollto" href="cart.rb"><font
						style="font-size: 0.9em">Cart</font></a></li>
				<li><a class="nav-link scrollto" href="logout.rb"><font
						style="font-size: 0.9em">Log Out</font></a></li>
				<%
           	}
%>
			</ul>
			<i class="bi bi-list mobile-nav-toggle"></i>
		</nav>
		<!-- .navbar -->
	</div>
</header>
<!-- End Header -->
