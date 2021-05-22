<%@page import="admin.model.vo.Admin"%>
<%@page import="donation.login.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%
    Member m = (Member)session.getAttribute("m");
    Admin adm = (Admin)session.getAttribute("admin");
    %>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="/css/main.css">
  <link rel="stylesheet" href="/css/join.css">
  <link rel="stylesheet" href="/css/admin.css">
  <!-- <script type="text/javascript" src="/js/jquery-3.3.1.js"></script> -->
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');
    @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&display=swap');
    @media screen and (max-width: 1280px) {
  		.right-col{
      		display: none;
  		}
	} 
  </style>
  <script>
  	function test11(){
  		alert("로그인 후 후원이 가능합니다.");
  		location.href="/";
  	}
  	function test12(){
  		alert("로그인 후 게시글 확인이 가능합니다.");
  		location.href="/";
  	}
  </script>
  <header>
    <div class="header-wrap">
      <a href="/" class="home">해피흠</a>
      <button type="button" class="menu-btn">메뉴열기</button>
      <ul class="nav">
        <li class="nav-item"><a href="/productList?reqPage=1">후원상품소개</a></li>
        <li class="nav-item"><a href="/supportList?reqPage=1">공지사항</a></li>

		<%if (m != null){ %>
        <li class="nav-item"><a href="/donation">후원하기</a></li>
        <%} else { %>
        <li class="nav-item"><a href="javascript:void(0);" onclick="test11();">후원하기</a></li>
        <%} %>
        <%if (m != null){ %>
        <li class="nav-item"><a href="/donationList?reqPage=1">후원게시판</a></li>
        <%} else { %>
        <li class="nav-item"><a href="javascript:void(0);" onclick="test12(); ">후원게시판</a></li>
        <%} %>
        <li class="nav-item"><a href="/freeBoard?reqPage=1">자유게시판</a></li>

      </ul>
     <%--  원래코드
      <%if (adm == null) {%>
      <div class="right-col">
        <ul class="login">
          <li class="login-item"><a href="/login">로그인</a></li>
          <li class="login-item"><a href="/join">회원가입</a></li>
        </ul>
        <a class="interior-link" href="/adminJoin">관리자</a>
      </div>
      <%} else { %>
      <div class="right-col">   
         <ul class="login">
          <li class="login-item"><a href="/adminPage" style="color:rgba(0, 183, 255, 0.959);"><%=adm.getAdminName() %> </a>님 환영합니다</li>
          <li class="login-item"><a href="/logout">로그아웃</a></li>
         </ul>
      </div>
      <%} %>
      --%>
      <%if (m != null) {%>
      <div class="right-col">   
         <ul class="login">
           <li class="login-item"><a href="/memberMyPage" style="color:rgba(0, 183, 255, 0.959);"><%=m.getMemberName() %> </a>님 환영합니다</li>
           <li class="login-item"><a href="/memberLogout">로그아웃</a></li>
         </ul>
      </div>
      <%} else if(adm != null){ %>
      <div class="right-col">   
         <ul class="login">
           <li class="login-item"><a href="/adminPage" style="color:rgba(0, 183, 255, 0.959);"><%=adm.getAdminName() %> </a>님 환영합니다</li>
           <li class="login-item"><a href="/logout">로그아웃</a></li>
         </ul>
      </div>
      <%}else{%>
      <div class="right-col">
        <ul class="login">
          	<li class="login-item"><a href="/memberLoginPage">로그인</a></li>
			<li class="login-item"><a href="/memberJoinPage">회원가입</a></li>
        </ul>
        <a class="interior-link" href="/adminJoin">관리자</a> 
      </div>
      <%} %>
      
    </div>

    <div class="mobile-panel">
      <div class="panel-board">
        <button type="button" class="board-close-btn">

        </button>

        <ul class="board-nav">
          <li class="board-nav-item"><a href="#none">메뉴1</a></li>
          <li class="board-nav-item"><a href="#none">메뉴2</a></li>
          <li class="board-nav-item"><a href="#none">메뉴3</a></li>
          <li class="board-nav-item"><a href="#none">메뉴4</a></li>
          <li class="board-nav-item"><a href="#none">마이페이지</a></li>
        </ul>
        <ul class="account-list">
          <li class="account-item"><a href="/login">로그인</a></li>
          <li class="account-item"><a href="#none">회원가입</a></li>
          <li class="account-item"><a href="#none">이용약관</a></li>
          <li class="account-item"><a href="#none">개인정보처리방침</a></li>
        </ul>
      </div>
    </div>
  </header>
  <script>
  		function func1(){
  			if(m != null){
  				location='/donation';
  			}else{
  				alert("로그인을 해야 후원이가능합니다.");
  			}
  		}
  </script>