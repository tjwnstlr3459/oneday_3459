<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%
		int num = (Integer)request.getAttribute("num");
		String str = (String)request.getAttribute("str");
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 기존방식 -->
	<h2><%=num %></h2>
	<h2><%=str %></h2>
	
	<!-- el방식 -->
	<!-- 리퀘스트방식 꺼내기 -->
	<h2>${requestScope.num}</h2>
	<h2>${requestScope.str}</h2>
	
	<!-- 세션에있는걸 꺼내기 -->
	<h2>${sessionScope.num }</h2>
	<h2>${sessionScope.str }</h2>
	
	<h2>${requestScope.str1 }</h2>
	<h2>${sessionScope.str2 }</h2>
	<hr>
	
	<!-- 앞에 Scopre를 안적고,변수명이 같을시 기본 request값이 출력된다 -->
	<h2>${num }</h2>
	<h2>${str }</h2>
	<h2>${str1 }</h2>
	<h2>${str2 }</h2>
</body>
</html>









