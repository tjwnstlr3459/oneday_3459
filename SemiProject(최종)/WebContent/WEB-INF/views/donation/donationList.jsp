<%@page import="java.text.DecimalFormat"%>
<%@page import="donation.DonationList"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	ArrayList<DonationList> list = (ArrayList<DonationList>)request.getAttribute("list");
	String pageNavi = (String)request.getAttribute("pageNavi");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>project</title>
  <link rel="stylesheet" href="./css/main.css">
  <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
  <!--게시글 스트랩-->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>

  <!--슬릭-->
  <link rel="stylesheet" type="text/css" href="/slick/slick/slick.css" />
  <link rel="stylesheet" type="text/css" href="/slick/slick/slick-theme.css" />
  <script type="text/javascript" src="/slick/slick/slick.js"></script>
  <script src="/slick/main.js" type="text/javascript"></script>
  
  <!-- css -->
  <link href="/css/donationList.css" rel="stylesheet" type="text/css" />
  <link href="/css/donation1.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<style>
	.header-wrap>.nav>li>a{
 		padding: 0;
 	}
 </style>
<body>
	
	<!-- Header -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
  <div class="layout-wrap">
    <!-- header -->
    
    <!-- header -->

    <!-- content -->
    	
      <div class="content" style="padding-top: 0px; width: 910px; margin: 0 auto;">
      <div class="con1" style="overflow: hidden">
          <div id="slider-div" style="">
            <div><img src="mini_img/16.jpg" class="slideImg" /></div>
            <div><img src="mini_img/9.jpg" class="slideImg" /></div>
            <div><img src="mini_img/10.jpg" class="slideImg" /></div>
            <div><img src="mini_img/8.jpg" class="slideImg" /></div>
            <div><img src="mini_img/5.jpg" class="slideImg" /></div>
            <div><img src="mini_img/11.jpg" class="slideImg" /></div>
          </div>
        </div>
      <div class="container">
      	<br><br>
        <h3 style="margin-left: 70px;">후원게시판</h2>
        <br>                                         
        <div class="table-responsive">          
        <table class="table" style="margin: 0px; overflow: hidden; ">
          <thead>
            <tr class="donahighNavi" style="background-color: #343a40; color:white;">
              <th style="text-align: center;">번호</th>
              <th style="width:130px;">후원분류</th>
              <th>금액</th>
              <th>후원인</th>
              <th>전하고싶은말</th>
              <th>수정</th>
            </tr>
          </thead>
          <tbody>
             <%for(DonationList n : list){ %>
             <%DecimalFormat formatter = new DecimalFormat("###,###,###"); %>
             
            <tr class="donaConList" style="height:40px;">
              <td style="width: 60px;"><%=n.getDona_no() %></td>
              <td style="width: 130px; padding-top: 10px"><%=n.getPa_level() %></td>
              <td style="width: 120px; text-align: right; padding-right: 30px"><%=formatter.format(n.getPa_amount())%>원</td>
              <td style="width: 120px; text-align: left; padding-left: 20px"><%=n.getDona_writer()%></td>
              <td style="width: 300px; height: 40px; text-align: left; margin-left: 100px"><%=n.getDona_content()%></td>
              
              
              <%if(n.getDona_writer().equals(m.getMemberName())){ %>
              <td style="width: 100px;"><input type="button"  class="modifyDonation" value="수정" style="font-size:14px;" > 
              <%}else{ %>
              <td style="width: 100px;"><input style="background-color: rgba(0, 183, 255, 0.959);font-size:14px;" type="button"  class="modifyDonation" value="내역";> 
              <%} %>
              
                <div class="alertModal" style="position: absolute; z-index: 10;">
                  <div class="alertWrap">
                    <h2>후원내용</h2>
                    <hr>
                    <form action="/donationListUpdate?donationNo=<%=n.getDona_no()%>" method="post">
                      <div class="donaModal">
                        <div class="radioHover">
                          <div>후원처</div>
                          <input type="radio" id="dona_sor1" name="dona_sor" value="개인"><label style="width: 40px;" for="dona_sor1">개인</label>
                          <input type="radio"  id="dona_sor2" name="dona_sor" value="법인"><label style="width: 40px;" for="dona_sor2">법인</label>
                          <input type="radio"  id="dona_sor3" name="dona_sor" value="학교 및 단체"><label for="dona_sor3">학교 및 단체</label>
                          
                        </div>
                        <div>
                          <div>후원자</div>
                          <input type="text" name="name" style="width: 300px; font-size:14px;" value="<%=n.getDona_writer()%>"/>
                        </div>
                        <div>
                          <div>email</div>
                          	<%String str =  m.getMemberEmail(); %>
		                  	<%String email1 = str.substring(0,str.indexOf("@")); %>
		                  	<%String email2 = str.substring(str.lastIndexOf("@")+1); %>
                          <input type="text" name="email" style="width: 100px; font-size:14px;" value="<%=email1 %>" > @
                          <input type="text" name="email2" style="width: 90px; font-size:14px;" value="<%=email2 %>" >
                          <select class="select"style="width: 90px; height: 20px; outline: none; font-size:14px;"onChange="selectEmail(this)">
                            <option>직접입력</option>
                            <option value="naver.com">naver.com</option>
                            <option value="hanmail.net">hanmail.net</option>
                            <option value="yahoo.co.kr">yahoo.co.kr</option>
                            <option value="gmail.com">gmail.com</option>
                          </select>
                        </div>
                        <div>
                          <div>제목</div>
                          <input type="text" name="title" style=" font-size:14px;" value="<%=n.getDona_title()%>">
                        </div>
                        <div>
                          <div>내용</div>
                          <textarea name="concon" style="width: 300px; height: 100px;  font-size:14px; resize: none;"><%=n.getDona_content()%></textarea>
                        </div>
                      </div>
                      <div class="modifyBtn">
                      <%if(n.getDona_writer().equals(m.getMemberName())){ %>
                        <button class="modiBtn1" type="button" onclick="location.href='donaListDel?donaNum=<%=n.getDona_no() %>'" style=" font-size:14px; background-color: rgba(250, 44, 44, 0.555); color: white;">게시글 삭제</button>
                        <button class="modiBtn2" type="button" onclick="cancle()" style=" font-size:14px; background-color: rgba(48, 48, 48, 0.753); color: white;">취소</button>
                        <button class="modiBtn3" type="submit" style="background-color: orange;  font-size:14px; color: white;">수정</button>
                      <%} else{%>
                      <button class="modiBtn2" type="button" onclick="cancle()" style=" font-size:14px; background-color: rgba(48, 48, 48, 0.753); color: white;">취소</button>
                      <%} %>
                      </div>
                    </form>
                  </div>
              </div>
              </td>
            </tr>
            <%} %>
          </tbody>
        </table>
        </div>
        <div id="dona_pageNavi" style="text-align: center;"><%=pageNavi%></div>
        <hr style="width: 90%">
        <div class="donaBottom">
        <div class="donaBottom1">
        	<h3>함께이기에 하나가 될수있습니다</h3>
        	<hr style="width: 95%">
        	<p style="font-size: 13px; font-family: 'Nanum Gothic', sans-serif; line-height: 25px;">
        	여러분의 소중한 관심이 하나로 모여 오늘의 행복을 만들어 나갑니다.<br>
        	누구에게나 추억은 소중하듯이 그 소중한 추억을<br>
        	 우리 모두가 만들어낼수 있습니다<br>
        	 혼자가 아닌 함께이기에<br>
        	 저희 해피흠은 미래를 만들어 나갑니다.
        	</p>
        </div>
        <div class="donaBottom2">
        	<img src="mini_img/64.jpg">
        </div>
        </div>
      </div>

      <!-- footer -->
      
      <!-- footer -->

	<!-- Footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>

<script>
	$(function(){
	    $(".modifyDonation").click(function(){
	        $(this).next().css("display","flex");
	    });
	  });

	function cancle(){
		$(".alertModal").hide();
	}
	
	function selectEmail(ele) {
	    var ele = $(".select").val();
	    var email2 = $("input[name=email2]");
	    email2.val(ele);
	  } 
	//수정/내역 클릭시 라벨 적용되게끔
	$("[name=dona_sor]").next().click(function(){
		$(this).prev().click();
	});
	</script>
</html>











