<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
form{
	position:absolute;
	top: 25%;
}
button{
	margin-top: 10px;
	width: 100%;
	background-color: blue;
	color: blue;
}
.main-panel{
  position:absolute;
  top:0;right:0;bottom:0;left:0;
  display:flex;
  align-items:center;
  justify-content:center;

  display:-webkit-flex;
  -webkit-align-item;center;
  -webkit-justify-content:center;
}
.logo{
	position:absolute;
	width:100px;
	height:100px;
}
.login-panel {
	display: inline-block;
	width: 300px;
	height: 500px;
	background-color: #FFF;
	margin: -2.5px;
	border-radius: 50px;
	border-color: black;
	border-width: 5px;
	padding: 5px 15px;
}
.panel-body{
	margin: 20px;
}
.modal-body {
  height: inherit;
}
.modal-left {
	width: 30px;
	height: 30px;
	background-color: green;
	display: inline;
}
.modal-right {
	left: 100px;
	background-color: yellow;
	display: inline;
}
</style>
</head>
<body>
	<div class="main-panel">
		<div class="panel panel-default login-panel">
			<div class="panel-body">
				<form class="form-horizontal">
					<div class="form-group">
						<table>
							<tr>
								<td><label>아이디</label></td>
								<td></td>
							</tr>
							<tr>
								<td colspan="2"><input type="text" class="form-control" id="id"	placeholder="아이디를 입력하세요.">
								</td>
							</tr>
							<tr>
								<td><label>비밀번호</label></td>
								<td></td>							
							</tr>
							<tr>
								<td colspan="2"><input type="password" class="form-control" id="pwd"
								placeholder="비밀번호를 입력하세요.">
								</td>
							</tr>
							<tr>
								<td><label><input type="checkbox">기억하기</label>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<button type="submit" class="btn btn-default"">로그인</button>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									  <!-- Trigger the modal with a button -->
									  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">회원 가입</button>
								</td>
							</tr>
						</table>						
					</div>
				</form>
			</div>
		</div>
		
		  <!-- Modal -->
		  <div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">회원 가입</h4>
		        </div>
				<div class="modal-body" style="height:300px">
					<div class="modal-left">
					
					</div>
					<div class="modal-right">
						<form class="form-horizontal" method="post" action="nverIn/board_list.jsp">
							<div class="form-group">
								<table class="table-hover table-managed">
									<tr>
										<td>
											<label>아이디</label><br>
											<input type="text" placeholder="아이디를 입력하세요." />
										</td>
									</tr>
									<tr>
										<td>
											<label>비밀번호</label><br>
											<input type="password" placeholder="아이디를 입력하세요." />
										</td>
									</tr>
									<tr>
										<td>
											<label>비밀번호 확인</label><br>
											<input type="password" placeholder="아이디를 입력하세요." />
										</td>
									</tr>
								</table>
						        <input type="submit" class="btn btn-default" data-dismiss="modal"></button>		
							</div>			
						</form>
					</div>
				</div>
				<div class="modal-footer">
        		</div>
		      </div>
		      
		    </div>
		  </div>
		
	</div>
</body>
</html>