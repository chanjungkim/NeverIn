<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>�� �ۼ� ȭ��</title>
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
	<form action="<%=request.getContextPath()%>/reply" method="post">
		<input type="hidden" name="type" value="updateReply">
		<input type="hidden" name="articleNum" value="${reply.articleNum}">										
		<input type="hidden" name="replyNum" value="${reply.replyNum}">										

	<table class="table table-bordered" >
		<tr>
			<td id="writer1">�ۼ���:</td>
			<td>
				<input type="text" name="writer" value="${sessionScope.loginId }" size="10" disabled="disabled">
				<input type="hidden" name="writer" value="${sessionScope.loginId }">
			</td>
		</tr>
		<tr>
			<td id="content">����:</td>
			<td width="80%">
				<textarea rows="20" cols="80" name="contents">${reply.contents}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="�����Ϸ�">
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>