package free.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadImageServlet
 */
@WebServlet(name = "UploadImage", urlPatterns = { "/uploadImage" })
public class UploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadImageServlet() {
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

		// 2. 값추출
		// 파일 업로드 enctype 필터링
		if (!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "게시글 작성 오류[enctype]");
			request.setAttribute("loc", "/");

			rd.forward(request, response);
		}

		// 파일 업로드
		// 1) 파일 업로드 경로 지정
		String root = getServletContext().getRealPath("/"); // WebContent 경로 가져오기
		String saveDirectory = root + "upload/free"; // 파일 저장 경로지정
		// 2) 업로드 파일의 최대크기 지정 - 10mb
		int maxSize = 10 * 1024 * 1024;
		// 3) request -> MultipartRequest객체로 변환
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		// 파일명 추출
		String fileName = mRequest.getFilesystemName((String) mRequest.getFileNames().nextElement());

		// 상대 경로 전달
		// String filePath = "/upload/free/" + fileName;
		// System.out.println(filePath);
		// 4. 결과처리
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		System.out.println("업로드 : " + fileName);
		out.print(fileName);	
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
