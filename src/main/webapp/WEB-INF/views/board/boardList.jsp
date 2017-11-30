<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$(".list").click(function () {
			var cur=$(this).attr("title");
			var s = '${pager.search}';
			var t = '${pager.kind}';
			document.frm.curPage.value=cur;
			document.frm.search.value=s;
			document.frm.kind.value=t;
			document.frm.submit();
		});
	});
</script>
<style type="text/css">
	.list{
	cursor: pointer;}
</style>
</head>
<body>

	<h1>${board}List</h1>
	<form name="frm" action="./${board}List" method="get">
	<input type="hidden" name="curPage" value="1">
		<select name="kind">
			<option>Title</option>
			<option>Writer</option>
			<option>Contents</option>

		</select> <input type="text" name="search">
		<button>검색</button>
	</form>
	<table>
		<tr>
			<td>NUM</td>
			<td>TITLE</td>
			<td>WRTIER</td>
			<td>CONTENTS</td>
			<td>DATE</td>
			<td>HIT</td>
		</tr>

		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td><c:catch>
						<c:forEach begin="1" end="${dto.depth}">
			--
			</c:forEach>
					</c:catch> ${dto.title}</td>
				<td>${dto.writer}</td>
				<td>${dto.contents}</td>
				<td>${dto.reg_date}</td>
				<td>${dto.hit}</td>
			</tr>
		</c:forEach>




	</table>

	<div>
		<c:if test="${pager.curBlock gt 1}">
			<span class="list" title="${pager.startNum-1}">[이전]</span>
		</c:if>
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<span class="list" title="${i}">${i}</span>
			</c:forEach>
			<c:if test="${pager.curBlock lt pager.totalBlock}">
				<span class="list" title="${pager.lastNum+1}">[다음]</span>
			</c:if>
	</div>









</body>
</html>