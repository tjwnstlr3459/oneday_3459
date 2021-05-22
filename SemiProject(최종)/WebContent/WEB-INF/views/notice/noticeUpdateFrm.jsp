<%@page import="donation.login.Member"%>
<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Notice n = (Notice)request.getAttribute("n");
    //Member m = (Member)session.getAttribute("m");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
<script src="bootstrap-modal-wrapper-factory.min.js"></script>
<style>
	#update-frm{
		padding-top:150px;
	}
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container" id="update-frm">
		<form action="/noticeUpdate" method="post" enctype="multipart/form-data">
			<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo() %>">
			<fieldset>
				<legend>수정</legend>
				<table class="table table-striped" style="width:100%; height:500px;">
					<tr>
						<th class="danger">제목</th>
						<td colspan="3">
							<input type="text" class="form-control" name="noticeTitle" value="<%=n.getNoticeTitle()%>" style="height:30px;">
						</td>
					</tr>
					<tr>
						<th class="danger">작성자</th>
						<td>							
							<%=adm.getAdminId() %>	
						</td>
						<th>첨부파일</th>
						<td style="text-align:left">
							<input type="hidden" name="status" value="stay">
							<%if(n.getFilename() != null) {%>
								<img src="/img/file.png" width="16px" class="delFile">
								<span class="delFile"><%=n.getFilename() %></span>
								<button type="button" id="delBtn" class="btn btn-info btn-sm delFile">삭제</button>
								<input type="file" name="filename" id="file">
								<input type="hidden" name="oldFilename" value="<%=n.getFilename() %>">
								<input type="hidden" name="oldFilepath" value="<%=n.getFilepath() %>">
							<%}else{ %>							
								<input type="file" name="filename">
							<%} %>
						</td>
					</tr>
					<tr>
						<th class="danger">내용</th>
						<td colspan="3"><textarea name="noticeContent" class="form-control" style="height:400px;"><%=n.getNoticeContent() %></textarea></td>
					</tr>
					<tr>
						<th colspan="4">
							<button type="submit" class="btn btn-info btn-block" style="border-style:none;">수정하기</button>
						</th>
					</tr>
				</table>
				</fieldset>
		</form>
	</div>
	<script>
		$("#delBtn").click(function(){
			if(confirm("첨부파일을 삭제하시겠습니까?")){
				$("#delFile").hide();
				$("#file").show();
				$("[name=status]").val("delete");	
				
			}
		});
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>






