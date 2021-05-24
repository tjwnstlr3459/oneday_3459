<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL 테스트 페이지</h1>
	<h2><a href="/view/jstl/jstlTest1.jsp">1. JSTL 기초</a></h2>
	<!-- if문 -->
	<form action="/jstlTest1">
		2. if문 : <input type="text" name="memberId">
		<input type="submit" value="조회">
 	</form>
 	
 	<!-- switch문 -->
 	<form action="/jstlTest2">
		3.switch문 : <input type="text" name="memberId">
		<input type="submit" value="조회">
 	</form>
 	
 	<h2><a href="/jstlTest3">4. JSTL foreach</a></h2>
 	<!-- 토크나이저 기능 -->
 	<form action="/jstlTest4">
		5.토크나이저 : <input type="text" name="data">
		<input type="submit" value="입력">
 	</form>
</body>
</html>