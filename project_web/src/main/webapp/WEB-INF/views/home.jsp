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
	
	<jsp:include page="./header2.jsp"></jsp:include>
	<c:url value="/showMessage.html" var="messageUrl" />
	<c:url
		value="${webappRoot}/resources/images/back.jpg"
		var="backpage" />
	<div class="row row-no-padding">
	<div class="col-md-8">
			<img src="${backpage}" width="100%"align="top">
			</div>
			<div class="col-md-4">
			
			<div  id="crazy-form" class="crazy-form">
			
				<header>Enter the network and utilize your daven</header>
				<br><br><br><br><br><br><br><br>
				<label>
				You are just one step ahead to be a member of one of the finest professional network
				</label>
				
				<footer>
					<a href="create.htm"><button type="button" class="button">Sign Up Now  >> </button></a>
				</footer>
				
			</div>		
			
			</div>
			
	</div>
<jsp:include page="./bottom.jsp"></jsp:include>
</body>
</html>
