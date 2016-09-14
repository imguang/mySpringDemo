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
								<li class="active"><a href="/cart">购物车<span
										class="badge">${fn:length(cart)}</span></a></li>
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
				<!-- 显示内容 -->
				<c:choose>
					<c:when test="${total == 0}">
						<p>
							购物车空空如也，快去<a href="/main/index">选购</a>吧~
						</p>
					</c:when>
					<c:otherwise>
						<table class="table table-striped">
							<thead>
								<tr>
									<th><input type="checkbox" id="checkAll" /></th>
									<th>图片</th>
									<th>名称</th>
									<th>价格</th>
									<th>库存</th>
									<th>需要数量</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<form id="cart_table" action="/order" method="post">
									<c:forEach items="${rows}" var="item" varStatus="status">
										<tr id="tr_${item.id}" class="tr">
											<td><input type="checkbox" id="checkbox_${item.id}"
												value="${item.id}" class="checkbox" /></td>
											<td>${item.gImgurl}</td>
											<td>${item.gName }</td>
											<td class="price">${item.gPrice }</td>
											<td>${item.gNum }</td>
											<td class="needTd"><div data-trigger="spinner"
													class="spinner">
													<a href="javascript:;" data-spin="down"><span
														class="glyphicon glyphicon-minus"></span> </a> <input
														name="needNum_${item.id}" type="text"
														value="${item.needNum }" data-rule="quantity"
														data-max="${item.gNum }" style="width: 60px;"
														class="needNum"> <a href="javascript:;"
														data-spin="up"><span class="glyphicon glyphicon-plus"></span></a>
												</div></td>
											<td><button class='btn btn-primary delete_btn'
													value="${item.id}">删除</button></td>
										</tr>
									</c:forEach>
								</form>
							</tbody>
						</table>
						<div class="pull-right">
							<p>已选商品</p>
							<em id="tot_num">0</em> 件合计（不含运费）： ￥ <em id="tot_money">0</em>
							<button style="display: inline" class="btn btn-danger"
								id="summary">结算</button>
						</div>
					</c:otherwise>
				</c:choose>

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
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/util/jquery.lazyload.js"></script>
	<script type="text/javascript">
		$(function() {
			$("img.lazy").lazyload({
				threshold : 100,
				effect : "fadeIn",
			});
		});
	</script>
</body>

</html>