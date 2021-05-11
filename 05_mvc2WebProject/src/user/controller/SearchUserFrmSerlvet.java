package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import user.model.dao.UserDao;
import user.model.vo.User;

/**

* Servlet implementation class SearUserFrmServlet

*/

@WebServlet(name = "SearchUserFrm", urlPatterns = { "/searchUserFrm" })

public class SearchUserFrmSerlvet extends HttpServlet {

private static final long serialVersionUID = 1L;

/**

* @see HttpServlet#HttpServlet()

*/

public SearchUserFrmSerlvet() {

super();

// TODO Auto-generated constructor stub

}

/**

* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

*/

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//1인코딩
	request.setCharacterEncoding("utf-8");
	//2.값추출
	int No = Integer.parseInt(request.getParameter("no"));
	//3.로직처리
	User user = new UserDao().selectUser(No);
	//4.결과처리
	request.setAttribute("user", user);
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/searchUser.jsp");
	rd.forward(request, response);

}

/**

* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

*/

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

// TODO Auto-generated method stub

doGet(request, response);

}

}