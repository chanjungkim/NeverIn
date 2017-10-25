<%@page import="vo.Article"%>
<%@page import="vo.Reply"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<html>
<head>
<title>�� �б� ȭ��</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>�� �ۼ� ȭ��</title>
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
</head>
<body>
<jsp:include page="../menu.jsp"/>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"></c:set>
<%
	Article article = 
				(Article) request.getAttribute("article");
%>
<c:set var="writer" value="<%=article.getWriter()%>"></c:set>
<div class="container">
	<table class="table table-bordered">
		<tr colspin="2">
			<span class="badge"><h2>Q</h2></span>
		</tr>
		<tr>
			<td id="num">�۹�ȣ:</td>
			<td><%=article.getAritlcleNum()%></td>
		</tr>
		<tr>
			<td id="title">����:</td>
			<td><%=article.getTitle()%></td>
		</tr>
		<tr>
			<td id="writer">�ۼ���:</td>
			<td><%=article.getWriter()%></td>
		</tr>
		<tr>
			<td id="date">�ۼ���:</td>
			<td><%=article.getWriteDate()%></td>
		</tr>
		<tr>
			<td id="count"">��ȸ��:</td>
			<td><%=article.getReadCount()%></td>
		</tr>
		<tr>
			<td id="content">����:</td>
			<td width="80%" ></style>><%=article.getContents()%></td>
		</tr>
	</table>
	<c:forEach var="reply" items="${replyList}">
		<table class="table table-bordered">
			<tr>
				<td colspan="2">
				<span class="badge"><h2>A</h2></span>
				${reply.writer}���� �亯�Դϴ�.</td>
			</tr>
			<tr>
				<td colspan="2"><h4>${reply.writeTime}</h4></td>
				
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
	</div>
</body>
</html>