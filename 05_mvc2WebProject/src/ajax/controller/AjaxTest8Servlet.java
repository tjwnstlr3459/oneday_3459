package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class AjaxTest8Servlet
 */
@WebServlet(name = "AjaxTest8", urlPatterns = { "/ajaxTest8" })
public class AjaxTest8Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AjaxTest8Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		String memberId = request.getParameter("memberId");
		//3.로직처리
		Member m = new MemberService().selectOneMember(memberId);
		//4.결과처리
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		//자동으로 변환해서 넣어줌 구글에서 제공
		new Gson().toJson(m, response.getWriter());	
		
		
		//기존에 입력하던 방식
		
//		JSONObject result = null;
//		if(m !=null) {
//			result = new JSONObject();
//			result.put("memberNo", m.getMemberNo());
//			result.put("memberId", m.getMemberId());
//			result.put("memberName", URLEncoder.encode(m.getMemberName(),"UTF-8"));
//		}
//		response.setContentType("application/json");
//		PrintWriter out = response.getWriter();
//		out.print(result);	//데이터가 큰경우라면 밑에 코드작성
//		out.flush();		//버퍼링 되어 기록되지 않은 데이터를 출력스트림으로 모두출력
//		out.close();		//출력되지 않는 데이터가 있으면 출력하고 스트림 종료
		
		//4.결과처리
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
