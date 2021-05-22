<%@page import="product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Product p = (Product)request.getAttribute("p");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />

 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

<title>Insert title here</title>
<style>

h1, h2, h3, h4, h5, h6 {
    text-transform: uppercase;
    letter-spacing: 3px;
    font-weight : 600px
}
.btn1{
color: white;
}
.btn{
font-size : 0.765625rem;
}
.btn-info{
color:#fff;
background-color : #1f9bcf;
border-color : #1f9bcf;
}
.btn-info:hover{
color:#fff;
background-color : #1a82ae;
border-color : #1a82ae;
}
body, html{
background-color:white !important;
}
.content1 img{
width:100%;
}

</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<link rel="stylesheet" href="assets/css/main.css" />
	<div class="container">
			<div id="wrapper">
				<!-- Main -->
					<div id="main">
						<!-- Post -->
							<section class="post">
								<div class="major">
									<h1><%=p.getProductTitle() %></h1>
									<p><%=p.getProductInfoBr() %></p>
								</div>
								<div class="image main"><img src="/upload/product/<%=p.getFilepath()%>"></div>
								<p class="content1" style="font-size : 16pt"><%=p.getProductContent() %></p>
							</section>
					</div>

			</div>
			<div class="btnmenu">
				<%if(adm!=null){ %>
					<a class="btn btn-info btn1" href="/productUpdateFrm?productNo=<%=p.getProductNo()%>">수정하기</a>
					<%}%>
					<a class="btn btn-info btn1" href="/productList?reqPage=1">목록보기</a>
						<%if(adm!=null){ %>
					<a class="btn btn-info btn1" href="/productDelete?productNo=<%=p.getProductNo()%>">삭제하기</a>
					<%}%>
					</div>

	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>