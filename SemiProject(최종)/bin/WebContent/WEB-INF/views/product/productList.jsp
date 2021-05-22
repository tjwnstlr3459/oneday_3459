<%@page import="product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
    String pageNavi = (String)request.getAttribute("pageNavi");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="/css/product/product1.css" rel="stylesheet" type="text/css">
<style>

.dropdown {
    border-radius: 3px;
    border: 1px solid #e5e5e5;
    background-color: rgba(255,255,255,0.98);
    display: none;
    min-width: 160px;
    max-height: 650px;
    overflow-y: auto;
    opacity: 0;
    position: absolute;
    z-index: 999;
    will-change: width, height;
}
.dropdown li{
    clear: both;
    color: rgba(0, 0, 0, 0.87);
    cursor: pointer;
    min-height: 36px;
    width: 100%;
    text-align: left;
    text-transform: none;
}


</style>
 

</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>

	<div class="container">
		<div class="menuinfo">
			<div class="titleinfo">
       			<h5 class="h5">후원상품정보 </h5>
       			<p class="p1">후원 상품 정보를 소개하는 공간 입니다.</p>
			</div>
		</div>
		<div class = "menubtn">
			<a class="btn btn-info btn2"  href="#" >분류</a>
				<ul class="dropdown">
					<li><a href="#">전체</a></li>
					<li><a href="#">이웃</a></li>
					<li><a href="#">동물</a></li>
					<li><a href="#">자연</a></li>
					<li><a href="#">기타</a></li>
				</ul>
			<a class="btn btn-info btn1"  href="/productWriteFrm" >글쓰기</a>
			<a class="btn btn-info btn1"  href="/productList?reqPage=1" >목록보기</a>
		</div>
	<div class="row">
			<% for(Product p : list) {%>
        <div class="col-md-4 col-sm-6">
            <div class="product-grid9">
                <div class="product-image9">
                    <a href="/productView?productNo=<%=p.getProductNo()%>">
                        <img class="pic-1" src="/upload/product/<%=p.getFilepath()%>">
                    </a>
                </div>
                <div class="product-content">
                    <h3 class="title">후원처 : <%=p.getProductSpons() %> </h3>
                    <div class="price"> <%=p.getProductTitle() %> </div>
                    <a class="add-to-cart" href="">제품 정보 보기</a> 
                </div> <br>
            </div>
        </div>  
			<%} %>
       </div> 
    	
		<div id ="pageNavi"><%=pageNavi %></div>
		<br>
	</div>
	
	<%@include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>