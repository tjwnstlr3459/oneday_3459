package photo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import photo.medel.service.PhotoService;
import photo.medel.vo.Photo;

/**
 * Servlet implementation class PhotoMoreServlet
 */
@WebServlet(name = "PhotoMore", urlPatterns = { "/photoMore" })
public class PhotoMoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PhotoMoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		//1-5 /6-11
		int start = Integer.parseInt(request.getParameter("start"));
		//3.로직처리
		ArrayList<Photo> list = new PhotoService().morePhoto(start);
		System.out.println(list.size());
		//4.결과처리
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(list,response.getWriter());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
