package jstl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JstlTest4Servlet
 */
@WebServlet(name = "JstlTest4", urlPatterns = { "/jstlTest4" })
public class JstlTest4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public JstlTest4Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2.값추출
		String str = request.getParameter("data");
		//3.로직처리
		request.setAttribute("str", str);
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/view/jstl/jstlTest5.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
