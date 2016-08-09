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
$(".spinner").spinner({}).spinner('delay', 200) // delay in ms
.spinner('changed', function(e, newVal, oldVal) {
	console.log(e);
}).spinner('changing', function(e, newVal, oldVal) {
	// trigger immediately
});