<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>freeWriteFrm</title>
    <%@ include file="/WEB-INF/views/free/freeHeader.html" %>
      <!-- 서머노트 bs4 css/js -->
      <link href="/summernote/summernote-bs4.css" rel="stylesheet">
      <script src="/summernote/summernote-bs4.js"></script>
      <!-- summernote 한글 설정 -->
      <script src="/summernote/lang/summernote-ko-KR.js"></script>
      <link href="/css/free/freeBoardFrm.css" rel="stylesheet">
  </head>

  <body>
    <!-- Header -->
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
      <div class="container">
        <h3>자유게시판 글쓰기</h3>
        <br>
        <form action="/freeWrite" method="POST">
          <fieldset>
            <input name="freeTitle" style="width: 100%;" type="text" placeholder="제목을 입력하세요." required><br><br>
            <!-- summerEditor -->
            <textarea id="summernote" name="editordata"></textarea>

            <!-- 파일 이름 저장용 -->
            <input type="hidden" name="filename">

            <div class="btn-right">
              <button type="submit" class="btn btn-primary">완료</button>
            </div>
          </fieldset>
        </form>
      </div>
      <!-- Footer -->
      <%@ include file="/WEB-INF/views/common/footer.jsp" %>

        <script>
          $(function () {
            // summernote init
            $("#summernote").summernote({
              height: 300, // editor height
              focus: true, // set focus editable area
              lang: "ko-KR", // 한글설정
              placeholder: "내용을 입력하세요.",
              callbacks: {
                // 이미지 첨부 시
                onImageUpload: function (files) {
                  // 다중 업로드 처리
                  for (var i = 0; i < files.length; i++) {
                    uploadImage(files[i], this);
                  }
                }
              }
            });

            // 이미지 업로드
            function uploadImage(file, editor) {
              var formData = new FormData();
              formData.append("file", file);

              $.ajax({
                data: formData,
                type: "POST",
                url: "/uploadImage",
                enctype: 'multipart/form-data',
                cache: false,
                contentType: false,
                processData: false,
                success: function (data) {
                  // 파일 네임 전송용
                  $("[name=filename]").val(data);
                  // 이미지 경로 설정
                  data = "/upload/free/" + data;
                  // 이미지 미리보기
                  $(editor).summernote('insertImage', data);
                }
              });
            }
          });
        </script>
  </body>

  </html>