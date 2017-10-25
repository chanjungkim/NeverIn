<%@page import="vo.FreeBoardArticle"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#btnComment').click(function(){
			$.ajax({
				type:'post',
				url:'freeboard', 
				data:'type=writecomment',
				dataType:'text',
				success:function(resultData){
					alert(resultData);
				},
				error:function(){
					alert('ajax 요청 실패');
				}
				
			})
		})
	})
</script>
<title>글 읽기 화면</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
	<table border="1">
		<tr>
			<td>글번호:</td>
			<td>${freeboardarticle.articleNum }</td>
		</tr>
		<tr>
			<td>제목:</td>
			<td>${freeboardarticle.title}</td>
		</tr>
		<tr>
			<td>작성자:</td>
			<td>${freeboardarticle.writer }</td>
		</tr>
		<tr>
			<td>작성일:</td>
			<td>${freeboardarticle.writeTime }</td>
		</tr>
		<tr>
			<td>조회수:</td>
			<td>${freeboardarticle.readCount}</td>
		</tr>
		<tr>
			<td>내용:</td>
			<td>${freeboardarticle.contents}</td>
		</tr>
	</table>
	<a href=
		"${myContextPath}/freeboard?type=answerForm&freeboardarticleNum=${freeboardarticle.articleNum}">
		[답변달기]
	</a>
	<c:if test="${sessionScope.loginId==freeboardarticle.id}">
		<a href=
		"${myContextPath}/freeboard?type=updateForm&freeboardarticleNum=${freeboardarticle.articleNum}">
			[수정하기]
		</a>
		<a href=
		"${myContextPath}/freeboard?type=deleteForm&freeboardarticleNum=${freeboardarticle.articleNum}">
			[삭제하기]
		</a>
	</c:if>
	
	<a href=
	"${myContextPath}/freeboard?type=freeboardList">
		[게시판 목록으로]
	</a>
	
	
	
	<table border="1">
		<tr>
			<td>
				(임시)닉네임 : ${nickname}
			</td>
			<td>
				댓글내용 들어갈곳
			</td>
			<td>
				<button>답변</button><br>
				<button>수정</button><br>
				<button>삭제</button>
			</td>
		</tr>
		<tr>
			<td>
				(임시)닉네임 : ${nickname}
			</td>
			<td>
				<textarea rows="5" cols="50" id="comment"></textarea>
			</td>
			<td>
				<button id="btnComment">등록</button>
			</td>
		</tr>
	</table>
</body>
</html>





