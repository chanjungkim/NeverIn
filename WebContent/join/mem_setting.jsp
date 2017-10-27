<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
.delete {
	color: red;
}

#items {
	width: 100%;
	height: 66px;
}

row, .tab-pane {
	width: 370px;
}

.tab-content {
	width: 100px;
	margin: 30px;
}

.content-fluid {
	align-content: center;
}

}
#qa, #qa-form {width =80%;
	
}

#report-title {
	padding-bottom: 10px;
	border-left-width: 2px;
	border-top-width: 2px;
	border-right-width: 2px;
	border-bottom-width: 2px;
	margin-left: 0px;
	margin-bottom: 10px;
	width: 301px;
}
#image-container{
	border-style: outset;
	border-width: 2px;
	width: 70px;
	height: 100px;
	align-content:space-around;
	text-align: center;
	align-content: center;
}
</style>
<script type="text/javascript">
	$(function(){
		$('#deleteBtn').on('click', function(){
			var answer = confirm("정말 삭제하시겠습니까?");
			if(answer){
				$('#deleteBtn').submit();
			}else{
				alert('취소 되었습니다.');		
			}
		})
	})
</script>
</head>
<body>
	<c:set var="myContextPath" value="${pageContext.request.contextPath}" />
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="container-fluid">
					<div class="row">
						<div class="tab-pane" id="test">
							<!-- Nav tabs -->
							<ul class="nav nav-tabs">
								<li class="active"><a href="#myPage" data-toggle="tab">마이페이지</a></li>
								<li><a href="#shop" data-toggle="tab">결제</a></li>
								<li><a href="#report" data-toggle="tab">신고</a></li>
								<li><a href="#qa" data-toggle="tab">Q&A</a></li>
								<li><a href="#copyright" data-toggle="tab">저작권</a></li>
							</ul>
							<!-- Nav tabs content -->
							<div class="tab-content">
								<div id="myPage" class="tab-pane active">
									<h1>마이페이지</h1>
									<fieldset>
										<legend>${sessionScope.loginId}님의 정보수정</legend>
										<form action="<%=request.getContextPath()%>/member"
											method="post">
											<input type="hidden" name="task" value="update"> <input
												type="hidden" name="id" value="${sessionScope.loginId}">
											닉네임<br> <input type="text" name="nickname"><br>
											비밀번호<br> <input id="pwCheck1" type="password" style="display:inline-block;">
											<span id="pwWarn"></span>
											<br> 비밀번호 확인<br> <input id="pwCheck2"
												type="password" name="pw"><br>
												<input id="editBtn" type="submit" style="margin-top:10px;"value="수정하기">
										</form>
										<form action="${myContextPath}/member" method="post">
											<input type="hidden" name="task" value="delete">
											<input type="hidden" name="id" value="${sessionScope.loginId}">
											<input id="deleteBtn" type="button" style="background-color:Transparent; border-style:none; color: red;" value="회원 탈퇴">
										</form>
									</fieldset>
								</div>
								<div id="shop" class="tab-pane">
									<div id="item-list">
										<%-- 		          		<c:forEach var="item" items="itemList"> --%>
										<div id="item-container">
											<div id="image-container">
												<img id="items" src="img/item.png"> <br>10포인트
											</div>
										</div>
										<div id="item-container">
											<div id="image-container">
												<img id="items" src="img/item.png"> <br>50포인트
											</div>
										</div>
										<div id="item-container">
											<div id="image-container">
												<img id="items" src="img/item.png"> <br>150포인트
											</div>
										</div>
										<div id="item-container">
											<div id="image-container">
												<img id="items" src="img/item.png"> <br>300포인트
											</div>
										</div>
										<br>
										<div id="item-container">
											<div id="image-container">
												<img id="items" src="img/item.png"> <br>500포인트
											</div>
										</div>
										<%-- 		          		</c:forEach> --%>
									</div>
								</div>
								<div id="report" class="tab-pane">
									<div id="report-container">
										<form action="" method="post">
											<input id="report-title" type="text" name="reportTitle"
												size="20" placeholder="제목을 입력해주세요"><br>
											<textarea rows="15" name="reportContents" cols="40"
												style="resize: none;">내용을 작성해주세요.</textarea>
											<br> <input type="submit" value="제출">
										</form>
									</div>
								</div>
								<div id="qa" class="tab-pane">
									<table id="qa-form" border="1" width="100%">
										<tr>
											<td width="10%">번호</td>
											<td width="75%">제목</td>
											<td width="20%">날짜</td>
										</tr>
										<tr>
											<td colspan="3">게시글이 없습니다.</td>
										</tr>
										<%-- 		          		<c:forEach var="row" items="questions"> --%>

										<%-- 		          		</c:forEach>   --%>
									</table>
								</div>
								<div id="copyright" class="tab-pane">내용이 없습니다.</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
		<button type="button" class="close" data-dismiss="modal">&times;</button>
	</div>
</body>
</html>