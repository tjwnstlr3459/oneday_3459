<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 라이브러리 등록 -->
    <%@ 
    taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Mybatis 테스트</h1>
	<hr>
	<c:choose>
		<c:when test="${empty sessionScope.c }">
			<form action="/login" method="post">
				<fieldset>
					<legend>로그인</legend>
					아이디 : <input type="text" name="memberId"></br>
					비밀번호: <input type="text" name="memberPw"></br>
					<input type="submit" value="로그인">
					<input type="reset" value="초기화"><br>
					<a href="/joinFrm">회원가입</a>
					<a href="/searchFrm">아이디/비빌번호 찾기</a>
				</fieldset>
			</form>
		</c:when>
		<c:otherwise>
			<fieldset>
				<legend>로그인 성공</legend>
				<h3>[${sessionScope.c.cafeName }]님 환영합니다.</h3>
				<a href="/selectAllmember">전체회원조회</a><br>
				<a href="/mypage?memberId=${sessionScope.c.cafeId }">마이페이지</a><br>
				<a href="/logout">로그아웃</a><br>
				<a href="/delete?memberId=${sessionScope.c.cafeId }">회원탈퇴</a><br>
			</fieldset>
		</c:otherwise>
	</c:choose>
	
	
	
</body>
</html>