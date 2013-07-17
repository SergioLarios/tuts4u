<%@ include file="../header/basic-header.jsp" %>

<section class="container">

	<div class="content-wrapper">

		<!-- ********** Normal Login ********** -->
		<c:if test="${view.type == 0}">
			<%@ include file="../include/login_include.jsp"%>
		</c:if>
		
		<!-- ********** SUCCEESS ********** -->
		<c:if test="${view.type == 1}">
			<div style="border: 2px solid green; padding: 5px;">${view.message}</div>
		</c:if>
		
		<!-- ********** FAIL ********** -->
		<c:if test="${view.type == 2}">
			<div style="border: 2px solid red; padding: 5px;">${view.message}</div>
		</c:if>

	</div>
	
</section>

<%@ include file="../footer/basic-footer.jsp" %>