<%@page import="vo.FreeBoardArticle"%>
<%@page import="vo.FreeBoardArticlePage"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<html>
<head>
<title>�Խ��� ���</title>
<!-- �������� �ּ�ȭ�� �ֽ� CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- �ΰ����� �׸� -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- �������� �ּ�ȭ�� �ֽ� �ڹٽ�ũ��Ʈ -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>

<body>
<jsp:include page="../menu.jsp"/>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
	<h2>�̰��� �����Խ��� ȭ�� �Դϴ�.</h2>
	<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>�۹�ȣ</th>
			<th>����</th>
			<th>�ۼ���</th>
			<th>�ۼ���</th>
			<th>��ȸ��</th>
		</tr>
	<c:choose>	
		<c:when test="${empty freeboardarticlePage.freeboardarticleList}">	
			<tr>
				<td colspan="5">
					�ۼ��� �Խñ��� �������� �ʽ��ϴ�.
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="freeboardarticle" items="${freeboardarticlePage.freeboardarticleList}">
				<tr>
					<td>${freeboardarticle.articleNum}</td>
					<td>
						<a href="${myContextPath}/freeboard?type=read&freeboardarticleNum=${freeboardarticle.articleNum}">
						${freeboardarticle.title}
						</a>
					</td>
					<td>${freeboardarticle.writer}</td>
					<td><fmt:formatDate 
							value="${freeboardarticle.writeTime}" type="both"
								dateStyle="short" timeStyle="short"/></td>
					<td>${freeboardarticle.readCount}</td>
				</tr>
			</c:forEach>
		</c:otherwise>	
	</c:choose>	
	</table>
<!-- �ϴ� ������ ��ũ �ɱ� -->
	<div>
		<c:if test="${freeboardarticlePage.startPage>1}">
		<a href="${myContextPath}/freeboard?p=${freeboardarticlePage.startPage-1}"> 
		[����] </a>
		</c:if>
		<c:forEach begin="${freeboardarticlePage.startPage}" 
						end="${freeboardarticlePage.endPage}" var="i">		
			<a href="${myContextPath}/freeboard?p=${i}"> ${i} </a>
		</c:forEach>
		<c:if test="${freeboardarticlePage.endPage<freeboardarticlePage.totalPage}">
		<a href="${myContextPath}/freeboard?p=${freeboardarticlePage.endPage+1}"> 
		[����] </a>
		</c:if>			
	</div>
	<div>
		<c:if test="${not empty sessionScope.loginId}">
			<a href="${myContextPath}/freeboard?type=writeForm">
				<button>�۾���</button>
			</a>
		</c:if>
	</div>
	</div>
</body>
</html>




