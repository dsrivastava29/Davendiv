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
<title>Enter your details</title>

</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	<div>
		<form action="" method="post" id="crazy-form" class="crazy-form">
			<header>Enter details for this report </header>
			<fieldset>
				<section>
					<label class="input"> <i class="icon-append fa fa-user"></i>
						<input type="text" name="title" placeholder="Title"
						value=""/>
						
					</label>
				</section>
				<section>
					<label class="input"> <i class="icon-append fa fa-user"></i>
						<input type="text" name="desription" placeholder="Description"
						value=""  /> 						
					</label>
				</section>
				
			</fieldset>
			<fieldset>
				<legend> Personal Information </legend>
				<div class="row">
					<section class="col col-4">
						<label class="input"> <input type="text"
							name="personalInfo.firstname" value="<c:out value="${currentuser.personalInfo.firstname}" />" placeholder="First name" required>
						</label>
					
					</section>
					<section class="col col-4">
						<label class="input"> <input type="text"
							name="personalInfo.middlename" value="<c:out value="${currentuser.personalInfo.middlename}" />" placeholder="Middle name" required>
						</label>
					</section>
					<section class="col col-4">
						<label class="input"> <input type="text"
							name="personalInfo.lastname" value="<c:out value="${currentuser.personalInfo.lastname}" />" placeholder="Last name" required>
						</label>
					</section>
				</div>
				
							
			</fieldset>
<footer>
					<button type="submit" name="_eventId_next" class="button">Next  >> </button>
					
				</footer>
		</form>
	</div>
</body>
</html>