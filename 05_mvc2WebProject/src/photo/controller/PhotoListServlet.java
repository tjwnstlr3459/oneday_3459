package photo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import photo.medel.service.PhotoService;

/**
 * Servlet implementation class PhotoListServlet
 */
@WebServlet(name = "PhotoList", urlPatterns = { "/photoList" })
public class PhotoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PhotoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//총게시물수 파악
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		//3.비지니스로직
		int totalCount = new PhotoService().totalCount();
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/photo/photoList.jsp");
		request.setAttribute("totalCount", totalCount);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
