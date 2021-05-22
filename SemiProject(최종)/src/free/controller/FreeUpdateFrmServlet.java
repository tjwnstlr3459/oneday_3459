package free.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.model.service.FreeService;
import free.model.vo.Free;

/**
 * Servlet implementation class UpdateFreeServlet
 */
@WebServlet(name = "FreeUpdateFrm", urlPatterns = { "/freeUpdateFrm" })
public class FreeUpdateFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FreeUpdateFrmServlet() {
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
		int freeNo = Integer.parseInt(request.getParameter(("freeNo")));
		Free f = new FreeService().selectFree(freeNo); // 해당 게시물 조회

		if (f != null) {
			request.setAttribute("f", f);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "해당게시물은 삭제되었습니다.");
			request.setAttribute("loc", "/freeBoard?reqPage=1"); // 다시 자유게시판 화면으로 이동
			rd.forward(request, response);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/free/freeUpdateFrm.jsp");
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
