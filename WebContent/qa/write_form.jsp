<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>글 작성 화면</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>

	
	<form action="<%=request.getContextPath()%>/board" method="post" enctype="multipart/form-data">
		<input type="hidden" name="type" value="write">												
	<table border="1">
		<tr>
			<td>제목:</td>
			<td>
				<input type="text" name="title" size="10">
			</td>
		</tr>
		<tr>
			<td>작성자:</td>
			<td>
				<input type="text" name="writer" value="${sessionScope.loginId }" size="10">
			</td>
		</tr>
		<tr>
			<td>내용:</td>
			<td>
				<textarea rows="5" cols="10" name="contents" placeholder="여기에 내용을 입력하세요."></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">파일 선택: <input type="file" name="myFile">	
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="작성완료">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>