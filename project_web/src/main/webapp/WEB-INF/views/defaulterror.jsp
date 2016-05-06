<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="./headsection.jsp"></jsp:include>
<%@ page language="java" isErrorPage="true" %>
</head>
<body id="crazy-form" class="crazy-form">
	<jsp:include page="./header.jsp"></jsp:include>
	<c:url
		value="${webappRoot}/resources/images/back.jpg"
		var="backpage" />
	<div class="row row-no-padding">
	<div class="col-md-8">
			<img src="${backpage}" width="100%"align="top" />
			</div>
			<div class="col-md-4">
			
			<div  id="crazy-form" class="crazy-form">
			
				<header>OOPSS</header>
				
				<font style="color: red;">
		
		<c:if test="${not empty errCode}">
		<h1>${errCode} : System Errors</h1>
	</c:if>
	
	<c:if test="${empty errCode}">
		<h1>System Errors</h1>
	</c:if>

	<c:if test="${not empty errMsg}">
		<h2>${errMsg}</h2>
	</c:if>

				</font>
				<label>
				
				</label>
				
				<footer>
					<a href="lost.htm"><button type="button" class="button">Lost?? Let me take you to right location  >> </button></a>
				</footer>
				
			</div>		
			
			</div>
			
	</div>
	
	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="${webappRoot}/resources/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="${webappRoot}/resources/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="${webappRoot}/resources/js/jquery.metisMenu.js"></script>
	<!-- MORRIS CHART SCRIPTS -->
	<script src="${webappRoot}/resources/js/morris/raphael-2.1.0.min.js"></script>
	<script src="${webappRoot}/resources/js/morris/morris.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="${webappRoot}/resources/js/custom.js"></script>

<jsp:include page="./bottom.jsp"></jsp:include>
</body>
</html>
