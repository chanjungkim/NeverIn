<%@page import="vo.FreeBoardArticle"%>
<%@page import="vo.FreeBoardArticlePage"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<html>
<head>
<title>게시판 목록</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>

<body>
<jsp:include page="../menu.jsp"/>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
	<h2>이곳은 자유게시판 화면 입니다.</h2>
	<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	<c:choose>	
		<c:when test="${empty freeboardarticlePage.freeboardarticleList}">	
			<tr>
				<td colspan="5">
					작성된 게시글이 존재하지 않습니다.
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
<!-- 하단 페이지 링크 걸기 -->
	<div>
		<c:if test="${freeboardarticlePage.startPage>1}">
		<a href="${myContextPath}/freeboard?p=${freeboardarticlePage.startPage-1}"> 
		[이전] </a>
		</c:if>
		<c:forEach begin="${freeboardarticlePage.startPage}" 
						end="${freeboardarticlePage.endPage}" var="i">		
			<a href="${myContextPath}/freeboard?p=${i}"> ${i} </a>
		</c:forEach>
		<c:if test="${freeboardarticlePage.endPage<freeboardarticlePage.totalPage}">
		<a href="${myContextPath}/freeboard?p=${freeboardarticlePage.endPage+1}"> 
		[다음] </a>
		</c:if>			
	</div>
	<div>
		<c:if test="${not empty sessionScope.loginId}">
			<a href="${myContextPath}/freeboard?type=writeForm">
				<button>글쓰기</button>
			</a>
		</c:if>
	</div>
	</div>
</body>
</html>




