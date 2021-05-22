package Member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Member.service.MemberService;
import donation.login.Member;




/**
 * Servlet implementation class MemberMyPage2Servlet
 */
@WebServlet(name = "MemberMyPage2", urlPatterns = { "/memberMyPage2" })
public class MemberMyPage2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMyPage2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1
		request.setCharacterEncoding("utf-8");
		//2
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("m");
		//3
		Member member = new MemberService().selectOneMember(m.getMemberId()); 
		//4
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Member/myPage.jsp");
		request.setAttribute("member", member);
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
