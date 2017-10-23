<%@page import="vo.Article"%>
<%@page import="vo.ArticlePageVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
<%
// 요청을 받은 자바 서블릿이 set한 페이지 데이터를 get으로 꺼내기
	ArticlePageVO articlePage = 
		(ArticlePageVO) request.getAttribute("articlePage");
%>
<body>
<jsp:include page="../menu.jsp"/>

	<h2>이곳은 심플 게시판 화면 입니다.</h2>
	<table class="table table-striped table-hover">
		<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		</thead>
		<tbody>
	<%if(articlePage.getArticleList().size()==0){ %>
		<tr>
			<td colspan="5">
				작성된 게시글이 존재하지 않습니다.
			</td>
		</tr>
	<%}else{%>
		<%for(Article article: articlePage.getArticleList()){ %>
			<tr>
				<td><%=article.getAritlcleNum()%></td>
				<td>
					<a href="<%=request.getContextPath()%>/board?type=read&articleNum=<%=article.getAritlcleNum()%>">
						<%=article.getTitle()%>
					</a>
				</td>
				<td><%=article.getWriter()%></td>
				<td><%=article.getWriteDate()%></td>
				<td><%=article.getReadCount()%></td>
			</tr>
		<%}%>
	<%} %>	
	</tbody>	
	</table>
<!-- 하단 페이지 링크 걸기 -->
	<div class="text-center">
		<ul class="pagination">
		<%
			int startPage = articlePage.getStartPage();
			int endPage = articlePage.getEndPage();
			for(int i=startPage; i<=endPage; i++){
		%>
			<li><a href="board?type=boardList&p=<%=i%>"> <%=i%> </a></li>
		<%	} %>
		</ul>
	</div>
	<div>
		<a href=
		"<%=request.getContextPath()%>/board?type=writeForm">
			<button>글쓰기</button>
		</a>
	</div>
</body>
</html>




