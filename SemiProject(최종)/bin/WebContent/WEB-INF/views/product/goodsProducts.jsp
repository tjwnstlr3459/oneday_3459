<%@page import="main.model.vo.Main"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    ArrayList<Main> list = (ArrayList<Main>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<style>
#searchList{
	margin-top : 100px;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="content">
		<div class="content-detail">
			<div id="searchList">
				<%for(Main n : list){ %>
					<tr class="table-light">
						<td><%=n.getNoticeTitle() %>, </td>
						<td><%=n.getNoticeWriter() %>, </td>
						<td><%=n.getNoticeDate() %></td>
					</tr>
					<br>
				<%} %>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>