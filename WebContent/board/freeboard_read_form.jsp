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
					alert('ajax ��û ����');
				}
				
			})
		})
	})
</script>
<title>�� �б� ȭ��</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
	<table border="1">
		<tr>
			<td>�۹�ȣ:</td>
			<td>${freeboardarticle.articleNum }</td>
		</tr>
		<tr>
			<td>����:</td>
			<td>${freeboardarticle.title}</td>
		</tr>
		<tr>
			<td>�ۼ���:</td>
			<td>${freeboardarticle.writer }</td>
		</tr>
		<tr>
			<td>�ۼ���:</td>
			<td>${freeboardarticle.writeTime }</td>
		</tr>
		<tr>
			<td>��ȸ��:</td>
			<td>${freeboardarticle.readCount}</td>
		</tr>
		<tr>
			<td>����:</td>
			<td>${freeboardarticle.contents}</td>
		</tr>
	</table>
	<a href=
		"${myContextPath}/freeboard?type=answerForm&freeboardarticleNum=${freeboardarticle.articleNum}">
		[�亯�ޱ�]
	</a>
	<c:if test="${sessionScope.loginId==freeboardarticle.id}">
		<a href=
		"${myContextPath}/freeboard?type=updateForm&freeboardarticleNum=${freeboardarticle.articleNum}">
			[�����ϱ�]
		</a>
		<a href=
		"${myContextPath}/freeboard?type=deleteForm&freeboardarticleNum=${freeboardarticle.articleNum}">
			[�����ϱ�]
		</a>
	</c:if>
	
	<a href=
	"${myContextPath}/freeboard?type=freeboardList">
		[�Խ��� �������]
	</a>
	
	
	
	<table border="1">
		<tr>
			<td>
				(�ӽ�)�г��� : ${nickname}
			</td>
			<td>
				��۳��� ����
			</td>
			<td>
				<button>�亯</button><br>
				<button>����</button><br>
				<button>����</button>
			</td>
		</tr>
		<tr>
			<td>
				(�ӽ�)�г��� : ${nickname}
			</td>
			<td>
				<textarea rows="5" cols="50" id="comment"></textarea>
			</td>
			<td>
				<button id="btnComment">���</button>
			</td>
		</tr>
	</table>
</body>
</html>





