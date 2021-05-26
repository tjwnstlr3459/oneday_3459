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
			<c:if test="${not empty ckName}">
				<th>이름</th>
			</c:if>
			<c:if test="${ckPhone != null}">
				<th>전화번호</th>
			</c:if>
			<c:if test="${ckAddress ne null}">
				<th>주소</th>
			</c:if>
		</tr>
		<c:forEach items="${list}" var="list" varStatus="count">
			<tr>
				<th>${count.count}</th>
				<th>${list.memberId}</th>
				<c:if test="${not empty ckName}">
					<th>${list.memberName}</th>
				</c:if>
				<c:if test="${not empty ckPhone}">
					<th>${list.phone}</th>
				</c:if>
				<c:if test="${not empty ckAddress}">
					<th>${list.address}</th>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>