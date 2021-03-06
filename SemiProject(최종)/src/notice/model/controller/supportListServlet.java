package notice.model.controller;

 

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;

import notice.model.vo.NoticePageData;

 

/**

 * Servlet implementation class supporNoticeServlet

 */

@WebServlet(name = "supportList", urlPatterns = { "/supportList" })

public class supportListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public supportListServlet() {

        super();

        // TODO Auto-generated constructor stub

    }

 

	/**

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.인코딩

				request.setCharacterEncoding("utf-8");

				int reqPage = Integer.parseInt(request.getParameter("reqPage"));	//

				NoticePageData npd = new NoticeService().selectNoticeList(reqPage);

				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/notice/noticeList.jsp");

				request.setAttribute("list", npd.getList());

				request.setAttribute("pageNavi", npd.getPageNavi());

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
