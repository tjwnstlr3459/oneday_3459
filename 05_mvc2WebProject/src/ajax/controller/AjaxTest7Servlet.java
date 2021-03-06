package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class AjaxTest7Servlet
 */
@WebServlet(name = "AjaxTest7", urlPatterns = { "/ajaxTest7" })
public class AjaxTest7Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AjaxTest7Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		//3.로직처리
		ArrayList<Member> list = new MemberService().selectAllMember();
		JSONObject map = new JSONObject();
		for(Member m : list){
			JSONObject userInfo = new JSONObject();
			userInfo.put("memberNo",m.getMemberNo());
			userInfo.put("memberName",URLEncoder.encode(m.getMemberName(),"utf-8"));
			userInfo.put("phone",m.getPhone());
			//개체안에 객체가 들어가있음
			map.put(m.getMemberNo(),userInfo);
		}
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		//제이슨타입 맵으로 리턴
		out.print(map);
		out.flush();
		out.close();
		
		//4.결과처리
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
