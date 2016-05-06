<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<jsp:include page="./headsection.jsp"></jsp:include>
<c:set value="${currentuser.uname}" var="myuser" />
<script type="text/javascript">
	var current = "${myuser}";
</script>
</head>
<body>
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

					<li><a class="active-menu" href="connections.htm"><i
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
				<div class="row">
					<div class="col-md-12">
						<!-- Advanced Tables -->
						<div class="panel panel-default">
							<div class="panel-heading">Existing Connections</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>User</th>
												<th>UserName</th>
												<th>Title</th>
												<th>Message</th>
												<th>View</th>
												<th>Status</th>
												<th>Remove</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach items="${connusers}"	var="cnss">
												<tr>
													<c:forEach items="${cnss}" var="x">
														
														<c:choose>
																<c:when test="${x.key=='userpic'}"><td>
																	<img src="<c:url value="/Dimage?val=${x.value}"/>"
																		class="user-image img-responsive" /></td>
																</c:when>
																<c:when test="${x.key=='name'}">
																	<td><c:out value="${x.value}" /></td>
																</c:when>
																<c:when test="${x.key=='nm'}">
																	<td><c:out value="${x.value}" /></td>
																	<c:set value="${x.value}" var="rowname" />
																</c:when>
																<c:when test="${x.key=='conid'}">
																	<c:set value="${x.value}" var="tmpname" />
																</c:when>
																<c:when test="${x.key=='status'}">
																	<c:set value="${x.value}" var="cntnsts" />
																</c:when>														
															</c:choose>
														</c:forEach>
														<td>
															<button id="view" type="button"
																value="<c:out value="${rowname}"/>">Send
																Messege</button>
														</td>
														<td>
														<a href="viewprofile.htm?id=<c:out value="${rowname}"/>">
															<button id="view" type="button"
																value="<c:out value="${rowname}"/>">View User</button>
																</a>
														</td>
														<td><c:out value="${cntnsts}" /></td>
														<td>
															<button id="view" type="button"
																value="<c:out value="${tmpname}"/>">Remove
																Connection</button>
														</td>
															</tr>
													</c:forEach>										
										</tbody>
									</table>
								</div>

							</div>
						</div>
						<!-- end tble 1 -->

						<!--End Advanced Tables -->
					</div>
				</div>
				<!-- /. ROW  -->
				<div class="row">
					<div class="col-md-12">
						<!-- Advanced Tables -->
						<div class="panel panel-default">
							<div class="panel-heading">Search Users</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example2">
										<thead>
											<tr>
												<th>User</th>
												<th>UserName</th>
												<th>Title</th>
												<th>View</th>
												<th>Add</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${allusers}" var="columns">
												<tr>
													<c:forEach items="${columns}" var="column">
														<td><c:choose>
																<c:when test="${column.key=='pic'}">
																	<img src="<c:url value="/Dimage?val=${column.value}"/>"
																		class="user-image img-responsive" />
																</c:when>
																<c:otherwise>
																	<c:choose>
																		<c:when test="${column.key=='name'}">
																			<c:set value="${column.value}" var="tmp" />
																		</c:when>
																	</c:choose>
																	<c:out value="${column.value}" />
																</c:otherwise>
															</c:choose></td>
													</c:forEach>
													<td>
													<a href="viewprofile.htm?id=<c:out value="${tmp}"/>">
														<button id="view" type="button"
															value="<c:out value="${tmp}"/>">View User</button>
															</a>
													</td>
													<td>
														<button type="button" id="add"
															value="<c:out value="${tmp}"/>">Add</button>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<!-- end tble 1 -->

						<!--End Advanced Tables -->
					</div>
				</div>
			</div>

		</div>
		<!-- /. PAGE INNER  -->
	</div>

	<!-- /. PAGE WRAPPER  -->
	<!-- /. WRAPPER  -->
	<jsp:include page="./bottom.jsp"></jsp:include>
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<c:url value="${webappRoot}/resources/js/jquery-1.10.2.js" var="jscrpt" />
	<script src="${jscrpt}"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<c:url value="${webappRoot}/resources/js/bootstrap.min.js" var="bootjs" />
	<script src="${bootjs}"></script>
	<!-- METISMENU SCRIPTS -->
	<c:url value="${webappRoot}/resources/js/jquery.metisMenu.js"
		var="menuscript" />
	<script src="${menuscript}"></script>
	<!-- DATA TABLE SCRIPTS -->
	<c:url
		value="${webappRoot}/resources/js/dataTables/jquery.dataTables.js"
		var="dtjq" />
	<script src="${dtjq}"></script>
	<c:url
		value="${webappRoot}/resources/js/dataTables/dataTables.bootstrap.js"
		var="dtstrp" />
	<script src="${dtstrp}"></script>
	<script>
		$(document).ready(
				function() {
					$('#dataTables-example').dataTable();
					$('#dataTables-example2').dataTable();

					$("button[id='add']").click(
							function() {
								var link = $(this).val();
								var btn = $(this);
								var json = "{";
								json = json + "\"" + "myuser" + "\":\""
										+ current + "\"";
								json = json + "," + "\"" + "link" + "\":\""
										+ link + "\"";
								json = json + "}";

								var obj = $.parseJSON(json);
								alert(json);
								alert(obj);
								var back = "'button[value=\'" + link + "\']'";
								$.post("addcontact.htm?action=" + json, obj,
										function(data, status) {
											alert(data);
											$(this).remove();
											btn.remove();

										});
							});

				});
	</script>
	<!-- //Script for detect Browser refresh.. -->
<script type="text/javascript">
 
         var logoutFlag = true;
         var success = false;
 
         $(document).ready(function () {
        	 
        		 $.post("refresh.htm", obj,
							function(data, status) {
								alert(data);							

							});
        		         
           });
    </script>
	<!-- CUSTOM SCRIPTS -->
	<c:url value="${webappRoot}/resources/js/custom.js" var="cusscrpt" />
	<script src="${cusscrpt}"></script>


</body>
</html>
