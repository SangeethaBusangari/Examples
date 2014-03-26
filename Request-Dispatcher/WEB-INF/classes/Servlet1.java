import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Servlet1 extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		RequestDispatcher rd=req.getRequestDispatcher("/Servlet2");
		rd.forward(req,res);
	}
}
