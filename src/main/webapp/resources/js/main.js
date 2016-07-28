$().ready(function() {
	$("#login_form").validate({
		rules : {
			username : "required",
			password : {
				required : true,
				minlength : 5
			},
		},
		messages : {
			username : "请输入姓名",
			password : {
				required : "请输入密码",
				minlength : jQuery.format("密码不能小于{0}个字 符")
			}
		},
		submitHandler : function(form) {
			var a = $("#loginPassword").val();
			var b = $("#loginUserName").val();
			$("#loginPassword").val(hex_sha1(a+b));
			form.submit();
		}
	});
	$("#register_form").validate({
		rules : {
			username : "required",
			password : {
				required : true,
				minlength : 5
			},
			rpassword : {
				equalTo : "#register_password"
			},
			email : {
				required : true,
				email : true
			}
		},
		messages : {
			username : "请输入姓名",
			password : {
				required : "请输入密码",
				minlength : jQuery.format("密码不能小于{0}个字 符")
			},
			rpassword : {
				equalTo : "两次密码不一样"
			},
			email : {
				required : "请输入邮箱",
				email : "请输入有效邮箱"
			},
			code : {
				required : "请输入验证码",
				minlength : 4
			}
		},
		submitHandler : function(form) {
			var a = $("#registPassword").val();
			var b = $("#registUserName").val();

			$("#registPassword").val(hex_sha1(a + b));
			form.submit();
		}
	});
});
$(function() {
	$("#register_btn").click(function() {
		$("#div2").css("display", "block");
		$("#div1").css("display", "none");
	});
	$("#back_btn").click(function() {
		$("#div2").css("display", "none");
		$("#div1").css("display", "block");
	});
});

function changeCode() {
	var timestamp = new Date().getTime();
	$("#kaptchaImage").hide().attr('src', '/count/img?' + timestamp).fadeIn();
	event.cancelBubble = true;
}
