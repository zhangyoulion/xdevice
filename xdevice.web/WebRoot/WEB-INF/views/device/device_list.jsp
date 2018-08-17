<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/common.css" />
<style>
.x-menu {
}

.x-main {
	
}
.x-table-container .x-td{
	vertical-align: top;
	padding-top:5px;
	border:2px #fff solid;
}
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>

<body>
	<div class="x-banner">
		Device list page.
		<div style="float:right;">
			<span class="x-user">Hi,${username }</span> <span><a
				class="x-btn" href="userlogin/logout">Logout</a> </span>
		</div>
		<hr color="#fff" style="clear:both;" />
	</div>
	<div>
		<table class="x-table-container" width="100%" height="100%" border="0" style="vertical-align: top;">
			<tr>
				<td class="x-td"><div class="x-menu">
						<ul>
							<li><a href="#">User List</a></li>
							<li><a href="#">Device List</a></li>
						</ul>

					</div>
				</td>
				<td class="x-td" style="padding:0 10px;"><div class="x-main">

						<div>
							<a class="x-btn" href="javascipt:void(0)">Add</a>
						</div>
						<div>
							<table border="1" width="100%" id="x-table-list">
								<thead>
									<tr>
										<td>Device Brand</td>
										<td>Device Name</td>
										<td>Device Model</td>
										<td>Version</td>
										<td>Created Time</td>
										<td>Last Update Time</td>
										<td>Operation</td>
									</tr>
								</thead>
								<tbody style="display:none;">
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td><a class="x-btn-edit" href="javascript:void(0);">Edit</a>
											<a class="x-btn-delete" href="javascript:void(0);">Delete</a>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</td>
			</tr>
		</table>


	</div>
</body>
</html>
<script type="text/javascript" src="js/device/device_list.js"></script>
<script>

</script>
