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
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/sha1.js"></script>
<script type="text/javascript">
	function addPro_form() {
		var formData = new FormData($("#addPro_form")[0]);
		$.ajax({
			url : '/admin/dealAddPro',
			type : 'POST',
			data : formData,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(returndata) {
				$("#modal-container-900242").modal('hide');
				var state = returndata.state;
				switch (state) {
				case "1":
					$("#show_content").text("上传成功");
					break;
				case "2":
					$("#show_content").text("上传失败");
					break;
				}
				$("#myModal").modal('show');
				setTimeout("$('#myModal').modal('hide')", 1000);
			},
			error : function(returndata) {
				alert("failed!");
			}
		});
	}
</script>
</head>

<body>
	<div class="container">
		<div class="modal fade" id="myModal" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body" id="show_content">这里是弹窗的内容</div>
				</div>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<button href="#modal-container-900242" class="btn btn-info"
					data-toggle="modal">新增</button>
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
										<label for="exampleInputEmail1">商品名称：</label><input
											type="text" class="form-control" id="gName" name="gName"
											placeholder="名称" />
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
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
								<button type="button" class="btn btn-primary"
									onclick="addPro_form()">增加</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>