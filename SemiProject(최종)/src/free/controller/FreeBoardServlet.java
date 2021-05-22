package free.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.model.service.FreeService;
import free.model.vo.FreePageData;

/**
 * Servlet implementation class FreeBoardServlet
 */
@WebServlet(name = "FreeBoard", urlPatterns = { "/freeBoard" })
public class FreeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FreeBoardServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		// 2. 값 추출
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		// 3. 비지니스 로직
		FreePageData fpd = new FreeService().selectFreeList(reqPage);
		// 4. 결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/free/freeBoard.jsp");
		request.setAttribute("list", fpd.getList());
		request.setAttribute("pageNavi", fpd.getPageNavi());
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
