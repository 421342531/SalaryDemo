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
import util.JiafaUtil;

/**
 * Servlet implementation class QueryProductsServlet
 */
@WebServlet("/JisuangongziServlet")
public class JisuangongziServlet extends HttpServlet {
	
	 private static Logger logger = Logger.getLogger(JisuangongziServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JisuangongziServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();  
		RequestDispatcher rd = null;   
		request.setCharacterEncoding("utf-8");
		try {
			String saveCharacter = (String)request.getParameter("saveCharacter");
			System.out.println("saveCharacter : "+saveCharacter);
			
			
			//返回 JiafaUtil.jiafaFunc(saveCharacter);
			String sumOut = JiafaUtil.sumSalaryFunc(saveCharacter);
			request.setAttribute("data", JiafaUtil.gongzijiaFunc(saveCharacter));
			request.setAttribute("sumSalary", sumOut);

			InsertSalaryInfoUtil.recordSalaryInfo(saveCharacter,sumOut);
			
			rd = sc.getRequestDispatcher("/confirm.jsp"); //定向的页面   
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

}
