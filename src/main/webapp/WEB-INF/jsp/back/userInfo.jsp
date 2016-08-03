<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-table.css" />
<!-- <link
	href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet"> -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/sha1.js"></script>

<style>
.table th, .table td {
	text-align: center;
	vertical-align: middle !important;
	height: 38px;
}
</style>
</head>


<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#">用户管理</a></li>
					<li><a href="/admin/productInfo">商品管理</a></li>
					<li><a href="#">load...</a></li>
				</ul>

				<table id="user_table">
				</table>
				<div id="toolbar" class="btn-group">
					<button id="btn_add" type="button" href="#modal-container-900242"
						data-toggle="modal" class="btn btn-danger">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
					</button>
				</div>
				<div class="modal fade" id="modal-container-900242" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">添加账号</h4>
							</div>
							<div class="modal-body">
								<form role="form" action="/admin/add" method="post"
									id="add_form">
									<div class="form-group">
										<label for="exampleInputEmail1">账号：</label><input type="text"
											class="form-control" name="userName" placeholder="账号"
											id="loginUserName" />
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">密码：</label><input
											type="password" class="form-control" name="password"
											placeholder="密码" id="loginPassword" />
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Email：</label><input
											type="text" class="form-control" id="email" name="email"
											placeholder="email" />
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
								<button type="button" class="btn btn-primary"
									onclick="add_form()">增加</button>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/table_user.js"></script>
</body>
</html>