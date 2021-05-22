package donation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DonationListUpdateServlet
 */
@WebServlet(name = "DonationListUpdate", urlPatterns = { "/donationListUpdate" })
public class DonationListUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DonationListUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		int listNum = Integer.parseInt(request.getParameter("donationNo"));
		System.out.println(listNum);
		DonationList list = new DonationList();
		Donation d = new Donation();
		
		
		list.setPa_level(request.getParameter("dona_sor"));
		list.setDona_writer(request.getParameter("name"));
		list.setDona_title(request.getParameter("title"));
		list.setDona_content(request.getParameter("concon"));
		//3.로직처리
		int result = new DonationService().donationUpdate(d,list,listNum);
		System.out.println(result);
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "수정되었습니다.");
		}else {
			request.setAttribute("msg", "수정실패");
		}
		request.setAttribute("loc", "/donationList?reqPage=1");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
