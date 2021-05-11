<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 결제 스크립트 -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="containver">
		<h3>결제모듈</h3>
		<hr>
		<div class="shopping">
			<div>
				<img id="goods" src="/img/mintchoco.jpg">
			</div>
			<div>
				<h4>민트초코</h4>
				<div class="star">
					<img src="/img/star-on.png">
					<img src="/img/star-on.png">
					<img src="/img/star-on.png">
					<img src="/img/star-on.png">
					<img src="/img/star-off.png">
					<div>4.0</div>
				</div>
				<hr>
				<div class="price">
					<span>2000</span>원
					<span>(1개당 가격)</span>
				</div>
				<div class="count">
					<span>수량</span>
					<button class="btn btn-secondary btn-sm">-</button>
					<span class="amount">1</span>
					<button class="btn btn-secondary btn-sm">+</button>
				</div>
				<div class="total">
					총
					<span id="totalPrice">2000</span>원
				</div>
				<button id="payment" class="btn btn-outline-danger btn-block">결제하기</button>
			</div>
		</div>
	</div>
	<script>
		$(".count>button").click(function(){	//수량 + - 클릭시 (span.html과 가격이 바껴야함)
			var currAmount = Number($(".amount").html());//span태그 사이값
			if($(this).html() =='+'){
				$(".amount").html(currAmount+1);
			}else{
				if(currAmount != 1){	//1이하를 제외하곤 -가능
				$(".amount").html(currAmount-1);
				}
			}
			currAmount = Number($(".amount").html());
			var price = Number($(".price>span").first().html());
			$("#totalPrice").html(currAmount*price);
		});
		$("#payment").click(function(){
			var price = $("#totalPrice").html();
			var d = new Date();	//결제고유번호의 날짜를 위해 날짜생성
			//날짜 넣기 (+""+를 안하면 숫자가 합해지기에 공백 넣는다)
			var date = d.getFullYear()+""+(d.getMonth()+1)+""+d.getDate()+""+d.getHours()+""+d.getMinutes()+""+d.getSeconds();
			
			//스크립트 임포트해서 IMP사용 가능
			IMP.init('imp62610614');	//결제 api 사용을 위한 코드입력
			IMP.request_pay({
				merchant_uid : "상품명_"+date,			//거래ID
				name : "결제 테스트",						//결제 이름
				amount : price,							//결제금액
				buyer_email : "tjwnstlr3459@naver.com",	//구매자 email주소
				buyer_name : "서준식",					//구매자 이름
				buyer_phone : "010-2874-7801",			//구매자 전화번호
				buyer_addr : "서울시 양천구 신월동",			//구매자 주소
				buyer_postcode : "07902"				//구매자 우편번호
			}, function(rsp){	// rsp : 결제 성공여부
				if(rsp.success){
					//결제 성공시 DB에 결제정보 저장하고 사용자 화면 처리
					alert("결제 성공");
					console.log("카드 승인번호 : "+rsp.apply_num);//카드 승인번호 출력
				}else{
					alert("결제 실패");
				}
			});
		})
</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>





















