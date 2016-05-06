<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
				<li class="active"><a href="login.htm">Home <span class="sr-only">(current)</span></a></li>
				<li><a href="#">Global News</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Cr@zyDiv <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Divyansh1</a></li>
						<li><a href="#">Divyansh2</a></li>
						
						<li><a href="#">One more separated link</a></li>
					</ul></li>
			</ul>
			<%
					String user = (String)session.getAttribute("name");
					if (user != null) {
						
				%>
			    
				<div class="nav navbar-nav navbar-right">
					Welcome	${users.uname}
				</div>
				<%
					} else {
				%>
			<form:form action="login.htm" commandName="login" method="post" id="crazy-form" class="navbar-form navbar-right" >
				
				<form:errors></form:errors>
				<div class="form-group">
					<form:input path="uname" type="text" class="form-control" placeholder="UserName" />
					<font color="red"><form:errors path="uname"/></font>
					<form:input path="password" type="password" class="form-control" placeholder="Password" />
					<font color="red"><form:errors path="password"/></font>
				</div>
				<button type="submit" class="btn btn-default">Enter Daven</button>
			
			</form:form>
				<%
					}
				%>
			<ul class="nav navbar-nav navbar-right">
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
