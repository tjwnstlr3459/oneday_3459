<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체회원 출력</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>성별</th>
		</tr>
		<c:forEach items="${list}" var="list" varStatus="count">
			<tr>
				<th>${count.count}</th>
				<th>${list.memberId}</th>
				<th>${list.memberName}</th>
				<th>${list.phone}</th>
				<th>${list.address}</th>
				<th>${list.gender}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>