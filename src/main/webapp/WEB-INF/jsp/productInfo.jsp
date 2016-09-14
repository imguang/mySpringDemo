<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
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
								<li class="active"><a href="/main/index">商品</a></li>
								<li><a href="/cart">购物车<span class="badge" id="badge">${fn:length(cart)}</span></a></li>
								<li><a href="/order/total">订单中心</a></li>
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
				<ul class="breadcrumb">
					<li><a href="/main/index">首页</a></li>
					<li class="active">${product.gName}</li>
				</ul>
				<div class="row clearfix" style="padding-top: 50px;">
					<div class="col-md-6 column">
						<img src="${product.gImgurl}" class="center-block" />
					</div>
					<div class="col-md-6 column">
						<h2 class="center-block">${product.gName}</h2>
						<div>
							<label>价格：${product.gPrice}</label><label>元</label>
						</div>
						<div>
							<label>简介：${product.gDescription}</label>
						</div>
						<div>
							<label>库存数量：${product.gNum}</label>
						</div>
						<form id="addCartForm">
							<input type="hidden" name="productId" id="productId"
								value="${product.id}" /> <label>选择购买数量:</label><input
								type="number" name="number" style="width: 40px" min="1"
								max="${product.gNum}" value="1" />
						</form>
						<div>
							<a class="btn btn-primary">立即购买</a> <a class="btn btn-danger"
								onclick="addCart()">加入购物车</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="myModal" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body" id="show_content">这里是弹窗的内容</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/productInfo_addcart.js"></script>
</body>
</html>