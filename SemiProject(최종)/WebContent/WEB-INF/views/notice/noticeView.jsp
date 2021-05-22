<%@page import="admin.model.vo.Admin"%>
<%@page import="donation.login.Member"%>
<%@page import="notice.model.vo.NoticeComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Notice n = (Notice) request.getAttribute("n");
ArrayList<NoticeComment> list = (ArrayList<NoticeComment>) request.getAttribute("list");
//Member m = (Member) session.getAttribute("m");
Admin a = (Admin) session.getAttribute("admin");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!— jQuery라이브러리 추가(2개)—>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> 
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script> 
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script> 
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
  />


<style>
#view-wrap {
	padding-top: 150px;
	/* height:1200px; */
	padding-bottom: 80px;
	
}

#view-com {
	padding-bottom: 50px;
}

#view-btn {
	padding-top: 30px;
}

#view-com {
	width: 100px;
	height: 40px;
	padding: 0;
}
#view-botton{
	height:30px;

}
#view-btntag{
	margin-top:20px;
}
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	
	<div class="container" id="view-wrap">
		<div id="notice-view">
			<table class="table" id="notice-view" style="width: 100%;">
				<tr class="table-info">

					<th colspan="4"><%=n.getNoticeTitle()%></th>
				</tr>
				<tr class="table-light">
					<th style="width:100px;">작성자</th>
					<th style="width:100px;"><%=n.getNoticeWriter()%></th>
					<th style="width:100px;">작성일</th>
					<th style="width:100px;"><%=n.getNoticeDate()%></th>
				</tr>
				<tr class="table-light">
					<th>첨부파일</th>
					<th colspan="3">
						<%
						if (n.getFilename() != null) {
						%> <img src="/img/file.png" width="16px"> <a
						href="/fileDown?noticeNo=<%=n.getNoticeNo()%>"><%=n.getFilename()%></a>
						<%
						}
						%>
					</th>
				</tr>
				<tr class="table-light">
					<th>내용</th>
					<th colspan="3"><%=n.getNoticeContentBr()%></th>
				</tr>

				<tr class="table-light">
					<th colspan="4" style="text-align: center;" id="view-btn">
						<button class="btn btn-info" onclick="history.go(-1);">돌아가기 </button>
						<%
						if (a != null) {
						%> <a class="btn btn-info"
						href="/noticeUpdateFrm?noticeNo=<%=n.getNoticeNo()%>">수정</a> <a
						class="btn btn-info"
						href="/noticeDelete?noticeNo=<%=n.getNoticeNo()%>">삭제</a> <%
 }
 %>
					</th>
				</tr>
				
			</table>
		</div>
		<%
		if (m != null || a!=null) {
		%>
		<div class="inputCommentBox card-header bg-light" style="margin-top:50px;">
		<i class="fa fa-comment fa"></i> REPLY
			<form action="/insertComment" method="post">
				<ul>
					<li><i class=”fafa-arrows-v“></i></li>
					<li><input type="hidden" name="ncLevel" value="1"> 
						<%if(m != null) {%>
						<input
						type="hidden" name="ncWriter" value="<%=m.getMemberId()%>">
						<%} %>
						<input type="hidden" name="noticeRef" value="<%=n.getNoticeNo()%>">
						<input type="hidden" name="ncRef" value="0"> <textarea
							class="form-control" name="ncContent" style="height: 40px;"></textarea></li>
					<li>
						<button type="submit" class="btn btn-dark mt-3 float-right"
							id="view-com" style="height: 40px; margin-top:20px;">등록</button>
					</li>
				</ul>
			</form>
		</div>
		<%
		}
		%>
		<%--댓글 출력 시작 --%>
		<div  style="margin-top:50px;">
		
			<%for(NoticeComment nc : list) {%>
			<%if(nc.getNcLevel() == 1) {		%> 
			<ul  class="list-group list-group-flush">
				<li class="list-group-item" style="padding:0">
				<div class="form-inline mb-2" style="padding:5px;">
				<i class="fa fa-user-circle-o fa-2x"></i>
					<p style="padding-left:30px;"><%=nc.getNcWriter() %></p>
					</div>
				</li>
				<li>
					<p style="padding:10px;"><%=nc.getNcContentBr() %></p>
					<textarea name="ncContent" class="form-control ml-2" style="display:none;"><%=nc.getNcContent() %></textarea>
					<p class="commentsBtn float-right " style="margin-bottom:20px;">
					<%if(a!=null) {%>
						<%if(a.getAdminId().equals(nc.getNcWriter())) {%>
							<a class="btn btn-light"id="view-botton" href="javascript:void(0)" onclick="modifyComment(this,'<%=nc.getNcNo()%>','<%=n.getNoticeNo()%>');">수정</a>
							<a class="btn btn-light"id="view-botton" href="javascript:void(0)" onclick="deleteComment(this,'<%=nc.getNcNo()%>','<%=n.getNoticeNo()%>');">삭제</a>
							
						<%} //댓글 작성자와 로그인 회원이 일치하는 경우 %>
						
					<%} //로그인 되어있는경우 %>
					</p>
					<%-- <%if(m != null ) {%>
					<form action = "/insertComment" class="recoment">
						<input type="hidden" name="ncLevel" value="2">
						<input type="hidden" name="ncWriter" value="<%=m.getMemberId() %>">
						<input type="hidden" name="noticeRef" value="<%=n.getNoticeNo() %>">
						<input type="hidden" name="ncRef" value="<%=nc.getNcNo()%>">
						
					</form>
					<%} %> --%>
				</li>
			</ul>
			
			<%} %>
			<%} //전체댓글 반복문 끝나는 지점%>
			</div>
			</div>
			<script>
	
			$(".recShow").click(function(){
				var idx = $(".recShow").index(this);	//클릭한게 몇번째 답글달기 버튼인지 구하는 코드
				$(this).show();
				$(".recoment").eq(idx).css("display","flex");
			});
			$(".recCancel").click(function(){
				var idx = $(".recCancel").index(this);
				$(".recoment").eq(idx).css("display","none");
				$(".recShow").eq(idx).hide();
			});
		function modifyComment(obj,ncNo,noticeNo){
			//textarea를 보여줌
			$(obj).parent().prev().show();
			//기존본문내용을 숨김
			$(obj).parent().prev().prev().hide();
			//수정 -> 수정완료
			$(obj).html('수정완료');
			$(obj).attr("onclick","modifyComplete(this,'"+ncNo+"','"+noticeNo+"')");
			//삭제 -> 수정취소
			$(obj).next().html("수정취소");
			$(obj).next().attr("onclick","modifyCancel(this,'"+ncNo+"','"+noticeNo+"')");
			//답글달기 버튼 삭제
			$(obj).next().next().hide();
		}
		function modifyCancel(obj,ncNo,noticeNo){
			//textarea 숨김
			$(obj).parent().prev().hide();
			//기존본문내용 다시 보여줌
			$(obj).parent().prev().prev().show();
			//수정완료 -> 수정 
			$(obj).prev().html("수정");
			$(obj).prev().attr("onclick","modifyComment(this,'"+ncNo+"','"+noticeNo+"')");
			//수정 취소 -> 삭제
			$(obj).html("삭제");
			$(obj).attr("onclick","deleteComment(this,'"+ncNo+"','"+noticeNo+"')");
			//답글달기버튼 보이게
			$(obj).next().show();
		}
		function modifyComplete(obj,ncNo,noticeNo){
			var form = $("<form action='/noticeCommentUpdate' method='post'></form>");
			form.append($("<input type='text' name='ncNo' value='"+ncNo+"'>"));
			form.append($("<input type='text' name='noticeNo' value='"+noticeNo+"'>"));
			form.append($(obj).parent().prev());
			$("body").append(form);
			form.submit();
		}
		function deleteComment(obj,ncNo,noticeNo){
			if(confirm("댓글을 삭제하시겠습니까?")){
				location.href="/noticeCommentDelete?ncNo="+ncNo+"&noticeNo="+noticeNo;
			}
		}
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>