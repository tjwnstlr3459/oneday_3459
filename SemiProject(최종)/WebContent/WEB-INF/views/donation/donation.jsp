<%@page import="donation.login.Member"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="/css/donation1.css">
	<link rel="stylesheet" href="/css/donation2.css">
	<link rel="stylesheet" href="/css/donation3.css">

  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>project</title>
    <link rel="stylesheet" href="./css/main.css" />
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>

    <!-- slick -->
    <link rel="stylesheet" type="text/css" href="/slick/slick/slick.css" />
    <link rel="stylesheet" type="text/css" href="/slick/slick/slick-theme.css" />
    <script type="text/javascript" src="/slick/slick/slick.js"></script>
    <link href="/css/donation1.css" rel="stylesheet" type="text/css" />
    <script src="/slick/main.js" type="text/javascript"></script>

	<!-- 결제 스크립트 -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    <!--나눔고딕체-->
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap"rel="stylesheet"/>

    <!--css-->
    <link href="/css/donation1.css" rel="stylesheet" type="text/css" />
    <link href="/css/donation2.css" rel="stylesheet" type="text/css" />
    <link href="/css/donation3.css" rel="stylesheet" type="text/css" />
    <style>
    	 .header-wrap>.nav>li>a{
		  	font-weight: bold;
		  }
		  
    </style>
  </head>

  <body>
  
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
      <div class="layout-wrap">
      <!-- header -->
	
      <!-- content -->
      <div class="content" style="width: 1100px; margin: 0 auto">
        <div class="con1" style="overflow: hidden">
          <div id="slider-div">
            <div><img src="mini_img/16.jpg" class="slideImg" /></div>
            <div><img src="mini_img/9.jpg" class="slideImg" /></div>
            <div><img src="mini_img/10.jpg" class="slideImg" /></div>
            <div><img src="mini_img/8.jpg" class="slideImg" /></div>
            <div><img src="mini_img/5.jpg" class="slideImg" /></div>
            <div><img src="mini_img/11.jpg" class="slideImg" /></div>
          </div>
        </div>

        <div class="con2">
          <div class="con2_img">
            <img src="mini_img/33.jpg" style="width: 90%" />
          </div>
          <div class="con2_text">
            <p style="font-size: 20px; font-weight: bold">
              모든 어린이는 보호받을 권리가 있습니다.
            </p>
            <hr style="width: 100%; ">
            <pre style="font-size: 13px; font-family: 'Nanum Gothic', sans-serif; line-height: 25px;">
