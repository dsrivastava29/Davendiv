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

				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">

						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="nottable">
									<thead>
										<tr>
											<th>Type</th>
											<th>Description</th>
											<th>Status</th>
											<th>Take Action</th>
											<th>Remove</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach items="${notif}" var="n">
											<tr>
												<td><c:out value="${n.type}" /></td>
												<td><c:out value="${n.description}" /></td>
												<td><c:out value="${n.status}" /></td>
												<td>
												<c:choose>
													<c:when test="${n.status=='Pending Confirmation'}">
													<button id="add" type="button"
														value="<c:out value="${n.notid}"/>">Perform
														Action</button>
													</c:when>
												</c:choose>
													
												</td>
												<td>
													<button id="remove" type="button"
														value="<c:out value="${n.notid}"/>">Remove</button>
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
					//Confirm connection notification add logic
					$("button[id='add']").click(
							function() {
								var link = $(this).val();
								var btn = $(this);
								var json = "{";
								json = json + "\"" + "myuser" + "\":\""
										+ current + "\"";
								json = json + "," + "\"" + "notid" + "\":\""
										+ link + "\"";
								json = json + "}";

								var obj = $.parseJSON(json);
								alert(json);
								alert(obj);
								var back = "'button[value=\'" + link + "\']'";
								$.post("replynot.htm?action=" + json, obj,
										function(data, status) {
											alert(data);
											$(this).remove();
											btn.remove();

										});
							});
					$("button[id='remove']").click(
							function() {
								var link = $(this).val();
								var btn = $(this);
								var json = "{";
								json = json + "\"" + "myuser" + "\":\""
										+ current + "\"";
								json = json + "," + "\"" + "notid" + "\":\""
										+ link + "\"";
								json = json + "}";

								var obj = $.parseJSON(json);
								alert(json);
								alert(obj);
								var back = "'button[value=\'" + link + "\']'";
								$.post("removenot.htm?action=" + json, obj,
										function(data, status) {
											alert(data);
											$(this).parent().parent().remove();
											btn.parent().parent().remove();

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
