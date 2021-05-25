package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class IdSearchServlet
 */
@WebServlet(name = "IdSearch", urlPatterns = { "/idSearch" })
public class IdSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IdSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberName = request.getParameter("memberName");
		String phone = request.getParameter("phone");
		
		Member m = new MemberService().selectOneMember(memberName,phone);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(m != null) {
			request.setAttribute("msg", "회원님의 아이디는["+m.getMemberId()+"]입니다.");
			request.setAttribute("loc", "/");
		}else {
			request.setAttribute("msg", "정보를 조회할수없습니다.");
			request.setAttribute("loc", "/searchFrm");
		}
		rd.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
