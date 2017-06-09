<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ATTEND LOGIN</title>
<%@ include file="/include.jsp"%>
<style type="text/css">
body {
  background: #eee;
  background-image: url(images/furley_bg.png);
}
</style>
</head>
<body>
	<nav class="navbar navbar-inner"></nav>
	<nav class="navbar navbar-inner navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="main/home.do" target="mainFrame">
					<span class="second">
						<i class="fa fa-book"></i> ATTEND
					</span>
				</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Settings</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">${loginSessionKey.username}<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a tabindex="-1" href="#">My Account</a></li>
							<li class="divider"></li>
							<li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
							<li class="divider visible-phone"></li>
							<li><a tabindex="-1" href="login/logout.do">Logout</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="sidebar-nav">
		<div data-target="#dashboard-menu" class="nav-header" data-toggle="collapse">
			<i class="icon-dashboard"></i>ATD
		</div>
		<ul id="dashboard-menu" class="nav nav-list collapse in">
			<!-- <li><a href="attend/work.do" target="mainFrame">me</a></li> -->
			<li><a href="attend/attend.do" target="mainFrame">attend</a></li>
		</ul>
	</div>

	<div class="content">
		<ul class="breadcrumb">
			<li class="active"><a href="main/home.do" target="mainFrame">Home</a>
			<!-- <li class="active">Dashboard</li> -->
		</ul>
		<iframe id="mainFrame" name="mainFrame" src = "main/home.do"
            frameborder="0" style="padding: 0px; width: 100%;"></iframe>
        <!-- <footer>
			<hr>
			<p class="pull-right"> Edit by 
			<a href="https://github.com/WaterBai/" title="WaterBAI" target="_blank">WaterBAI</a>
			</p>
			<p>&copy; 2017</p>
		</footer> -->
	</div>
</body>
<script type="text/javascript">
$(document).ready(function() {
	$("a ").click(function() {
		clearBreadCrumb();
		addBreadCrumb($(this).text(),$(this).attr("href"));
	}); 
});

function reinitIframe() { 
    var iframe = document.getElementById("mainFrame");  
    try {
    	var bHeight = document.documentElement.clientHeight-100;
        //var bHeight = iframe.contentWindow.document.body.scrollHeight;  
        var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;  
        var height = Math.max(bHeight, dHeight);  
        //var height = bHeight;  
        iframe.height = height;  
    } catch (ex) {}
}
window.setInterval("reinitIframe()", 200);

</script>
</html>