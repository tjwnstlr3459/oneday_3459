package jstl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class JstlTest3Servlet
 */
@WebServlet(name = "JstlTest3", urlPatterns = { "/jstlTest3" })
public class JstlTest3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public JstlTest3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2.값추출
		//3.비지니스로직
		ArrayList<Member> list = new MemberService().selectAllMember();
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/view/jstl/jstlTest4.jsp");
		request.setAttribute("list", list);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
