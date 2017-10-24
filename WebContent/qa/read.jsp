<%@page import="vo.Article"%>
<%@page import="vo.Reply"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<html>
<head>
<title>�� �б� ȭ��</title>
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
			<td>�۹�ȣ:</td>
			<td><%=article.getAritlcleNum()%></td>
		</tr>
		<tr>
			<td>����:</td>
			<td><%=article.getTitle()%></td>
		</tr>
		<tr>
			<td>�ۼ���:</td>
			<td><%=article.getWriter()%></td>
		</tr>
		<tr>
			<td>�ۼ���:</td>
			<td><%=article.getWriteDate()%></td>
		</tr>
		<tr>
			<td>��ȸ��:</td>
			<td><%=article.getReadCount()%></td>
		</tr>
		<tr>
			<td>����:</td>
			<td><%=article.getContents()%></td>
		</tr>
	</table>
	<c:forEach var="reply" items="${replyList}">
		<table border="1">
			<tr>
				<td colspan="2">${reply.writer}���� �亯�Դϴ�.</td>
			</tr>
			<tr>
				<td>${reply.writer}</td>
				<td>${reply.writeTime}</td>
			</tr>
			<tr>
				<td colspan="2">${reply.contents}</td>
			</tr>
		</table>
	</c:forEach>
	<c:if test="${sessionScope.loginId == writer}" >	
	<a href=
	"<%=request.getContextPath()%>/board?type=updateForm&articleNum=<%=article.getAritlcleNum()%>">
		[�����ϱ�]
	</a>
	<a href=
	"<%=request.getContextPath()%>/board?type=deleteForm&articleNum=<%=article.getAritlcleNum()%>">
		[�����ϱ�]
	</a>
	</c:if>
	<a href=
	"<%=request.getContextPath()%>/board?type=boardList">
		[�Խ��� �������]
	</a>
	<c:if test="${sessionScope.loginId != writer}" >	
	<a href=
	"<%=request.getContextPath()%>/reply?type=replyForm&articleNum=<%=article.getAritlcleNum()%>">
		[�亯�ϱ�]
	</a>
	</c:if>
</body>
</html>