어린이는 보호와 지원을 받아야 하지만 세상의 많은 
어린이들은 전쟁과 기아, 폭력,질병 등으로 고통받고 있습니다.
어린이들의 생명을 구하고 삶을 개선하기 위해 해피흠은 
2차 세계대전 직후인 1946년부터 전 세계에서 어린이들을 돕는 
활동을 펼치고 있습니다. 현재 해피흠은 약 190개 국가 및 
영토에서 활동하고 있으며 157개 개발도상국에서 어린이들의 
생명을 구하고, 어린이의 삶을 개선하기 위한 다양한 
사업을 펼치고 있습니다.
          </pre>
          </div>
        </div>

        <div class="donation_pan">
          <div class="dona_navi">
            <div class="dona_naviCon1">STEP1<br />후원방법 선택</div>
            <div class="dona_naviCon2">STEP2<br />후원자 정보 입력</div>
            <div class="dona_naviCon3">STEP3<br />후원금 납입</div>
            <div class="dona_naviCon4">STEP4<br />후원 완료</div>
          </div>


          <form action="/donationListInsert" method="post">
          <div class="dona_kind">
            <p class="ment1">후원 방법을 선택해주세요</p>
            <hr width="95%">
            <div class="kind1" style="margin-left: 160px;">
              <input type="radio" id ="kind1"class="radi" name=kind value="정기후원">
              <label for="kind1"><p style="font-size: 20px; margin-top: 10px">정기후원하기</p><p style="font-size:13px">매월 약정된 금액을 후원하여 구호<br>활동에 참여하실수있습니다</p></label></div>
            <div class="kind2">
              <input type="radio" id ="kind2"class="radi" name=kind value="일시후원">
              <label for="kind2"><p style="font-size: 20px; margin-top: 10px">일시후원하기</p><p style="font-size:13px">일시적으로 금액을 후원하여 구호<br>활동에 참여하실수있습니다</p></label></div>
          </div>
          
          <div class="dona_radio">
            <P class="ment1" style="width: 90%;">후원 종류 선택하기</P>
            <hr width="95%" style="margin-left: 30px;">
            <div class="dona_radio_con1">
              <input type="radio" id ="kind3"class="radi" name=kind1 value="세계어린이 돕기">
              <label for="kind3"><div>세계 어린이 돕기</div> 전세계 도움이 필요한 어린이들의 생존과 인권을 위한 유니세프의 구호 활동에 후원금이 사용됩니다.</label>
            </div>
            <div class="dona_radio_con2">
              <input type="radio" id ="kind4"class="radi" name=kind1 value="지구변화 돕기">
              <label for="kind4"><div>지구 변화 돕기</div> 전쟁,환경오염,기후변화 인간에 의한 지구 환경변화를 생각한 구호 활동에 후원금이 사용됩니다.</label>
            </div>
            <div class="dona_radio_con3">
              <input type="radio" id ="kind5"class="radi" name=kind1 value="나의 이웃돕기">
              <label for="kind5"><div>나의 이웃 돕기</div> 인기척없이 힘들고, 고통받고 있을수있는 나의 이웃을 보살피는 구호활동에 후원금이 사용됩니다.</label>
            </div>
            <div class="dona_btn" style="height: 60px; border: none;">
              <div style="margin-left: 310px;"><a href ="/" style="margin-left:10px;">메인으로</a></div>
              <div onclick="func1()">다음</div>
            </div>
          </div>

          <!--화면2-->
          <div class="con4" style="display: none">
            <div class="con4_pan">
              <div class="con4_1">
                <p class="ment1" style="margin-bottom: 10px">
                  후원인 정보를 입력해주세요
                </p>
                <hr width="95%">
                <div class="info">
                  <div>후원인 구분</div>
                  <div>
                    <input type="radio" id="dona_sor1" name="dona_sor" value="개인" /><label for="dona_sor1">개인</label>
                    <input type="radio" id="dona_sor2" name="dona_sor" value="법인" /><label for="dona_sor2">법인</label>
                    <input type="radio" id="dona_sor3" name="dona_sor" value="학교 및 단체" /><label for="dona_sor3">학교 및 단체</label>
                  </div>
                </div>

                <div class="info">
                  <div>후원인 이름</div>
                  <div>
                    <input type="text" name="name" style="width: 300px; font-size: 14px;" value=<%=m.getMemberName()%>>
                  </div>
                </div>
                <div class="info">
                  <div>전화번호</div>
                  <div>
                    <input type="text" name="phone" style="width: 300px; font-size: 14px;" value=<%=m.getMemberPhone() %>>
                  </div>
                </div>
                <div class="info" style="margin-bottom: 30px;">
                  <div>이메일</div>
                  <div>
                  	<%String str =  m.getMemberEmail(); %>
                  	<%String email1 = str.substring(0,str.indexOf("@")); %>
                  	<%String email2 = str.substring(str.lastIndexOf("@")+1); %>
                    <input type="text" name="email" style=" font-size: 14px;" value=<%=email1 %> /> @
                    <input type="text" name="email2" style=" font-size: 14px;" value=<%=email2 %> />
                    <select
                      class="select"
                      style="width: 120px; height: 20px; outline: none; font-size:13px;"
                      
                      onChange="selectEmail(this)"
                    >
                      <option value="">직접입력</option>
                      <option value="naver.com">naver.com</option>
                      <option value="hanmail.net">hanmail.net</option>
                      <option value="yahoo.co.kr">yahoo.co.kr</option>
                      <option value="gmail.com">gmail.com</option>
                    </select>
                  </div>
                </div>
                <div class="info_content">
                  <p class="ment1" style="margin-bottom: 10px">
                    후원동기 및 한마디
                  </p>
                  <hr width="95%">
                  <div class="info">
                    <div>제목</div>
                    <div>
                      <input type="text" name="title" style=" font-size: 14px;" placeholder="제목을 입력해주세요" />
                    </div>
                  </div>
                  <div class="info_con">
                    <div>내용</div>
                    <div style="margin-left: 30px">
                      <textarea name="concon" style="width: 600px; height: 80px; outline: none; font-size: 14px;" placeholder="전하고싶은 말을 적어주세요!"></textarea>
                    </div>
                  </div>
                </div>
              </div>
              <div class="con4_2">
                <p class="ment1" style="margin-top:20px; width:100%; margin-bottom: 20px">
                  약관 및 개인정보 수집 - 이용동의
                  <input type="checkbox" id="allCheck" style="margin-left: 470px;"><label for="allCheck">이용약관 전체동의</label>
                </p>
                <div class="agree">
                  <input type="checkbox" id="check1" name="agree"/>
                  <p class="agree1">[+] 후원 약관 동의[필수]</p>
                </div>
                <div id="toggle1">
                  <div style="overflow-x: scroll; font-size:12px; width: 100%; height: 100px; text-align: left; background: white;">
                    [ 해피흠 이용 약관 ]<br>
