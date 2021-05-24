<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- JSTL 라이브러리 등록 -->
    <%@ 
    taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" 
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%@ include file="/WEB-INF/views/common/header.jsp" %> --%>
	<jsp:include page="/WEB-INF/views/common/header1.jsp"/>
	<div class="container">
		<h1>웹프로젝트 메인</h1>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>