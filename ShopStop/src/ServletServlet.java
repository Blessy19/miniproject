

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletServlet
 */
@WebServlet("/ServletServlet")
public class ServletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("Text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<HTML>");
		 out.println("<body>");
		out.println("<body bgcolor=\"#ffffff\">");
		out.println("<h1>Request Methods</h1>");
		 out.println("<b>Remote host: </b> " +request.getRemoteHost() + "<br>");
		 out.println("<b>Remote port: </b> " +request.getRemotePort() + "<br>");
		 out.println("<b>Requested URI: </b> " +request.getRequestURI() + "<br>");
		 out.println("<b>Server Name: </b> " +request.getServerName() + "<br>");
		 out.println("<b>Server Port: </b> " +request.getServerPort() + "<br>");
		 out.println("</body>");
		 out.println("</html>");
		 out.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
