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
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet(name = "ProductUpdate", urlPatterns = { "/productUpdate" })
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		if(!ServletFileUpload.isMultipartContent(request)) {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");	//처리할 페이지
		request.setAttribute("msg", "공지사항 작성오류[entype]");									//오류메세지 띄워주고
		request.setAttribute("loc", "/");														//메인페이지로이동요청
		rd.forward(request, response);															//페이지이동
		return;																					//끝
		}
		String root = getServletContext().getRealPath("/"); 
		String saveDirectory = root+"upload/product";
		int maxSize = 10*1024*1024; 
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory,maxSize,"utf-8",new DefaultFileRenamePolicy());	 	
		int productNo = Integer.parseInt(mRequest.getParameter("productNo"));
		String spons = mRequest.getParameter("spons");
		String productTitle = mRequest.getParameter("title");
		String filename = mRequest.getOriginalFileName("filename");
		String filepath = mRequest.getFilesystemName("filename");
		String productInfo = mRequest.getParameter("info");
		String productContent = mRequest.getParameter("content");
		Product p = new Product();
		p.setProductContent(productContent);
		p.setProductInfo(productInfo);
		p.setProductNo(productNo);
		p.setProductTitle(productTitle);
		p.setFilename(filename);
		p.setFilepath(filepath);
		p.setProductSpons(spons);
		//3.비지니스로직
		int result = new ProductService().updateProduct(p);
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "수정완료");
		}else {
			request.setAttribute("msg", "수정실패");
		}
		request.setAttribute("loc", "/productView?productNo="+productNo);
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
