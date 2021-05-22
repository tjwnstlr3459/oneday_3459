package Member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLogoutServlet
 */
@WebServlet(name = "MemberLogout", urlPatterns = { "/memberLogout" })
public class MemberLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		//request.getSession() : 현재 존재하는 세션을 가지고옴/존재하지 않으면 세션을 새로 생성해서 리턴
		//request.getSession(false) : 현재 존재하는 세션을 가지고옴/존재하지 않으면 null 리턴
		if(session != null) {//로그인 한적이 있는경우
			//세션을 파기
			session.invalidate();
			request.setAttribute("msg", "로그아웃 성공");
		}
		//결과처리할 페이지 지정
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		//결과화면에서 사용할 데이터 등록
		//화면이동
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
