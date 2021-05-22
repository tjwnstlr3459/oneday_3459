<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/main.css">
  <!--게시글 스트랩-->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  <!--슬릭-->
  <link rel="stylesheet" type="text/css" href="slick/slick/slick.css" />
  <link rel="stylesheet" type="text/css" href="slick/slick/slick-theme.css" />
  <script type="text/javascript" src="slick/slick/slick.js"></script>
  <link href="main.css" rel="stylesheet" type="text/css" />
  <script src="main.js" type="text/javascript"></script>

  <!--로그인 css-->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<style>
  div{
    border: 0px solid black;
  }
  .tableLogin>div>div{
    height: 100%;
  }
  .IdPw>div{
    float: left;
  }
  .tableLogin>div{
    width: 100%;
    height: 40px;
  }
  .tableLogin>div>div:nth-child(1){
    text-align: center;
    width: 80px;
    margin-left: 50px;
    line-height: 30px;
    font-weight: bold;
  }
  .testInsert{

    margin-top: 5px;
    height: 50%;
  }
  .joinjoin > div{
    line-height: 30px;
  }
  .tableLogin input {
    outline: none;
    border: lightgray;
    border-radius: 10px;;
  }
</style>
<script>
  $(function(){
      $("#modifyDonation").click(function(){
          $(".alertModal").css("display","flex");
      });

      $("#closeBtn").click(function(){
          $(".alertModal").hide();
      });
    })

    function selectEmail(ele) {
        var ele = $(".select").val();
        var email2 = $("input[name=email2]");
        email2.val(ele);
      } 
  
</script>
<body>
  <form action="/memberLogin" method="post">
  <div class="layout-wrap">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <!-- content -->
    <div class="content" style="margin-top: 20px;">
      <div class="container" style="margin-bottom: 100px; border-radius: 20px; background-color: rgba(189, 189, 189, 0.377); width: 400px; height: 330px; margin-top: 150px; padding-top: 20px;">
        <div><h2 style="text-align: center; font-weight: bold; ">로그인</h2></div>
        <hr>
        <div>
          <div>
            <div class="tableLogin">
            
              <div class="IdPw">
                <div>아이디 :</div>
                <div class="testInsert"><input type="text" name="id"></div>
              </div>
              <div class="IdPw">
                <div>비밀번호 :</div>
                <div class="testInsert"><input type="password" name="pw"></div>
              </div>
              <hr>
              <div class="joinjoin">
                <div class="loginPageJoin" style="width: 160px; margin: 0 auto; height: 30px; margin-bottom: 2px; font-weight: bold; background-color: skyblue;"><input type="submit" style="text-decoration: none; background-color: skyblue; line-height: 25px;" value="로그인"></div>
                
                
                
              </div>
              <div class="idAndPw">
                <br>
                <br>
                <a href="#">아이디 찾기</a><a style="margin-left: 10px;" href="#">비밀번호 찾기</a>
              </div>
              
            </div>
          </div>
        </div>
          <style>
            .loginPageJoin{
              border: 1px solid lightgrey;
              border-radius: 10px;
              text-align: center;
              width: 100%;
            }
            .loginPageJoin > *{
              text-decoration: none;
              font-weight: bold;
            }
            .idAndPw{
              font-size: 11px;
              margin-left: 120px;
            }
            .loginPageJoin :hover div{
            }
          </style>
      </div><!--container-->
      <%@include file="/WEB-INF/views/common/footer.jsp" %>
      
    </div>
  </form>
</body>

</html>