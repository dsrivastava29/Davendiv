<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="utf-8">
<c:url value="${webappRoot}/resources/css/crazy-forms.css" var="registerCss" />
<link href="${registerCss}" rel="stylesheet" />
<link rel='stylesheet'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'></link>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script>
<script
	src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
<title>Welcome</title>
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	<c:url value="/showMessage.html" var="messageUrl" />
	<c:url
		value="${webappRoot}/resources/images/back.jpg"
		var="backpage" />
	<div class="row row-no-padding">
	<div class="col-md-8">
			<img src="${backpage}" width="100%" height="32%" align="top">
			</div>
			<div class="col-md-4">
			<form:form action="newuser.htm" commandName="users" method="post" id="crazy-form" class="crazy-form">
			
				<header>Enter the network and utilize your daven</header>
				
				<fieldset>					
					<section>
						<label class="input">
							<i class="icon-append fa fa-user"></i>
							<input type="text" name="uname" placeholder="Username" required />
							<b class="tooltip tooltip-bottom-right">Your unique identity</b>
						</label>
					</section>
					
					<section>
						<label class="input">
							<i class="icon-append fa fa-envelope-o"></i>
							<input type="email" name="mail" placeholder="Email address" required>
							<b class="tooltip tooltip-bottom-right">Required to verify your account</b>
						</label>
					</section>
					
					<section>
						<label class="input">
							<i class="icon-append fa fa-lock"></i>
							<input type="password" name="pass" placeholder="Password" id="password" required>
							<b class="tooltip tooltip-bottom-right">Don't forget your password</b>
						</label>
					</section>
					
					<section>
						<label class="input">
							<i class="icon-append fa fa-lock"></i>
							<input type="password" name="passwordConfirm" placeholder="Confirm password" required>
							<b class="tooltip tooltip-bottom-right">Don't forget your password</b>
						</label>
					</section>
				</fieldset>
					
				<fieldset>
									
					<section>
						<label class="select">
							<select name="gender">
								<option value="0" selected disabled>Gender</option>
								<option value="1">Male</option>
								<option value="2">Female</option>
								<option value="3">Other</option>
							</select>
							<i></i>
						</label>
					</section>
					
					<section>
						<label class="checkbox"><input type="checkbox" name="subscription" id="subscription"><i></i>I want to receive news and  special offers</label>
						<label class="checkbox"><input type="checkbox" name="terms" id="terms"><i></i>I agree with the Terms and Conditions</label>
					</section>
				</fieldset>
				<footer>
					<button type="submit" class="button">Sign Up Now  >> </button>
				</footer>
			</form:form>		
			
			</div>
			
	</div>
	
	<jsp:include page="./bottom.jsp"></jsp:include>
</body>
</html>
