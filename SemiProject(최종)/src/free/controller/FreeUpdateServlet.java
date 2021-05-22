package free.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import donation.login.Member;
import free.model.service.FreeService;
import free.model.vo.Free;

/**
 * Servlet implementation class FreeUpdateServlet
 */
@WebServlet(name = "FreeUpdate", urlPatterns = { "/freeUpdate" })
public class FreeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FreeUpdateServlet() {
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
		Free f = new Free();
		f.setFreeTitle(request.getParameter("freeTitle"));
		f.setFreeContent(request.getParameter("editordata"));
		f.setFilepath(request.getParameter("filename"));
		f.setFreeNo(Integer.parseInt(request.getParameter(("freeNo"))));
		// 3. 비지니스로직
		int result = new FreeService().updateFree(f);
		// 4. 결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

		if (result > 0) {
			request.setAttribute("msg", "게시물 수정 성공!");
		} else {
			request.setAttribute("msg", "게시물 수정 실패!");
		}
		request.setAttribute("loc", "/freeView?freeNo=" + f.getFreeNo());
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
