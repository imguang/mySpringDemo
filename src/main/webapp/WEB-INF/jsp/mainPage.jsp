<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
<style type="text/css">
body {
	padding-top: 70px;
}
</style>
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

				<div class="row " style="padding-top: 50px;">
					<c:forEach items="${products}" var="product" varStatus="status">
						<div class="col-md-4 ">
							<div class="thumbnail ">
								<img class="lazy" alt="300x200 "
									data-original="${product.gImgurl }" />
								<div class="caption ">
									<h3>${product.gName}</h3>
									<p>¥${product.gPrice}</p>
									<p>${product.gDescription }</p>
									<p>
										<a class="btn btn-primary " href="/product/${product.id}">浏览</a>
										<a class="btn btn-danger" href="# ">收藏</a>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="text-center">
					<ul class="pagination">
						<c:if test="${pageInfo.nowPage != '1'}">
							<li><a
								href="/main/index?nowPage=1&onePageNum=${pageInfo.onePageNum}">
									<<</a></li>
						</c:if>
						<c:if test="${pageInfo.nowPage - 1 > 0}">
							<li><a
								href="/main/index?nowPage=${pageInfo.nowPage - 1}&onePageNum=${pageInfo.onePageNum}">
									<</a></li>
						</c:if>
						<c:if test="${pageInfo.nowPage - 2 > 0}">
							<li><a
								href="/main/index?nowPage=${pageInfo.nowPage - 2}&onePageNum=${pageInfo.onePageNum}">${pageInfo.nowPage - 2}</a></li>
						</c:if>
						<c:if test="${pageInfo.nowPage - 1 > 0}">
							<li><a
								href="/main/index?nowPage=${pageInfo.nowPage - 1}&onePageNum=${pageInfo.onePageNum}">${pageInfo.nowPage - 1}</a></li>
						</c:if>
						<li class="active"><a href="#">${pageInfo.nowPage}</a></li>
						<c:if test="${pageInfo.nowPage + 1 <= pageInfo.totPage}">
							<li><a
								href="/main/index?nowPage=${pageInfo.nowPage + 1}&onePageNum=${pageInfo.onePageNum}">${pageInfo.nowPage + 1}</a></li>
						</c:if>
						<c:if test="${pageInfo.nowPage + 2 <= pageInfo.totPage}">
							<li><a
								href="/main/index?nowPage=${pageInfo.nowPage + 2}&onePageNum=${pageInfo.onePageNum}">${pageInfo.nowPage + 2}</a></li>
						</c:if>
						<c:if test="${pageInfo.nowPage + 1 <= pageInfo.totPage}">
							<li><a
								href="/main/index?nowPage=${pageInfo.nowPage + 1}&onePageNum=${pageInfo.onePageNum}">></a></li>
						</c:if>
						<c:if test="${pageInfo.nowPage != pageInfo.totPage}">
							<li><a
								href="/main/index?nowPage=${pageInfo.totPage}&onePageNum=${pageInfo.onePageNum}">>></a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
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