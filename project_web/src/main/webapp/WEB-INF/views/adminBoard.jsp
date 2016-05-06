<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="./headsection.jsp"></jsp:include>
<c:set value="${currentuser.uname}" var="myuser" />
<script type="text/javascript">
	var current = "${myuser}";
</script>
</head>
<body id="crazy-form" class="crazy-form">
	<jsp:include page="./header.jsp"></jsp:include>
	<div id="wrapper">
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li class="text-center"><c:url value="/Dimage?val=${picture}"
							var="pics" /> <img src="${pics}"
						class="user-image img-responsive" /></li>

					<li><a href="daven.htm"><i class="fa fa-dashboard fa-3x"></i>
							DavenFeed</a></li>

					<li><a href="connections.htm"><i
							class="fa fa-desktop fa-3x"></i> Connections</a></li>

					<li><a href="messeges.htm"><i class="fa fa-qrcode fa-3x"></i>
							Messages</a></li>

					<li><a href="job.htm"><i class="fa fa-bar-chart-o fa-3x"></i>
							Job</a></li>

					<li><a href="updateskills.htm"><i
							class="fa fa-table fa-3x"></i> Update Skills</a></li>

					<li><a href="summary.htm"><i class="fa fa-edit fa-3x"></i>
							Summary </a></li>


				</ul>

			</div>

		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<jsp:include page="./optionbar.jsp"></jsp:include>
				<!-- /. ROW  -->
				<hr />
	Total Users : ${fn:length(allusers)}
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">

						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="nottable">
									<thead>
										<tr>
											<th>User</th>
											<th>UserName</th>
											<th>Status</th>
											<th>Show Sessions</th>
											<th>View</th>

											<th>Remove</th>
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

															<button id="activate" type="button"
																value="<c:out value="${user.userid}"/>">ACTIVATE</button>

														</c:when>
														<c:otherwise>
															<font color="#0000FF">ACTIVE</font>
															<button id="deactivate" type="button"
																value="<c:out value="${user.userid}"/>">DEACTIVATE</button>
														</c:otherwise>
													</c:choose></td>
												<td><button id="sessions" type="button"
														value="<c:out value="${user.userid}"/>">Sessions</button></td>
												<td>
												<a href="viewprofile.htm?id=<c:out value="${user.uname}"/>">
													<button id="view" type="button"
														value="<c:out value="${user.uname}"/>">View User</button>
														</a>
												</td>
												<td>
												<a href="deleteuser.htm?id=<c:out value="${user.uname}"/>">
													<button id="remove" type="button"
														value="<c:out value="${user.uname}"/>">Remove</button>
														</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>

						</div>

					</div>
				</div>
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<script>
		$(document).ready(
				function() {
					$('#nottable').dataTable();
					$("button[id='activate']").click(
							function() {
								var link = $(this).val();
								var btn = $(this);
								var json = "{";
								json = json + "\"" + "myuser" + "\":\""
										+ current + "\"";
								json = json + "," + "\"" + "uid" + "\":\""
										+ link + "\"";
								json = json + "}";

								var obj = $.parseJSON(json);
								alert(json);
								alert(obj);
								var back = "'button[value=\'" + link + "\']'";
								$.post("activate.htm?action=" + json, obj,
										function(data, status) {
									location.reload();									
											
										});
							});
					$("button[id='deactivate']").click(
							function() {
								var link = $(this).val();
								var btn = $(this);
								var json = "{";
								json = json + "\"" + "myuser" + "\":\""
										+ current + "\"";
								json = json + "," + "\"" + "uid" + "\":\""
										+ link + "\"";
								json = json + "}";

								var obj = $.parseJSON(json);
								alert(json);
								alert(obj);
								var back = "'button[value=\'" + link + "\']'";
								$.post("deactivate.htm?action=" + json, obj,
										function(data, status) {
									location.reload();										
											

										});
							});

				});
	</script>
	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="${webappRoot}/resources/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="${webappRoot}/resources/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="${webappRoot}/resources/js/jquery.metisMenu.js"></script>
	<!-- MORRIS CHART SCRIPTS -->

	<!-- CUSTOM SCRIPTS -->
	<script src="${webappRoot}/resources/js/custom.js"></script>
	<c:url
		value="${webappRoot}/resources/js/dataTables/jquery.dataTables.js"
		var="dtjq" />
	<script src="${dtjq}"></script>
	<c:url
		value="${webappRoot}/resources/js/dataTables/dataTables.bootstrap.js"
		var="dtstrp" />
	<script src="${dtstrp}"></script>

	<jsp:include page="./bottom.jsp"></jsp:include>
</body>
</html>
