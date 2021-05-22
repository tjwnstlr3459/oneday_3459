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
 * Servlet implementation class FreeSearchServlet
 */
@WebServlet(name = "FreeSearch", urlPatterns = { "/freeSearch" })
public class FreeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FreeSearchServlet() {
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
		int reqPage = Integer.parseInt(request.getParameter("reqPage")); // 조회한 첫 페이지
		String searchWhat = request.getParameter("searchWhat"); // 검색할 컬럼
		String searchContent = request.getParameter("searchContent"); // 검색할 내용

		// 3. 비지니스 로직
		// 작성자
		FreePageData fpd = new FreeService().selectSearchList(reqPage, searchWhat, searchContent);

		// 검색 결과 없을 시 게시판 첫페이지로 이동
		if (fpd.getList().size() == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "조회된 결과가 없습니다.");
			request.setAttribute("loc", "/freeBoard?reqPage=1"); // 첫 페이지로 이동
			rd.forward(request, response);
			return;
		}

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