제1장 총칙<br>

제 1 조 (목적)<br>
이 약관은 해피흠 주식회사(이하 “회사”)가 운영하는 후원에서 제공하는 서비스와 이를 이용하는 회원의 권리·의무 및 책임사항을 규정함을 목적으로 합니다.<br>

제 2 조 (용어의 정의)<br>
이 약관에서 사용하는 용어의 정의는 다음과 같습니다. 그리고 여기에서 정의되지 않은 이 약관상의 용어의 의미는 일반적인 거래관행에 따릅니다.<br>
1. “사이버몰”이란 회사가 상품 또는 용역 등(일정한 시설을 이용하거나 용역을 제공받을 수 있는 권리를 포함하며, 이하 “상품 등”)을 회원에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 상품 등을 거래할 수 있도록 설정한 가상의 영업장(http://www.coupang.com 등 회사가 운영하는 웹사이트 및 모바일 웹, 앱 등을 모두 포함)을 의미합니다.<br>
2. “회원”이라 함은 사이버몰에 회원등록을 한 자로서, 계속적으로 사이버몰에서 제공하는 서비스를 이용할 수 있는 자를 말합니다.<br>
3. “아이디(ID)”라 함은 회원의 식별과 서비스 이용을 위하여 회원이 설정하고 회사가 승인하여 등록된 전자우편주소를 말합니다.<br>
4. “비밀번호(Password)”라 함은 회원의 동일성 확인과 회원의 권익 및 비밀보호를 위하여 회원 스스로가 설정하여 사이버몰에 등록한 문자와 숫자 등의 조합을 말합니다.<br>
5. “마켓플레이스 서비스(MarketPlace Service)”라 함은 회사가 사이버몰을 통하여 제공하는 통신판매중개 서비스 및 관련 부가서비스 일체를 말합니다.<br>
                  </div>
                </div>
                <div class="agree">
                  <input type="checkbox" id="check2"/>
                  <p class="agree2">[+] 개인정보 수집-이용동의[선택]</p>
                </div>
                <div id="toggle2">
                  <div style="overflow-x: scroll; font-size:12px;  width: 100%; height: 100px; text-align: left; background: white;">
                    [ 해피흠 이용 약관 ]<br>
제1장 총칙<br>

제 1 조 (목적)<br>
이 약관은 해피흠 주식회사(이하 “회사”)가 운영하는 후원에서 제공하는 서비스와 이를 이용하는 회원의 권리·의무 및 책임사항을 규정함을 목적으로 합니다.<br>

제 2 조 (용어의 정의)<br>
이 약관에서 사용하는 용어의 정의는 다음과 같습니다. 그리고 여기에서 정의되지 않은 이 약관상의 용어의 의미는 일반적인 거래관행에 따릅니다.<br>
1. “사이버몰”이란 회사가 상품 또는 용역 등(일정한 시설을 이용하거나 용역을 제공받을 수 있는 권리를 포함하며, 이하 “상품 등”)을 회원에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 상품 등을 거래할 수 있도록 설정한 가상의 영업장(http://www.coupang.com 등 회사가 운영하는 웹사이트 및 모바일 웹, 앱 등을 모두 포함)을 의미합니다.<br>
2. “회원”이라 함은 사이버몰에 회원등록을 한 자로서, 계속적으로 사이버몰에서 제공하는 서비스를 이용할 수 있는 자를 말합니다.<br>
3. “아이디(ID)”라 함은 회원의 식별과 서비스 이용을 위하여 회원이 설정하고 회사가 승인하여 등록된 전자우편주소를 말합니다.<br>
4. “비밀번호(Password)”라 함은 회원의 동일성 확인과 회원의 권익 및 비밀보호를 위하여 회원 스스로가 설정하여 사이버몰에 등록한 문자와 숫자 등의 조합을 말합니다.<br>
5. “마켓플레이스 서비스(MarketPlace Service)”라 함은 회사가 사이버몰을 통하여 제공하는 통신판매중개 서비스 및 관련 부가서비스 일체를 말합니다.<br>
                  </div>
                </div>
              </div>
              <div class="dona_btn" style="margin-top: 20px;">
                <div style="margin-left: 310px"><a href ="/">메인으로</a></div>
                <div onclick="func2()">다음</div>
              </div>
            </div>
          </div>
          <!--화면3-->
          
          <div class="con5" style="display: none;">
            <div class="con5_1">
              <p class="ment1" style="padding-top: 40px;">후원 금액을 선택해주세요.</p>
            </div>
            <hr width="95%">

            <div class="con5_1">
              <input type="radio" id="100000" name="price_choice" value="100000"/><label for="100000">100,000원</label>
              <input type="radio" id="200000" name="price_choice" value="200000"/><label for="200000"> 200,000원</label>
              <input type="radio" id="500000" name="price_choice" value="500000"/><label for="500000">500,000원</label>
              <input type="radio" id="1000000" name="price_choice" value="1000000"/><label for="1000000">1,000,000원</label>
              <input type="radio" id="gitar" name="price_choice" value="" />
              <label for="gitar">기타<input type="text" class="realPrice" onchange ="selectMoney(this)" name="price_choice" value="" placeholder="직접입력" style=" font-size:13px; margin-top: 20px; margin-left: 10px; width: 100px;"/>원</label>
            </div>

            <div class="con5_1" style="padding-top: 10px;">
              <p class="ment1" style="padding-top: 40px;">후원 정보 추가 확인</p>
              
            </div>
            <hr width="95%">

            <div class="con5_1" >
              <p class="ment1" style="float: left; padding-top: 30px;">후원자님의 비밀번호를 입력해주세요.</p>
              <input style="float: left; margin-top: 25px; margin-left: 30px; width: 200px;" type="password" class="passRe" name="passRe">
              <button id="pass_check" class="passCheck" style="font-size:14px; float: left; margin-top: 25px; margin-left: 10px; width: 50px;" onclick="func22()" type="button" value="확인">확인</button>
            </div>
            <div class="con5_1">
              <p style="font-weight: bold; text-align: center; color: orangered;">
                후원자님의 후원내역은 후원게시판에 작성되며, 후원자님의 선택하에 후원동기를 수정 및 삭제 가능합니다.<br>
                약정하신 금액이 인출이 되지 않거나, 후원금이 전달되지 않는경우, 1회에 한해 다음결제일에 재출금이 진행됩니다.
              </p>
            </div>
            <div class="dona_btn">
              <div style="margin-left: 310px"><a href ="/">메인으로</a></div>
              
              
              <div id="payment">결제하기</div>
            </div>
          </div>
          <div class="con6" style="display: none;">
            <div class="con6_1">
              <p style="margin-top: 20px;">후원과정이 완료되었습니다.</p>
            </div>
            <hr width="95%" style="margin-bottom: 30px;">
            <div class="con6_2" style="margin-bottom: 20px;">
              <div class="con6_2_1">
                <p>후원자님의 마음에 감사드립니다.</p>
                <p>후원자님의 소중한 마음이 우리 주변 이웃들에게 큰 힘이 되어 아이들에게 꿈과 희망을 줍니다<br>
                  어린이에게는 밝은 미래를 열수있는 희망을,<br>
                  노인에게는 사람들의 따뜻함을,<br>
                  나 자신에게는 베풀수 있다는 자신감을,<br>
                  우리는 하나라는걸 배우게됩니다.
                </p>
              </div>
              
              <div class="con6_2_2" >
                <img src="/mini_img/56.jpg" style="height: 100%;">
              </div>
            </div>
            <p class="ment6">후원게시판을 클릭하시면 후원게시물이 등록됩니다.<br>등록 후 후원게시판으로 이동합니다.</p>
            
            <div class="dona_btn">
              <div style="margin-left: 340px; width: 180px; background-color: orange;">
              <button style="margin-top: 5px; font-weight: bold;" type="submit" class="formDonaList" value="후원게시판">후원게시판</button></div>
            </div>
          </form>
          </div>
        </div>

        <!--pan -->

      <script>
        function selectEmail(ele) {
          var ele = $(".select").val();
          var email2 = $("input[name=email2]");
          email2.val(ele);
        }
        
      	 function selectMoney(money){
        	var money = $(".realPrice").val();
        	$("#gitar").val(money);
        }
        
        function func1() {
        	var kind = $("input[name=kind]").is(":checked");
        	var kind1 = $("input[name=kind1]").is(":checked");
          if(kind && kind1){	
	          $(".dona_kind").css("display", "none");
	          $(".dona_radio").css("display", "none");
	          $(".con4").css("display", "block");
	          $(".dona_naviCon1").css("background-color", "rgba(211, 211, 211, 0.535)");
	          $(".dona_naviCon2").css( "background-color","rgba(135, 207, 235, 0.645)");
	          $(".con2_img > img").attr("src","mini_img/54.jpg");
          }else{
        	  alert("후원을 선택해주세요");
          }
        }
        function func2() {
        	var donaSor = $("input[name=dona_sor]").is(":checked");
        	var title = $("input[name=title]").val();
        	var concon = $("textarea[name=concon]").val();
        	var agree = $("input[name=agree]").is(":checked");
        	
        	if(donaSor){
        		if(title !="" && concon != ""){
        			if(agree){
        				$(".con4").css("display", "none");
       		          $(".con5").css("display", "block");
       		          $(".dona_naviCon2").css("background-color", "rgba(211, 211, 211, 0.535)");
       		          $(".dona_naviCon3").css("background-color", "rgba(135, 207, 235, 0.645)");
       		          $(".con2_img > img").attr("src","mini_img/51.jpg");
        			}else{
        				alert("약관에 동의해 주세요");
        			}
        		}else{
        			alert("제목과 내용을 입력해주세요");
        		}
        	}else{
        		alert("후원구분을 선택해주세요");
        	}
        }
        function func3() {
        	var priceChoice = $("input[name=price_choice]").is(":checked");
        	var passRe = $("input[name=passRe]").val();
        	if(priceChoice){
        		if(passRe=='<%=m.getMemberPw()%>'){
        			$(".con5").css("display", "none");
        	          $(".con6").css("display", "block");
        	          $(".dona_naviCon3").css("background-color", "rgba(211, 211, 211, 0.535)");
        	          $(".dona_naviCon4").css("background-color", "rgba(135, 207, 235, 0.645)");
        	          $(".con2_img > img").attr("src","mini_img/53.jpg");
        		}else{
        			alert("회원님의 비밀번호를 확인해주세요");
        		}
        	}else{
        		alert("후원금액을 선택해주세요");
        	}
        }

        function func22(){
        	var pass = $(".passRe").val();
        	if(pass == '<%=m.getMemberPw()%>' ){
        		alert("회원님의 비밀번호가 일치합니다!!!!");
        		$(".passCheck").val("일치");
        	}else{
        		alert("비밀번호가 일치하지 않습니다.");
        		$(".passCheck").val("틀림");
        	}
        }

        $(function () {
          //약관내용
          $(".agree1").click(function () {
            $("#toggle1").slideToggle(200);
          });
          $(".agree2").click(function () {
            $("#toggle2").slideToggle(200);
          });
          //전체동의
          $("#allCheck").click(function(){
            if($("#allCheck").prop("checked")){
              $("input[type=checkbox]").prop("checked",true);
            }else{
              $("input[type=checkbox]").prop("checked",false);
            }
          });
          

        });
        $("#payment").click(function(){
        	var passRe = $(".passCheck").val();
        	console.log(passRe);
			var price = $("input[name=price_choice]:checked").val();
			
			if($(".passCheck").val()=="일치"){
			var d = new Date();	//결제고유번호의 날짜를 위해 날짜생성
			//날짜 넣기 (+""+를 안하면 숫자가 합해지기에 공백 넣는다)
			var date = d.getFullYear()+""+(d.getMonth()+1)+""+d.getDate()+""+d.getHours()+""+d.getMinutes()+""+d.getSeconds();
			
			//스크립트 임포트해서 IMP사용 가능
			IMP.init('imp62610614');	//결제 api 사용을 위한 코드입력
			IMP.request_pay({
				merchant_uid : "후원_"+date,			//거래ID
				name : "후원 결제",							//결제 이름
				amount : price,							//결제금액
				
				buyer_email : '<%=m.getMemberEmail()%>',	//구매자 email주소
				buyer_name : '<%=m.getMemberName()%>',	//구매자 이름
				buyer_phone : '<%=m.getMemberPhone()%>',	//구매자 전화번호
				buyer_addr : '<%=m.getMemberAddr()%>',	//구매자 주소
				buyer_postcode : "07902"				//구매자 우편번호
			}, function(rsp){	// rsp : 결제 성공여부
				if(rsp.success){
					//결제 성공시 DB에 결제정보 저장하고 사용자 화면 처리
					alert("결제 성공");
					console.log("카드 승인번호 : "+rsp.apply_num);//카드 승인번호 출력
					
					var priceChoice = $("input[name=price_choice]").is(":checked");
		        	var passRe = $("input[name=passRe]").val();
		        	if(priceChoice){
		        		if(passRe=='<%=m.getMemberPw()%>'){
		        			$(".con5").css("display", "none");
		        	          $(".con6").css("display", "block");
		        	          $(".dona_naviCon3").css("background-color", "rgba(211, 211, 211, 0.535)");
		        	          $(".dona_naviCon4").css("background-color", "rgba(135, 207, 235, 0.645)");
		        	          $(".con2_img > img").attr("src","mini_img/53.jpg");
		        		}else{
		        			alert("회원님의 비밀번호를 확인해주세요");
		        		}
		        	}else{
		        		alert("후원금액을 선택해주세요");
		        	}
					
				}else{
					alert("결제 실패");
				}
			});
			}else{
				alert("비밀번호를 확인해주세요!");
			}
		});


        
      </script>

    </div>
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    
  </body>
</html>
    