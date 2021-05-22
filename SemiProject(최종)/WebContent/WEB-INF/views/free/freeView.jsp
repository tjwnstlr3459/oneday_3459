<%@page import="donation.login.Member" %>
  <%@page import="free.model.vo.FreeComment" %>
    <%@page import="java.util.ArrayList" %>
      <%@page import="free.model.vo.Free" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

          <% Free f=(Free) request.getAttribute("f"); ArrayList<FreeComment> list = (ArrayList<FreeComment>)
              request.getAttribute("list");
              int love = (int)request.getAttribute("love");

              %>

              <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
              <html>

              <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>freeView</title>
                <!-- 폰트어썸 5.10.2 cdn -->
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.2/css/all.min.css"
                  integrity="sha512-u7ppO4TLg4v6EY8yQ6T6d66inT0daGyTodAi6ycbw9+/AU8KMLAF7Z7YGKPMRA96v7t+c7O1s6YCTGkok6p9ZA=="
                  crossorigin="anonymous" />

                <%@ include file="/WEB-INF/views/free/freeHeader.html" %>
              </head>

              <body>
                <!-- Header -->
                <%@ include file="/WEB-INF/views/common/header.jsp" %>
                  <link rel="stylesheet" href="/css/free/freeView.css">
                  <div class="container">
                    <table class="table table-bordered">
                      <tbody>
                        <tr>
                          <th>좋아요</th>
                          <td class="change-like">
                            <%=f.getLikeCount()%>
                          </td>
                          <th>조회</th>
                          <td>
                            <%=f.getReadCount() + 1%>
                          </td>
                        </tr>
                        <tr>
                          <th>작성자</th>
                          <td>
                            <%=f.getFreeWriter()%>
                          </td>
                          <th>작성일</th>
                          <td>
                            <%=f.getFreeDate()%>
                          </td>
                        </tr>
                        <tr>
                          <th>제목</th>
                          <td colspan="2">
                            <%=f.getFreeTitle()%>
                          </td>
                          <%if (m !=null) {%>
                            <td class="like">
                              <!-- 좋아요 인 상태-->
                              좋아요
                              <%if(love==1) { %>
                                <i class="fas fa-heart fa-lg heart love"></i>
                                <!-- 좋아요 아닌 상태 -->
                                <%} else {%>
                                  <i class="far fa-heart fa-lg heart"></i>
                                  <%} %>
                                    <%} else {%>
                            <td></td>
                            <%}%>
                              </td>
                        </tr>
                        <tr>
                          <td colspan="4">
                            <%=f.getFreeContent()%>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                    <!-- 하단 버튼 -->
                    <div class="text-center">
                      <!-- 현재 로그인한 회원과, 해당 게시물의 작성자가 같은경우 수정/삭제 -->
                      <%if (m !=null && f.getFreeWriter().equals(m.getMemberId())){ %>
                        <a href="/freeUpdateFrm?freeNo=<%=f.getFreeNo() %>" class="btn btn-outline-info">수정</a>
                        <a href="/freeDelete?freeNo=<%=f.getFreeNo() %>" class="btn btn-outline-danger">삭제</a>
                        <%} %>
                          <a class="btn btn-outline-primary" href="/freeBoard?reqPage=1">목록</a>
                    </div>

                    <!-- 로그인 한 경우 -->
                    <% if (m !=null) { %>
                      <div class="inputCommentBox">
                        <form action="/insertComment" method="post">
                          <ul>
                            <li>
                              <input type="hidden" name="fcWriter" value="<%=m.getMemberId()%>">
                              <input type="hidden" name="freeRef" value="<%=f.getFreeNo()%>">
                              <input type="hidden" name="fcRef" value="0">
                              <textarea style="resize: none;" class="form-control" name="fcContent"></textarea>
                            </li>
                            <li>
                              <button type="submit" class="btn btn-outline-success">등록</button>
                            </li>
                          </ul>
                        </form>
                      </div>
                      <% } %>

                  </div>
                  <!-- Footer -->
                  <%@ include file="/WEB-INF/views/common/footer.jsp" %>
                    <script>

                      $(function () {
                        var likeCnt = $(".change-like").html();

                        // 컬럼명 파란색 칠하기 + 글씨색 흰색
                        $("table th").addClass('bg-primary text-white');
                          <% if (m != null) { %>
                          // 좋아요 클릭
                          $(".heart").on("click", function () {
                            $(this).toggleClass('love'); // 좋아요 색변경
                            // 좋아요 삭제
                            if ($(this).hasClass('fas')) {
                              $.ajax({
                                url: "/deleteLove",
                                data: {
                                  freeWriter: '<%=m.getMemberId() %>',
                                  freeNo: '<%=f.getFreeNo() %>'
                                },
                                type: "post"
                              });
                              // 빈 하트 변경
                              $(this).removeClass('fas');
                              $(this).addClass('far');
                              $(".change-like").html(--likeCnt); // 좋아요 1감소
                            } else {// 좋아요 등록
                              $.ajax({
                                url: "/insertLove",
                                data: {
                                  freeWriter: '<%=m.getMemberId() %>',
                                  freeNo: '<%=f.getFreeNo() %>'
                                },
                                type: "post"
                              });
                              // 빨간하트 변경
                              $(this).removeClass('far');
                              $(this).addClass('fas')
                              $(".change-like").html(++likeCnt); // 좋아요 1증가
                            }
                          }); // 좋아요 클릭
                          <%}%>
                        });

                    </script>
              </body>

              </html>