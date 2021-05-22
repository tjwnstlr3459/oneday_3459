package notice.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeWriteServlet
 */
@WebServlet(name = "NoticeWrite", urlPatterns = { "/noticeWrite" })
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//파일업로드--> enctype="multipart/form-data"로 처리--> enctype이 정상인지 확인
		if(!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "공지사항 작성오류[enctype]");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
			return;
		}
		//파일업로드 준비		
		//1) 파일업로드 경로 지정
		String root = getServletContext().getRealPath("/");	//WebContent 폴더 경로 가져오는 코드
		String saveDirectory = root+"upload/notice";		//파일저장경로 지정
		System.out.println("파일 저장경로 : "+saveDirectory);
		//2) 업로드 파일의 최대크기 지정 (일반적으로 웹은 10Mb 정도 사용)
		int maxSize = 10*1024*1024;
		//3) reqeust -> MultipartRequest객체로 변환
		//매개변수 5개 request객체, 파일저장경로, 최대크기, 인코딩타입, 파일명 중복 처리 객체
		// 파일이업로드되는 코드
		MultipartRequest mRequest 
		= new MultipartRequest(request, saveDirectory,maxSize,"UTF-8", new DefaultFileRenamePolicy());
		Notice n = new Notice();
		n.setNoticeTitle(mRequest.getParameter("noticeTitle"));
		n.setNoticeWriter(mRequest.getParameter("noticeWriter"));
		n.setNoticeContent(mRequest.getParameter("noticeContent"));
		n.setFilename(mRequest.getOriginalFileName("filename"));//사용자가 업로드한 파일 명
		n.setFilepath(mRequest.getFilesystemName("filename"));	//실제 업로드 된 파일 이름
		//getOriginalFileName,getFilesystemName 매개변수는 <input type="file" name="">name속성값
		//3. 비지니스로직
		int result = new NoticeService().insertNotice(n);
		//4. 결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "등록 성공!");
		}else {
			request.setAttribute("msg", "등록 실패!");
		}
		request.setAttribute("loc", "/supportList?reqPage=1");
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
