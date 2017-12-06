<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1{
	text-align: center;
}
table {
	margin: 0 auto;
	border: 1px solid #ddd;
	border-collapse: collapse;
	width: 500px;
}
td{
	border: 1px solid #ddd;
	height: 25px;
	text-align: center;
}
.content{
	height: 100px;
}
</style>
</head>
<body>
	<h1>${board} View Page</h1>
	
	<table>
		<tr>
			<td>${view.num}</td>
			<td colspan="2">${view.title}</td>
		</tr>
		<tr>
			<td>글쓴이: ${view.writer}</td>
			<td>등록일: ${view.reg_date}</td>
			<td>조회수: ${view.hit}</td>
		</tr>
		<tr>
			<td class="content" colspan="3">${view.contents}</td>
		</tr>
	</table>
	
	<c:forEach items="${view.ar}" var="file">
		<a href="../util/download?filename=${file.filename}&oriname=${file.oriname}">${file.oriname}</a>
	</c:forEach>	
	
	<a href="./${board}Update?num=${view.num}">Update</a>
	<a href="./${board}Delete?num=${view.num}">Delete</a>
	<a href="./${board}List">list</a>
</body>
</html>