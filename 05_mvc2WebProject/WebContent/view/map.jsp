<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 지도 라이브러리 임포트 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- 강사님이 주신 지도 api -->																		<!-- 내키값 % 지오코드입력 -->
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=5phj586nrp&submodules=geocoder"></script>


</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div>
	<h3>1. 다음 주소찾기</h3>
       <div>
          <input type="text" id="postCode" class="short form-control" readonly>
          <button onclick="addrSearch();" class="btn btn-primary">주소검색</button>
       </div>
       <div>
          <input type="text" id="roadAddr" class="form-control" placeholder="도로명주소">
       </div>
       <div>
          <input type="text" id="jibunAddr" class="form-control" placeholder="지번주소">
       </div>
       <div>
          <input type="text" id="detailAddr" class="form-control" placeholder="상세주소">
       </div>
       <hr>
       <h3>2.네이버 지도 API</h3>
       <div id="map" style="width:100%; height:500px;"></div>
       
    </div>
	<script>
		//네이버지도 사용
		window.onload = function(){
			var map = new naver.maps.Map('map',{
				center : new naver.maps.LatLng(37.533807,126.896772),	//지도 중심
				zoom : 17,	//숫자만큼 확대
				zoomControl : true,	//확대/축소 스크롤 넣기
				zoomControlOptions : {	//우측상단에 + - 로 지도 확대축소 버튼 생성
					position : naver.maps.Position.TOP_RIGHT,
					style : naver.maps.ZoomControlStyle.SMALL
				}
			});
			var marker = new naver.maps.Marker({	//찾은 지도 표시마커
				position : new naver.maps.LatLng(37.533807,126.896772),
				map : map	//어느 지도에 쓸지(위에 변수map을 설정해둠)
			});
			var contentString = [
				'<div class="iw_inner">',
				'	<h3>KH정보교육원</h3>',
				'	<p>서울시 영등포구 선유동2로 57 이레빌딩 19f,20f</p>',
				'</div>'
			].join(""); //하나의 문자열로 만들어짐
			
			var infoWindow = new naver.maps.InfoWindow();	//지도 위에 글씨 입력하게
			naver.maps.Event.addListener(marker,"click",function(e){	//지도에 마커 클릭시 실행
				if(infoWindow.getMap()){ //현재 지도에 infoWindow가 있으면
					infoWindow.close();	//정보 닫아주고
				}else{	
					infoWindow = new naver.maps.InfoWindow({	
						content : contentString
					});
					infoWindow.open(map,marker);
				}
			});
			//지도에 임의위치클릭시 
			naver.maps.Event.addListener(map,"click",function(e){	//맵에 클릭이벤트 걸기
				marker.setPosition(e.coord);	//마커위치를 클릭한 위치로 이동
				if(infoWindow.getMap()){	//다른 곳 클릭했는데 기존위치의 마크정보가 열려있다면 
					infoWindow.close();	//마크정보 닫기
				}
				//reverseGeocoder를 이용해서 위/경도값을 주소로 변환
				naver.maps.Service.reverseGeocode({	//reversGeocode한테 두개의 값을저장 (객체,function)
					location : new naver.maps.LatLng(e.coord.lat(),e.coord.lng()),	//경도를 주소값으로 변환
				},function(status,response){
					if(status != naver.maps.Service.Status.OK){	//비정상적인 위경도일경우
						return alert("주소를 찾을수 없습니다.");
					}
					var result = response.result;	//마크위치정보의 결과값 변수에 저장
					items = result.items;	//items는 배열타입
					var address = items[1].address;
					contentString = [
						'<div class="iw_inner">',
						'<p>'+address+'</p>',
						'</div>'
					].join("");
				})
			});
		}
	
		function addrSearch(){
			new daum.Postcode({
				oncomplete : function(data){
					$("#postCode").val(data.zonecode);	//우편번호
					$("#roadAddr").val(data.roadAddress);//도로명주소
					$("#jibunAddr").val(data.jibunAddress);//지번주소
					$("#detailAddr").focus();	//상세주소로 마우스커서 이동
				}
			}).open();
		}
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>