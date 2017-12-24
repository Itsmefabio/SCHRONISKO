package SchroniskoApp.javaee.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import SchroniskoApp.javaee.classes.UserCheck;

/**
 * Servlet implementation class SchroniskoAppServlet
 */
@WebServlet("/SchroniskoAppServlet")
public class SchroniskoAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchroniskoAppServlet() {
        super();
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd= request.getRequestDispatcher("/login.jsp");
		String email= request.getParameter("email");
		String pass=request.getParameter("pass");
		 if(UserCheck.credentialsCheck(email, pass))
			
			         {
		
			             RequestDispatcher rs = request.getRequestDispatcher("/index.jsp");
			
			             rs.forward(request, response);
			
			        }
			
			         else
			
			         {
			        	 response.getWriter().println("b³êdny login lub has³o !");
			
			            RequestDispatcher rs = request.getRequestDispatcher("/login.jsp");
			
			            rs.include(request, response);
			
			         }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
	}

}
