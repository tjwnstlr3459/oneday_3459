package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.service.ProductService;

import product.model.vo.Product;


/**
 * Servlet implementation class ProductDeleteServlet
 */
@WebServlet(name = "ProductDelete", urlPatterns = { "/productDelete" })
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDeleteServlet() {
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
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		//3.비지니스로직
		ProductService service = new ProductService();
		Product p = service.selectOneProduct(productNo);
		int result = service.deleteProduct(productNo);
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
		if(result>0) {
			if(p.getFilepath() != null) {
				String root = getServletContext().getRealPath("/");		//파일 위치지정
				String file = root+"upload/product/"+p.getFilepath();	//가져와야할건 실제로 저장된 파일이름(filepath)
				File delFile = new File(file);							//파일 객체 delFile = new 파일객체(저장된파일이름)
				delFile.delete();	
			}
			request.setAttribute("msg", "삭제성공");
			request.setAttribute("loc", "/productList?reqPage=1");
		}else {
			request.setAttribute("msg", "삭제실패");
			request.setAttribute("loc", "/productView?productNo="+productNo);
		}
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
