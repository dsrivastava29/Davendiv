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
									<table class="table table-striped table-bordered table-hover"
									id="nottable">
									<thead>
										<tr>
											<th>User</th>
											<th>UserName</th>
											<th>Status</th>
											
											
										</tr>
									</thead>
									<tbody>

										<c:forEach items="${allusers}" var="user">
											<tr>
												<td><c:url value="/Dimage?val=${user.logicalpic}"
														var="pics" /> <img src="${pics}"
													class="user-image img-responsive" /></td>
												<td><c:out value="${user.uname}" /></td>
												<td><c:choose>
														<c:when test="${user.isActive==0}">
															<font color="#FF0000">NOT ACTIVE</font>

														
														</c:when>
														<c:otherwise>
															<font color="#0000FF">ACTIVE</font>
															
														</c:otherwise>
													</c:choose></td>
											
											
											</tr>
										</c:forEach>
									</tbody>
								</table>
								</div>
							</div>
				
							
			</fieldset>
<footer>
					<input type="submit" name="_eventId_next" value="Generate"/><br/>
<input type="submit" name="_eventId_prev" value="prev"/> Change previous Information<br/>
<input type="submit" name="_eventId_startOver" value="startOver"/><br/>
					
				</footer>
		</form>
	</div>
</body>
</html>