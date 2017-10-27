<%@page import="vo.FreeBoardArticle"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
<!-- �������� �ּ�ȭ�� �ֽ� CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- �ΰ����� �׸� -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- �������� �ּ�ȭ�� �ֽ� �ڹٽ�ũ��Ʈ -->
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
					alert('ajax ��û ����');
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
					alert('ajax ��û ����');
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
					alert('ajax ��û ����');
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
							commentList += "<button id='updatesubmit' value='" + item['commentnum'] + "'>�Ϸ�</button></td>"
						}else{
							commentList += "<td>" + item['contents'] + "</td>"
						}
						commentList += "<td>"
						if(item['id']=="${sessionScope.loginId}"){
							commentList += "<button id='update' value='" + item['commentnum'] + "'>����</button>"+
											"<button id='delete' value='" + item['commentnum'] + "'>����</button>"
						}
						commentList += "</td>"
						commentList += "</tr>"
						
					})
					commentList += "<tr>"
						commentList += "<td>${nickname}</td>"
						commentList += "<td><textarea rows='5' cols='50' id='comment'></textarea></td>"
						commentList += "<td><button id='btnComment'>���</button><br></td>"
					commentList += "</tr>"
				commentList += "</table>"+
								"</div>"
				$('#commentList').html(commentList);
				
			},
			error:function(){
				alert('ajax ��û ����');
			}
			
		})
	}
</script>
<title>�� �б� ȭ��</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>

<div class="container">
	<table class="table table-bordered">
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
	</div>
	<div>
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
	</div>
	
	<div id="commentList"></div>
</body>
</html>





