package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class IfTestServlet
 */
@WebServlet(name = "IfTest", urlPatterns = { "/ifTest" })
public class IfTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public IfTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		String ckName = request.getParameter("ckName");
		String ckPhone = request.getParameter("ckPhone");
		String ckAddress = request.getParameter("ckAddress");
		//3.로직처리
		ArrayList<Member> list = new MemberService().ifTest(ckName,ckPhone,ckAddress);
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/ifTest.jsp");
		request.setAttribute("list", list);
		request.setAttribute("ckName", ckName);
		request.setAttribute("ckPhone", ckPhone);
		request.setAttribute("ckAddress", ckAddress);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
