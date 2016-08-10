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
	href="<%=request.getContextPath()%>/resources/css/iF.step.css" />
<style>
.table th, .table td {
	text-align: center;
	vertical-align: middle !important;
	height: 38px;
}

p {
	display: inline
}

body {
	padding-top: 70px;
}

em {
	color: #f40;
	font-weight: 700;
	font-size: 18px;
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
								<li><a href="/cart">购物车<span class="badge">${fn:length(cart)}</span></a></li>
								<li><a href="#">订单中心</a></li>
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
				<div>
					<ol class="ui-step ui-step-yellow ui-step-3">
						<li class="step-start step-done">
							<div class="ui-step-line"></div>
							<div class="ui-step-cont">
								<span class="ui-step-cont-number">1</span> <span
									class="ui-step-cont-text">查看购物车</span>
							</div>
						</li>
						<li class="step-active">
							<div class="ui-step-line"></div>
							<div class="ui-step-cont">
								<span class="ui-step-cont-number">2</span> <span
									class="ui-step-cont-text">确认订单</span>
							</div>
						</li>
						<li class="step-end">
							<div class="ui-step-line"></div>
							<div class="ui-step-cont">
								<span class="ui-step-cont-number">3</span> <span
									class="ui-step-cont-text">完成订单</span>
							</div>
						</li>
					</ol>
				</div>
				<br />
				<!-- 显示内容 -->
				<strong>选择收货地址</strong> <br /> <br /> <br /> <strong>确认订单信息</strong><br />
				<table class="table table-striped">
					<form>
						<thead>
							<tr>
								<th>图片</th>
								<th>名称</th>
								<th>单价</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cartItems}" var="item" varStatus="status">
								<tr>
									<th>${item.gImgurl}</th>
									<th>${item.gName}</th>
									<th>${item.gPrice}</th>
									<th>${item.needNum}</th>
									<th>${item.needNum * item.gPrice}</th>
								</tr>
							</c:forEach>
						</tbody>
					</form>
				</table>
				<div class="pull-right">
					<p class="money">
						<span class="hd">实付款：</span><span class="bd"><span
							class="tc-rmb">￥</span><strong id="J_RealPay">${tot_money}</strong></span>
					</p>
					<br />
					<button class="btn btn-danger pull-right">提交订单</button>
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
		src="<%=request.getContextPath()%>/resources/js/jquery.spinner.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery.json-2.4.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/cart_table.js"></script>
</body>

</html>