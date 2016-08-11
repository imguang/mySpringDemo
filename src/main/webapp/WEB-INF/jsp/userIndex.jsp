<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
<style type="text/css">
span {
	padding-right: 10px;
}
</style>
</head>

<body>

	<div class="container">
		<div class="row clearfix">
			<div class="jumbotron">
				<h1>个人主页</h1>
			</div>
			<div class="col-sm-3 col-md-3 column">
				<div style="padding-top: 30px; padding-bottom: 30px;">
					<h4>
						<strong> 您好，${userName} </strong>
					</h4>
				</div>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#"><span
							class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息</a></li>
					<li><a href="/userInfo/addressIndex" id="showAddress"><span
							class="glyphicon glyphicon-flag" aria-hidden="true"></span>管理收货地址</a></li>
					<li><a href="#"><span
							class="glyphicon glyphicon-credit-card" aria-hidden="true"></span>修改密码</a>
					</li>

					<li><a href="/cart"><span
							class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>购物车</a>
					</li>
					<li><a href="/main/index"><span
							class="glyphicon glyphicon-home" aria-hidden="true"></span>返回主页</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 column">
				<div class="container" id="container">
					<p class="container">暂时没有什么信息</p>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>

</html>