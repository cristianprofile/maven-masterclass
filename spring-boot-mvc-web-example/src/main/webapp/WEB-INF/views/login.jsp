
<div id="content">
	<legend>
		<spring:message code="home.legend" />

	</legend>
	<p>
	<div th:if="${param.error}">Invalid username and password.</div>
	<div th:if="${param.logout}">You have been logged out.</div>
	<form th:action="@{/login}" method="post">
		<div>
			<label> User Name : <input type="text" name="username" />
			</label>
		</div>
		<div>
			<label> Password: <input type="password" name="password" />
			</label>
		</div>
		<div>
			<label for="remember-me">Remember me</label>
			 <input type="checkbox"
				name="remember-me" id="remember-me" />
		</div>
		<div>
			<input type="submit" value="Sign In" />
		</div>

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />


	</form>
	</p>

</div>