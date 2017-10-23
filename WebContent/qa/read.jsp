<%@page import="vo.Article"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>글 읽기 화면</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>

<%
	Article article = 
				(Article) request.getAttribute("article");
%>
	<table border="1">
		<tr>
			<td>글번호:</td>
			<td><%=article.getAritlcleNum()%></td>
		</tr>
		<tr>
			<td>제목:</td>
			<td><%=article.getTitle()%></td>
		</tr>
		<tr>
			<td>작성자:</td>
			<td><%=article.getWriter()%></td>
		</tr>
		<tr>
			<td>작성일:</td>
			<td><%=article.getWriteDate()%></td>
		</tr>
		<tr>
			<td>조회수:</td>
			<td><%=article.getReadCount()%></td>
		</tr>
		<tr>
			<td>내용:</td>
			<td><%=article.getContents()%></td>
		</tr>
	</table>
	<a href=
	"<%=request.getContextPath()%>/board?type=updateForm&articleNum=<%=article.getAritlcleNum()%>">
		[수정하기]
	</a>
	<a href=
	"<%=request.getContextPath()%>/board?type=deleteForm&articleNum=<%=article.getAritlcleNum()%>">
		[삭제하기]
	</a>
	<a href=
	"<%=request.getContextPath()%>/board?type=boardList">
		[게시판 목록으로]
	</a>
</body>
</html>





