<%@page import="user.model.vo.User"%>
<%@page import="user.model.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    User user = (User)request.getAttribute("user");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/searchUserFrm" method="post">
		<input type="text" name="no">
		<button type="submit" value="버튼">버튼</button>
	</form>
	
	<%if(user!=null){ %>
	<tr>
		<th>번호</th><th><%=user.getUserNo()%></th>
		<th>번호</th><th><%=user.getUserId()%></th>
		<th>번호</th><th><%=user.getUserName()%></th>
		<th>번호</th><th><%=user.getUserAge()%></th>
	<tr>	
	<%}else{ %>
		<a href="/searchUserFrm"></a>
	<%} %>
</body>
</html>