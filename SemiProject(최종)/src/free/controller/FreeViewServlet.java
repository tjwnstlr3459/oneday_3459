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
import free.model.vo.FreeViewData;

/**
 * Servlet implementation class FreeViewServlet
 */
@WebServlet(name = "FreeView", urlPatterns = { "/freeView" })
public class FreeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FreeViewServlet() {
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
		int freeNo = Integer.parseInt(request.getParameter("freeNo"));
		Free f = new FreeService().selectFree(freeNo); // 게시물 유/무 확인

		if (f == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "해당게시물은 삭제되었습니다.");
			request.setAttribute("loc", "/freeBoard?reqPage=1"); // 다시 자유게시판 화면으로 이동
			rd.forward(request, response);
			return;
		}
		// 현재 회원값 넘기기
		HttpSession session = request.getSession(false); // 로그인 했으면 값 불러옴 / 로그인 안했으면 null
		Member m = (Member) session.getAttribute("m");
		String memberId = "";

		if (m != null) { // 로그인 한 경우
			memberId = m.getMemberId(); // 회원 아이디 조회
		} else { // 로그인 안했으면 조회 불가
			memberId = "";
		}
		// 3. 비지니스 로직
		FreeService service = new FreeService();
		FreeViewData fvd = service.selectFreeView(freeNo, memberId); // 게시물 정보 및 댓글 / 좋아요 추출

		service.updateReadCount(freeNo); // 조회수 증가

		// 4. 결과처리
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/free/freeView.jsp");

		request.setAttribute("f", fvd.getF()); // 게시물 정보
		request.setAttribute("list", fvd.getList()); // 댓글 정보
		request.setAttribute("love", fvd.getLove()); // 좋아요 유/무

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
