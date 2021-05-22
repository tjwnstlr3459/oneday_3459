package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import admin.model.vo.Admin;
import donation.login.Member;

/**
 * Servlet implementation class UpdateAdminServlet
 */
@WebServlet(name = "UpdateAdmin", urlPatterns = { "/updateAdmin" })
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Admin a = new Admin();
		a.setAdminId(request.getParameter("adminId"));
		a.setAdminPw(request.getParameter("adminPw"));
		a.setPhone(request.getParameter("adminPhone"));
		a.setAddr(request.getParameter("adminAddr"));
		int result = new AdminService().updateAdmin(a);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if (result > 0) {
			request.setAttribute("msg", "정보변경 성공!!");
			
		} else {
			request.setAttribute("msg", "정보변경 실패ㅠ");
		}
		
		request.setAttribute("loc", "/adminPage");// 마이페이지로 이동시키기 위해 서블릿 매핑값을 전달
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
