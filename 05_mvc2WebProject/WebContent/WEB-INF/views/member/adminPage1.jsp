<%@page import="java.util.ArrayList"%>
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
	<jsp:include page="/WEB-INF/views/common/header1.jsp"/>
	<div class="container">
		<fieldset>
			<legend>전체회원정보</legend>
			<table class="table-hover" style="width:100%;">
				<tr class="table-primary">
					<th>선택</th><th>회원번호</th><th>아이디</th><th>이름</th><th>전화번호</th>
					<th>주소</th><th>가입일</th><th>회원등급</th><th>등급변경</th>
				</tr>
				
				<c:forEach items="${list }" var="member">
				<tr class="table-light">
					<td><input type="checkbox" class="chk"></td>
					<td>${member.memberNo }</td>
					<td>${member.memberId }</td>
					<td>${member.memberName }</td>
					<td>${member.phone }</td>
					<td>${member.address }</td>
					<td>${member.enrollDate}</td>
					<td>
						<select class="form-control" style="width:80%;display:inline-block">
							<c:choose>
								<c:when test="${member.memberLevel == 1 }">
									<option value="1" selected>관리자</option>
									<option value="2">정회원</option>
									<option value="3">준회원</option>
								</c:when>
								<c:when test="${member.memberLevel == 2 }">
									<option value="1" >관리자</option>
									<option value="2" selected>정회원</option>
									<option value="3">준회원</option>
								</c:when>
								<c:when test="${member.memberLevel == 3 }">
									<option value="1" >관리자</option>
									<option value="2">정회원</option>
									<option value="3" selected>준회원</option>
								</c:when>
							</c:choose>
						</select>
					</td>
					<td>
						<button class="btn btn-outline-warning btn-sm changeLevel">등급변경</button>
					</td>
					
				</tr>
				</c:forEach>
				
				<tr>
					<th colspan="9">
						<button class="btn btn-warning btn-block checkedChangeLevel">선택회원 등급변경</button>
					</th>
				</tr>
			</table>
		</fieldset>
	</div>
	<script>
		//등급변경 클릭시 (level,membeno)가 필요
		$(".changeLevel").click(function(){
			//회원등급 확인
			var memberLevel = $(this).parent().prev().children().val();
			console.log(memberLevel);
			//회원번호 확인
			var memberNo = $(this).parent().parent().children().eq(1).html();
			console.log(memberNo);
			location.href="/changeLevel?memberNo="+memberNo+"&memberLevel="+memberLevel;
		});
		
		//전체 등급변경 클릭시
		$(".checkedChangeLevel").click(function(){
			var inputs = $(".chk:checked");
			var num = new Array();
			var level = new Array();
			
			inputs.each(function(idx,item){
				num.push($(item).parent().next().html());
				level.push($(item).parent().parent().find("select").val());
			});
			console.log(num);
			console.log(level);
			location.href="/checkedChangeLevel?num="+num.join("/")+"&level="+level.join("/");
		});
	
	</script>
	
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>





















