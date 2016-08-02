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
	
</script>
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
		<!-- 提示模态框 -->
		<div class="modal fade" id="myModal" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body" id="show_content">这里是弹窗的内容</div>
				</div>
			</div>
		</div>
		<!-- 增加模态框 -->
		<div class="modal fade" id="modal-container-900242" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">添加商品</h4>
					</div>
					<div class="modal-body">
						<form role="form" id="addPro_form" enctype="multipart/form-data">
							<div class="form-group">
								<label for="exampleInputEmail1">商品名称：</label><input type="text"
									class="form-control" id="gName" name="gName" placeholder="名称" />
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">商品价格：</label><input
									type="text" class="form-control" id="gPrice" name="gPrice"
									placeholder="价格" />
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">商品数量：</label><input
									type="text" class="form-control" id="gNum" name="gNum"
									placeholder="数量" />
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">商品描述：</label><input
									type="text" class="form-control" id="gDescription"
									name="gDescription" placeholder="描述" />
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">选择图片：</label><input
									type="file" class="form-control" id="img" name="img" />
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary"
							onclick="addPro_form()">增加</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 修改模态框 -->
		<div class="modal fade" id="modal-container-edit" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">修改商品</h4>
					</div>
					<div class="modal-body">
						<form role="form" id="editPro_form" enctype="multipart/form-data">
							<input type="hidden" id="idEdit" name="id" />
							<div class="form-group">
								<label for="exampleInputEmail1">商品名称：</label><input type="text"
									class="form-control" id="gNameEdit" name="gName"
									placeholder="名称" />
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">商品价格：</label><input
									type="text" class="form-control" id="gPriceEdit" name="gPrice"
									placeholder="价格" />
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">商品数量：</label><input
									type="text" class="form-control" id="gNumEdit" name="gNum"
									placeholder="数量" />
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">商品描述：</label><input
									type="text" class="form-control" id="gDescriptionEdit"
									name="gDescription" placeholder="描述" />
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">更改图片：</label><input
									type="file" class="form-control" id="imgEdit" name="img" />
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary"
							onclick="editPro_form()">修改</button>
					</div>
				</div>
			</div>
		</div>

		<div class="row clearfix">
			<div class="col-md-12 column">

				<ul class="nav nav-tabs">
					<li><a href="/admin">用户管理</a></li>
					<li class="active"><a href="#">商品信息管理</a></li>
					<li><a href="#">loading...</a></li>
					<li class="pull-right"><a href="#modal-container-900242"
						data-toggle="modal">新增</a></li>
				</ul>
				<!-- <button href="#modal-container-900242" class="btn btn-info"
					data-toggle="modal">新增</button> -->
				<table class="table">
					<thead>
						<tr>
							<th>编号</th>
							<th>图片</th>
							<th>商品名称</th>
							<th>价格</th>
							<th>数量</th>
							<th>简介</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${products }" varStatus="status">
							<tr
								<c:if test="${(status.index + 1) % 2 == 0 }">
								 class="active"
							</c:if>>
								<td>${status.index+1 }</td>
								<td><img alt="50x50" src="${product.gImgurl} " /></td>
								<td>${product.gName }</td>
								<td>${product.gPrice }</td>
								<td>${product.gNum }</td>
								<td>${product.gDescription }</td>
								<td><a class="btn btn-danger" href="javascript:void(0)"
									onclick="deleteOneProduct(${product.id})">删除</a> <a
									class="btn btn-primary" href="javascript:void(0)"
									onclick="editModel(this,${product.id})">修改</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/productInfo.js"></script>
</body>

</html>