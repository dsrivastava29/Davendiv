<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="./headsection.jsp"></jsp:include>
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

					<li><a class="active-menu"  href="daven.htm"><i class="fa fa-dashboard fa-3x"></i>
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

						<div
							class="chat-panel panel panel-default chat-boder chat-panel-head">
							<div class="panel-heading">
								<i class="fa fa-comments fa-fw"></i> Daven Feed
									${fn:length(feeds)}
								<div class="btn-group pull-right">
									<button type="button"
										class="btn btn-default btn-xs dropdown-toggle"
										data-toggle="dropdown">
										<i class="fa fa-chevron-down"></i>
									</button>
									
								</div>
							</div>
							<div class="panel-footer">
								<div class="input-group">
									<input id="btn-input" type="text" class="form-control input-sm"
										placeholder="Type your views to broadcast..." /> <span
										class="input-group-btn">
										<button class="btn btn-warning btn-sm" id="btn-chat">
											Broadcast</button>
									</span>
								</div>
							</div>
							<div class="panel-body">
								<ul class="chat-box">
								<c:forEach items="${feeds}" var="feed">
									<li class="left clearfix"><span class="chat-img pull-left">
											<img src="${webappRoot}/resources/img/1.png" alt="User"
											class="img-circle" />
									</span>
										<div class="chat-body">
											<strong>
										
											<c:out value="${feed.id.userid}" />
											</strong> <small
												class="pull-right text-muted"> <i
												class="fa fa-clock-o fa-fw"></i><c:out value="${feed.id.davenid}" />
											</small>
											<p><c:out value="${feed.post}" />.</p>
										</div></li>
								</c:forEach>
									
								</ul>
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
					$("button[id='btn-chat']").click(
							function() {
								
								var val = $("input[id='btn-input']").val();
								var json = "{";
								json = json + "\"" + "text" + "\":\""
										+ val + "\"";
								json = json + "," + "\"" + "link" + "\":\""
										+ val + "\"";
								json = json + "}";

								var obj = $.parseJSON(json);
								alert(json);
								alert(obj);								
								$.post("postfeed.htm?action=" + json, obj,
										function(data, status) {
											alert(data);
											$("input[id='btn-input']").val("");											

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
	<script src="${webappRoot}/resources/js/morris/raphael-2.1.0.min.js"></script>
	<script src="${webappRoot}/resources/js/morris/morris.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="${webappRoot}/resources/js/custom.js"></script>

<jsp:include page="./bottom.jsp"></jsp:include>
</body>
</html>
