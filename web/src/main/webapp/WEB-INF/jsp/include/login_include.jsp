<%@ include file="../init.jsp" %>

<div class="login">

	<h1><spring:message code="login.header"/></h1>

	<form action="<%=Mappings.LOGIN%>" method="post">
	
		<%-- ----- User Mail ----- --%>
		<p>
			<input type="text" name="<%=LoginForm.USER_MAIL%>" value="" 
				placeholder="<spring:message code="login.placeholder.email"/>">
		</p>
		
		<%-- ----- Password ----- --%>
		<p>
			<input type="password" name="<%=LoginForm.USER_PASSWORD%>" value="" 
				placeholder="<spring:message code="login.placeholder.password"/>">
		</p>
		
		<%-- ----- Submit ----- --%>
		<p class="submit">
			<input type="submit" name="commit" value="<spring:message code="login.submit"/>">
		</p>
		
	</form>

</div>