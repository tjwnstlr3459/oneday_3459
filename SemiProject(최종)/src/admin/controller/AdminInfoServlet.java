package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import admin.model.vo.Admin;

/**
 * Servlet implementation class AdminInfoServlet
 */
@WebServlet(name = "AdminInfo", urlPatterns = { "/adminInfo" })
public class AdminInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		String adminId = request.getParameter("adminId");
		String adminPw = request.getParameter("adminPw");
		String adminName = request.getParameter("adminName");
		String adminPhone = request.getParameter("adminPhone");
		String adminAddr = request.getParameter("adminAddr");
		Admin a = new Admin();
		a.setAdminId(adminId);
		a.setAdminPw(adminPw);
		a.setAdminName(adminName);
		a.setPhone(adminPhone);
		a.setAddr(adminAddr);
		//3.비지니스로직
		int result = new AdminService().insertAdmin(a);
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if (result != 0) {
			request.setAttribute("msg", "회원가입 성공!");
			
		} else {
			request.setAttribute("msg", "회원가입 실패!");
		}
		request.setAttribute("loc", "/");
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
