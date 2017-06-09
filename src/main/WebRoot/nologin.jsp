<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ATTEND LOGIN</title>
<%@ include file="/include.jsp"%>
<title>Insert title here</title>
<style type="text/css">
body {
	background: #eee;
	background-image: url(images/furley_bg.png);
}

.secord {
	color: #000000;
	font-weight: 900;
}
</style>
</head>
<body class="http-error">
	<div class="row-fluid">
		<div class="http-error">
			<h1>Oops!</h1>
			<p class="info">No login！Please login</p>
			<p>
				<i class="icon-home"></i>
			</p>
			<p>
				<a href="javascript:void(0);" onclick="backlogin()">Back to the login page!</a>
			</p>
			<p >
				<span class="secord" id="secord"> 5s</span> auto back.
			</p>
		</div>
	</div>
</body>
<script type="text/javascript">
	var countdown = 5;
	function backlogin(){
		top.location='login.jsp';
	}
	function settime() {
		if (countdown == 1) {
			top.location='login.jsp';
			//window.location.href = "login.jsp";
		} else {
			countdown--;
			document.getElementById("secord").innerHTML = countdown + 's';
		}
	}
	setInterval(function() {
		settime();
	}, 1000);
</script>
</html>