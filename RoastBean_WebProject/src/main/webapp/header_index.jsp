<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<!-- ======= Top Bar ======= -->
<section id="topbar"
	class="d-flex align-items-center fixed-top topbar-transparent">
	<div
		class="container-fluid container-xl d-flex align-items-center justify-content-center justify-content-lg-start">
		<i class="bi bi-phone d-flex align-items-center"><span>02-3687-7577</span></i>
		<i class="bi bi-clock ms-4 d-none d-lg-flex align-items-center"><span>Mon-Sat:
				10:00 AM - 18:00 PM</span></i>
	</div>
</section>

<!-- ======= Header ======= -->
<header id="header"
	class="fixed-top d-flex align-items-center header-transparent">
	<div
		class="container-fluid container-xl d-flex align-items-center justify-content-between">

		<div>
			<h1>
				<a href="index.jsp"><img src="assets/img/logo.png" alt=""
					class="img-fluid" width="320" height="72"></a>
			</h1>
		</div>
		<nav id="navbar" class="navbar order-last order-lg-0">
			<c:if test="${ID == null }">
				<ul>
			
				<li><a class="nav-link scrollto" href="#about">ABOUT</a></li>
				
				<li><a class="nav-link scrollto" href="list.do?page=1">COMMUNITY</a></li>
				
				<li><a class="nav-link2 scrollto" href="beaninfo.do">BEAN 
						INFORMATION</a></li>
						
				<li><a class="nav-link2 scrollto" href="#coffee_shop">COFFEE
						SHOP</a></li>
						
				<li class="dropdown"><a href="#customer_service"><span>CUSTOMER
							SERVICE</span></a>
					<ul>
						<li><a href="#notice">NOTICE</a></li>
						<li><a href="#faq">FAQ</a></li>
						<li><a href="#qna">QnA</a></li>
				</ul>
				<li>&emsp;&emsp;&emsp;</li>
				<li></li>
				<li><a class="nav-link scrollto" href="login.jsp"><font
						color="#F2BCBB" style="font-size: 0.9em">Login</font></a></li>
				<li><a class="nav-link scrollto" href="signup.jsp"><font
						style="font-size: 0.9em">Sign Up</font></a></li>
			</c:if>	
			
						<!-- success login -->
			<c:if test="${ID != null }">
				<ul>
			
				<li><a class="nav-link scrollto" href="#about">ABOUT</a></li>
				
				<li><a class="nav-link scrollto" href="list.do?page=1">COMMUNITY</a></li>
				
				<li><a class="nav-link2 scrollto" href="beaninfo.do">BEAN 
						INFORMATION</a></li>
						
				<li><a class="nav-link2 scrollto" href="#coffee_shop">COFFEE
						SHOP</a></li>
						
				<li class="dropdown"><a href="#customer_service"><span>CUSTOMER
							SERVICE</span></a>
					<ul>
						<li><a href="#notice">NOTICE</a></li>
						<li><a href="#faq">FAQ</a></li>
						<li><a href="#qna">QnA</a></li>
				</ul>
				<li>&emsp;&emsp;&emsp;</li>
				
				<li><font color="#F2BCBB" style="font-size: 0.9em">${ID } 님</font></li>
					<c:if test="${ID == 'admin' }">
				<li><a class="nav-link scrollto" href="ManageMain.do"><font
						color="#F2BCBB" style="font-size: 0.9em">Manage</font></a></li>
					</c:if>
				<li><a class="nav-link scrollto" href="logout.do"><font
						color="#F2BCBB" style="font-size: 0.9em">Logout</font></a></li>
				<li><a class="nav-link scrollto" href="#event"><font
						style="font-size: 0.9em">My Page</font></a></li>
			</c:if>	

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

			</ul>
			<i class="bi bi-list mobile-nav-toggle"></i>
		</nav>
		<!-- .navbar -->
	</div>
	<!-- Google Login API -->
	<script>
	    function signOut() {
	        google.accounts.id.disableAutoSelect();
	        // do anything on logout
	        location.reload();
    		//document.location = "index.jsp";
	    }
	</script>
	<script src="https://accounts.google.com/gsi/client" async defer></script>
    
</header>
<!-- End Header -->
