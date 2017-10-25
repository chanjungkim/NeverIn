<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>글 작성 화면</title>
<style type="text/css">
#writer1{
	background-color: cce;
}
#title{
	background-color: cce;
}
#content{
background-color: cce;

}



</style>

</head>
<body>
<jsp:include page="../menu.jsp"/>

	<div class="container">
	<form action="<%=request.getContextPath()%>/board" method="post" >
		<input type="hidden" name="type" value="write">												
	<table class="table table-bordered" >
		<tr>
			<td id="title"><h4>제목:</h4></td>
			<td>
				<input type="text" name="title" size="40">
			</td>
		</tr>
		<tr>
			<td id="writer1" ><h4>작성자:</h4></td>
			<td >
				<input type="text" name="writer" value="${sessionScope.loginId}" disabled="disabled">
				<input type="hidden" name="writer" value="${sessionScope.loginId }">
			</td>
		</tr>
		<tr>
			<td id="content"><h4>내용:</h4></td>
			<td width="80%">
				<textarea rows="20" cols="80" name="contents"  placeholder="여기에 내용을 입력하세요."></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="작성완료">
			</td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>