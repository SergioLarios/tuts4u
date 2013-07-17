<%@ include file="../init.jsp" %>

<div class="login">

	<h1><spring:message code="register.header"/></h1>

	<form action="<%=Mappings.LOGIN%>" method="post">
	
		<%-- ----- User Mail ----- --%>
		<p>
			<input type="text" name="<%=CreateAccountForm.USER_MAIL%>" value=""
				placeholder="<spring:message code="login.placeholder.email"/>">
		</p>
		
		<%-- ----- Password ----- --%>
		<p>
			<input type="password" name="<%=CreateAccountForm.USER_PASSWORD%>" value="" 
				placeholder="<spring:message code="login.placeholder.password"/>">
		</p>
		
		<%-- ----- Password ----- --%>
		<p>
			<input type="password" name="<%=CreateAccountForm.USER_PASSWORD_REPEAT%>" value="" 
				placeholder="<spring:message code="register.placeholder.repeat-password"/>">
		</p>
		
		<%-- ----- Submit ----- --%>
		<p class="submit">
			<input type="submit" name="commit" value="<spring:message code="register.submit"/>">
		</p>
		
	</form>

</div>