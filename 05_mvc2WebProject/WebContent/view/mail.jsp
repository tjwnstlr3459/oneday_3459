<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
		<h3>EMAIL보내기</h3>
		<input type="text" id="email" class="short form-control" placeholder="email주소입력">
		<button id="sendMail" class="btn btn-success">인증코드 보내기</button>
		<!-- 인증코드 보내면 밑에가 나타나게 -->
		<div id="auth">
			<input type="text" id="authCode" class="short form-control" placeholder="인증코드입력">
			<button class="btn btn-primary" id="authBtn">인증하기</button>
			<span id="timeZone"></span>
			<span id="authMsg"></span>
		</div>
	</div>
	<script>
		var mailCode;
		$("#sendMail").click(function(){
			var email = $("#email").val();
			$.ajax({
				url : "/sendMail",
				data : {email:email},
				success: function(data){
					//console.log(data);
					mailCode = data;
					$("#auth").slideDown();
					authTime();
				}
			});
		});
		$("#authBtn").click(function(){
			if($("#authCode").val()== mailCode){
				$("#authMsg").html("인증성공");
				$("#authMsg").css("color","blue");
				clearInterval(intervalId);	//인증성공시 이터벌 그만
				$("#timeZone").empty();
			}else{
				$("#authMsg").html("인증번호를 확인하세요");
				$("#authMsg").css("color","red");
			}
		});
		
		//시간초
		var intervalId;
		function authTime(){
			$("#timeZone").append("<span id='min'>3</span> : <span id='sec'>00</span>");
			intervalId = window.setInterval(function(){
				
			},100);//1초마다 실행
		}
		function timeCount(){
			var min = Number($("#min").html());	//문자열을 숫자열로 변환
			var sec = $("#sec").html();
			if(sec == "00"){	//3:00 -> 2:59
				if(min == 0){	//시간초과로 인증실패
					mailCode = null;
					clearInterval(intervalId);
				}else{
					$("#min").html(--min);
					$("#sec").html(59);
				}
			}else{
				var newSec = Number(sec);
				newSec--;
				if(newSec<10){
					$("#sec").html("0"+newSec);	//10이하일땐 09 / 08 / 07 <이런식으로 보여주게
				}else{
					$("#sec").html(newSec);
				}
			}
		}
	</script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>





