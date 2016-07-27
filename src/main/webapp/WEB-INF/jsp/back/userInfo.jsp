<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<!--font-awesome 核心我CSS 文件-->
<link
	href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<!-- 在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- Bootstrap 核心 JavaScript 文件 -->
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<!--jquery.validate-->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
<script type="text/javascript">
	function add_form() {
		$("#add_form").submit();
	}
</script>
</head>


<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#">用户管理</a></li>
					<li><a href="#">load...</a></li>
					<li class="pull-right">
						<button href="#modal-container-900242" class="btn btn-info"
							data-toggle="modal">新增</button>
					</li>
				</ul>
				<div>
					<form class=""></form>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>编号</th>
							<th>用户名</th>
							<th>密码</th>
							<th>邮箱</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user" varStatus="status">

							<tr
								<c:if test="${(status.index + 1) % 2 == 0 }">
								 class="active"
							</c:if>>
								<td>${status.index+1}</td>
								<td>${user.userName}</td>
								<td>${user.password}</td>
								<td>${user.email}</td>
								<td><a class="btn btn-danger"
									href="/admin/delete/${user.id}">删除</a> <a
									class="btn btn-primary" href="/admin/reset/${user.id}">重置密码</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<ul class="pagination">
					<li><a href="#">首页</a></li>
					<li><a href="#">上一页</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">下一页</a></li>
					<li><a href="#">尾页</a></li>
				</ul>

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
											class="form-control" id="userName" name="userName"
											placeholder="账号" />
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">密码：</label><input
											type="password" class="form-control" id="password"
											name="password" placeholder="密码" />
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
</body>
</html>