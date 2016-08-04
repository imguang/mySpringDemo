<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>主页</title>
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
				<div id="top">
					<div id="topBar">
						<div class="welcome">
							<h2>
								欢迎光临！
								<c:choose>
									<c:when test="${state == '0'}">
										<a href="/count/RegisterAndLoginView ">游客,请登录！</a>
									</c:when>
									<c:otherwise>
										<a href="/count/userInfo/${userName}">${userName}</a>
									</c:otherwise>
								</c:choose>
							</h2>
						</div>
					</div>
				</div>

				<ul class="nav nav-tabs ">
					<li class="active "><a href="# ">商品</a></li>
					<li><a href="# ">购物车</a></li>
					<li class="disabled "><a href="# ">more...</a></li>
				</ul>
				<div class="row ">
					<c:forEach items="${products}" var="product" varStatus="status">
						<div class="col-md-4 ">
							<div class="thumbnail ">
								<img alt="300x200 " src="${product.gImgurl }" />
								<div class="caption ">
									<h3>${product.gName}</h3>
									<p>${product.gDescription }</p>
									<p>
										<a class="btn btn-primary " href="# ">浏览</a> <a
											class="btn btn-danger" href="# ">加入购物车</a>
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
</body>
</html>