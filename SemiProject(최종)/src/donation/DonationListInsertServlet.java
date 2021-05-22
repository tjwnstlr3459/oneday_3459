package donation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DonationLisetInsertServlet
 */
@WebServlet(name = "DonationListInsert", urlPatterns = { "/donationListInsert" })
public class DonationListInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DonationListInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		Donation d = new Donation();
		DonationList list = new DonationList();
		d.setPa_use(request.getParameter("kind"));
		d.setPa_kind(request.getParameter("kind1"));
		d.setPa_email(request.getParameter("email"));
		d.setPa_email2(request.getParameter("email2"));
		d.setPa_phone(request.getParameter("phone"));
		d.setPa_name(request.getParameter("name"));
		list.setDona_title(request.getParameter("title"));
		list.setDona_content(request.getParameter("concon"));
		list.setPa_level(request.getParameter("dona_sor"));
		
		d.setPrice_choice(Integer.parseInt(request.getParameter("price_choice")));
		System.out.println(d.getPrice_choice());
		
		String pa_lev = request.getParameter("dona_sor");//후원인 list게시판
		
		
		//3.로직처리
		int result = new DonationService().insertList(d,pa_lev,list);
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
		
		if(result>0) {
			request.setAttribute("msg", "후원게시판에 등록");
		}else {
			request.setAttribute("msg", "후원게시판에 등록실패");
		}
		request.setAttribute("loc", "/donationList?reqPage=1");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
