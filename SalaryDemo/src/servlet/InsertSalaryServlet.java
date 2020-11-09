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

import util.InsertSalaryInfoUtil;

/**
 * Servlet implementation class ChenfaServlet
 */
@WebServlet("/InsertSalaryServlet")
public class InsertSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Logger logger = Logger.getLogger(InsertSalaryServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSalaryServlet() {
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
		
			String jsonArray = (String)request.getParameter("jsonArray");
			String sumSalary = (String)request.getParameter("sumSalary");
			System.out.println("jsonArray: "+jsonArray+" sumSalary:"+sumSalary);

			;
			try {
				response.getWriter().append(InsertSalaryInfoUtil.recordSalaryInfo(jsonArray,sumSalary));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
