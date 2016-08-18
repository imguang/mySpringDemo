function add_form() {
	var a = $("#loginPassword").val();
	var b = $("#loginUserName").val();
	$("#loginPassword").val(hex_sha1(a + b));
	// $("#add_form").submit();
	var formData = new FormData($("#add_form")[0]);
	$("#modal-container-900242").modal('hide');
	$.ajax({
		url : '/userInfoAjax/addUser',
		type : 'POST',
		data : formData,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		dataType : 'json',
		success : function(returndata) {
			var state = returndata.state;
			console.log(state);
			switch (state) {
			case "1":
				$("#show_content").text("添加成功");
				var tem = returndata.re;
				$("#user_table").bootstrapTable('append', tem);
				break;
			case "2":
				$("#show_content").text("添加失败");
				break;
			}
			$("#myModal").modal('show');
			setTimeout("$('#myModal').modal('hide')", 800);
		},
		error : function(returndata) {
			alert("failed!");
		}
	});
}

function delete_one(id) {
	$.get("/userInfoAjax/deleteUser/" + id, function(response, status) {
		if (status == "success") {
			if (response.state == "1") {
				$("#show_content").text("删除成功");
				$("#user_table").bootstrapTable('removeByUniqueId', id);
			} else {
				$("#show_content").text("删除失败");
			}
		} else {
			$("#show_content").text("网络错误");
		}
		$("#myModal").modal('show');
		setTimeout("$('#myModal').modal('hide')", 800);
	}, "json");

}
function reset_one(id) {
	$.get("/userInfoAjax/resetUser/" + id, function(response, status) {
		if (status == "success") {
			if (response.state == "1") {
				$("#show_content").text("重置成功");
				var tem = $("#user_table").bootstrapTable('getRowByUniqueId',
						id);
				tem.password = response.password;
				$("#user_table").bootstrapTable('updateByUniqueId', id, tem);
			} else {
				$("#show_content").text("重置失败");
			}
		} else {
			$("#show_content").text("网络错误");
		}
		$("#myModal").modal('show');
		setTimeout("$('#myModal').modal('hide')", 800);
	}, "json");
}

$(function() {
	// 1.初始化Table
	var oTable = new TableInit();
	oTable.Init();
});

var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#user_table')
				.bootstrapTable(
						{
							url : '/backProductAjax/selectLimitUser', // 请求后台的URL（*）
							method : 'get', // 请求方式（*）
							toolbar : '#toolbar', // 工具按钮用哪个容器
							striped : true, // 是否显示行间隔色
							cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
							pagination : true, // 是否显示分页（*）
							sortable : false, // 是否启用排序
							sortOrder : "asc", // 排序方式
							queryParams : oTableInit.queryParams, // 传递参数（*）
							sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
							pageNumber : 1, // 初始化加载第一页，默认第一页
							pageSize : 10, // 每页的记录行数（*）
							pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
							search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
							strictSearch : false,
							showColumns : false, // 是否显示所有的列
							showRefresh : true, // 是否显示刷新按钮
							minimumCountColumns : 2, // 最少允许的列数
							clickToSelect : false, // 是否启用点击选中行
							uniqueId : 'id', // 每一行的唯一标识，一般为主键列
							showToggle : false, // 是否显示详细视图和列表视图的切换按钮
							cardView : false, // 是否显示详细视图
							detailView : false, // 是否显示父子表
							columns : [
									{
										field : 'id',
										title : 'id',
										align : 'center',
										visible : false
									},
									{
										field : 'userName',
										title : '名称',
										align : 'center'
									},
									{
										field : 'password',
										title : '密码',
										align : 'center'
									},
									{
										field : 'email',
										title : 'email',
										align : 'center'
									},
									{
										title : '操作',
										field : 'id',
										align : 'center',
										formatter : function(value, row, index) {
											var e = "<a href='javascript:void(0)' onclick='delete_one("
													+ row.id + ")'>删除</a> ";
											var d = "<a href='javascript:void(0)' onclick='reset_one("
													+ row.id + ")'>重置</a> ";
											return e + d;
										}
									}, ]
						});
	};

	// 得到查询的参数
	oTableInit.queryParams = function(params) {
		var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			limit : params.limit, // 页面大小
			offset : params.offset
		};
		return temp;
	};
	return oTableInit;
};
