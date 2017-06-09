<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ATTEND LOGIN</title>
<%@ include file="/include.jsp"%>
<!-- Bootstrap-Table -->
<script src="js/lib/bootstrapTable/bootstrap-table.js"></script>
<script src="js/lib/bootstrapTable/locale/bootstrap-table-zh-CN.js"></script>
<link href="js/lib/bootstrapTable/bootstrap-table.css" rel="stylesheet" />
</head>
<body>
<form id="formEdit" action="">
	<input type="hidden" name="editType" value="${editType}" class="form-control">
	<input type="hidden" name="createUser" value="${atd.createUser}" class="form-control">
	<input type="hidden" name="id" value="${atd.id}" class="form-control">
	<div class="form-group">
	    <label for="username">username</label>
	    <input type="text" name="username" value="${atd.username}" class="form-control">
	</div>
	<div class="form-group">
	    <label for="project">project</label>
	    <input type="text" name="project" value="${atd.project}" class="form-control">
	</div>
	<div class="form-group">
	    <label for="work">work</label>
	    <input type="text" name="work" value="${atd.work}" class="form-control">
	</div>
	<div class="form-group">
	    <label for="workType">workType</label>
	    <input type="text" name="type" value="${atd.type}" class="form-control">
	</div>
	<div class="form-group">
	    <label for="startTime">startTime</label>
	    <input type="datetime" name="startTime" value="${atd.startTime}" class="form-control">
	</div>
	<div class="form-group">
	    <label for="endTime">endTime</label>
	    <input type="datetime" name="endTime" value="${atd.endTime}" class="form-control">
	</div>
	<div class="form-group">
	    <label for="remark">remark</label>
	    <textarea  name="remark" rows="3" cols="" class="form-control">${atd.remark}</textarea>
	</div>
</form>
</body>
<script type="text/javascript">
</script>
</html>