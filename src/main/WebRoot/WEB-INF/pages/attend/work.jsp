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
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading" data-toggle="collapse"
						data-target="#page-stats">Work</div>
			        <div id="page-stats" class="panel-body collapse in">
			            <h2>Here's a Tip</h2>
			            <p>This template was developed with <a href="http://middlemanapp.com/" target="_blank">Middleman</a> and includes .erb layouts and views.</p>
			            <p>All of the views you see here (sign in, sign up, users, etc) are already split up so you don't have to waste your time doing it yourself!</p>
			            <p>The layout.erb file includes the header, footer, and side navigation and all of the views are broken out into their own files.</p>
			            <p>If you aren't using Ruby, there is also a set of plain HTML files for each page, just like you would expect.</p>
			        </div>
			    </div>
			</div>
		</div>
	</div>
</body>
</html>