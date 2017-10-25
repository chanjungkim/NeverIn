<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
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
	<form action="<%=request.getContextPath()%>/reply" 
												method="post">
		<input type="hidden" name="type" value="replyWrite">
		<input type="hidden" name="articleNum" value="<%=request.getAttribute("articleNum") %>">										
	<table class="table table-bordered" >
		<tr>
			<td id="writer1">작성자:</td>
			<td>
				<input type="text" name="writer" value="${sessionScope.loginId }" size="10" disabled="disabled">
				<input type="hidden" name="writer" value="${sessionScope.loginId }">
			</td>
		</tr>
		<tr>
			<td id="content">내용:</td>
			<td width="80%">
				<textarea rows="20" cols="80" name="contents" placeholder="여기에 내용을 입력하세요."></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="작성완료">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>