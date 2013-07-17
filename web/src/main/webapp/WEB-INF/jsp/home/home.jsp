<%@ include file="../header/basic-header.jsp"%>

<section class="container">

	<div class="content-wrapper">
	
		<h1 class="home-h1"><spring:message code="home.main"/></h1>
		
		<div class="home-credentials" >
			<div class="box">
				<%@ include file="../include/login_include.jsp"%>
			</div>
			<div class="box">
				<%@ include file="../include/registrer_include.jsp"%>
			</div>
			<div class="clear"></div>
		</div>
		
	</div>
	
</section>

<%@ include file="../footer/basic-footer.jsp"%>