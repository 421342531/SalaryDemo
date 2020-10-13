package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import util.QueryProductsUtil;

/**
 * Servlet implementation class QueryProductsServlet
 */
@WebServlet("/QueryProductsServlet")
public class QueryProductsServlet extends HttpServlet {
	
	 private static Logger logger = Logger.getLogger(QueryProductsServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();  
		RequestDispatcher rd = null;   
		response.setCharacterEncoding("utf-8");
		try {
			System.out.println("111");
			request.setAttribute("data", 
					QueryProductsUtil.queryProductsFunc());
			rd = sc.getRequestDispatcher("/index.jsp"); //定向的页面   
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();  
		RequestDispatcher rd = null;   
		response.setCharacterEncoding("utf-8");
		try {
			System.out.println("111");
			request.setAttribute("data", 
					QueryProductsUtil.queryProductsFunc());
			rd = sc.getRequestDispatcher("/index.jsp"); //定向的页面   
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return;
	}

}
