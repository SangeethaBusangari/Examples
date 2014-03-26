import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Servlet2 extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String vpid=req.getParameter("pid");
		String vpname=req.getParameter("pname");
		String vqty=req.getParameter("qty");

		ServletContext context=getServletContext();
		context.setAttribute("quantity",vqty);
		RequestDispatcher rd=req.getRequestDispatcher("/Servlet3");
		res.setContentType("text/plain");
		PrintWriter pw=res.getWriter();
		pw.println("Product id:"+vpid);
		pw.println("Product name:"+vpname);
		pw.println("Quantity:"+vqty);
		rd.include(req,res);
		pw.close();

	}
}
