<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-table.css" />
<style>
.table th, .table td {
	text-align: center;
	vertical-align: middle !important;
	height: 38px;
}

body {
	padding-top: 70px;
}
</style>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- 导航栏 -->
				<div class="bs-example bs-navbar-top-example">
					<nav class="navbar navbar-default navbar-fixed-top"> <!-- We use the fluid option here to avoid overriding the fixed width of a normal container within the narrow content columns. -->
					<div class="container container-fluid">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse"
								data-target="#bs-example-navbar-collapse-6"
								aria-expanded="false">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#">Brand</a>
						</div>

						<div class="collapse navbar-collapse"
							id="bs-example-navbar-collapse-6">
							<ul class="nav navbar-nav">
								<li><a href="/main/index">商品</a></li>
								<li class="active"><a href="/cart">购物车<span
										class="badge">${fn:length(cart)}</span></a></li>
								<li class="disabled "><a href="# ">more...</a></li>
							</ul>
							<p class="navbar-text navbar-right" style="padding-right: 30px">
								<c:choose>
									<c:when test="${userName ne null}">
										<a class="navbar-link" href="/userInfo/userIndex/${userName}">${userName}</a>
									</c:when>
									<c:otherwise>

										<a class="navbar-link" href="/count/RegisterAndLoginView ">游客,请登录</a>
									</c:otherwise>
								</c:choose>
							</p>
						</div>
					</div>
					</nav>
				</div>

				<table id="tb_departments" style=""></table>
				<div id="toolbar" class="btn-group">
					<button id="btn_balance" type="button" data-toggle="modal"
						class="btn btn-danger">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>结算
					</button>
					<button id="btn_delete" type="button" data-toggle="modal"
						class="btn btn-danger">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>结算
					</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 提示模态框 -->
	<div class="modal fade" id="myModal" role="dialog"
		aria-labelledby="tipModalLabel" aria-hidden="true"
		style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body" id="show_content">这里是弹窗的内容</div>
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
		src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/cart_table.js"></script>
</body>

</html>