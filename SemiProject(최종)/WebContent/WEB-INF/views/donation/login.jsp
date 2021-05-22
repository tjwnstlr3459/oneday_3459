<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>project</title>
  <link rel="stylesheet" href="./css/main.css">
  <!--게시글 스트랩-->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

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
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
  <div class="layout-wrap">
    <!-- header -->
    <!-- header -->
    <!-- content -->
    <div class="content" style="margin-top: 20px;">
      <div class="container" style="margin-bottom: 100px; border-radius: 20px; background-color: rgba(189, 189, 189, 0.377); width: 400px; height: 330px; margin-top: 150px; padding-top: 20px;">
        <div><h2 style="text-align: center; font-weight: bold; ">로그인</h2></div>
        <hr>
        <div>
          <div>
          <form action="/loginCheck" method="post">
            <div class="tableLogin">
            <form action="/loginCheck" method="post">
              <div class="IdPw">
                <div>아이디 :</div>
                <div class="testInsert"><input type="text" name="id"></div>
              </div>
              <div class="IdPw">
                <div>비밀번호 :</div>
                <div class="testInsert"><input type="password" name="pw"></div>
              </div>
             </form>
             
              <hr>
              <div class="joinjoin">
                <div class="loginPageJoin" style="width: 160px; margin: 0 auto; height: 30px; margin-bottom: 2px; font-weight: bold;">
                	<input type="submit" value="로그인">
                </div>
                <div class="loginPageJoin" style="width: 160px; margin: 0 auto; height: 30px;">
                	<a href="/join">회원가입</a>
                </div>
              </div>
              <div class="idAndPw">
                <br>
                <br>
                <a href="#">아이디 찾기</a><a style="margin-left: 10px;" href="#">비밀번호 찾기</a>
              </div>
            </div>
            </form>
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
      <!-- footer -->
      
      <!-- footer -->
    </div>
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>

</html>