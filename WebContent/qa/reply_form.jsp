<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>�� �ۼ� ȭ��</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>

	<form action="<%=request.getContextPath()%>/reply" 
												method="post">
		<input type="hidden" name="type" value="replyWrite">
		<input type="hidden" name="articleNum" value="<%=request.getAttribute("articleNum") %>">										
	<table border="1">
		<tr>
			<td>�ۼ���:</td>
			<td>
				<input type="text" name="writer" value="${sessionScope.loginId }" size="10">
			</td>
		</tr>
		<tr>
			<td>����:</td>
			<td>
				<textarea rows="5" cols="10" name="contents" placeholder="���⿡ ������ �Է��ϼ���."></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="�ۼ��Ϸ�">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>