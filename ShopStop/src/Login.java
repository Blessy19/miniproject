

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		 response.setContentType("Text/Html");
		 PrintWriter out=response.getWriter();
		 String n=request.getParameter("userName");
		 String p=request.getParameter("userPass");
		 
		 if(p.equals("blessy123")) {
			 RequestDispatcher rd=request.getRequestDispatcher("Welcome");
			 rd.forward(request, response);
		 }
		 else
		 {
			 out.println("Sorry UserName or Password Error!");
			 RequestDispatcher rd=request.getRequestDispatcher("Input.html");
			 rd.include(request, response);
			 
		 }
			
		 
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
