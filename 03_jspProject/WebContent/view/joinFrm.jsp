<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/view/join.jsp" method="post">
		<fieldset>
			<legend>회원가입</legend>
			아이디 : <input type="text" name="id"><br>
			비밀번호 : <input type="password" name="pw"><br>
			비밀번호 확인: <input type="password" name="pwRe"><br>
			이름 : <input type="text" name="name"><br>
			전화번호 : <input type="text" name="phone"><br>
			주소 : <input type="text" name="addr"><br>
			<button type="submit">가입하기</button>
		</fieldset>
	</form>
</body>
</html>