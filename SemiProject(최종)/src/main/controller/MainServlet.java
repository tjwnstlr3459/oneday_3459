package main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import donation.login.Member;
import free.model.vo.Free;
import main.model.service.MainService;
import product.model.vo.Product;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet(name = "Main", urlPatterns = { "/main" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = null;
		ArrayList<Product> goods = new MainService().allGoodsProduct();
		request.setAttribute("goods", goods);		
		if(session != null) {
			Member m = (Member)session.getAttribute("m");
			if(m != null) {
				id = m.getMemberId();
				ArrayList<Free> list3 = new MainService().likeList(id);
				request.setAttribute("list3", list3);	
				request.setAttribute("m", m);	
			}else {
				ArrayList<Free> list4 = new MainService().allList();
				request.setAttribute("list4", list4);			
			}
		}else {
			ArrayList<Free> list4 = new MainService().allList();
			request.setAttribute("list4", list4);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/main/main.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
