<%@ include file="../init.jsp" %>
<html>
<head>
	
	<%-- CSS List --%>
	<link rel="stylesheet" type="text/css" href="/resource/style/main.css"/>
	
	<%-- JS List --%>
	<script type="text/javascript" src="/resource/js/main.js"></script>
	
	<%-- Title --%>
	<title>${view.title}</title>
	
</head>
<body>

	<section class="header">
	
		<%-- Logo --%>
		<div class="header-logo">
			<a href="/"><img alt="logo" src="/resource/img/header/Logo_Tuts4u.png" /></a>
		</div>
	
		<%-- Navigation --%>
		<nav class="header-nav">
			<ul class="nav">
				<li class="active"><a href="index.html" title="Home">Home</a></li>
				<li><a href="index.html" title="Explore">Explore</a></li>
				<li><a href="index.html" title="How to">How to</a></li>
				<li><a href="index.html" title="About">About</a></li>
			</ul>
		</nav>
		
		<%-- User box --%>
		<div class="user-box">
			<c:if test="${sessionScope.user.type == 0}">
				<spring:message code="header.user-guest"/>
			</c:if>
			<c:if test="${sessionScope.user.type != 0}">
				<spring:message code="header.user-logged" arguments="${sessionScope.user.userName}"/>
			</c:if>
		</div>		
		
		<%-- Search Box --%>
		<form action="index.html" method="post" class="search">
			<input type="text" placeholder="Search..." name="q">
		</form>

		<span class="clear"></span>
	</section>

