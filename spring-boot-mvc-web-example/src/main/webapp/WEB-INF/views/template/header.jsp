<div id="header" class="text-center">
	<div class="span10">
		<h3>Spring Boot Base welcome: </h3>
		${httpServletRequest.remoteUser}
	</div>
	<div class="span2">
		<a href="?lang=es" class="btn btn-primary">es</a> 
		<a href="?lang=en"class="btn btn-success">en</a>
							 
		<form action="logout" method="post"
				id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div>
					<input type="submit" value="Logout" />
				</div>
		</form>

	</div>
</div>