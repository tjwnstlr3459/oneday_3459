<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- JSTL 라이브러리 등록 -->
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
	
	<c:set var="num1" value="100" scope="request"/><!-- 끝에 /면 닫는 태그 생략가능 -->
	<!-- el방식 출력 -->
	<h1>${num1 }</h1>
	<c:set var="num2" value="200" scope="request"/>
	<h1>${num2 }</h1>
	<h1>${num1+num2 }</h1>
	
	<!-- 세션에 저장 -->
	<c:set var="num1" value="300" scope="session"/>
	<h1>${sessionScope.num1 }</h1>
	
	<!-- 삭제 -->
	<c:remove var="num1" scope="request"/>
	<h1>${num1 }</h1><!-- request num1 이 삭제되어서 세션에 num1이 출력된다 -->
	<h1>${requestScope.num1 }</h1><!-- 삭제되어 출력 안됨 -->
	<hr>
	
	<!-- c:out 을 쓰는 이유(기본값 설정가능) -->
	<h1><c:out value="${num2 }" default="없음"/></h1>
	<h1><c:out value="${data }" default="없음"/></h1>
	
	<!-- 태그 비적용/적용 -->
	<p><c:out value="글씨를 진하게 하려면<b>11</b>를 사용" escapeXml="false"/></p>
	<p><c:out value="글씨를 진하게 하려면<b>11</b>를 사용" escapeXml="true"/></p>
	
</body>
</html>











