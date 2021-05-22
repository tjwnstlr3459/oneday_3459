<%@page import="donation.DonationList" %>
   <%@page import="product.model.vo.Product" %>
      <%@page import="java.util.ArrayList" %>
         <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <% ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
                  ArrayList<DonationList> list1 = (ArrayList<DonationList>)request.getAttribute("list1");
                        String search = (String)request.getAttribute("search");
                        %>

                        <!DOCTYPE html>

                        <html>
                        <style>
                           #searchList {
                              margin-top: 100px;
                           }

                           img {
                              width: 100% !important;
                              height: 170px;
                              border-top-right-radius: 15px;
                              border-top-left-radius: 15px;
                           }

                           img:hover {
                              opacity: 0.7;
                           }


                           p {
                              color: grey;
                           }

                           .photo>a {
                              color: grey;
                           }

                           h3 {
                              padding-top: 25px !important;
                              color: orange;
                           }

                           h5 {
                              padding: 10px !important;
                              color: rgba(0, 183, 255, 0.959);
                           }

                           .content-detail>ul>li {
                              /* padding:10px; */

                           }
                        </style>

                        <head>
                           <meta charset="UTF-8">
                           <title>Insert title here</title>
                        </head>

                        <body>
                           <%@ include file="/WEB-INF/views/common/header.jsp" %>
                              <div class="content">
                                 <div class="content-detail">
                                    <div id="searchList">
                                    </div>
                                    <span style="color:rgba(80, 185, 226, 0.959);">
                                       <%=search %>
                                    </span><span>의 검색결과 입니다.</span><br>
                                    <ul>
                                       <%for(Product p : list){ %>
                                          <li>
                                             <div class="photo"><a
                                                   href="/productView?productNo=<%=p.getProductNo()%>">
                                                   <%if(p.getFilepath()==null) {%>
                                                      <img src="/img/logo.png" width="180"
                                                         height="180">
                                                      <%}else{ %>
                                                         <img src="/upload/product/<%=p.getFilepath() %>"
                                                            width="180" height="180">
                                                         <%} %>
                                                </a></div>
                                             <h3>
                                                <%=p.getProductTitle() %>
                                             </h3>
                                             <h5>
                                                <%=p.getProductSpons() %>
                                             </h5>
                                          </li>
                                          <%} %>
                                    </ul>
                                    <span><i class="fa fa-heart"></i>후원상품▼</span>
                                    <ul>
                                       <%for(DonationList d : list1){ %>
                                          <li>
                                             <h3>
                                                <%=d.getDona_title() %>
                                             </h3>
                                             <h5>
                                                <%=d.getDona_content() %>
                                             </h5>
                                             <h5>
                                                <%=d.getDona_writer() %>
                                             </h5>
                                          </li>
                                          <%} %>
                                    </ul>

                                 </div>
                              </div>
                              <%@ include file="/WEB-INF/views/common/footer.jsp" %>
                        </body>

                        </html>