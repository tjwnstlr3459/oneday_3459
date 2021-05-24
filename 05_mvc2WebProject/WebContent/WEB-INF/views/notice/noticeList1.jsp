<%@page import="notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!-- JSTL 라이브러리 등록 -->
    <%@ 
    taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	String pageNavi = (String)request.getAttribute("pageNavi");
%> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%@include file="/WEB-INF/views/common/header.jsp" %> --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="container">
	<fieldset>
		<legend>공지사항</legend>
		
		<c:if test="${empty sessionScope.m }">
			<div>
				<a class="btn btn-info writeBtn" href="/noticeWriteFrm">글쓰기</a>
			</div>
		</c:if>
		
		<table class="table-hover" style="width:100%">
			<tr>
				<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
			</tr>
			
			
			<c:forEach items="${list }" var="n">
				<tr class ="table-light">
					<td>${Rnum }</td>
					<td style="text-align:left;"><a href="/noticeView?noticeNo=${n.noticeNo }">${n.noticeTitle }</a></td>
					<td>${n.noticeWriter }</td>
					<td>${n.noticeDate }</td>
				</tr>
			</c:forEach>
		
		</table>
		<div id="pageNavi">${pagenavi }</div>	
		</fieldset>
	</div>
	
	
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>