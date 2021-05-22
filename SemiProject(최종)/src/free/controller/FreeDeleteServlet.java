package free.controller;

import java.io.File;
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
 * Servlet implementation class FreeDeleteServlet
 */
@WebServlet(name = "FreeDelete", urlPatterns = { "/freeDelete" })
public class FreeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FreeDeleteServlet() {
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
		
		// 3. 비지니스로직
		FreeService service = new FreeService();
		Free f = service.selectFree(freeNo);
		int result = service.deleteFree(freeNo); // 삭제
		
		// 4. 결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

		if (result > 0) {
			if(f.getFilepath() != null) { // 첨부파일이 있는경우
				String root = getServletContext().getRealPath("/");
				String file = root + "upload/free/" + f.getFilepath();

				File delFile = new File(file);
				delFile.delete();
			}
			request.setAttribute("msg", "게시물 삭제 성공!");
			request.setAttribute("loc", "/freeBoard?reqPage=1"); // 첫 페이지로 이동
		} else {
			request.setAttribute("msg", "게시물 삭제 실패!");
			request.setAttribute("loc", "/freeView?freeNo=" + freeNo); // 실패 시 해당 글 다시 보기
		}
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
