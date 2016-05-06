<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>${currentuser.uname}'s Davendiv Network</title>
<!-- BOOTSTRAP STYLES-->
<c:url value="${webappRoot}/resources/css/bootstrap.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->

<c:url value="${webappRoot}/resources/css/font-awesome.css" var="font" />
<link href="${font}" rel="stylesheet" />
<!-- MORRIS CHART STYLES-->

<c:url value="${webappRoot}/resources/js/morris/morris-0.4.3.min.css"
	var="morrismin" />
<link href="${morrismin}" rel="stylesheet" />

<!-- CUSTOM STYLES-->
<c:url value="${webappRoot}/resources/css/custom.css" var="custom" />
<link href="${custom}" rel="stylesheet" />

<link rel='stylesheet'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'></link>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script>
<script
	src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
<c:url value="${webappRoot}/resources/css/crazy-forms.css"
	var="registerCss" />
<c:url value="${picture}" var="imgg" />
</head>

</html>
