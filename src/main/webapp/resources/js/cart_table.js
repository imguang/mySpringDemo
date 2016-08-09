$('#checkAll').change(
		function() {
			if (this.checked) {
				$('.checkbox').prop("checked", true);
				var tot_num = new Number(0);
				var tot_money = new Number(0);
				$('.tr').each(
						function() {
							tot_num++;
							tot_money += parseInt($(this).find(".needNum")
									.val())
									* parseInt($(this).find(".price").text());
						});
				$('#tot_num').text(tot_num);
				$('#tot_money').text(tot_money);
			} else {
				$('.checkbox').prop("checked", false);
				$('#tot_num').text('0');
				$('#tot_money').text('0');
			}
		});
// checkbox进行事件绑定
$(".checkbox").change(
		function() {
			var tot_num = parseInt($('#tot_num').text());
			var tot_money = parseInt($('#tot_money').text());
			var needNum = parseInt($(this).parent().siblings(".needTd").find(
					".needNum").val());
			var price = parseInt($(this).parent().siblings(".price").text());
			var diverge = needNum * price;
			if (this.checked) {
				$(this).prop("checked", true);
				$('#tot_num').text(tot_num + 1);
				$('#tot_money').text(tot_money + diverge);
			} else {
				$(this).prop("checked", false);
				$('#tot_num').text(tot_num - 1);
				$('#tot_money').text(tot_money - diverge);
			}
		});
// 对增加减少的空间进行时间绑定
$(".spinner").spinner({}).spinner('delay', 200) // delay in ms
.spinner('changed', function(e, newVal, oldVal) {
	// remain
}).spinner(
		'changing',
		function(e, newVal, oldVal) {
			// trigger immediately
			var t = $(this).parent().parent().parent().find(".checkbox").prop(
					'checked');
			if (t) {
				var price = parseInt($(this).parent().parent().parent().find(
						".price").text());
				var tot_money = parseInt($('#tot_money').text());
				$('#tot_money').text(tot_money + (newVal - oldVal) * price);
			}
		});
// 对删除按钮进行事件绑定
$(".delete_btn").click(function() {
	var id = $(this).val();
	$.ajax({
		url : '/cartAjax/deleteOneCart/' + id,
		type : 'GET',
		context : this,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		dataType : "json",
		success : function(returndata) {
			var state = returndata.state;
			switch (state) {
			case "1":
				$("#show_content").text("删除成功");
				$(this).parent().parent().remove();
				break;
			case "0":
				$("#show_content").text("不存在");
				break;
			}
			$("#myModal").modal('show');
			setTimeout("$('#myModal').modal('hide')", 500);

		},
		error : function(returndata) {
			alert("failed!");
		}
	});
});