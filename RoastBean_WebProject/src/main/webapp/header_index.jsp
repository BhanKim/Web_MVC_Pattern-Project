<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<!-- ======= Top Bar ======= -->
<section id="topbar"
	class="d-flex align-items-center fixed-top topbar-transparent">
	<div
		class="container-fluid container-xl d-flex align-items-center justify-content-center justify-content-lg-start">
		<i class="bi bi-phone d-flex align-items-center"><span>02-7157-7557</span></i>
		<i class="bi bi-clock ms-4 d-none d-lg-flex align-items-center"><span>Mon-Sat: 10:00 AM - 18:00 PM</span></i>
	</div>
</section>

<!-- ======= Header ======= -->
<header id="header" class="fixed-top d-flex align-items-center header-transparent">
	<div class="container-fluid container-xl d-flex align-items-center justify-content-between">
		<div class="col-lg-4">
			<h1>
				<a href="index.jsp"><img src="assets/img/logo.png" alt="" class="img-fluid" width="320" height="72"></a>
			</h1>
		</div>
		<nav id="navbar" class="navbar order-last order-lg-0">
			<c:if test="${ID == null }">
				<ul>
					<li class="dropdown"><a href="#about"><span>ABOUT</span></a>
						<ul>
							<li><a href="companyinfo.jsp">Information</a></li>
							<li><a href="companylocation.jsp">Location</a></li>
						</ul>
					<li><a class="nav-link scrollto" href="list.do?page=1">COMMUNITY</a></li>
					<li><a class="nav-link scrollto" href="beaninfo.do">BEAN INFORMATION</a></li>
					<li><a class="nav-link scrollto" href="productList.do?page=1">COFFEE SHOP</a></li>
					<li class="dropdown"><a href="#customer_service"><span>CUSTOMER SERVICE</span></a>
						<ul>
							<li><a href="#notice">NOTICE</a></li>
							<li><a href="#faq">FAQ</a></li>
							<li><a href="#qna">QnA</a></li>
						</ul>
					<li>&emsp;&emsp;&emsp;</li>
					<li></li>
					<li><a class="nav-link scrollto" href="login.jsp"><font color="#F2BCBB" style="font-size: 1.1em">Get Started</font></a></li>
				</ul>
			</c:if>	
			
			<!-- success login -->
			<c:if test="${ID != null }">
				<ul>
					<li><a class="nav-link scrollto" href="#about">ABOUT</a></li>
					<li><a class="nav-link scrollto" href="list.do?page=1">COMMUNITY</a></li>
					<li><a class="nav-link scrollto" href="beaninfo.do">BEAN INFORMATION</a></li>
					<li><a class="nav-link scrollto" href="productList.do?page=1">COFFEE SHOP</a></li>
					<li class="dropdown"><a href="#customer_service"><span>CUSTOMER SERVICE</span></a>
						<ul>
							<li><a href="#notice">NOTICE</a></li>
							<li><a href="#faq">FAQ</a></li>
							<li><a href="#qna">QnA</a></li>
						</ul>
					</li>
					<li>&emsp;&emsp;&emsp;</li>
					<li><a class="nav-link scrollto" href="mypage_info.do"><font color="#F2BCBB" style="font-size: 0.9em">${NICK}님</font></a></li>
					<c:if test="${ADMIN != null}">
						<li><a class="nav-link scrollto" href="UserListSelect.do"><font color="#F2BCBB" style="font-size: 0.9em">Manage</font></a></li>
					</c:if>
				<c:choose>
					<c:when test="${API eq null}">
						<li><a class="nav-link scrollto" href="logout.do"><font style="font-size: 0.9em">Logout</font></a></li>
					</c:when>
					<c:otherwise>
						<li><a class="nav-link scrollto" href="logout.do" onclick="signOut()"><font style="font-size: 0.9em">Logout</font></a></li>
					</c:otherwise>
				</c:choose>
				</ul>
			</c:if>	
			<i class="bi bi-list mobile-nav-toggle"></i>
		</nav>
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