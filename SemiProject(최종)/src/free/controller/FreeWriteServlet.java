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
 * Servlet implementation class FreeWriteServlet
 */
@WebServlet(name = "FreeWrite", urlPatterns = { "/freeWrite" })
public class FreeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FreeWriteServlet() {
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
		HttpSession session = request.getSession(false); // 로그인 했으면 값 불러옴 / 로그인 안했으면 null
		if(session == null) { // 로그인 안 한 경우
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "로그인 후 작성 가능합니다.");
			request.setAttribute("loc", "/freeBoard?reqPage=1"); // 다시 자유게시판 화면으로 이동
			rd.forward(request, response);
			return;
		}
		
		Member m = (Member) session.getAttribute("m");
		Free f = new Free();
		f.setFreeTitle(request.getParameter("freeTitle"));
		f.setFreeContent(request.getParameter("editordata"));
		f.setFilepath(request.getParameter("filename"));
		f.setFreeWriter(m.getMemberId());

		// 3. 비지니스로직
		int result = new FreeService().insertFree(f);
		// 4. 결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

		if (result > 0) {
			request.setAttribute("msg", "게시물 등록 성공!");
		} else {
			request.setAttribute("msg", "게시물 등록 실패!");
		}
		request.setAttribute("loc", "/freeBoard?reqPage=1");
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
