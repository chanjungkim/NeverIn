<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html>
<html lang="en">
<head>
<title>NEVER 지식IN-무엇이든 물어보세요</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#pwCheck1').on('keyup', function(){
		console.log('1눌림');
		
		var pw1 = $('#pwCheck1').val();
		var pw2 = $('#pwCheck2').val();
		
		if(pw1!=pw2){
			console.log('비밀번호 다름')
			$('#pwWarn').html("<label style='color:red;'>비밀번호가 일치하지 않습니다.</label>");
			$('#editBtn').attr('disabled','true');
		}else{
			console.log('비밀번호 같음')
			$('#pwWarn').html("<label style='color:green;'>비밀번호가 일치합니다.</label>");		
			$('#editBtn').removeAttr("disabled");
		}
	})

	$('#pwCheck2').on('keyup', function(){

		console.log('2눌림');

		var pw1 = $('#pwCheck1').val();
		var pw2 = $('#pwCheck2').val();

		if(pw1!=pw2){
			console.log('비밀번호 다름')
			$('#pwWarn').html("<label style='display:inline-block;color:red;'>비밀번호가 일치하지 않습니다.</label>");	
			$('#editBtn').attr('disabled','true');
		}else{
			console.log('비밀번호 같음')
			$('#pwWarn').html("<label style='display:inline-block;color:green;'>비밀번호가 일치합니다.</label>");		
			$('#editBtn').removeAttr("disabled");
		}
	})
})
</script>
<style>
ul.nav li.dropdown:hover>ul.dropdown-menu {
	display: block;
	margin: 0;
}
<style type="text/css">
.delete{
	color: red;
}

.modal {
  text-align: center;
  padding: 0!important;
}

.modal:before {
  content: '';
  display: inline-block;
  height: 100%;
  vertical-align: middle;
  margin-right: -4px;
}

.model-content{
	width:500px;
	height:600px;
}
.modal-dialog {
  display: inline-block;
  text-align: left;
  vertical-align: middle;
  padding-left:11%;
}

.tab-pane{
	align-content: center;
}
</style>	
</head>
<body>
<jsp:include page="header.jsp"/>
<c:set var="myContextPath" 
			value="${pageContext.request.contextPath}"/>
	
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li>
					<a class="dropdown" href="${myContextPath}/board">지식Q&A</a>
					<ul class="dropdown-menu">
						<li><a href="qa/page2.jsp">교육</a></li>
						<li><a href="qa/page3.jsp">컴퓨터</a></li>
						<li><a href="qa/page4.jsp">엔터테인먼트</a></li>
					</ul>
				</li>
				<li>
					<a href="${myContextPath}/freeboard">자유 게시판</a>
				</li>
				<li>
					<!-- Trigger the modal with a button -->
		  			<a data-toggle="modal" data-target="#myModal">설정</a>
				</li>
				<c:if test=${sessionScope.loginId == 'master'}>
				<li>
					<a href="${myContextPath}">관리</a>
				</li>
				</c:if>
			</ul>
				<div class="set-modal" style="display:flex;align-items:center;justify-content:center;">
					<jsp:include page="join/mem_setting.jsp"/>
				</div>
		</div>
	</nav>
</body>
</html>