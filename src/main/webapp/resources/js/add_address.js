/**
 * 增加地址/删除
 */

function addAddress_form() {
	var formData = new FormData($("#add_form")[0]);
	$("#modal-container-900242").modal('hide');
	$.ajax({
		url : '/AddressAjax/addAddress',
		type : 'POST',
		data : formData,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(returndata) {
			var state = returndata.state;
			console.log(state);
			switch (state) {
			case "1":
				$("#show_content").text("上传成功");
				var tem = returndata.re;
				$("#user_table").bootstrapTable('append', tem);
				break;
			case "2":
				$("#show_content").text("上传失败");
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

function delete_add(tt) {
	$.get('/AddressAjax/deleteAddress/' + tt, function(data) {
		var state = data.state;
		switch (state) {
		case "1":
			$("#show_content").text("删除成功！");
			$("#address_table").bootstrapTable('removeByUniqueId', tt);
			break;
		case "2":
			$("#show_content").text("删除失败！");
			break;
		}
		$("#myModal").modal('show');
		setTimeout("$('#myModal').modal('hide')", 800);
	});
}