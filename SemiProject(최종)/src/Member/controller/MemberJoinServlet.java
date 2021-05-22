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
 * Servlet implementation class MemberJoinServlet
 */
@WebServlet(name = "MemberJoin", urlPatterns = { "/memberJoin" })
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinServlet() {
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
		Member m = new Member();
		m.setMemberId(request.getParameter("memberId"));
		m.setMemberPw(request.getParameter("memberPw"));
		m.setMemberName(request.getParameter("memberName"));
		m.setMemberEmail(request.getParameter("memberEmail"));
		m.setMemberPhone(request.getParameter("Phone"));
		m.setMemberAddr(request.getParameter("memberAddr"));
		//3
		int result = new MemberService().inserMember(m);
		//4
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "회원가입 성공");
			request.setAttribute("loc", "/joinEnd");
		}else {
			HttpSession seesion = request.getSession();
			seesion.setAttribute("m", m);
			request.setAttribute("msg", "회원가입 실패");
			
		}
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
