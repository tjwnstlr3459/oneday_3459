<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>project</title>
    <link rel="stylesheet" href="./css/main.css" />
    <!--게시글 스트랩-->
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  

    <!--로그인 css-->
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  </head>
  <style>
    div {
      border: 0px solid black;
    }
    .tableLogin > div > div {
      height: 100%;
    }
    .JoinInsert > div {
      float: left;
    }
    .tableLogin > div {
      width: 100%;
      height: 40px;
    }
    .tableLogin > div > div:nth-child(1) {
      text-align: center;
      width: 20%;
      margin-left: 120px;
      line-height: 30px;
      font-weight: bold;
    }
    .testInsert {
      margin-top: 5px;
      height: 50%;
    }
    .joinjoin > div {
      line-height: 30px;
    }
    .tableLogin input {
      outline: none;
      border: lightgray;
      border-radius: 5px;
    }
  </style>
  <script>
    $(function () {
      $("#modifyDonation").click(function () {
        $(".alertModal").css("display", "flex");
      });

      $("#closeBtn").click(function () {
        $(".alertModal").hide();
      });
    });

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
      <div class="content" style="margin-top: 20px">
        <div
          class="container"
          style="
            margin-bottom: 100px;
            border-radius: 20px;
            background-color: rgba(189, 189, 189, 0.377);
            width: 600px;
            height: 500px;
            margin-top: 150px;
            padding-top: 20px;
          "
        >
          <div>
            <h2 style="text-align: center; font-weight: bold">회원가입</h2>
          </div>
          <hr />
          <div>
            <div>
            <form action="/joinInsert" method="post">
              <div class="tableLogin">
                <div class="JoinInsert">
                  <div>아이디 :</div>
                  <div class="testInsert">
                    <input type="text" placeholder="영문+숫자 6자리이상" name="id"/>
                  </div>
                  <input type="button" class="idCheckBtn"  style="border-radius: 5px; margin-left: 5px; margin-top: 3px;" value="중복검사"></input>
                </div>
                <div class="JoinInsert">
                  <div>비밀번호 :</div>
                  <div class="testInsert">
                    <input type="password" placeholder="숫자 4자리 이상"  name="pw"/>
                  </div>
                </div>
                <div class="JoinInsert">
                  <div>비밀번호 확인 :</div>
                  <div class="testInsert"><input type="password" name="pwRe" /></div>
                </div>
                <div class="JoinInsert">
                  <div>이름 :</div>
                  <div class="testInsert"><input type="text" name="name" /></div>
                </div>
                <div class="JoinInsert">
                  <div>이메일 :</div>
                  <div class="testInsert"><input type="email" name="email" /></div>
                </div>
                <div class="JoinInsert">
                  <div>전화번호 :</div>
                  <div class="testInsert">
                    <input type="text" placeholder=" - 빼고 숫자만 입력" name="phone" />
                  </div>
                </div>
                <div class="JoinInsert">
                  <div>주소 :</div>
                  <div class="testInsert"><input type="text" name="addr" /></div>
                </div>
                <div>
                  <input class="joinBtnBtn" type="submit" value="가입하기" />
                </div>
              </div>
              </form>
            </div>
          </div>
        </div>
        
        <style>
          .loginPageJoin {
            border: 1px solid lightgrey;
            border-radius: 10px;
            text-align: center;
            width: 100%;
          }
          .loginPageJoin > * {
            text-decoration: none;
            font-weight: bold;
          }
          .idAndPw {
            font-size: 11px;
            margin-left: 120px;
          }
          .loginPageJoin :hover div {
          }
          .joinBtnBtn {
            width: 30%;
            height: 35px;
            border: 1px solid black;
            background-color: rgb(69, 161, 247);
            margin-left: 210px;
            margin-top: 20px;
            font-weight: bold;
            font-size: 18px;
            line-height: 10px;
          }
          .joinBtnBtn:hover {
            background-color: rgba(0, 183, 255, 0.959);
            color: white;
          }

          .idCheckBtn {
            font-weight: bold;
            background-color: lightgrey;
          }
          .idCheckBtn :hover {
            background-color: rgba(0, 183, 255, 0.959);
            color: white;
          }
        </style>
      </div>
      <!--container-->
      <!-- footer -->
      
      <!-- footer -->
    </div>
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
  </body>
</html>
