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
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading" data-toggle="collapse"
						data-target="#page-stats">Latest Stats</div>
					<div id="page-stats" class="panel-body collapse in">
						<div class="stat-widget-container">
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">2,500</p>
									<p class="detail">Accounts</p>
								</div>
							</div>
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">3,299</p>
									<p class="detail">Subscribers</p>
								</div>
							</div>
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">$1,500</p>
									<p class="detail">Pending</p>
								</div>
							</div>
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">$12,675</p>
									<p class="detail">Completed</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="btn-toolbar">
					<button class="btn btn-primary">
						<i class="fa fa-plus"></i> New User
					</button>
					<button class="btn">Import</button>
					<button class="btn">Export</button>
					<div class="btn-group"></div>
				</div>
				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Username</th>
								<th style="width: 26px;"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Mark</td>
								<td>Tompson</td>
								<td>the_mark7</td>
								<td><a href="user.html"><i class="icon-pencil"></i></a> <a
									href="#myModal" role="button" data-toggle="modal"><i
										class="icon-remove"></i></a></td>
							</tr>
							<tr>
								<td>2</td>
								<td>Ashley</td>
								<td>Jacobs</td>
								<td>ash11927</td>
								<td><a href="user.html"><i class="icon-pencil"></i></a> <a
									href="#myModal" role="button" data-toggle="modal"><i
										class="icon-remove"></i></a></td>
							</tr>
							<tr>
								<td>3</td>
								<td>Audrey</td>
								<td>Ann</td>
								<td>audann84</td>
								<td><a href="user.html"><i class="icon-pencil"></i></a> <a
									href="#myModal" role="button" data-toggle="modal"><i
										class="icon-remove"></i></a></td>
							</tr>
							<tr>
								<td>4</td>
								<td>John</td>
								<td>Robinson</td>
								<td>jr5527</td>
								<td><a href="user.html"><i class="icon-pencil"></i></a> <a
									href="#myModal" role="button" data-toggle="modal"><i
										class="icon-remove"></i></a></td>
							</tr>
							<tr>
								<td>5</td>
								<td>Aaron</td>
								<td>Butler</td>
								<td>aaron_butler</td>
								<td><a href="user.html"><i class="icon-pencil"></i></a> <a
									href="#myModal" role="button" data-toggle="modal"><i
										class="icon-remove"></i></a></td>
							</tr>
							<tr>
								<td>6</td>
								<td>Chris</td>
								<td>Albert</td>
								<td>cab79</td>
								<td><a href="user.html"><i class="icon-pencil"></i></a> <a
									href="#myModal" role="button" data-toggle="modal"><i
										class="icon-remove"></i></a></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div >
					<ul class="pagination">
						<li><a href="#">Prev</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">Next</a></li>
					</ul>
				</div>

				<div class="modal small hide fade" id="myModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">Delete Confirmation</h3>
					</div>
					<div class="modal-body">
						<p class="error-text">
							<i class="icon-warning-sign modal-icon"></i>Are you sure you want
							to delete the user?
						</p>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
						<button class="btn btn-danger" data-dismiss="modal">Delete</button>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>