<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
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
						<label>选择购买数量:<input type="number" style="width: 40px"></input></label>
						<div>
							<a class="btn btn-primary">立即购买</a> <a class="btn btn-danger">加入购物车</a>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>