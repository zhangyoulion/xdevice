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
<script type="text/javascript" src="./index.js"></script>
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
<script type="text/javascript" src="js/demo.js"></script>
</head>

<body>
	<div class="x-banner">
		Device list page.
		<div style="float:right;">
			<span class="x-user">Hi,${username }</span> <span><a
				class="x-btn" href="loginService/logout">Logout</a> </span>
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
<script>
	var $tbody = $("#x-table-list").find("tbody");
	var $tpl_tr = $tbody.find("tr:eq(0)").clone();
	function loadDeviceList() {
		$.ajax({
					url : "device/list/1/10",
					method : "GET",
					success : function(result) {

						var list = result;
						if (list.length) {
							$tbody.empty().show();
							for ( var i = 0; i < list.length; i++) {
								var rec = list[i];
								var $cl = $tpl_tr.clone();
								$cl.find("td:eq(0)").text(rec.deviceBrand);
								$cl.find("td:eq(1)").text(rec.deviceName);
								$cl.find("td:eq(2)").text(rec.deviceModel);
								$cl.find("td:eq(3)").text(rec.deviceOSVersion);
								$cl.find("td:eq(4)").text(
										formatTime(rec.creationDate));
								$cl.find("td:eq(5)").text(
										formatTime(rec.lastUpdateDate));
								$tbody.append($cl);
							}

						}

					},
					error : function(e) {
						console.log(e);
					}
				});
	}
	function formatTime(v) {
		return new Date(v).format("yyyy/MM/dd hh:mm:ss");
	}
	$(function() {
		loadDeviceList();
	});
</script>
