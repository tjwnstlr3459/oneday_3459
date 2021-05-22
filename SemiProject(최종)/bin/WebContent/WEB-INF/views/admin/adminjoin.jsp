<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.registerForm{
    border: 1px solid rgb(206, 203, 203);
    border-radius: 10px;
    padding: 30px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="content">
		<div class="content-detail">
                <h1 class="register">관리자 회원가입
                    <hr style="width : 80%">
                </h1>
               	<form action="/checkId" name="checkIdFrm" method="post">
					<input type="hidden" name="checkId">
				</form>
                 <form action="/adminInfo" method="post" name="adminInfo" class="registerForm">
                    <h3>관리자정보를 입력해주세요<sapn>(필수)</sapn>
                    </h3>
                    <hr style="border: 0.1px solid rgb(233, 232, 232); margin: 30px;">
                    <ul>
                        <li><span>관리자아이디</span><input type="text" name="adminId" placeholder="아이디를 입력해주세요"><button
                                type="button" id="idChk">중복확인</button><br></li>
                        <li><span>비밀번호</span><input type="password" name="adminPw" placeholder="비밀번호를 입력해주세요"><br></li>
                        <li><span>비밀번호확인</span><input type="password" name="adminPwRe" placeholder="비밀번호를 확인해주세요"><br></li>
                        <li><span>이름</span><input type="text" name="adminName" placeholder="예)홍길동"><br></li>
                        <li><span>전화번호</span><input type="text" name="adminPhone" placeholder="예)01012345678"><br></li>
                        <li><span>주소</span><input type="text" name="adminAddr" placeholder="주소를 입력해주세요"><br></li>
                    </ul>
                    <button type="button"><a href="/adminLogin">로그인</a></button>
                    <button type="submit">가입하기</button>
                    
                </form>
               
                <div class="content-footer"> </div>
            </div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		$("#idChk").click(function(){
		var adminId = $(this).prev().val();
			if(adminId==""){
				alert("아이디를 입력하세요!");
				return;
			}
			$("[name=checkId]").val(adminId);
			window.open("","checkId","left=500px,top=300px,width=400px,height=280px");
			$("[name=checkIdFrm]").attr("target","checkId");
			$("[name=checkIdFrm]").submit();//폼태그 제출
		})
	</script>
</body>
</html>