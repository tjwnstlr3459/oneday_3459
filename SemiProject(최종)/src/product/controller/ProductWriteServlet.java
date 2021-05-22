package product.controller;

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

import product.model.service.ProductService;
import product.model.vo.Product;

/**
 * Servlet implementation class ProductWriteServlet
 */
@WebServlet(name = "ProductWrite", urlPatterns = { "/productWrite" })
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		if(!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "게시판 작성 오류[enctype]");
			request.setAttribute("loc", "/productList");
			rd.forward(request, response);
			return;
		}
		//파일업로드준비
		//1)파일업로드 경로 설정
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/product";
		//2)파일 최대크기지정
		int maxSize = 10*1024*1024;
		//3)request -> MultipartRequest 변환(파일을 업로드)
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory,maxSize,"utf-8",new DefaultFileRenamePolicy());
		Product p = new Product();
		p.setProductTitle(mRequest.getParameter("title"));
		p.setFilename(mRequest.getOriginalFileName("filename"));
		p.setFilepath(mRequest.getFilesystemName("filename"));
		p.setProductContent(mRequest.getParameter("content"));
		p.setProductInfo(mRequest.getParameter("info"));
		p.setProductSpons(mRequest.getParameter("spons"));
		//3.비지니스로직
		int result = new ProductService().insertProduct(p);
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "등록성공");
		}else {
			request.setAttribute("msg", "등록실패");
		}
		request.setAttribute("loc", "/productList?reqPage=1");
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
