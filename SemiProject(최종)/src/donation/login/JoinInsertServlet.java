package donation.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.DonationDao;
import donation.DonationService;

/**
 * Servlet implementation class JoinInsertServlet
 */
@WebServlet(name = "JoinInsert", urlPatterns = { "/joinInsert" })
public class JoinInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Member m = new Member();
		m.setMemberId(request.getParameter("id"));
		m.setMemberPw(request.getParameter("pw"));
		m.setMemberName(request.getParameter("name"));
		m.setMemberEmail(request.getParameter("email"));
		m.setMemberAddr(request.getParameter("addr"));
		m.setMemberPhone(request.getParameter("phone"));
		
		int result = new DonationService().memberInsert(m);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
