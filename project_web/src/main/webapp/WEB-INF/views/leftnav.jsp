<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li class="text-center"><c:url value="/Dimage?val=${picture}"
							var="pics" /> <img src="${pics}"
						class="user-image img-responsive" /></li>
					<li><a class="active-menu" href="daven.htm"><i
							class="fa fa-dashboard fa-3x"></i> DavenFeed</a></li>
					<li><a href="connections.htm"><i class="fa fa-desktop fa-3x"></i>
							Connections</a></li>
					<li><a href="messeges.htm"><i class="fa fa-qrcode fa-3x"></i>
							Messages</a></li>
					<li><a href="notification.htm"><i class="fa fa-bar-chart-o fa-3x"></i>
							Job</a></li>
					<li><a href="updateskills.htm"><i class="fa fa-table fa-3x"></i> Update
							Skills</a></li>
					<li><a href="summary.htm"><i class="fa fa-edit fa-3x"></i> Summary
					</a></li>


				</ul>

			</div>

		</nav>