<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
        /*몸통*/
        .sw-line1{
            border-top: 5px solid rgb(224, 224, 224);
            width: 100%;
        }
        .sw-boxB{
            width: 600px;
            height: 600px;
            margin: 0 auto;
            padding: 20px;
        }
        .sw-textBox{
            width: 500px;
            height: 500px;
            
            margin: 0 auto;
            padding: 10px;
        }
        img{
            width: 500px;
            height: 300px;
        }
        .sw-text1{
            font-size: 33px;
            text-align: center;
            color : green;
            font-weight: bolder;
        }
        .sw-text2{
            text-align: center;
            font-size: 20px;
        }
        .sw-boxC{
            margin: 0 auto;
            width: 250px;
            height: 50px;
            text-align: center;
            background-color: rgb(52, 152, 219);
            border-radius: 10px;
        }
        .sw-goLogin{
            font-size: 17px;
            font-weight: bolder;
            color: white;
            line-height: 50px;
            text-decoration: none;
        }
    </style>
</head>
<body>

    <!--body-->
    <form>
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <div class="sw-line1">
        <div class="sw-boxB">
            <div class="sw-textBox"><br><br><br>
                <img src="/img/check.png" style="align:center">
                <p class="sw-text1">해피 흠에 오신것을 환영합니다!</p>
                <p class="sw-text2">더욱 더 많은 것을 찾아보세요!</p>
            </div>
            <div class="sw-boxC">
                <!--로그인 페이지로 하이퍼 링크-->
                <a class="sw-goLogin" href="/" >로그인페이지로 이동</a>
            </div>
        </div>
    <br><br>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    </form>
    
</body>
</html>