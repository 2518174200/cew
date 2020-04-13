<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>帖子列表页面</title>
<style type="text/css">
	/*上下居中*/
	.vitar{
		height: 80px;
		line-height: 80px;
		/* border:1px solid red; */
	}
</style>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
<!-- 引用js，先引用jQuery，在引用bootstarp -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 class="text-center vitar">帖子列表</h2>
		<form action="FindByTitle" method="post" class="form-inline" role="form">
			<div class="form-group">
				<label>帖子标题：</label><input type="text" class="form-control" name="title" value="">
				<button type="submit" class="btn btn-primary btn-lg">搜索</button>
			</div>
		</form>
		<table class="table table-hover">
			<tr>
				<th>标题</th>
				<th>内容摘要</th>
				<th>作者</th>
				<th>发布时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${list }" var="invi">
				<tr>
					<td>${invi.title }</td>
					<td>${invi.summary }</td>
					<td>${invi.author }</td>
					<td><fmt:formatDate value="${invi.createdate }" pattern="YYYY-MM-dd HH:mm:ss"/></td>
					<td><a href="LookReply?inviId=${invi.id}">查看回复</a>&nbsp;&nbsp;<a href="DeleteInvi?id=${invi.id }">删除帖子</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>