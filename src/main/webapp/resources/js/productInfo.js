var href = "'/admin/productInfo'";
function addPro_form() {
	var formData = new FormData($("#addPro_form")[0]);
	$.ajax({
		url : '/admin/dealAddPro',
		type : 'POST',
		data : formData,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(returndata) {
			$("#modal-container-900242").modal('hide');
			var state = returndata.state;
			switch (state) {
			case "1":
				$("#show_content").text("上传成功");
				setTimeout("window.location.href = " + href, 700);
				break;
			case "2":
				$("#show_content").text("上传失败");
				break;
			}
			$("#myModal").modal('show');
			setTimeout("$('#myModal').modal('hide')", 500);
		},
		error : function(returndata) {
			alert("failed!");
		}
	});
}

function editModel(id,name,price,num,description) {
	$('#idEdit').val(id);
	$('#gNameEdit').val(name);
	$('#gPriceEdit').val(price);
	$('#gNumEdit').val(num);
	$('#gDescriptionEdit').val(description);
	$('#modal-container-edit').modal('show');
}

function deleteOneProduct(id) {
	$.ajax({
		url : '/backProductAjax/deleteOneProduct/' + id,
		type : 'GET',
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(returndata) {
			var state = returndata.state;
			switch (state) {
			case "1":
				$("#show_content").text("删除成功");
				setTimeout("window.location.href = " + href, 700);
				break;
			case "2":
				$("#show_content").text("删除失败");
				break;
			case "3":
				$("#show_content").text("找不到该商品");
				setTimeout("window.location.href = " + href, 700);
				break;
			}
			$("#myModal").modal('show');
			setTimeout("$('#myModal').modal('hide')", 500);
		},
		error : function(returndata) {
			alert("failed!");
		}
	});
}

function editPro_form() {
	var formData = new FormData($("#editPro_form")[0]);
	$.ajax({
		url : '/backProductAjax/updateProduct',
		type : 'POST',
		data : formData,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(returndata) {
			$("#modal-container-edit").modal('hide');
			var state = returndata.state;
			switch (state) {
			case "1":
				$("#show_content").text("修改成功");
				setTimeout("window.location.href = " + href, 700);
				break;
			case "2":
				$("#show_content").text("修改失败");
				break;
			case "3":
				$("#show_content").text("找不到该商品");
				break;
			}
			$("#myModal").modal('show');
			setTimeout("$('#myModal').modal('hide')", 500);
		},
		error : function(returndata) {
			alert("failed!");
		}
	});
}
