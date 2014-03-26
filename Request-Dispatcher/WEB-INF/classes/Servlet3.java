import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Servlet3 extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{

		ServletContext context=getServletContext();
		String qt=(String)context.getAttribute("quantity");
		qt.trim();
		double d=Double.parseDouble(qt);
		double p=3.14;
		double bill=d*p;
		res.setContentType("text/plain");
		PrintWriter pw=res.getWriter();
		pw.println("price of the product:"+p);
		pw.println("total bill:"+bill);
		pw.close();

	}
}
