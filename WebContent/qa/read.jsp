<%@page import="vo.Article"%>
<%@page import="vo.Reply"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<html>
<head>
<title>글 읽기 화면</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>글 작성 화면</title>
<style type="text/css">
#writer{
	background-color: cce;
}
#title{
	background-color: cce;
}
#content{
background-color: cce;
width: -30%;
height: 30%;
}
#count{
background-color: cce;

}
#date{
background-color: cce;

}
#num{
background-color: cce;

}
</style>
</head>
<body>
<jsp:include page="../menu.jsp"/>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"></c:set>
<%
	Article article = 
				(Article) request.getAttribute("article");
	String articleNum = Integer.toString(article.getAritlcleNum());
%>
<c:set var="writer" value="<%=article.getWriter()%>"></c:set>
<div class="container">
	<table class="table table-bordered">
		<tr>
			<td colspan="2">
				<span class="badge">Q</span>
				<b><%=article.getTitle()%></b>			
			</td>
			<td>답변수:<%=article.getReplyCount()%></td>
		</tr>
		<tr>
			<td><%=article.getWriter()%></td>
			<td><%=article.getWriteDate()%></td>
			<td>조회수:<%=article.getReadCount()%></td>
		</tr>
		<tr>
			<td colspan="3"><%=article.getContents()%></td>
		</tr>
	</table>
	<c:forEach var="reply" items="${replyList}">
		<table class="table table-bordered">
			<tr>
				<td width="70%">
					<span class="badge">A</span>
					<b>${reply.writer}</b>님의 답변입니다.
				</td>
				<td>
					${reply.writeTime}
				</td>
			</tr>
			<tr>
				<td>${reply.contents}</td>
				<td>
				<c:if test="${sessionScope.loginId == reply.writer}">
					<form action="${myContextPath}/reply" method="post">
						<input type="hidden" name="type" value="edit">
						<input type="hidden" name="articleNum" value="${reply.articleNum}">
						<input type="hidden" name="replyNum" value="${reply.replyNum}">
						<input type="submit" value="수정">
					</form>					
					<form action="${myContextPath}/reply" method="post">
						<input type="hidden" name="type" value="delete">
						<input type="hidden" name="articleNum" value="${reply.articleNum}">
						<input type="hidden" name="replyNum" value="${reply.replyNum}">
						<input type="submit" value="삭제">
					</form>
				</c:if>				
				</td>
			</tr>
		</table>
	</c:forEach>
	<form action="<%=request.getContextPath()%>/board" method="get">
		<input type="hidden" name="type" value="boardList">
		<input type="submit" value="게시판 목록으로">
	</form>
	<c:if test="${sessionScope.loginId == writer}" >
		<form action="<%=request.getContextPath()%>/board" method="post">
			<input type="hidden" name="type" value="updateForm">
			<input type="hidden" name="articleNum" value="<%=article.getAritlcleNum()%>">
			<input type="submit" value="수정하기">
		</form>
		<form action="<%=request.getContextPath()%>/board" method="post">
			<input type="hidden" name="type" value="deleteForm">
			<input type="hidden" name="articleNum" value="<%=article.getAritlcleNum()%>">
			<input type="submit" value="삭제하기">
		</form>
	</c:if>
	<c:if test="${sessionScope.loginId != writer}" >	
		<a href="<%=request.getContextPath()%>/reply?type=replyForm&articleNum=<%=articleNum%>"><button>답변하기</button></a>
	</c:if>
	</div>
</body>
</html>