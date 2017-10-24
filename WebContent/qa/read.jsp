<%@page import="vo.Article"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<html>
<head>
<title>글 읽기 화면</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"></c:set>

<%
	Article article = 
				(Article) request.getAttribute("article");
%>
<c:set var="writer" value="<%=article.getWriter()%>"></c:set>

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
	<c:if test="${sessionScope.loginId == writer}" >	
	<a href=
	"<%=request.getContextPath()%>/board?type=updateForm&articleNum=<%=article.getAritlcleNum()%>">
		[수정하기]
	</a>
	<a href=
	"<%=request.getContextPath()%>/board?type=deleteForm&articleNum=<%=article.getAritlcleNum()%>">
		[삭제하기]
	</a>
	</c:if>
	<a href=
	"<%=request.getContextPath()%>/board?type=boardList">
		[게시판 목록으로]
	</a>
</body>
</html>