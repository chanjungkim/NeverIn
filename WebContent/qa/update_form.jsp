<%@page import="vo.Article"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>������ ���� �Է� ȭ��</title>
<style type="text/css">
#writer{
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
<%
	Article original = 
		(Article) request.getAttribute("original");
%>
<body>
<jsp:include page="../menu.jsp"/>
<div class="container">
	<form action="<%=request.getContextPath()%>/board" method="post">
	<input type="hidden" name="type" value="update">
	<input type="hidden" name="articleNum" 
					value="<%=original.getAritlcleNum()%>">																	
	<table class="table table-bordered">
		<tr>
			<td id="title">����:</td>
			<td>
				<input type="text" name="title" 
					size="10" value="<%=original.getTitle()%>">
			</td>
		</tr>

		<tr>
			<td id="content">����:</td>
			<td width="80%">
				<textarea rows="20" cols="80" name="contents"><%=original.getContents()%></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="�ۼ��Ϸ�">
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>