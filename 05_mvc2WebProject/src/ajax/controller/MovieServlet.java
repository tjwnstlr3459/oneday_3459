package ajax.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet(name = "Movie", urlPatterns = { "/movie" })
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//http://kobis.or.kr/~~.json?key=f5eef3421c602c6cb7ea224104795888 & targetDt=20210501
		//1 인코딩
		request.setCharacterEncoding("utf-8");
		//2 값추출
		String targetDt = request.getParameter("targetDt");
		
		String key = "2d1960a325f72e312330c46c40440bb2";
		String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
		
		//Jsoup은 lib에 jsoup.jar 추가
		String result = Jsoup.connect(url)				//지정 url로 접속 요청
							.data("key",key)			//매개변수 key
							.data("targetDt",targetDt)	//매개변수 targetDt
							.userAgent("Mozilla")		//접속 브라우져 설
							.ignoreContentType(true)	//리턴 데이터타입 무관
							.execute()					//요청
							.body();					//결과를 문자열 형태로 변환
		System.out.println(result);
		JsonParser parser = new JsonParser();			//문자열을 json으로 변환해줄 객체
		JsonObject movieRank = (JsonObject)parser.parse(result);	//result문자열을 json타입으로 변환
		System.out.println(movieRank);
		JsonObject boxOffice = (JsonObject)movieRank.get("boxOfficeResult");
		System.out.println(boxOffice);
		JsonArray movieList = (JsonArray)boxOffice.get("dailyBoxOfficeList");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(movieList,response.getWriter());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
