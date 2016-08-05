/**
 * 添加购物车、立即购买
 */
function model() {
	$('#myModal').modal('show');
}
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
			$('#myModal').modal('show');
			var state = returndata.state;
			var num = returndata.cartNum;
			switch (state) {
			case "1":
				$("#badge").text(num);
				$("#show_content").text("添加成功！");
				break;
			case "2":
				$("#show_content").text("请先登录！");
				break;
			}
			setTimeout("$('#myModal').modal('hide')", 1000);
		},
		error : function() {
			alert("failed!");
		}
	});
}