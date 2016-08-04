/**
 * 添加购物车、立即购买
 */
function addCart() {
	var formData = new FormData($("#addCartForm")[0]);
	$.ajax({
		url : '/cartAjax/addToCart',
		type : 'POST',
		data : formData,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(returndata) {
			var state = returndata.state;
			switch (state) {
			case "1":
				$("#show_content").text("添加成功！");
				break;
			case "2":
				$("#show_content").text("请先登录！");
				break;
			}
			$("#myModal").modal('show');
			// setTimeout("$('#myModal').modal('hide')", 1000);
		},
		error : function() {
			alert("failed!");
		}
	});
}