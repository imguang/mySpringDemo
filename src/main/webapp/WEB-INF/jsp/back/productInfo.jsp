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
					<li><a href="/admin">用户管理</a></li>
					<li class="active"><a href="#">商品信息管理</a></li>
					<li><a href="#">loading...</a></li>
				</ul>
				<table id="tb_departments" style=""></table>
				<div id="toolbar" class="btn-group">
					<button id="btn_add" type="button" href="#modal-container-900242"
						data-toggle="modal" class="btn btn-danger">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
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
	<!-- 增加模态框 -->

	<div class="modal fade" id="modal-container-900242" role="dialog"
		aria-labelledby="addModalLabel" aria-hidden="true"
		style="display: none;">
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
		aria-labelledby="myModalLabel" aria-hidden="true"
		style="display: none;">
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

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/productInfo.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/table.js"></script>
</body>

</html>