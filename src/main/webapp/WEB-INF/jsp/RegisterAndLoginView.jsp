<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<meta charset="utf-8" />
<title>登录注册</title>
<!--用百度的静态资源库的cdn安装bootstrap环境-->
<!-- Bootstrap 核心 CSS 文件 -->
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<!--font-awesome 核心我CSS 文件-->
<link
	href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<!-- 在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- Bootstrap 核心 JavaScript 文件 -->
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<!--jquery.validate-->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-form.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/sha1.js"></script>
<style type="text/css">
body {
	background: url(<%=path%>/resources/img/4.jpg) no-repeat;
	background-size: <span style="font-family: 微软雅黑; background-color: rgb(239, 239, 239);">cover</span>;
	font-size: 16px;
}

.form {
	background: rgba(255, 255, 255, 0.2);
	width: 400px;
	margin: 100px auto;
}

#div1 {
	display: block;
}

#div2 {
	display: none;
}

.fa {
	display: inline-block;
	top: 27px;
	left: 6px;
	position: relative;
	color: #ccc;
}

input[type="text"], input[type="password"] {
	padding-left: 26px;
}

.checkbox {
	padding-left: 21px;
}
</style>
</head>

<body>
	<div class="container">
		<div class="modal fade" id="myModal" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body" id="show_content">这里是弹窗的内容</div>
				</div>
			</div>
		</div>
		<div class="form row" id="div1">
			<form class="form-horizontal col-sm-offset-3 col-md-offset-3"
				id="login_form">
				<h3 class="form-title">Login to your account</h3>
				<div class="col-sm-9 col-md-9">
					<div class="form-group">
						<i class="fa fa-user fa-lg"></i> <input
							class="form-control required" type="text" placeholder="Username"
							name="userName" autofocus="autofocus" maxlength="20"
							id="loginUserName" />
					</div>
					<div class="form-group">
						<i class="fa fa-lock fa-lg"></i> <input
							class="form-control required" type="password"
							placeholder="Password" name="password" maxlength="8"
							id="loginPassword" />
					</div>
					<div class="form-group">
						<label class="checkbox"> <input type="checkbox"
							name="remember" value="1" /> Remember me
						</label>
					</div>
					<div class="form-group">
						<a href="javascript:;" id="register_btn" class="">Create an
							account</a> <input type="submit" class="btn btn-success pull-right"
							value="Login " />
					</div>
				</div>
			</form>
		</div>

		<div class="form row" id="div2">
			<form class="form-horizontal col-sm-offset-3 col-md-offset-3"
				id="register_form" method="post" action="/count/register">
				<h3 class="form-title">Regist an account</h3>
				<div class="col-sm-9 col-md-9">
					<div class="form-group">
						<i class="fa fa-user fa-lg"></i> <input
							class="form-control required" type="text" placeholder="Username"
							name="userName" autofocus="autofocus" id="registUserName" />
					</div>
					<div class="form-group">
						<i class="fa fa-lock fa-lg"></i> <input
							class="form-control required" type="password"
							placeholder="Password" name="password" id="registPassword" />
					</div>
					<div class="form-group">
						<i class="fa fa-check fa-lg"></i> <input
							class="form-control required" type="password" name="rePassword"
							placeholder="Re-type Your Password" />
					</div>
					<div class="form-group">
						<i class="fa fa-envelope fa-lg"></i> <input
							class="form-control eamil" type="text" placeholder="Email"
							name="email" />
					</div>
					<div class="form-group">
						<div class="input-group">
							<input class="form-control required" type="text"
								placeholder="验证码" name="code" />
							<div class="input-group-addon">
								<img id="kaptchaImage" src="/count/img" onclick="changeCode()" />
							</div>
						</div>
						<a href="#" onclick="changeCode()">看不清楚？换一张！</a>
					</div>
					<div class="form-group">
						<a href="javascript:;" id="back_btn" class="pull-left">Back</a> <input
							type="submit" class="btn btn-success pull-right" value="Sign Up " />
						<!--<input type="submit" class="btn btn-info pull-left" id="back_btn" value="Back" />-->
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/main.js"></script>
</body>

</html>