<%@page import="donation.login.Member"%>
<%@page import="admin.model.vo.Admin"%>
<%@page import="notice.model.vo.Notice"%>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>

<%
ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");

	String pageNavi = (String) request.getAttribute("pageNavi");
	//Member m = (Member)session.getAttribute("m");
	Admin a = (Admin)session.getAttribute("admin");
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

</head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<style>

 

#notice-content{

	width:1200px;

	margin:0 auto;

	padding-left:50px;
	padding-bottom:50px;
	 background: url(/img/backimg.jpeg);
	 background-size: 1200px 300px;
	background-repeat: no-repeat;


}

#notice {

	padding-top: 100px; 

	width: 90%;

}

 

.title:hover {

	text-decoration: underline;

	color: black;

}

 

#btn-style {

	padding: 50px 0;

}

 

#button-style {

	text-align: right;

	padding-right: 55px;

	padding-bottom: 20px;

}

 

#list-nav {

	margin-bottom:40px;

}
#notice-tab{
	height:30px;
}
#notice-style>td{
	text-align:center;
	border-style:none;
}
#notice-style>th{
	text-align:center;
}
#list-h3{
	padding-top:200px;
	text-align:center;
}
</style>

<body>

	<%@include file="/WEB-INF/views/common/header.jsp"%>

	<div id="notice-wrap">
		
		<div id="notice-content">
				<h3 id="list-h3">"해피흠에서 새로운 소식과 보도자료를 만나보세요" </h3>
			<div id="notice">
			
				<table class="table table-hover">

					<tr class="table-info"id="notice-style">

						<th>번호</th>

						<th>제목</th>

						<th>작성자</th>

						<th>작성일</th>

					</tr>

					<%
					for (Notice n : list) {
					%>

					<tr id="notice-style">

						<td><%=n.getRnum()%></td>

						<td><a href="/noticeView?noticeNo=<%=n.getNoticeNo()%>"><%=n.getNoticeTitle()%></a></td>

						<td><%=n.getNoticeWriter()%></td>

						<td><%=n.getNoticeDate()%></td>

					</tr>

					<%

						}

					%>

				</table>
				
				<%if(a!=null){ %>
				
				<div class="form-row pull-right" id="button-style">
			
					<a class="btn btn-outline-secondary" href="/noticeWriteFrm">글쓰기</a>

				</div>
				<%} %>
				

				<nav aria-label="Page navigation example">

				<div id="list-nav"><%=pageNavi%></div>

				</nav>

			</div>

		</div>

	</div>

	
	<%@include file="/WEB-INF/views/common/footer.jsp"%>

 

</body>

</html>
