<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  	.content-detail>.registerForm {
         height: auto;
         margin-bottom: 100px;

     }

     .registerForm>ul>li {
         /* margin: 30px; */
         padding: 10px;
     }
     .registerForm{
	    border: 2px solid rgba(0, 183, 255, 0.959);
	    border-radius: 10px;
	    padding: 30px;
	}
        
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="content">
		<div class="content-detail">
		   <h1 class="register">관리자 로그인
                    <hr style="width : 80%">
                </h1>

                <form action="/adminLogin2" method="post" class="registerForm" name="adminLogin2">
                    <div class="paddingTop"><img src="./../img/logo.png" width="200" height="200"></div>
                    <ul>
                        <li><span>관리자아이디</span><input type="text" name="adminId" placeholder="아이디를 입력해주세요"></li>
                        <li><span>비밀번호</span><input type="password" name="adminPw" placeholder="비밀번호를 입력해주세요"><br></li>
                    </ul>
                    <button type="submit" style="background-color: rgba(0, 183, 255, 0.959); width:20%;">로그인</button>
                </form>
				<div class="content-footer"> </div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>