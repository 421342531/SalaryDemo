package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import util.ChenfaUtil;

/**
 * Servlet implementation class ChenfaServlet
 */
@WebServlet("/ChenfaServlet")
public class ChenfaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Logger logger = Logger.getLogger(ChenfaServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChenfaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext sc = getServletContext();  
		RequestDispatcher rd = null;   
		response.setCharacterEncoding("utf-8");
			String price = (String)request.getParameter("price");
			String num = (String)request.getParameter("num");
			System.out.println("price: "+price+" num:"+num);
			logger.info("price: "+price+" num:"+num);
			ChenfaUtil.chenFaFunc(price,num);
			response.getWriter().append(ChenfaUtil.chenFaFunc(price,num));
		
	}

}
