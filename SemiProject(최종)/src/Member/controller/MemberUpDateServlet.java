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
 * Servlet implementation class MemberUpDateServlet
 */
@WebServlet(name = "MemberUpDate", urlPatterns = { "/memberUpDate" })
public class MemberUpDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpDateServlet() {
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
		m.setMemberEmail(request.getParameter("memberEmail"));
		m.setMemberPhone(request.getParameter("Phone"));
		m.setMemberAddr(request.getParameter("memberAddr"));
		//3
		int result = new MemberService().updateMember(m);
		//4
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		//페이지에서 사용할 데이터 등록
		if(result>0) {
			request.setAttribute("msg", "정보변경 성공!");
			//정보변경에 성공한경우 세션에 회원정보를 갱신하기위한 코드
			Member member = new MemberService().selectOneMember(m.getMemberId());
			HttpSession session = request.getSession(false);
			session.setAttribute("m", member);
		}else {
			request.setAttribute("msg", "정보변경 실패");
		}
		request.setAttribute("loc", "/memberMyPage");//마이페이지로 이동시키기 위해 서블릿 매핑값을 등록
		
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
