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
		$('#id').focusout(function() {
			var id = $('#id').val();
			if (id.length<4) {
				$('#idCheck').html("ID는 4자리 이상 입력하시오");
			} else {
				$('#idCheck').empty();
			}
		})
		$('#pw').focusout(function() {
			var pw = $('#pw').val();
			if (pw.length<4) {
				$('#pwCheck').html("비밀번호는 4자리 이상 입력하시오");
			} else {
				$('#pwCheck').empty();
			}
		})
		$('#pwConfirm').focusout(function() {
			var pw = $('#pw').val();
			var pwConfirm = $('#pwConfirm').val();
			if (pw==pwConfirm) {
				$('#pwConfirmCheck').html("비밀번호가 일치합니다");
			} else {
				$('#pwConfirmCheck').html("비밀번호가 일치하지 않습니다");
			}
		})
		
		$('form').submit(function(){
			var birth = $('#year').val()+$('#month').val()+$('#day').val();
			$('#birth').val(birth);
		})
		$('form').submit(function(){
			var email = $('#email01').val()+"@"+$('#email02').val();
			$('#email').val(email);
		})
		$('form').submit(function(){
			var phone = $('#phoneNum00').val()+$('#phoneNum01').val()+$('#phoneNum02').val();
			$('#phone').val(phone);
		})
	})
</script>
</head>
<body>
	<span id="title">회원가입</span>
	<div>

		<input type="hidden" name="task" value="join">
			<table border="1">
				<tr>
					<td>ID</td>
					<td><input id="id" type="text" name="id"><span id="idCheck"></span></td>
				</tr>
				<tr>
					<td>PW<br> 확인
					</td>
					<td><input id="pw" name="pw" type="password"><span id="pwCheck"></span><br>
						<input id="pwConfirm" type="password"><span
						id="pwConfirmCheck"></span></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input id="name" name="name" type="text"><span id="nameCheck"></span></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><select id="year">
							<%
								for (int i = 1900; i <= 2017; i++) {
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
					<td>성별</td>
					<td><input type="radio" name="gender" value="남" checked="checked">남 <input
						type="radio" name="gender" value="여">여</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input id="nickname" name="nickname" type="text"><span id="nicknameCheck"></span></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" id="email01" size="18" maxlength="18">@
						<input type="text" id="email02" size="15" maxlength="15">
						<input type="hidden" name="email" id="email" value=""/>
				</tr>
				<tr>
					<td>핸드폰</td>
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
					<td colspan="2"><input type="submit" value="signup"></td>
				</tr>
			</table>
	</div>

</body>
</html>