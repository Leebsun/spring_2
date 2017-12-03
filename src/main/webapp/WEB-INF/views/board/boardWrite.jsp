<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var index=0;
		var count=0;
		$("#add").click(function() {
			 if(index < 5){
				var s = '<div id="d'+count+'">';
				s=s+'<input type="file" name="f1"><span class="del" title="d'+count+'">X</span></div>';
				$("#files").append(s);
				count++;
				index++;
			 }else {
				 alert("Fail");
			 }
		});
		
		$("#files").on("click",".del",function(){
			var id=$(this).attr("title");
			$("#"+id).remove();
			index--;
		});
		
	});
</script>


<style type="text/css">
h1{
	text-align: center;
}
table {
	margin: 0 auto;
	width: 500px;
	border: 1px solid #ddd;
	border-collapse: collapse;
}
td{
	height: 25px;
	text-align: center;
	padding: 10px;
}
input{
	padding: 3px;
	width: 200px;
	border-radius: 4px;
	border: 1px solid #ddd;
}
.content textarea{
	height: 100px;
	width: 95%;
	border: 1px solid #ddd;
	border-radius: 4px;
	color: gray;
}
.btn{
	padding: 5px 7px;
	border-radius: 4px;
	font-size: 17px;
}
</style>
</head>
<body>
	<h1>${board} Write Form</h1>
	
	<form action="${board}Write" method="post">
		<table>
		<tr>
			<td><input type="text" name="title" placeholder="?쒕ぉ???낅젰?댁＜?몄슂."></td>
			<td><input type="text" name="writer" placeholder="湲?댁씠瑜??낅젰?댁＜?몄슂."></td>
			
		</tr>
		<tr>
			<td class="content" colspan="2"><textarea name="contents" draggable="false">?댁슜???낅젰?댁＜?몄슂.</textarea></td>
		</tr>
	</table>
	
	<input type="button" value="File Add" id="add">
	<div id="files"></div>
	
	
	<button class="btn">write</button>
	</form>
</body>
</html>