<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Create User Page</title>

</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	<div>
		<form:form action="newuser.htm" commandName="users" method="post" id="crazy-form" class="crazy-form">
			<header>Please provide some more information before
				accessing your own daven </header>
			<fieldset>
			<form:errors path="*" />
				<section>
					<label class="input"> <i class="icon-append fa fa-user"></i>
						<input type="text" name="uname" placeholder="Username" required
						value="${users.uname}"/> <b
						class="tooltip tooltip-bottom-right">Your unique identity</b>
						<font color="red"><form:errors path="uname"/></font>
					</label>
				</section>
				<section>
					<label class="input"> <i class="icon-append fa fa-user"></i>
						<input type="password" name="pass" placeholder="Password" required
						value="${users.pass}"  /> <b
						class="tooltip tooltip-bottom-right">Your unique password</b>
						<font color="red"><form:errors path="pass"/></font>
					</label>
				</section>
				<section>
					<label class="input"> <i
						class="icon-append fa fa-envelope-o"></i> <input type="email" required
						name="mail" placeholder="Email address" value="${users.mail}"
						> <b
						class="tooltip tooltip-bottom-right">Required to verify your
							account</b>
							<font color="red"><form:errors path="mail"/></font>
					</label>
				</section>
			</fieldset>
			<fieldset>
				<legend> Personal Information </legend>
				<div class="row">
					<section class="col col-4">
						<label class="input"> <input type="text"
							name="personalInfo.firstname" placeholder="First name" required>
						</label>
						<font color="red"><form:errors path="personalInfo.firstname"/></font>
					</section>
					<section class="col col-4">
						<label class="input"> <input type="text"
							name="personalInfo.middlename" placeholder="Middle name">
						</label>
					</section>
					<section class="col col-4">
						<label class="input"> <input type="text"
							name="personalInfo.lastname" placeholder="Last name" required>
						</label>
					</section>
				</div>
				<%
				String[] locales = Locale.getISOCountries();
			    ArrayList<String> list = new ArrayList<String>();
			    pageContext.setAttribute("list", list);
			    for (String countryCode : locales) {
			        Locale obj = new Locale("en", countryCode);
			        list.add(obj.getDisplayCountry());
			    }
			    Collections.sort(list);
				%>
				<div class="select">			
						<select name="personalInfo.country">
							<c:forEach items="${list}" var="obj">
							<option><c:out value="${obj}"/></option>
							</c:forEach>
						</select> 
						<b class="tooltip tooltip-bottom-right">Your Country</b>
					</div>
				<section>
					<label class="input"> <i class="icon-append fa fa-user"></i>
						<input type="text" name="personalInfo.state" placeholder="State" required /> <b
						class="tooltip tooltip-bottom-right">Your state</b>
						<font color="red"><form:errors path="personalInfo.state"/></font>
					</label>
				</section>
				<section>
					<label class="input"> <i class="icon-append fa fa-user"></i>
						<input type="text" name="personalInfo.city" placeholder="City"  required/> <b
						class="tooltip tooltip-bottom-right">Your current city</b>
						<font color="red"><form:errors path="personalInfo.city"/></font>
					</label>
				</section>				
			</fieldset>
<footer>
					<button type="submit" class="button">Add Information  >> </button>
					<a href="login.htm"><button type="button" class="button">Later On  >> </button></a>
				</footer>
		</form:form>
	</div>
</body>
</html>