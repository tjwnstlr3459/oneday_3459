package donation.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import donation.DonationDao;
import donation.DonationService;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet(name = "LoginCheck", urlPatterns = { "/loginCheck" })
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		//3.로직처리
		Member m = new DonationService().loginCheck(id,pw);
		System.out.println(m);
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(m != null) {
			request.setAttribute("msg", "로그인 성공!");
			HttpSession session = request.getSession();
			session.setAttribute("m", m);
		}else {
			request.setAttribute("msg", "로그인 실패");
		}
		request.setAttribute("loc", "/");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
