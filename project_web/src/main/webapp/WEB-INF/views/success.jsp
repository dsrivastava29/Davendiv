<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.util.Collections"%>
<html>
<head>
<meta charset="utf-8">
<c:url value="${webappRoot}/resources/css/crazy-forms.css"
	var="registerCss" />
<link href="${registerCss}" rel="stylesheet" />
<link rel='stylesheet'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script>
<script
	src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
<script>
	$(document).ready(function() {
		$("img").hide();
		$("#subbutton").click(function() {
			processFileUpload();
		});
		function processFileUpload() {

			var formData = new FormData();
			formData.append("file", file.files[0]);

			$.ajax({
				dataType : 'json',
				url : "${pageContext.request.contextPath}/uploadDivPicture",
				data : formData,
				type : "POST",
				enctype : 'multipart/form-data',
				processData : false,
				contentType : false,
				success : function(result) {
								
					alert(result["response"]);
					if(result["response"]=="success"){
					$("img").show();
					$("#subbutton").hide();
					}
					else{
						alert("Could not upload picture, try again later");
					}
				
				},
				error : function(result) {
					alert('error' + JSON.stringify(result));
				}
			});
		}
	});
</script>


<title>Create User Page</title>
</head>
<body>
	<jsp:include page="./header2.jsp"></jsp:include>
	<div class="row crazy-form">
		<div class="col-md-12">
			<header> Please submit Div's display picture ! </header>
			<fieldset>
				<legend> Select file to upload: </legend>
				<section>
					<form method="post" id="myForm" enctype="multipart/form-data"
						class="crazy-form">
						<label class="input"> <input type="file" name="file"
							id="file" /> <br />
						</label>
						<button type="button" id="subbutton" value="Upload" class="button"
							style="float: left;">Upload</button>
					</form>
				</section>
				<section>
					<label id="done"> <c:url
							value="${webappRoot}/resources/img/success.png" var="finduser" />
						<img src="${finduser}" class="user-image img-responsive"
						style="width: 50%; height: 50%;" />
					</label>
				</section>

			</fieldset>
			<fieldset>
				<legend id="success">Congratulations, Now you are a member
					of DavenDiv professional network. Please do not forget to update
						your settings once you are logged in</legend>


			</fieldset>
		</div>
		<footer>
			<button type="button" class="button"
				onclick="location.href='usercreated.htm'">Click here to go
				to home page and Login >></button>
		</footer>
	</div>
	<a href="http://www.crazydrt.com">&copy; 2016 @crazydrt.com </a>
</body>
</html>