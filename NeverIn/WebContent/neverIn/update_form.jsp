<%@page import="vo.Article"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>수정할 내용 입력 화면</title>
</head>
<%
	Article original = 
		(Article) request.getAttribute("original");
%>
<body>
<jsp:include page="../menu.jsp"/>

	<form action="<%=request.getContextPath()%>/board" 
												method="post">
	<input type="hidden" name="type" value="update">
	<input type="hidden" name="articleNum" 
					value="<%=original.getAritlcleNum()%>">												
	<table border="1">
		<tr>
			<td>제목:</td>
			<td>
				<input type="text" name="title" 
					size="10" value="<%=original.getTitle()%>">
			</td>
		</tr>

		<tr>
			<td>내용:</td>
			<td>
				<textarea rows="5" cols="10" name="contents"><%=original.getContents()%></textarea>
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