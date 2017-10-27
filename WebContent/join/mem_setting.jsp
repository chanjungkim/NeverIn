<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
.delete{
	color: red;
}
.model-dialog{
	width:100%;
}
.modal-content{
	width:62.3%;
	height:80%;
}
#items{
	width:40px;
	height:40px;
}
</style>

</head>
<body>
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
		          		닉네임
		          		<input type="text">
		          		비밀번호
		          		<input type="password">
		          		비밀번호 확인
		          		<input type="password">
		          		
		          		<a href="#" style="color:red;">회원탈퇴</a>
		          </div>
		          <div id="shop" class="tab-pane">
<%-- 		          		<c:forEach var="item" items="itemList"> --%>
		          		<div id="item-container">
		          			<div id="image-container">
		          				<img id="items" src="../img/item.png">
		          			</div>
		          		</div>
<%-- 		          		</c:forEach> --%>
		          </div>
		          <div id="report" class="tab-pane">
		          		<div id="report-container">
			          		<input type="text" size="20" placeholder="제목을 입력해주세요">
			          		<textarea rows="30" cols="30" placeholder="내용을 작성해주세요.">
		          			  
			          		</textarea>
		          		</div>
		          </div>
		          <div id="qa" class="tab-pane">
		          		<table border="1">
		          			<tr>
		          				<td width="5%">번호</td>
		       					<td width="75%">제목</td>
		       					<td width="20%">날짜</td>
		          			</tr>
		          			<tr>
		          				<td>게시글이 없습니다.</td>
		          			</tr>
<%-- 		          		<c:forEach var="row" items="questions"> --%>
		          		
<%-- 		          		</c:forEach>   --%>		          		
		          		</table>
		          </div>
		          <div id="copyright" class="tab-pane">
							내용이 없습니다.		          
		          </div>
		        </div>    
		      </div>
		  </div>
		</div>
	    <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        </div>
      </div>
    </div>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
  </div>
</body>
</html>