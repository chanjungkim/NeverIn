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
	.list{
		overflow-y: scroll;
		height:400px;
	}
	li img{
		width:100px;
		height:50px;
	}
	.bottom-img{
		width:20px;
		height:20px;
	}
	.main-panel{
		margin: 30px;
		position:absolute;
		left: 20%;
		width: 710px;
		border: thick;
		border-color: black;
		border-style: solid;
		border-radius: 20px;
			
		display:-webkit-flex;
		-webkit-align-item;center;
		-webkit-justify-content:center;		
	}
	
	tr td:FIRST-CHILD{
		font-size: 30px;
	}
	tr {
		font-size: 20px;
	}	
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class="main-panel">
		<div class="container">
		  <ul class="nav nav-tabs">
		    <li class="active"><a data-toggle="tab" href="#game"><img src="images/logo.png"></a></li>
		    <li><a data-toggle="tab" href="#lang"><img src="images/logo.png"></a></li>
		    <li><a data-toggle="tab" href="#meet"><img src="images/logo.png"></a></li>
		    <li><a data-toggle="tab" href="#study"><img src="images/logo.png"></a></li>
		    <li><a data-toggle="tab" href="#music"><img src="images/logo.png"></a></li>
		  </ul>
		
		  <div class="tab-content">
		    <div id="game" class="tab-pane fade in active">
		    	<div class="list">
		    		<table border="3" style="width:100%">
			    		<tr>
			    			<th colspan="2">제목</th>
			    			<th>인원</th>
			    			<th>레벨</th>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>	    		
		    		</table>
		    	</div>
		    	<div>
					<table class="bottom" border="1" style="width:100%;">
						<tr>
							<td width="50%">
								<img class="bottom-img" src="images/logo.png">
		    				</td>
		    				<td width="50%">
			    				<img class="bottom-img" src="images/logo.png"><input type="text" size="1" maxlength="1"> - <input type="text" size="4" maxlength="4">
		    				</td>
						</tr>
					</table>
		    	</div>
		    </div>
		    <div id="lang" class="tab-pane fade">
		    	<div>
		    		<table border="3" style="width:100%">
			    		<tr>
			    			<th colspan="2">제목</th>
			    			<th>인원</th>
			    			<th>레벨</th>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>	    		
		    		</table>
		    	</div>
		 	  </div>
		    <div id="meet" class="tab-pane fade">
		    	<div>
		    		<table border="3" style="width:100%">
			    		<tr>
			    			<th colspan="2">제목</th>
			    			<th>인원</th>
			    			<th>레벨</th>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>	    		
		    		</table>
		    	</div>
		    </div>
		    <div id="study" class="tab-pane fade">
		    	<div>
		    		<table border="3" style="width:100%">
			    		<tr>
			    			<th colspan="2">제목</th>
			    			<th>인원</th>
			    			<th>레벨</th>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>	    		
		    		</table>
		    	</div>
		    </div>
		    <div id="music" class="tab-pane fade">
		    	<div>
		    		<table border="3" style="width:100%">
			    		<tr>
			    			<th colspan="2">제목</th>
			    			<th>인원</th>
			    			<th>레벨</th>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">League of Legend</td>
			    			<td>3/3</td>
			    			<td style="text-align: center;">Diamond</td>
			    		</tr>	    		
		    		</table>
		    	</div>
		    </div>
		    
		  </div>
		</div>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>