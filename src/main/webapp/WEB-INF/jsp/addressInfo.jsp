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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-table.css" />
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
					<li><a href="/userInfo/userIndex/${userName}"><span
							class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息</a></li>
					<li class="active"><a href="#" id="showAddress"><span
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
				<table id="address_table">
				</table>
				<div id="toolbar" class="btn-group">
					<button id="btn_add" type="button" href="#modal-container-900242"
						data-toggle="modal" class="btn btn-danger">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
					</button>
				</div>
			</div>
		</div>
		<div class="modal fade" id="modal-container-900242" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">新增地址</h4>
					</div>
					<div class="modal-body">
						<form role="form" action="/admin/add" method="post" id="add_form">
							<div class="form-group">
								<label for="exampleInputEmail1">账号：</label><input type="text"
									class="form-control" name="userName" placeholder="账号"
									id="loginUserName" />
							</div>
							<div class="form-group t1">
								<select name="province" id="province">
								</select> <select name="city" id="city">
								</select> <select name="county" id="county">
								</select>
							</div>

						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" onclick="add_form()">增加</button>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/resources/js/jquery-3.0.0.min.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/resources/js/bootstrap-table.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/resources/js/bootstrap-table-zh-CN.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/resources/js/address_table.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/resources/js/util/pccs.js"></script>
</body>

</html>