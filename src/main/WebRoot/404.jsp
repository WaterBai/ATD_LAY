<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath %>" />
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
</style>
</head>
<body class="http-error">
	<div class="row-fluid">
		<div class="http-error">
			<h1>Oops!</h1>
			<p class="info">This page doesn't exist.</p>
			<p>
				<i class="icon-home"></i>
			</p>
			<p>
				<a href="index.html">Back to the home page</a>
			</p>
		</div>
	</div>
</body>

</html>