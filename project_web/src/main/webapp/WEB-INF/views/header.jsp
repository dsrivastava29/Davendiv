<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">DavenDiv</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/login.htm">Home <span class="sr-only">(current)</span></a></li>
			
				<li><a href="#"> <c:choose>
							<c:when test="${name!=null}">
					Welcome <c:out value="${name}" />
							</c:when>
							<c:otherwise>
					Hello guest
					</c:otherwise>
						</c:choose>
				</a></li>
				
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
						<c:when test="${isadmin==1}">
						<li><a href="flows/admin" target="_blank">Generate All users report</a></li>
							<li><a style="color:#FF3344;size: +1;" href="admin.htm">ADMIN BOARD</a></li>
						</c:when>					
					</c:choose>
				<li><a href="#">Link</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="logout.htm">Logout</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
