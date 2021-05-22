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
 * Servlet implementation class UserLoginServlet
 */
@WebServlet(name = "MemberLogin", urlPatterns = { "/memberLogin" })
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 .인코딩
		request.setCharacterEncoding("utf-8");
		//2. 추출
		String memberId = request.getParameter("id");
		String memberPw = request.getParameter("pw");
		//3.비지니스 로직
		Member m = new MemberService().selectOneUser(memberId,memberPw);
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(m!=null) {
			request.setAttribute("msg", "로그인 성공");
			HttpSession seesion = request.getSession();
			seesion.setAttribute("m", m);
			request.setAttribute("loc", "/");
		}else {
			request.setAttribute("msg", "로그인 실패");
			HttpSession seesion = request.getSession();
			seesion.setAttribute("m", m);
			request.setAttribute("loc", "/memberLoginPage");
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
