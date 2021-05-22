<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    String adminId = (String)request.getAttribute("adminId");
    boolean result = (Boolean)request.getAttribute("result");
    %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<style>
 	@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');
    @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&display=swap');
    *{
    	font: 16px 'Nanum Gothic', sans-serif;
    }
	#checked-container{
		text-align : center;
		padding-top : 50px;
	}
	#checked{
		color:red;
		font-weight:bold;
	}
	.reAdminId{
		width:200px;
		border : 1px solid rgba(0, 171, 250, 0.959);
		border-radius: 5px;
		padding:15px;
	}
	.reCheck{
		margin : 10px;
		width:100px;
		padding:8px;
		border : 1px solid rgba(0, 171, 250, 0.959);
		background-color: rgba(0, 171, 250, 0.959);
		color:white;
	}
</style>
</head>
<body>
<div id="checked-container">
		<%if(result){ %>
		[<span><%=adminId %></span>]는 사용이 가능합니다.
		<br><br>
		<button class="reCheck" onclick="setMemberId('<%=adminId %>')">닫기</button>
		<%}else{ %>
		[<span id="checked"><%=adminId %></span>]는 이미 사용중입니다.
		<br><br>
		<form action="/checkId" method="post">
			<input class="reAdminId" type="text" name="checkId" placeholder="사용할 아이디를 입력하세요"><br>
			<input class="reCheck" type="submit" vlaue="중복검사">
		</form>
		<%} %>
	</div>
	<script>
		function setMemberId(memberId){
			$("#idChk",opener.document).prev().val(memberId);
			self.close();
		}
	</script>
</body>
</html>