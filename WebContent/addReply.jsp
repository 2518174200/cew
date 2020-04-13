<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加回复页面</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.css">
<!-- 引用js，先引用jQuery，在引用bootstarp -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/wangEditor.min.js"></script>
</head>
<body>
	<div class="container">
		<h3 class="text-center ">添加回复</h3>
		<form action="AddReply" method="post" class="form-inline" role="form">
			<div class="row">
				<div class="form-group">
					<!-- 获得帖子的id值 -->
				    <input type="hidden" value="${inviId }" name="inviId"/>
				  </div>
			</div>
			<div class="row">
				<div class="form-group">
				    <label for="content">回复内容</label>
				    <textarea rows="5" cols="20" name="content" id="text1"></textarea>
				    <div id="editor"></div>
				  </div>
			</div>
			 <div class="row">
			 	<div class="form-group">
				    <label for="author">名称</label>
				    <input type="text" class="form-control" id="author" name="author" placeholder="请输入回复昵称">
				  </div>
			 </div>
			 <div class="row">
			 	<div class="form-group">
				    <input type="submit" class="form-control btn-primary" value="增加">
				  </div>
			 </div> 
		</form>
	</div>
	<script type="text/javascript">
		var U = window.wangEditor;
		// 通过构造函数的形式创建要操作的对象
		var editor = new U("#editor");
		var $text = $("#text1");// ${"text1"}
		$text.css("display", "none");
		editor.customConfig.onchange = function(html) {
			// 监控变化，同步更新到 textarea
			$text.val(html)
		}
		// 调用create()方法创建出富文本框编辑器
		editor.create();
	</script>
</body>
</html>