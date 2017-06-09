<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<meta name="format-detection" content="telephone=no">
<meta name="description" content="Violate Responsive Admin Template">
<meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">
<title>ATTEND REGISTER</title>
<%@ include file="/include.jsp"%>
<style type="text/css">
</style>
</head>
<body>
	<div class="navbar navbar-inner">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="login.jsp">
					<span class="second">
						<i class="fa fa-book"></i> ATTEND
					</span>
				</a>
			</div>
		</div>	
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 col-md-offset-4" style="margin-top: 3em;">
				<div class="panel panel-default">
					<div class="panel-heading" style="font-size: 1.2em;">Sign In</div>
					<div class="panel-body">
						<form action="login/register.do" method="post">
							<div class="form-group">
								<label for="userId">Username</label> 
								<input type="text" class="form-control" name="userId" id="userId" placeholder="Username">
							</div>
							<div class="form-group">
								<label for="password">Password</label> 
								<input type="password" class="form-control" name="password" id="password" placeholder="Password">
							</div>
							
							<div class="form-group">
								<label for="email">Email</label> 
								<input type="text" class="form-control" name="email" id="email" placeholder="Email">
							</div>
							<div class="form-group">
								<label for="phone">Phone</label> 
								<input type="text" class="form-control" name="phone" id="phone" placeholder="phone">
							</div>
							<div class="form-group">
								<label for="sex">Sex</label> 
								<label class="radio-inline">
								  <input type="radio" name="sex" id="sex" value="0"> girl
								</label>
								<label class="radio-inline">
								  <input type="radio" name="sex" id="sex" value="1"> boy
								</label>
							</div>
							<div class="pull-right">
								<button type="reset" class="btn ">reset</button>
								<button type="submit" class="btn btn-primary">register & login</button>
							</div>
							<div class="clearfix"></div>
						</form>
					</div>
				</div>
				<p class="pull-right"><a href="login.jsp">here to login!</a></p> 
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

</script>
</html>
