<%@page import="donation.login.Member" %>
	<%@page import="free.model.vo.Free" %>
		<%@page import="java.util.ArrayList" %>
			<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

				<% ArrayList<Free> list = (ArrayList<Free>) request.getAttribute("list");
						String pageNavi = (String) request.getAttribute("pageNavi");

						%>
						<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
						<html>

						<head>
							<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
							<title>freeBoard</title>
							<%@ include file="/WEB-INF/views/free/freeHeader.html" %>
						</head>

						<body>

							<!-- Header -->
							<%@ include file="/WEB-INF/views/common/header.jsp" %>
								<link rel="stylesheet" href="/css/free/freeBoard.css">
								<div class="container">
									<h3>자유게시판</h3>
									<br>
									<table class="table table-hover table-bordered">
										<thead class="thead-dark">
											<tr>
												<th>글번호</th>
												<th>제목</th>
												<th>작성자</th>
												<th>작성일</th>
												<th>조회</th>
												<th>좋아요</th>
											</tr>
										</thead>

										<tbody>
											<%for(Free f : list) { %>
												<tr>
													<td>
														<%=f.getRnum() %>
													</td>
													<td><a href="/freeView?freeNo=<%= f.getFreeNo()%>">
															<%=f.getFreeTitle() %>
														</a></td>
													<td>
														<%=f.getFreeWriter() %>
													</td>
													<td>
														<%=f.getFreeDate() %>
													</td>
													<td>
														<%=f.getReadCount() %>
													</td>
													<td>
														<%=f.getLikeCount()%>
													</td>
												</tr>
												<%} %>
										</tbody>
									</table>

									<!-- 로그인 시에만 글쓰기 가능 -->
									<%if(m !=null) {%>
										<div>
											<a class="btn btn-outline-primary" href="/freeWriteFrm">글쓰기</a>
										</div>
										<%} %>
											<div class="pageNavi">
												<%=pageNavi%>
											</div>


											<form class="form-inline searchFrm" action="/freeSearch" method="GET">
												<select class="form-control" name="searchWhat">
													<option value="1">제목</option>
													<option value="2">작성자</option>
												</select>
												<input class="form-control" type="text" name="searchContent" required>
												<input class="btn btn-outline-info" type="submit" value="검색">
												<input type="hidden" value="1" name="reqPage">
											</form>

								</div>
								<!-- Footer -->
								<%@ include file="/WEB-INF/views/common/footer.jsp" %>
						</body>


						</html>