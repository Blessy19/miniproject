

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ServletDem
 */
@WebServlet("/ServletDem")
public class ServletDem extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public ServletDem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	
		ServletConfig config=null;  
		  
		public void init(ServletConfig config){  
		this.config=config;  
		System.out.println("servlet is initialized");  
		}  
		  
		public void service(ServletRequest req,ServletResponse res)  
		throws IOException,ServletException{  
		  
		res.setContentType("text/html");  
		  
		PrintWriter out=res.getWriter();  
		out.print("<html><body>");  
		out.print("<b>hello simple servlet</b>");  
		out.print("</body></html>");   
		}  

		public void destroy(){
		System.out.println("servlet is  destroyed");
		}
		  
		public ServletConfig getServletConfig(){

		return config;}  

		public String getServletInfo()
		{
		return "copyright 2010-2019";
		}  
		  
		} 
