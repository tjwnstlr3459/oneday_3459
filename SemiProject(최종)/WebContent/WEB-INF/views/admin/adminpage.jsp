<%@page import="java.util.ArrayList"%>
<%@page import="admin.model.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Admin admin = (Admin)request.getAttribute("admin");
    	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <style>
    .content-detail>.registerForm {
        height: auto;
        margin-bottom: 100px;
    }

    .registerForm>ul>li {
        /* margin: 30px; */
        padding: 10px;
        display:flex;
    }
   	#readonly1{
   		outline:none;
   		background-color:rgb(212, 212, 212);
   	}
</style>
<script>
      function selectTab(idx) {
          var tabContents = document.getElementsByClassName("tabContent");
          var tabs = document.getElementsByClassName("tab");
          for (var i = 0; i < tabContents.length; i++) {
              // tabs[i].style.border = "1px solid black";
              tabs[i].style.backgroundColor = "transparent";
              tabContents[i].style.display = "none";
          }
          tabs[idx].style.backgroundColor = "rgb(207, 204, 204)";
          tabContents[idx].style.display = "block";
      }
      window.onload = function () {
          var tabContents = document.getElementsByClassName("tabContent");
          var tabs = document.getElementsByClassName("tab");
          tabs[0].style.backgroundColor = "rgb(207, 204, 204)";
          tabContents[0].style.display = "block";
      }
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	 <div class="content">
            <div class="content-detail">
                <div>
                    <div class="tabMenu">
                        <ul class="tabs">
                            <li class="tab" onclick="selectTab(0);">정보수정</li>
                            <li class="tab" onclick="selectTab(1);">사용자관리</li>
                        </ul>
                        <div class="tabContent">

                            <form action="/updateAdmin" method="post" class="registerForm">
                                <h1 class="register" style="margin:0 0 30px 0">관리자 정보수정
                                </h1>
                                <hr style="border: 0.1px solid rgb(233, 232, 232);">
                                <ul>
                                    <li><span style="width:30%">관리자아이디</span><input id="readonly1" type="text" name="adminId"
                                            value="<%=admin.getAdminId()%>" readonly><br></li>
                                    <li><span style="width:30%">비밀번호</span><input type="password" name="adminPw"
                                             value="<%=admin.getAdminPw()%>"><br></li>
                                    <li><span style="width:30%">이름</span><input id="readonly1" type="text" name="adminName" value="<%=admin.getAdminName()%>" readonly><br></li>
                                    <li><span style="width:30%">전화번호</span><input type="text" name="adminPhone" value="<%=admin.getPhone()%>"><br></li>
                                    <li><span style="width:30%">주소</span><input type="text" name="adminAddr" value="<%=admin.getAddr()%>"><br>
                                    </li>
                                </ul>
                                <button type="submit">수정하기</button>
                            </form>
                            <div class="content-footer"> </div>

                        </div>
                        <div class="tabContent">
                            <table class="tableBorder" width="700" height="300">
                                <tbody>
                                    <tr class="table-primary">
                                        <td>선택</td>
                                        <td>아이디</td>
                                        <td>이름</td>
                                        <td>번호</td>
                                        <td>주소</td>
                                        <td>이메일</td>
                                        <td>회원탈퇴</td>
                                    </tr>
                                    <%for(Member m1 : list){ %>
                                    <tr class="table-light">
                                        <td><input type="checkbox" class="chk"></td>
                                        <td><%=m1.getMemberId() %></td>
                                        <td><%=m1.getMemberName() %></td>
                                        <td><%=m1.getMemberPhone() %></td>
                                        <td><%=m1.getMemberAddr() %></td>
                                        <td><%=m1.getMemberEmail() %></td>
                                        <td>
                                            <button type="button" style="background-color: orange;"><a href="/deleteMember?memberId=<%=m1.getMemberId()%>">회원탈퇴</a></button>
                                        </td>
                                    </tr>
                                    <%} %>
                                
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>