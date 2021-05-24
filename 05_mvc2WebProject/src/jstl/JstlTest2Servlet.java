package jstl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;


@WebServlet(name = "JstlTest2", urlPatterns = { "/jstlTest2" })
public class JstlTest2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public JstlTest2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2.값추출
		String memberId = request.getParameter("memberId");
		//3.비지니스로직
		Member m = new MemberService().selectOneMember(memberId);
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/view/jstl/jstlTest3.jsp");
		if(m != null) {
			request.setAttribute("m", m);
		}
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
