<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
.form-group>.form-control{
	background-color:#f4f4f4;
	
</style>
<body>
	<!-- incloud 헤더 푸터 입력이 기본셋팅 -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
		<!-- 아이디를 받아서 검사하는 박스 -->
		<form action="/checkId" name="checkIdFrm" method="post">
			<input type="hidden" name="checkId">
		</form>
		
		<form action="/join" method="post" name="joinFrm">
			<legend>회원가입</legend>
			<div class="form-group">
				<label class="control-label" for="memberId" style="display:block;">아이디<span id="ajaxCheck"></span></label>
				<input type="text" name="memberId" id="memberId" class="form-control" style="width:90%; display:inline-block">
				<button type="button" id="idChk" class="btn btn-secondary">중복체크</button>
			</div>
			<div class="form-group">
				<label class="control-label" for="memberPw">비밀번호</label>
				<input type="password" name="memberPw" id="memberPw" class="form-control">
			</div>
			<div class="form-group">
				<label class="control-label" for="memberName">이름</label>
				<input type="text" name="memberName" id="memberName" class="form-control">
			</div>
			<div class="form-group">
				<label class="control-label" for="phone">전화번호</label>
				<input type="text" name="phone" id="phone" class="form-control">
			</div>
			<div class="form-group">
				<label class="control-label" for="address">주소</label>
				<input type="text" name="address" id="address" class="form-control">
			</div>
			<button type="submit" class="btn btn-outline-primary btn-lg btn-block">회원가입</button>
		</form>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
	<script>
		$("#idChk").click(function(){
			var memberId = $(this).prev().val();
			if(memberId==""){
				alert("아이디를 입력하세요!!");
				return;
			}
			$("[name=checkId]").val(memberId);
			//아이디 중복체크 팝업창을 설정
			window.open("","checkId","left=500px, top=300px, width=300px, height=200px");
			//팝업창과 [name=checkIdFrm]인 form 태그를 연결
			$("[name=checkIdFrm]").attr("target","checkId"); //checkId가 같아야한다
			$("[name=checkIdFrm]").submit();	//폼태그 제출
		});
		
		//ajax를 이용한 id중복체크
		$("[name=memberId]").eq(1).keyup(function(){
			var memberId = $(this).val();
			$.ajax({
				url : "/ajaxIdCheck",
				data : {memberId:memberId},
				type : "post",
				success : function(data){
					if(data == 1){
						$("#ajaxCheck").html("이미사용중인 아이디입니다.");
						$("#ajaxCheck").css("color","red");
					}else{
						$("#ajaxCheck").html("사용 가능한 아이디입니다.");
						$("#ajaxCheck").css("color","blue");
					}
				}
			});
		});
		</script>
</body>
</html>





