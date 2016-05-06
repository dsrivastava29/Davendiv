<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Collections" %>
<html>
<head>
<meta charset="utf-8">
<c:url value="${webappRoot}/resources/css/crazy-forms.css"
	var="registerCss" />
<link href="${registerCss}" rel="stylesheet" />
<link rel='stylesheet'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'></link>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script>
<script
	src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
<title>Enter your messege and continue</title>
<jsp:include page="./headsection.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	<div>
		<form action="" method="post">
			<header>Total Users : ${fn:length(allusers)}</header>
			<fieldset>
				<section>
					<label class="input"> <i class="icon-append fa fa-user"></i>
						<input type="text" name="msg" placeholder="Send a messege"
						value=""/>
						
					</label>
				</section>
				
			</fieldset>
			<fieldset>
				<div class="panel-body">
								<div class="table-responsive">
								<h3>
										<a href="/project/getPdf">GET HERE</a>
										</h3>
								</div>
							</div>
				
							
			</fieldset>
<footer>
					
					
				</footer>
		</form>
	</div>
</body>
</html>