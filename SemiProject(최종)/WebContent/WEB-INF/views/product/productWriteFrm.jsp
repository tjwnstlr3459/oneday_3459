<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


<script src="/resources/library/summernote/summernote-lite.js"></script>
<script src="/resources/library/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/resources/library/summernote/summernote-lite.css">
<style>



.selectform{
	float : left;
    width: 110px;
    height: calc(1.5em + 1.5rem);
    padding: 0.75rem 1.5rem;
    font-size: 0.875rem;
    font-weight: 400;
    line-height: 1.5;
    color: #55595c;
    background-color: #f7f7f9;
    background-clip: padding-box;
    border: 0 solid #ced4da;
    border-radius: 0;
    margin-top : 10px;
    margin-bottom : 10px;
}
.titleform{
	float : left;
    width: 90%;
    height: calc(1.5em + 1.5rem);
    padding: 0.75rem 1.5rem;
    font-size: 0.875rem;
    font-weight: 400;
    line-height: 1.5;
    color: #55595c;
    background-color: #f7f7f9;
    background-clip: padding-box;
    border: 0 solid #ced4da;
    border-radius: 0;
    margin-top : 10px;
    margin-bottom : 10px;
}
.btn{
	float:right;
	margin : 10px;
	color : white;
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
</style>
</head>
<body>	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
	<form action="/productWrite" method="post" enctype="multipart/form-data">
	
		<div class="form-group">
				<select class="selectform" name="spons">
					<option selected disabled>-분류-</option>
					<option value="결식아동">결식아동</option>
					<option value="유기동물">유기동물</option>
					<option value="자연">자연</option>
					<option value="기타">기타</option>
				</select>
			<input type="text" class="titleform" placeholder="제목" id="title" name="title" required>
		</div>
		<div class="form-group">
		<div class="selectform">메인사진</div>
			<input type="file" class="titleform" name="filename" >
		</div>
		
	<div class="form-group">
			<textarea class="form-control" name="info" placeholder="간략정보" required></textarea>
		</div>
	
		<div class="form-group">
			<label for="content"></label>
			<textarea id="summernote" class="form-control" rows="5" id="content" name="content" required></textarea>
		</div>
	
		<button type="submit" class="btn btn-info btn1" id="write">글쓰기 등록</button>
	</form>


	</div>
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
<script>
$(document).ready(function() {
	//여기 아래 부분
	$('#summernote').summernote({
		  height: 300,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder : "상세정보입력",
	});
});
window.onload = function(){
	
}

</script>

</body>
</html>