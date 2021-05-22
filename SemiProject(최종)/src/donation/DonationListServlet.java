package donation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DonationListServlet
 */
@WebServlet(name = "DonationList", urlPatterns = { "/donationList" })
public class DonationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DonationListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		//3.로직처리
		DonationPageData dpd = new DonationService().selectDonationList(reqPage);
		DonationPageData member = new DonationService().selectDonationList(reqPage);
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/donation/donationList.jsp");
		request.setAttribute("list", dpd.getList());
		request.setAttribute("pageNavi", dpd.getPageNavi());
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
