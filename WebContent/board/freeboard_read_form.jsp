<%@page import="vo.FreeBoardArticle"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(document).ready(function(){
<%-- 			<% String str = (String) request.getAttribute("nickname"); %>  --%>
<%-- 			alert("<%=str%>"); --%>
// 			alert("${nickname}")
// 			alert("${freeboardarticle.title}");
			commentList();
		})
		
		$(document).on('click','#btnComment',function(){
			var comment = $('#comment').val();
			$.ajax({
				type:'post',
				url:'freeboardcomment', 
// 				url: '${myContextPath}/freeboardcomment', 
				data:'type=writecomment&nickname=${nickname}&freeboardarticleNum='+${freeboardarticle.articleNum}+'&comment='+comment+'&id=${sessionScope.loginId}',
				dataType:'text',
				success:function(resultData){
					commentList();
				},
				error:function(){
					alert('ajax 요청 실패');
				}
				
			})
		})
		
		$(document).on('click','#delete',function(){
			var commentnum = $(this).val();
			$.ajax({
				type:'post',
				url:'freeboardcomment', 
// 				url: ${myContextPath}+'/freeboardcomment', 
				data:'type=deletecomment&commentnum=' + commentnum,
				dataType:'text',
				success:function(resultData){
					commentList();
				},
				error:function(){
					alert('ajax 요청 실패');
				}
				
			})
		})
		
		$(document).on('click','#update',function(){
			var commentnum = $(this).val();
			commentList(commentnum);
		})
		
		$(document).on('click','#updatesubmit',function(){
			var updatecontents = $(this).siblings('textarea').val();
			var commentnum = $(this).val();
			
			$.ajax({
				type:'post',
				url:'freeboardcomment',
				data:'type=updatecomment&commentnum=' + commentnum+"&contents="+updatecontents,
				dataType:'text',
				success:function(resultData){
					commentList();
				},
				error:function(){
					alert('ajax 요청 실패');
				}
				
			})
		})
		
	})
	
	function commentList(check){
		var updatecheck = check;
// 		alert(updatecheck);
		$.ajax({
			type:'post',
			url: 'freeboardcomment',
			data:'type=commentList&freeboardarticleNum='+${freeboardarticle.articleNum},
			dataType:'json',
			success:function(resultData){
				var commentList = "<div class='container'>"+
								"<table class='table table-bordered'>"
// 								alert(resultData);
					$.each(resultData, function(index, item){
						commentList += "<tr>"
						commentList += "<td>" + item['writer'] + "</td>"
						if(updatecheck == item['commentnum']){
							commentList += "<td><textarea rows='1' cols='50' id='" + item['commentnum'] + "'>" + item['contents'] + "</textarea>"
							commentList += "<button id='updatesubmit' value='" + item['commentnum'] + "'>완료</button></td>"
						}else{
							commentList += "<td>" + item['contents'] + "</td>"
						}
						commentList += "<td>"
						if(item['id']=="${sessionScope.loginId}"){
							commentList += "<button id='update' value='" + item['commentnum'] + "'>수정</button>"+
											"<button id='delete' value='" + item['commentnum'] + "'>삭제</button>"
						}
						commentList += "</td>"
						commentList += "</tr>"
						
					})
					commentList += "<tr>"
						commentList += "<td>${nickname}</td>"
						commentList += "<td><textarea rows='5' cols='50' id='comment'></textarea></td>"
						commentList += "<td><button id='btnComment'>등록</button><br></td>"
					commentList += "</tr>"
				commentList += "</table>"+
								"</div>"
				$('#commentList').html(commentList);
				
			},
			error:function(){
				alert('ajax 요청 실패');
			}
			
		})
	}
</script>
<title>글 읽기 화면</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>

<div class="container">
	<table class="table table-bordered">
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
	</div>
	<div>
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
	</div>
	
	<div id="commentList"></div>
</body>
</html>





