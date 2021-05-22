package donation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DonaListDelServlet
 */
@WebServlet(name = "DonaListDel", urlPatterns = { "/donaListDel" })
public class DonaListDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DonaListDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		int donaNum = Integer.parseInt(request.getParameter("donaNum"));
		
		int result = new DonationService().donaDelete(donaNum);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
		
		if(result>0) {
			request.setAttribute("msg", "게시글이 삭제되었습니다.");
		}else {
			request.setAttribute("msg", "게시글 삭제가 취소되었습니다.");
		}
		request.setAttribute("loc","/donationList?reqPage=1");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
