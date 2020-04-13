<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>帖子回复列表</title>
<style type="text/css">
	/*上下居中*/
	.vitar{
		height: 100px;
		line-height: 100px;
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
		<h1 class="text-center vitar">回复帖子列表</h1>
		<div class="text-right" style="height:50px;">
			<a href="addReply.jsp">添加回复</a>
			<a href="index.jsp">返回帖子列表</a>
		</div>
		<table class="table table-hover">
			<tr class="warning">
				<th>回复内容</th>
				<th>回复昵称</th>
				<th>发布时间</th>
			</tr>
			<c:forEach items="${rlist }" var="r">
				<tr class="active">
					<td>${r.content }</td>
					<td>${r.author }</td>
					<td>
						<fmt:formatDate value="${r.createdate }" pattern="YYYY-MM-dd HH:mm:ss"/>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>