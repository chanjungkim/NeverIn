<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
.delete{
	color: red;
}
.modal-dialog{
	width:55%;
}
.container{
	width:100%;
	height:100%;
}
.setting-container{
	display:inline-block;
}
.logo-container{
	display:inline;
}
acronym{
	speak:auto;
}
#logo{
	background-color: green;
	width:200px;
	height:100px;
}
#setting-btn{
	width:50px;
	height:auto;
}
</style>
</head>
<body>
<div class="container">
	<div class="logo-container">
		<acronym>hahahahahahahahahahahahahahahahahahahahaha</acronym>
		<img id="logo" src="images/logo.png">
	</div>	
	<div class="setting-container">
		<div class="container">
		  <!-- Trigger the modal with a button -->
		  <img id="setting-btn" data-toggle="modal" data-target="#myModal" src="images/setting.png">
		
		  <!-- Modal -->
		  <div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">설정</h4>
		        </div>
				<div class="container-fluid">
				  <div class="row">
				    <!-- Nav left -->
				    <ul class="nav col-md-2" id="leftTabs">
				      <li class="active">
				        <a href="#mypage" data-toggle="tab">
				          <div></div>마이페이지
				        </a>
				      </li>
				      <li>
				        <a href="#buy" data-toggle="tab">
				          <div></div>결제
				        </a>
				      </li>
				      <li>
				        <a href="#test" data-toggle="tab">
				          <div></div>장치 테스트
				        </a>
				      </li>
				      <li>
				        <a href="#report" data-toggle="tab">
				          <div></div>신고
				        </a>
				      </li>
				      <li>
				        <a href="#qa" data-toggle="tab">
				          <div></div>Q&A
				        </a>
				      </li>
				      <li>
				        <a href="#copyright" data-toggle="tab">
				          <div></div>저작권
				        </a>
				      </li>
				      <li>
				        <a class="delete" href="#delete" data-toggle="tab">
				          <div></div>탈퇴
				        </a>
				      </li>
				    </ul>
				  	<!-- Nav content -->
				      <div class="tab-content col-md-10">
				      <div class="tab-pane active" id="mypage">
				        <h1>마이 페이지</h1>
				        <img src="images/logo.png">
				        
				        <form>
				        	<input type="text">
				        	<button></button>
				        </form>
				      </div>
				      <div class="tab-pane" id="buy">
				        <h1>결제</h1>
				        <img src="images/logo.png">
				        <img src="images/logo.png">
				        
				      </div>
				      <div class="tab-pane" id="test">
				        <!-- Nav tabs -->
				        <ul class="nav nav-tabs">
				          <li class="active"><a href="#mic" data-toggle="tab">마이크</a></li>
				          <li><a href="#speaker" data-toggle="tab">스피커</a></li>
				          <li><a href="#" data-toggle="tab">기타</a></li>
				        </ul>
				        <!-- Nav tabs content -->
				        <div class="tab-content">
				          <div id="mic" class="tab-pane active">마이크 테스트</div>
				          <div id="speaker" class="tab-pane">스피커 테스트</div>
				          <div id="" class="tab-pane">Content of third</div>
				        </div>    
				      </div>
				      <div class="tab-pane" id="report">
				        <h1>신고</h1>
				        <form>
					        <input type="text">
					        <button type="submit">제출</button>
				        </form>
				      </div>
				      <div class="tab-pane" id="qa">
				        <h1>Q&A</h1>
				        <form>
					        <input type="text">
					        <button type="submit">제출</button>
				        </form>
				      </div>
				      <div class="tab-pane" id="copyright">
				        <h1>저작권</h1>
				      </div>
				      <div class="tab-pane" id="delete">
				        <h1>탈퇴</h1>
				        <form>
					        <input type="text">
					        <button type="submit">제출</button>
				        </form>
				      </div>
				    </div>
				  </div>
				</div>
			    <div class="modal-footer">
		          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
		        </div>
		      </div>	      
		    </div>
		  </div>
		</div>
	</div>
</div>
</body>
</html>