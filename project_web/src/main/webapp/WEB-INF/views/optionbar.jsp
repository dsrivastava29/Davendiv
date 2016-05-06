<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<body>
	<div class="row">
		<div class="col-md-3">
			<div class="panel panel-back noti-box">
				<h2>
					Welcome <br /> ${currentuser.personalInfo.firstname}
					${currentuser.personalInfo.middlename}
					${currentuser.personalInfo.lastname}
				</h2>
				<h5>Glad to see you back.</h5>
			</div>
		</div>
		<div class="col-md-3">
			<div class="panel panel-back noti-box">
				<span class="icon-box bg-color-red set-icon"> <i
					class="fa fa-envelope-o"></i>
				</span>
				<div class="text-box">
					<p class="main-text">
					<a href="messeges.htm">
					${fn:length(currentuser.inbox.messages)}
					</a>
						</p>
					<p class="text-muted">Messages</p>
				</div>
			</div>
		</div>
		<div class="col-md-3">
			<div class="panel panel-back noti-box">
				<span class="icon-box bg-color-blue set-icon"> <i
					class="fa fa-bell-o"></i>
				</span>
				<div class="text-box">
					<p class="main-text">
					<a href="notification.htm">
					${fn:length(currentuser.notification)}
					</a>
						</p>
					<p class="text-muted">Notifications</p>
				</div>
			</div>
		</div>
		<div class="col-md-3">
			<div class="panel panel-back noti-box">
				<span class="icon-box bg-color-brown set-icon"> <i
					class="fa fa-rocket"></i>
				</span>
				<div class="text-box">
				
					<p class="main-text">
					<a href="connections.htm">
					${fn:length(currentuser.connectiondetailses)}
					</a>
						</p>
					<p class="text-muted">Connections</p>
				</div>
			</div>
		</div>
	</div>
</body>