package photo.controller;

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

import photo.medel.service.PhotoService;
import photo.medel.vo.Photo;

/**
 * Servlet implementation class PhotoWriteServlet
 */
@WebServlet(name = "PhotoWrite", urlPatterns = { "/photoWrite" })
public class PhotoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PhotoWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일 등록
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "게시판 작성 오류[enctype]");
			request.setAttribute("loc", "/photoList");
			rd.forward(request, response);
			return;
		}
		//파일 업로드 준비
		//1) 파일 업로드 경로 설정
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/photo";
		//2)파일 최대크기지정
		int maxSize = 10*1024*1024;
		//3)request -> MultipartRequest변환 (파일을 업로드)
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory,maxSize,"utf-8",new DefaultFileRenamePolicy());
		//4)포트객체 생성	//포터롸이트 사진 내용 전송이라 3개의 값이 넘어감
		Photo p = new Photo();
		p.setPhotoWriter(mRequest.getParameter("photoWriter"));
		p.setPhotoContent(mRequest.getParameter("photoContent"));
		p.setFilepath(mRequest.getFilesystemName("filename"));
		
		//3.로직처리
		int result = new PhotoService().insertPhoto(p);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result>0) {
			request.setAttribute("msg", "등록성공");
		}else {
			request.setAttribute("msg", "등록실패");
		}
		request.setAttribute("loc", "/photoList");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}








