<%@page import="free.model.vo.Free"%>
<%@page import="free.model.vo.FreeLike"%>
<%@page import="main.model.service.MainService"%>
<%@page import="product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="donation.login.Member"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="donation.DonationService"%>
<%@page import="donation.DonationList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int allMoney = new DonationService().allMoney();
    	Member m1 = (Member)session.getAttribute("m");
   ArrayList<Free> list3 = (ArrayList<Free>)request.getAttribute("list3"); 
   ArrayList<Product> goods = (ArrayList<Product>)request.getAttribute("goods"); 
    ArrayList<Free> list4 = (ArrayList<Free>)request.getAttribute("list4");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    img{
       width: 100% !important;
       height:170px;
       
      border-top-right-radius:15px ;
      border-top-left-radius: 15px;

    }
    img:hover{
       opacity: 0.7;
    }
    #search:focus{
       outline:none;
    }
    p{
       color : grey;
    }
    .photo>a{
       color: grey;
    }
    h3{
       padding:10px;
       color:turquoise;   
    }
    h5{
       background-color: pink;
       padding : 10px;
       color: white;
       width: 0 auto;
       border-radius: 20px;
       margin: 5px auto;
       width: 80px;
    }
    .content-detail>ul>li{
       /* padding:10px; */
    }
</style>
</head>
<body>
 <!-- content -->
    <div class="content">
      <div class="content-banner">
        <div>
          <form class="example" action="/search" method="get">
            <input type="text" placeholder="키워드를 검색해 주세요" id="search" name="search">
            <button type="submit"><i class="fa fa-search"></i></button>
          </form>
        </div>
       
      </div>
      <div class="content-detail">
      <%DecimalFormat formatter = new DecimalFormat("###,###,###"); %>
        <h1><span>￦<%=formatter.format(allMoney)%>원</span></h1>
        
        <span><i class="fa fa-heart"></i>관심 후원</span>
        <ul>
         <%if(m1!=null){ %>
            <%for(Free f : list3){%>
            <li>
               <div class="photo"><a href="/freeView?freeNo=<%=f.getFreeNo()%>">
               <%if(f.getFilepath()==null) {%>
                  <img src="/img/logo.png" width="180" height="180">
               <%}else{ %>
               <img src="/upload/free/<%=f.getFilepath() %>" width="180" height="180">
               <%} %>
               </a></div>
               <h3><%=f.getFreeTitle() %></h3>
               <h5><%=f.getFreeWriter() %></h5>
             </li>
         <%}%>
         <%} else{%>
            <%for(Free f : list4){%>
             <li>
               <div class="photo"><a href="/freeView?freeNo=<%=f.getFreeNo()%>">
               <%if(f.getFilepath() == null) {%>
                  <img src="/img/logo.png" width="180" height="180">
               <%}else{ %>
               <img src="/upload/free/<%=f.getFilepath() %>" width="180" height="180">
               <%} %>
               </a></div>
               <h3><%=f.getFreeTitle() %></h3>
               <h5><%=f.getFreeWriter() %></h5>
             </li>
          <%} %>
         <%} %>
       </ul>
       <span><i class="fa fa-heart"></i>굿즈상품 < 결식아동 ></span>
       <ul>
          <%for(Product p : goods){%>
             <%if(p.getProductSpons().equals("결식아동")) {%>
               <li>
               <div class="photo"><a href="/productView?productNo=<%=p.getProductNo()%>">
               <%if(p.getFilepath() == null) {%>
                  <img src="/img/logo.png" width="180" height="180">
               <%}else{ %>
               <img src="/upload/product/<%=p.getFilepath() %>" width="180" height="180">
               <%} %>
               </a></div>
               <h3><%=p.getProductTitle() %></h3>
             </li>
             <%} %>
         <%} %>
       </ul>
       <span><i class="fa fa-heart"></i>굿즈상품 : < 유기동물 ></span>
       <ul>
          <%for(Product p : goods){%>
             <%if(p.getProductSpons().equals("유기동물")) {%>
               <li>
               <div class="photo"><a href="/productView?productNo=<%=p.getProductNo()%>">
               <%if(p.getFilepath() == null) {%>
                  <img src="/img/logo.png" width="180" height="180">
               <%}else{ %>
               <img src="/upload/product/<%=p.getFilepath() %>" width="180" height="180">
               <%} %>
               </a></div>
               <h3><%=p.getProductTitle() %></h3>
             </li>
             <%} %>
         <%} %>
       </ul>
       <span><i class="fa fa-heart"></i>굿즈상품 < 자연 ></span>
       <ul>
          <%for(Product p : goods){%>
             <%if(p.getProductSpons().equals("자연")) {%>
               <li>
               <div class="photo"><a href="/productView?productNo=<%=p.getProductNo()%>">
               <%if(p.getFilepath() == null) {%>
                  <img src="/img/logo.png" width="180" height="180">
               <%}else{ %>
               <img src="/upload/product/<%=p.getFilepath() %>" width="180" height="180">
               <%} %>
               </a></div>
               <h3><%=p.getProductTitle() %></h3>
             </li>
             <%} %>
         <%} %>
       </ul>
      </div>
      </div>
</body>
</html>