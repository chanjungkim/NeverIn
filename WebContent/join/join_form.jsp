<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var submitConfirm = {'id':false,'pw':false,'name':false,'birth':false,
				'nickname':false,'email':false,'phone':false};
		
		$('#pw').on('keyup',function() {
			var pw = $('#pw').val();
			if (pw.length<4) {
				$('#pwCheck').html('<span style="color:red">비밀번호는 4자리 이상 입력하시오.</span>');
				submitConfirm['pw'] = false;
			} else {
				$('#pwCheck').empty();
			}
		})
		$('#pwConfirm').on('keyup',function() {
			var pw = $('#pw').val();
			var pwConfirm = $('#pwConfirm').val();
			if (pw==pwConfirm) {
				$('#pwConfirmCheck').html('<span style="color:green">비밀번호가 일치합니다.</span>');
				submitConfirm['pw'] = true;
			} else {
				$('#pwConfirmCheck').html('<span style="color:red">비밀번호가 불일치합니다.</span>');
				submitConfirm['pw'] = false;
			}
		})
		
		$('#name').focusout(function() {
			var id = $('#name').val();
			if (id.length<1) {
				submitConfirm['name'] = false;
			} else {
				submitConfirm['name'] = true;
			}
		})
		
		$('#nickname').focusout(function() {
			var id = $('#nickname').val();
			if (id.length<1) {
				submitConfirm['nickname'] = false;
			} else {
				submitConfirm['nickname'] = true;
			}
		})
		
		$('#joinBtn').click(function(){
			var birth = $('#year').val()+$('#month').val()+$('#day').val();
			$('#birth').val(birth);
			submitConfirm['birth'] = true;
			
			var email = $('#email01').val()+"@"+$('#email02').val();
			$('#email').val(email);
			if (email.length<10) {
				submitConfirm['email'] = false;
			} else {
				submitConfirm['email'] = true;
			}
			
			var phone = $('#phoneNum00').val()+$('#phoneNum01').val()+$('#phoneNum02').val();
			$('#phone').val(phone);
			if (phone.length<10) {
				submitConfirm['phone'] = false;
			} else {
				submitConfirm['phone'] = true;
			}
			
			var submitOK = true;
			
			$.each(submitConfirm,function(item){
				if(submitConfirm[item]==false){
					alert(item+'을 확인하세요');
					submitOK = false;
					return false;
				}
			})
			
			if(submitOK == true){
				$('#joinForm').submit();
// 				return true; // submit 진행
			}else{
				return false; // submit 취소
			}
		})
		
		$('#idChk').click(function(){
			var id = $('#id').val();
			if (id.length<4) {
				$('#idCheck').html('<span style="color:red">아이디는 4자리 이상 입력하시오.</span>');
				submitConfirm['id'] = false;
			} else {
				
				$.ajax({
					type:'get', // 요청 보내면 doPost가 실행됨
					url:'member', // 우리가 작성한 java 서블릿에게
					data:'id='+id+'&task=idCheck', // 검색어 데이터
					dataType: 'text',// 응답데이터 형식
					success:function(result){
						if(result==null || result == '' || result == 'null' || result == 'false' ){
							$('#idCheck').html('<span style="color:red">중복된 아이디 입니다..</span>');
							submitConfirm['id'] = false;
						}else{
							$('#idCheck').html('<span style="color:green">사용 가능한 아이디입니다.</span>');
							submitConfirm['id'] = true;
						}
					},
					error:function(){
						alert('서버 통신 에러');
					}
				})
				submitConfirm['id'] = true;
			}
		})
	})
</script>
</head>
<body>
<form id="joinForm" action = "<%=request.getContextPath()%>/member" method="post">
	<div>

		<input type="hidden" name="task" value="join">
			<table border="1" width=570px;>
				<tr>
					<td>&nbsp;&nbsp;ID</td>
					<td><input id="id" type="text" name="id"><input type="button" id="idChk" name="idChk" value="ID중복체크"><span id="idCheck"></span></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;PW<br> &nbsp;&nbsp;확인
					</td>
					<td><input id="pw" name="pw" type="password"><span id="pwCheck"></span><br>
						<input id="pwConfirm" type="password"><span
						id="pwConfirmCheck"></span></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;이름</td>
					<td><input id="name" name="name" type="text"><span id="nameCheck"></span></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;생년월일</td>
					<td><select id="year">
							<%
								for (int i = 2017; i >= 1900; i--) {
							%>
							<option value="<%=i%>"><%=i%></option>
							<%
								}
							%>
					</select>- <select id="month">
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
					</select>- <select id="day">
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
							<option value="10">10</option>
							<%
								for (int i = 11; i <= 31; i++) {
							%>
							<option value="<%=i%>"><%=i%></option>
							<%
								}
							%>
					</select>
					<input type="hidden" name="birth" id="birth" value=""/>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;성별</td>
					<td><input type="radio" name="gender" value="남" checked="checked">남 <input
						type="radio" name="gender" value="여">여</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;닉네임</td>
					<td><input id="nickname" name="nickname" type="text"><span id="nicknameCheck"></span></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;이메일</td>
					<td><input type="text" id="email01" size="18" maxlength="18">@
						<input type="text" id="email02" size="15" maxlength="15">
						<input type="hidden" name="email" id="email" value=""/>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;핸드폰</td>
					<td><select id="phoneNum00">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
					</select>- <input type="text" id="phoneNum01" size="4" maxlength="4">-
						<input type="text" id="phoneNum02" size="4" maxlength="4">
						<input type="hidden" name="phone" id="phone" value=""/>
					</td>
				</tr>
			
				<tr>
					<td colspan="2" align="right"><input id="joinBtn" type="button" value="회원가입" ></td>
				</tr>
			</table>
	</div>
</form>
</body>
</html>