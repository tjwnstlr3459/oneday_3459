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
	<!-- switch문 -->
	<c:choose>
		
		<c:when test="${not empty m }">	<!-- 값이 있을때 -->
			<h1>[${m.memberName }]</h1>
		</c:when>
		
		<c:otherwise>					<!-- 값이 없을때(else역할) -->
			<h1>회원정보가 없습니다.</h1>
		</c:otherwise>
		
	</c:choose>
</body>
</html>