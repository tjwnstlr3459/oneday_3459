package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class AjaxIdCHeckServlet
 */
@WebServlet(name = "AjaxIdCHeck", urlPatterns = { "/ajaxIdCHeck" })
public class AjaxIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AjaxIdCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		String memberId  = request.getParameter("memberId");
		//3.로직처리
		Member m = new MemberService().selectOneMember(memberId);
		//4.결과처리
		PrintWriter out = response.getWriter();
		if(m!= null) {
			out.print(1);
		}else {
			out.print(0);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
