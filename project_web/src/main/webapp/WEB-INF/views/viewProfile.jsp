<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<c:url value="${webappRoot}/resources/css/crazy-forms.css"
	var="registerCss" />
<link href="${registerCss}" rel="stylesheet" />
<jsp:include page="./headsection.jsp"></jsp:include>
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
				<c:choose>
					<c:when test="${empty viewuser}">
						<font color="red"> I think user is not available at this
							moment </font>
					</c:when>
				</c:choose>
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">


						<div class="panel panel-default chat-boder chat-panel-head">
							<div class="panel-heading">View User Board -- Username :
								${viewuser.uname}</div>

							<div class="panel-body">
								<div id="crazy-form" class="crazy-form">
									<header>${viewuser.personalInfo.firstname}
										${viewuser.personalInfo.middlename}
										${viewuser.personalInfo.lastname}</header>
									<fieldset>
										<section>
											<ul class="nav" id="main-menu">
												<li class="text-center"><c:url
														value="/Dimage?val=${viewuser.logicalpic}" var="p" />
													<img src="${p}" class="user-image img-responsive" /></li>
											</ul>
										</section>
									</fieldset>
									<fieldset>
										<section>
											<label class="input"> Email Id </label>
											<c:out value="${viewuser.mail}" />
										</section>
										<section>
											<label class="input"> Title </label>
											<c:out value="${viewuser.uname}" />
										</section>
										<section>
											<label class="input"> Phone </label>
											<c:out value="${viewuser.personalInfo.phone}" />
										</section>
									</fieldset>
									<fieldset>
										<legend> Other Information </legend>

										<section class="col col-4">
											<label class="input">Connections</label>
											${fn:length(viewuser.connectiondetailses)}
										</section>
										<section class="col col-4">
											<label class="input">Country</label>
											<c:out value="${viewuser.personalInfo.country}" />
										</section>
										<section class="col col-4">
											<label class="input"> </label>
										</section>
									</fieldset>
									<footer>
										<c:choose>
											<c:when test="${isadmin==1}">
												<a href="deleteuser.htm?id=<c:out value='${viewuser.uname}' />"><button type="button" class="button">Delete
														this User></button></a>
												
											</c:when>
										</c:choose>
									</footer>

								</div>
								<div
							class="chat-panel panel panel-default chat-boder chat-panel-head">
							<div class="panel-heading">
								<i class="fa fa-comments fa-fw"></i> <c:out value="${viewuser.uname}" />'s Daven Feed
									
								<div class="btn-group pull-right">
									<button type="button"
										class="btn btn-default btn-xs dropdown-toggle"
										data-toggle="dropdown">
										<i class="fa fa-chevron-down"></i>
									</button>
									
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
				</div>
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
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
