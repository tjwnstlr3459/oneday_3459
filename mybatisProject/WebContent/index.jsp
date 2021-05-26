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
		<c:when test="${empty sessionScope.m }">
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
				<h3>[${sessionScope.m.memberName }]님 환영합니다.</h3>
				<a href="/selectAllmember">전체회원조회</a><br>
				<a href="/mypage?memberId=${sessionScope.m.memberId }">마이페이지</a><br>
				<a href="/logout">로그아웃</a><br>
				<a href="/delete?memberId=${sessionScope.m.memberId }">회원탈퇴</a><br>
				<hr>
				<h2>동적쿼리 if문</h2>
				<h3>전체회원 조회 시 포함할 항목선택</h3>
				<form action="/ifTest" method="post">
					<input type="checkbox" name="ckName"> 이름
					<input type="checkbox" name="ckPhone"> 전화번호
					<input type="checkbox" name="ckAddress"> 주소
					<br>
					<input type="submit" value="조회">
				</form>
				<hr>
				<h2>동적쿼리 choose</h2>
				<h3>아이디 또는 이름으로 검색</h3>
				<form action="/chooseTest" method="post">
					<select name="type">
						<option value="id">아이디</option>
						<option value="name">이름</option>
					</select>
					<input type="text" name="keyword">
					<input type="submit" value="검색">
				</form>
				<hr>
				<h3>동적쿼리 trim</h3>
				<h3>이름과 주소를 입력하면 입력값이 포함된 회원 조회해서 출력</h3>
				<h3>단, 이름이나 주소 중 1개만 입력한 경우에는 1개에 대해서만 조회해서 출력</h3>
				<form action="/search2">
					이름 : <input type="text" name="name"><br>
					주소 : <input type="text" name="address"><br>
					<input type="submit" value="검색">
				</form>
				
				<h2>동적쿼리 foreach</h2>
				<form action="/foreachTest" method="post">
					<input type="checkbox" name="name" value="유저01">유저01
					<input type="checkbox" name="name" value="유저03">유저03
					<input type="checkbox" name="name" value="서준식">서준식
					<br>
					<input type="submit" value="선택회원정보조회">
				</form>
			</fieldset>
		</c:otherwise>
	</c:choose>
</body>
</html>













