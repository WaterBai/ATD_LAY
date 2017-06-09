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
	<div class="layui-header header header-doc">
		<ul class="layui-nav" lay-filter="">
			<li class="layui-nav-item"><a class="brand-logo" href="login.jsp"> 
				<i class="fa fa-book"></i> ATTEND
			</a></li>
			<li class="layui-nav-item pull-right"><a href="">Settings</a></li>
			<li class="layui-nav-item pull-right">
				<a href="javascript:;">username</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd> <a tabindex="-1" href="">My Account</a> </dd>
					<dd> <a tabindex="-1" href="">Settings</a> </dd>
					<dd> <a tabindex="-1" href="login/logout.do">Logout</a> </dd>
				</dl></li>
		</ul>
	</div>

	<div class="sidebar-nav">
		<ul class="layui-nav layui-nav-tree layui-nav-side">
		  <li class="layui-nav-item layui-nav-itemed">
		    <a href="javascript:;">默认展开</a>
		    <dl class="layui-nav-child">
		      <dd><a href="javascript:;">选项1</a></dd>
		      <dd><a href="javascript:;">选项2</a></dd>
		      <dd><a href="">跳转</a></dd>
		    </dl>
		  </li>
		  <li class="layui-nav-item">
		    <a href="javascript:;">解决方案</a>
		    <dl class="layui-nav-child">
		      <dd><a href="">移动模块</a></dd>
		      <dd><a href="">后台模版</a></dd>
		      <dd><a href="">电商平台</a></dd>
		    </dl>
		  </li>
		  <li class="layui-nav-item"><a href="">产品</a></li>
		  <li class="layui-nav-item"><a href="">大数据</a></li>
		</ul>
	</div>
	<div class="content">
		<ul class="breadcrumb">
			<li class="active"><a href="main/home.do" target="mainFrame">Home</a>
			<!-- <li class="active">Dashboard</li> -->
		</ul>
		<iframe id="mainFrame" name="mainFrame" src = "main/home.do"
            frameborder="0" style="padding: 0px; width: 100%;"></iframe>
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

layui.use('element', function() {
	var element = layui.element();
});
</script>
</html>