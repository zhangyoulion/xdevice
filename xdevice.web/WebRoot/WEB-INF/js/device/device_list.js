var $tbody = $("#x-table-list").find("tbody");
var $tpl_tr = $tbody.find("tr:eq(0)").clone();
function loadDeviceList() {
	$.ajax({
		url : "device/list/1/10",
		method : "GET",
		contentType: "application/json",
		dataType:"json",
		data:{},
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
					$cl.find("td:eq(4)").text(formatTime(rec.creationDate));
					$cl.find("td:eq(5)").text(formatTime(rec.lastUpdateDate));
					$tbody.append($cl);
				}

			}

		},
		error : function(e) {
			console.log(e);
		}
	});
	$.ajax({
		url : "services/xdevice/api/deviceservice/list/1/10",
		method : "GET",
		contentType: "application/json",
		dataType:"json",
		data:{},
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
					$cl.find("td:eq(4)").text(formatTime(rec.creationDate));
					$cl.find("td:eq(5)").text(formatTime(rec.lastUpdateDate));
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