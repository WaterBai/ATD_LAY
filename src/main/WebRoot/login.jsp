<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%  String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/"; %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<meta name="format-detection" content="telephone=no">
<meta name="description" content="Violate Responsive Admin Template">
<meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">
<title>ATTEND LOGIN</title>
<%@ include file="/include.jsp"%>
<style type="text/css">

</style>
</head>
<body>
	<div class="layui-header header header-doc">
		<ul class="layui-nav" lay-filter="">
			<li class="layui-nav-item"><a class="brand-logo" href="login.jsp"> <i
					class="fa fa-book"></i> ATTEND
			</a></li>
			<li class="layui-nav-item layui-this pull-right"><a href="login.jsp">用户登录</a></li>
			<li class="layui-nav-item pull-right"><a href="register.jsp">用户注册</a></li>
		</ul>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 col-md-offset-4" style="margin-top: 5em;">
				<div class="panel panel-default">
					<div class="panel-heading" style="font-size: 1.2em;">登录</div>
					<div class="panel-body">
						<form class="layui-form" action="login/login.do" method="post">
							<div class="layui-form-item">
								<label class="layui-form-label">用户名</label>
								<div class="layui-input-block">
									<input type="text" name="userId" required lay-verify="required"
										placeholder="输入用户名" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">密码</label>
								<div class="layui-input-block">
									<input type="password" name="password" required
										lay-verify="required" placeholder="输入密码" autocomplete="off"
										class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">记住用户</label>
								<div class="layui-input-block">
									<input type="checkbox" name="zzz" lay-skin="switch" lay-text="开启|关闭">
								</div>
							</div>
							<div class="layui-form-item">
								<div class="layui-input-block">
									<button class="layui-btn " lay-submit lay-filter="formDemo">立即提交</button>
									<button type="reset" class="layui-btn layui-btn-primary ">重置</button>
								</div>
							</div>
						</form>
					</div>

				</div>
				<!-- <label><input type="checkbox">Remember me</label>
				<p class="pull-right">
					<a href="register.jsp">here to register!</a>
				</p> -->
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	layui.use('element', function() {
		var element = layui.element();
	});
	//Demo
	layui.use('form', function() {
		var form = layui.form();
		//监听提交
		form.on('submit(formDemo)', function(data) {
			layer.msg(JSON.stringify(data.field));
			return true;
		});
	});
</script>
</html>
